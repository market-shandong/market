
/***初始化必须放在这里*/
$(function(){
	var url = $('base').attr("href")+ "main/goIndex";
	initContextMenu();
	addTab("首页",url);
});

function initContextMenu(){
	$('#mm').menu({
		onClick:function(item){
			if (item.name=='cur'){
				closeCurrentTab();
			}else if (item.name=='other'){
				closeOtherTabs();
			}else if (item.name=='all'){
				closeAllTabs();
			}
		}
	});
	$("#tabs").tabs({
		onContextMenu:function(e, title, index){
			e.preventDefault();
			if ('首页' != title){
				$("#tabs").tabs('select', index);
				$('#mm').menu('show', {
					left: e.pageX,
					top: e.pageY
				});
			}
		}
	});
}

function closeCurrentTab(){
	var tab = $('#tabs').tabs('getSelected');
	$('#tabs').tabs('close', tab.panel('options').title);
}

function closeOtherTabs(){
	var curTitle = $('#tabs').tabs('getSelected').panel('options').title;
	var arr = getAllTabTitle();
	
	for (i in arr){
		if (arr[i] != curTitle && arr[i] != '首页'){
			$('#tabs').tabs('close', arr[i]);
		}
	}
	
	$("#tabs").tabs('select', curTitle);
}

function closeAllTabs(){
	var arr = getAllTabTitle();
	for (i in arr){
		if (arr[i] != '首页'){
			$('#tabs').tabs('close', arr[i]);
		}
	}
}

function getAllTabTitle(){
	var tabs = $('#tabs').tabs('tabs');
	var arr = new Array();
	
	$.each(tabs, function(i, tb){
		arr.push(tb.panel('options').title);
	});
	
	return arr;
}

