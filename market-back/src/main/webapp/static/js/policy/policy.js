var datagrid;
var rowIdx = "";
$(function(){
	initWindowResize();
	initPolicyList();
	initSearchButton();
	initClearButton();
});

function initWindowResize(){
	$(window).resize(function(){
		resize("policyList");
	});
}

function initSearchButton(){
	$("a[id='search']").click(function(){
		var vendor = $('#vendor').val();
		var cid = $('#cid').val();
		var tripType = $("#tripType").combobox('getValue');
		var isValid = $("#isValid").combobox('getValue');
		tripType = tripType == 'all' ? '' : tripType;
		isValid = isValid == 'all' ? '' : isValid;
		$('#policyList').datagrid('load',{
			vendor: vendor,
			cid: cid,
			tripType: tripType,
			isValid: isValid
		});
	});
}

function initClearButton(){
	$("a[id='clear']").click(function(){
		$('#vendor').textbox('setValue', '');
		$('#cid').textbox('setValue', '');
		$("#tripType").combobox('select','all');
		$("#isValid").combobox('select','all');
	});
}

function initPolicyList(){
	datagrid = $('#policyList').datagrid({
		title:'订单管理', 
		url:baseUrl+'policy/getPolicys',
		view:ext_view,
		nowrap: true, 
		width:'auto',
		striped: true, 
		border: true, 
		collapsible:true,
		fitColumns:true,
		remoteSort:false,  
		singleSelect:true,
		pagination:true,
		rownumbers:true,
		pageSize:20,
		fit:true,
		noheader:true,
		pageList:[20,30,40,50],
		loadMsg:"正在努力加载数据，请稍后...",
		emptyMsg:'没有相关记录！',
		toolbar:'#search-box',
		columns:[[
			{field:'id',hidden:true},
			{field:'cid',sortable:true,title:'<font style="font-weight:bold">CID</font>',width:200,align:'center'},
			{field:'vendor',sortable:true,title:'<font style="font-weight:bold">供应商</font>',width:100,align:'center'},
			{field:'begdelay',sortable:true,title:'<font style="font-weight:bold">开始延迟</font>',width:100,align:'center'},
			{field:'enddelay',sortable:true,title:'<font style="font-weight:bold">结束延迟</font>',width:100,align:'center'},
			{field:'add_price',sortable:true,title:'<font style="font-weight:bold">加价</font>',width:150,align:'center',editor:{type:'numberbox',options:{required:true}}},
			{field:'sub_price',sortable:true,title:'<font style="font-weight:bold">减价</font>',width:150,align:'center',editor:{type:'numberbox',options:{required:true}}},
			{field:'add_ratio',sortable:true,title:'<font style="font-weight:bold">加价比率</font>',width:100,align:'center',editor:{type:'numberbox',options:{required:true,precision:2}}},
			{field:'add_percent',sortable:true,title:'<font style="font-weight:bold">加价百分比</font>',width:100,align:'center',editor:{type:'numberbox',options:{required:true,precision:1}}},
			{field:'cache_price',sortable:true,title:'<font style="font-weight:bold">缓存阀值</font>',width:100,align:'center',editor:{type:'numberbox',options:{required:true}}},
			{field:'change_price',sortable:true,title:'<font style="font-weight:bold">变价阀值</font>',width:100,align:'center',editor:{type:'numberbox',options:{required:true}}},
			{field:'data_source',sortable:true,title:'<font style="font-weight:bold">数据源</font>',width:100,align:'center'},
			{field:'trip_type',sortable:true,title:'<font style="font-weight:bold">行程类型</font>',width:170,align:'center'},
			{field:'is_valid',sortable:true,title:'<font style="font-weight:bold">是否有效</font>',width:100,align:'center',editor:{type:'numberbox',options:{required:true}}},
			{field:'ota_type',sortable:true,title:'<font style="font-weight:bold">ota类型</font>',width:100,align:'center'},
			{field:'ota_name',sortable:true,title:'<font style="font-weight:bold">ota名字</font>',width:170,align:'center'},
			{field:'opera',sortable:true,title:'<font style="font-weight:bold">操作</font>',width:170,align:'center',formatter:function(value,row,index){
				return '<a class="update c1" onclick="update('+index+')">修改</a>&nbsp;<a class="save c8" onclick="save('+index+')">保存</a>';
			}}
		]],
		onLoadSuccess:function(){
			updateButtonUI();
			resize("policyList");
		},
		onAfterEdit: function (rowIndex, rowData, changes) {
			updateButtonUI();
		},
		onCancelEdit:function(index, row){
			updateButtonUI();
		},
		onClickRow:function(index, row){
			if (index != rowIdx){
				cancelAllEdit();
			}
		}
	});
}

function update(index){
	cancelAllEdit();
	datagrid.datagrid('selectRow', index);
	datagrid.datagrid('beginEdit', index);
	rowIdx = index;
}

function cancelAllEdit(){
	var rows = datagrid.datagrid('getRows');
	$.each(rows, function(i, row){
		var idx = datagrid.datagrid('getRowIndex', row);
		datagrid.datagrid('cancelEdit', idx);
	});
}

function save(index){
	if (rowIdx === "")
		return;
	
	datagrid.datagrid('endEdit', index);
	var row = getRow(index);
	showProgress('进度', '正在保存......');
	post(baseUrl+"policy/updatePolicy", false, 'json', {
		id:row.id,
		cid:row.cid,
		add_price:row.add_price,
		sub_price:row.sub_price,
		add_ratio:row.add_ratio,
		add_percent:row.add_percent,
		cache_price:row.cache_price,
		change_price:row.change_price,
		is_valid:row.is_valid
	}, function(data){
		if (data.code != '0'){
			$.messager.alert({title:'提示',msg:data.msg,icon:'error'});
		}
	});
	closeProgress();
	datagrid.datagrid('reload');
	
	rowIdx = "";
}

function getRow(index){
	datagrid.datagrid('selectRow', index);
	return datagrid.datagrid('getSelected');
	
}

function updateButtonUI(){
	$(".update").linkbutton({iconCls:'icon-edit'});
	$(".save").linkbutton({iconCls:'icon-save'});
}

function addPolicy(){
	showDialog("添加政策", 400, 525, baseUrl+"policy/goAddPolicy", true, function(){
		datagrid.datagrid('reload');
	});
}

function delPolicy(){
	var row = datagrid.datagrid('getSelected');
	if (row == null || typeof(row) == 'undefined'){
		return $.messager.alert('提示：','请选择要删除的数据！','error');
	}
	$.messager.confirm('确认', '真的要删除这条数据吗？', function(r){
		if (r){
			post(baseUrl+"policy/delPolicyById", false, 'json', {
				id:row.id
			}, function(data){
				if (data.code == '0'){
					$.messager.alert('提示：','删除成功！','info', function(){
						datagrid.datagrid('reload');
					});
				}else{
					$.messager.alert('提示：','删除失败：'+data.msg,'error');
				}
			});
		}
	});
}

function refreshPolicy(){
	post(baseUrl+"policy/updatePolicyToRedis", false, 'json', {}, function(data){
		var icon = 'info';
		if (data.status != '0'){
			icon = 'error'
		}
		$.messager.alert({title:'提示', msg:data.msg, icon:icon});
	});
}

function resize(datagrid_id){
	setTimeout(function(){
		$('#'+datagrid_id).datagrid('resize');
	}, 200);
}