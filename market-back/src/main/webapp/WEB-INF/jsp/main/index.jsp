<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${baseUrl}"/>
	<title>首页</title>
	<%@include file="../common/common-css.jsp" %>
	<link rel="stylesheet" href="static/css/index/index.css" />
</head>

<body class="easyui-layout" data-options="fit:true">
	<%--
	<div id='center' data-options="region:'center',fit:true">
		<div id="wrapper">
			<div id="price">
				<p class="caption">一、底价：</p>
				<p class="content">
					<span class="subcap">1、</span>t_airseat_**里面的数据每天0点更新，作为一天的搜索的底价<br>
					<span class="subcap">2、</span>每次搜索的数据都是从t_airseat_**表里面拿的数据，然后再根据政策做不同的加减价<br>
					<span class="subcap">3、</span>更新运价库t_price_ak将最新的价格插入或更新到e_total
				</p>
			</div>
			<div id="price">
				<p class="caption">二、运价库：</p>
				<p class="content">
					<span class="subcap">1、</span>删除所有key jedisUtil.batchDel(jedis, "price:*")<br>
					<span class="subcap">2、</span>将t_price_ak表中的所有数据存到redis<br>
					<span class="subcap">3、</span>在redis中的存储形式：<b style="color:orange;">key</b>:price:flightNo+begcode+endcode;<b style="color:orange;">value</b>:currency+,+e_total
				</p>
			</div>
			<div id="price">
				<p class="caption">三、政策：</p>
				<p class="content">
					<span class="subcap">1、</span>删除所有的政策KEY  jedisUtil.batchDel(jedis, "policy:*")<br>
					<span class="subcap">2、</span>将所有的政策存储到redis<br>
					<span class="subcap">3、</span>政策在redis中的存储：<b style="color:orange;">key</b>:policy:+cid+vendor+trip_type;<b style="color:orange;">value</b>:序列化以后的Policy对象<br>
					<span class="subcap">4、</span>政策的使用：<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公共加价：<b style="color:#FF6699;">add_price</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;航司价格：<b style="color:#FF6699;">price（底价0点抓取的价格）</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;加价比率：<b style="color:#FF6699;">add_ratio</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;加价百分比：<b style="color:#FF6699;">add_pencent</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style="color:#CCCC00;">①、亚航：</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、去运价库拿价格<b style="color:#FF0066;">price2</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@1、去redis拿运价库的数据，如果没有，就返回1999（jedis.get("price:"+flightNo+begcode+endcode);）<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@2、判断底价是否在运价库e_total的某个区间，然后根据底价与前一个和后一个价格的差价来决定返回后一个还是后一个的后一个<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、去拿价格检验存储的实时价格<b style="color:#FF0066;">webprice</b>（这个价格已经存到redis中了）<b style="color:#FF0066;"> price3</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@1、若<b style="color:#FF0066;">price3 > 0</b>那么<b style="color:#FF0066;">price2=price3</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、算出加价：<b style="color:#CC0033;">addPrice</b>=max((<b style="color:#FF0066;">price2-</b><b style="color:#FF6699;">price</b>)*<b style="color:#FF6699;">add_ratio,add_price</b>);<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、去拿ota价格：<b style="color:#CC0033;">otaPrice</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@1、判断ota最低价是否为畅游蓝天，若是 <b style="color:#CC0033;">otaPrice</b>=次低价-底价-（1~5之间的随机数）<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@2、若ota最低价不是畅游蓝天 <b style="color:#CC0033;">otaPrice</b>=最低价-底价-（1~5之间的随机数）<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@3、判断<b style="color:#CC0033;">otaPrice</b>小于10 并且庆华的价格不为0，<b style="color:#CC0033;">otaPrice</b>=庆华价-底价-（1~5之间的随机数）<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5、最终加价<b style="color:#CC0033;">addPrice</b>=max(<b style="color:#CC0033;">addPrice,otaPrice</b>);<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style="color:#CCCC00;">②、其他航司</b><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最终加价<b style="color:#CC0033;">addPrice</b>=max(<b style="color:#FF6699;">price*add_pencent, add_price</b>);

				</p>
			</div>



		</div>
	</div>
	--%>
	<%@include file="../common/common-js.jsp" %>
	<script type="text/javascript" src="static/js/index/index.js"></script>
</body>
</html>