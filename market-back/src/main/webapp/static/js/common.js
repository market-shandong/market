/***基础路径*/
var baseUrl = $('base').attr('href');

/***ajax请求sesson超时的问题*/
$.ajaxSetup({
	type: 'POST',
	complete: function(xhr,status) {
		var sessionStatus = xhr.getResponseHeader('sessionstatus');
		var top = getTopWinow();
		if(sessionStatus == 'timeout') {
			$.messager.alert('提示：', '由于您长时间没有操作,session已过期,请重新登录！', 'info', function(){
				top.location.href = baseUrl + 'login/goLogin';
			});
		}
	}
});

/***post***/
function post(url, async, dataType, params, callback){
	$.ajax({
		url:url,
		type:'post',
		dataType:dataType,
		data:params,
		async:async,
		success:function(data){
			if (callback){
				callback(data);
			}
		},
		error:function(data){
			if (callback){
				callback(data);
			}
		}
	});
}

/***get***/
function get(url, async, dataType, callback){
	$.ajax({
		url:url,
		type:'get',
		dataType:dataType,
		async:async,
		success:function(data){
			if (callback){
				callback(data);
			}
		},
		error:function(data){
			if (callback){
				callback(data);
			}
		}
	});
}

/***在页面中任何嵌套层次的窗口中获取顶层窗口*/
function getTopWinow(){
	var p = window;
	while(p != p.parent){
		p = p.parent;
	}
	return p;
}

/***easyui 的datagrid的view在没数据是显示信息（用法：view:ext_view,emptyMsg:'没有相关数据'）*/
var ext_view = $.extend({},$.fn.datagrid.defaults.view,{
	onAfterRender:function(target){
		$.fn.datagrid.defaults.view.onAfterRender.call(this,target);
		var opts = $(target).datagrid('options');
		var vc = $(target).datagrid('getPanel').children('div.datagrid-view');
		vc.children('div.datagrid-empty').remove();
		if (!$(target).datagrid('getRows').length){
			var d = $('<div class="datagrid-empty"></div>').html(opts.emptyMsg || 'no records').appendTo(vc);
			d.css({
				position:'absolute',
				left:0,
				top:50,
				width:'100%',
				textAlign:'center'
			});
		}
	}
});

/** *创建标签 */
function addTab(title, url) {
	
	if ($('#tabs').tabs('exists', title)){
		$('#tabs').tabs('select', title);
	}else {
		var close = true;
		if (title == "首页"){
			close = false;
		}
		var content = '<iframe scrolling="scroll" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
		$('#tabs').tabs('add', {
			title : title,
			content : content,
			closable : close
		});
	}
}

/***创建对话框*/
function showDialog(title, width, height, url, modal, callback){
	var dialog = document.getElementById("ZBSS");
	if (null == dialog){
		$("body").append("<div id='ZBSS' style='overflow-y:hidden;'></div>");
	}
	var content = '<iframe scrolling="scroll" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	$('#ZBSS').dialog({
		title: title,
		content:content,
		width: width,
		height: height,
		closed: false,
		cache: false,
		resizable:true,
		modal: modal,
		onClose:function(){
			$(this).dialog('destroy');/***销毁对话框元素清除*/
			if (callback){/***回调函数调用*/
				callback();
			}
		}
	});
}

/***关闭对话框*/
function closeDialog(){
	$('#ZBSS').dialog('close');
}

/***显示进度条*/
function showProgress(title, msg){
	$.messager.progress({
		title:title,
		msg:msg
	}); 
}

/***关闭进度条*/
function closeProgress(){
	$.messager.progress('close');
}

