package com.zbss.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

/**
 * @author zbss
 * @desc Http工具类 	注意：这两个apache的方法返回的数据对GZIP已经进行了解压缩
 * @date 2016-4-23 下午2:39:31
 */
public class HttpClientUtils {
	
	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String HEADER = "headers";
	public static final String BODY = "body";
	public static final String COOKIE = "cookies";
	public static final CookieStore cookieStore = new BasicCookieStore();
	
	/***获取get内容*/
	public static Map<String, Object> get(boolean isHttps, String url, 
			 Map<String, Object> headers, Integer timeOut) throws Exception{
		HttpRequestBase request = getRequest(url, null, timeOut, headers, GET);
		return http(isHttps, request);
	}
	
	/***获取post内容*/
	public static Map<String, Object> post(boolean isHttps, String url, 
			String param, Map<String, Object> headers, Integer timeOut) throws Exception{
		HttpRequestBase request = getRequest(url, param, timeOut, headers, POST);
		return http(isHttps, request);
	}
	
	/***发送请求*/
	private static Map<String, Object> http(boolean isHttps, HttpRequestBase request) throws Exception{
		Map<String, Object> result = new HashMap<>();
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		httpClient = createClient(isHttps);
		response = httpClient.execute(request);

		List<Cookie> cookieList = cookieStore.getCookies();
		Header[] responseHeaders = response.getAllHeaders();

		// 请求头
		Map<String, Object> resHeaderMap = new HashMap<>();
		if (null != responseHeaders && responseHeaders.length > 1){
			for (Header header : responseHeaders){
				if (!"Set-Cookie".equals(header.getName())){
					resHeaderMap.put(header.getName(), header.getValue());
				}
			}
		}

		// cookie
		String cookies = "";
		if (cookieList != null && cookieList.size() > 0){
			for (Cookie co : cookieList){
				cookies+=co.getName()+"="+co.getValue()+";";
			}
		}

		result.put(HEADER, resHeaderMap);
		result.put(COOKIE, cookies);
		result.put(BODY, EntityUtils.toString(response.getEntity()));
		
		EntityUtils.consume(response.getEntity());
		
		if (response != null)
			response.close();
		if (httpClient != null)
			httpClient.close();
		
		return result;
	}
	
	/***设置请求内容*/
	private static HttpRequestBase getRequest(String url, String param, 
			Integer timeOut, Map<String, Object> headers, String type){
		HttpRequestBase request = null;
		if (GET.equals(type))
			request = new HttpGet(url);
		if (POST.equals(type))
			request = new HttpPost(url);
		
		if (timeOut != null){
			RequestConfig requestConfig = RequestConfig.custom()//
					.setSocketTimeout(timeOut)//
					.setConnectTimeout(timeOut)//
					.setCookieSpec(CookieSpecs.STANDARD_STRICT)//
					.build();
			request.setConfig(requestConfig);
		}
		
		if (headers != null){
			for (String key : headers.keySet()){
				request.addHeader(key, String.valueOf(headers.get(key)));
			}
		}
		
		if (param != null && POST.equals(type)){
			((HttpPost)request).setEntity(new StringEntity(param, "utf-8"));
		}

		return request;
	}

	/***创建httpClient*/
	private static CloseableHttpClient createClient(boolean isHttps) throws Exception{
		if (isHttps)
			return createHttpsClient();
		return createHttpClient();
	}
	
	/***http客户端*/
	private static CloseableHttpClient createHttpClient(){
		return HttpClients.custom().setDefaultCookieStore(cookieStore).build();
	}
	
	/***https客户端*/
	private static CloseableHttpClient createHttpsClient() throws Exception{
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				return true;
			}
		}).build();
		
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
		return HttpClients.custom().setDefaultCookieStore(cookieStore).setSSLSocketFactory(sslsf).build();
	}
}
