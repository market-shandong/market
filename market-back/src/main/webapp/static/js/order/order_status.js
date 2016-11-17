$(function(){
	initWindowResize();
	initOrderList();
	initSearchButton();
	initClearButton();
});

function initWindowResize(){
	$(window).resize(function(){
		resize("orderList");
	});
}

function initSearchButton(){
	$("a[id='search']").click(function(){
		var fromDate = $('#fromDate').datebox('getValue');
		var retDate = $('#retDate').datebox('getValue');
		$('#orderList').datagrid('load',{
			fromDate: fromDate,
			retDate: retDate
		});
	});
}

function initClearButton(){
	$("a[id='clear']").click(function(){
		$('#fromDate').datebox('setValue', '');
		$('#retDate').datebox('setValue', '');
	});
}

function initOrderList(){
	/***加载部门表格数据*/
	datagrid = $('#orderList').datagrid({
		title:'<div style="width:100%;text-align:center;">票号状态</div>',
		url:baseUrl+'order/getOrderStatus',
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
			{field:'order_no',sortable:true,title:'<b>订单号</b>',width:400,align:'center'},
			{field:'order_time',sortable:true,title:'<b>订单时间</b>',width:250,align:'center'},
			{field:'pnr',sortable:true,title:'<b>PNR</b>',width:170,align:'center',hidden:true},
			{field:'cid',sortable:true,title:'<b>CID</b>',width:200,align:'center'},
			{field:'vendor',sortable:true,title:'<b>供应商</b>',width:170,align:'center'},
			{field:'from_city',sortable:true,title:'<b>出发城市</b>',width:170,align:'center'},
			{field:'to_city',sortable:true,title:'<b>到达城市</b>',width:170,align:'center'},
			{field:'from_date',sortable:true,title:'<b>启程日期</b>',width:170,align:'center'},
			{field:'ret_date',sortable:true,title:'<b>回程日期</b>',width:170,align:'center'},
			{field:'startTime',sortable:true,title:'<b>起飞时间</b>',width:250,align:'center',
				formatter:function(value, row, index){
					if (row.vendor == 'tr'){
						return row.tr_time;
					}else{
						return row.tz_time;
					}
				}
			},
			{field:'flight_no',sortable:true,title:'<b>航班号</b>',width:170,align:'center'},
			{field:'price_total',sortable:true,title:'<b>总价</b>',width:170,align:'center'},
			{field:'adult_count',sortable:true,title:'<b>人数</b>',width:50,align:'center'},
            {field:'status_update_time',sortable:true,title:'<b>更新时间</b>',width:200,align:'center'},
			{field:'ota_orderstatus',sortable:true,title:'<b>OTA状态</b>',width:250,align:'center',
				formatter:function(value, row, index){
					if (typeof(value) == "undefined"){
						return '<font style="color:purple;">无状态</font>';
					}
					if (value.lastIndexOf('订单关闭') != -1){
						return '<font style="color:orange;">'+value+'</font>';
					}
					if (value.lastIndexOf('验真失败') != -1){
						return '<font style="color:blue;">'+value+'</font>';
					}
					return '<font style="color:green;">'+value+'</font>';;
				}
			},
			{field:'status',sortable:true,title:'<b>订单状态</b>',width:170,align:'center',
				formatter: function(value,row,index){
					if (row.ota_orderstatus.lastIndexOf('订单关闭') != -1){
						return '<font style="color:red;font-weight: bold;">已关闭</font>';
					}
					if (value=='正常'){
						return '<font style="color:green;font-weight: bold;">'+value+'</font>';
					}else{
						return '<font style="color:red;font-weight: bold;">'+value+'</font>';
					}
				}
			},
			{field:'opera',sortable:true,title:'<b>操作</b>',width:170,align:'center',
				formatter: function(value,row,index) {
					return '<a class="update c6" onclick="updateTicketNo('+index+')">乘客信息</a>';
				}
			},
		]],
		onLoadSuccess:function(){
			updateButtonUI();
			resize("orderList");
		}
	});
}

function updateButtonUI(){
	$(".update").linkbutton({iconCls:'icon-edit'});
}

function resize(datagrid_id){
	setTimeout(function(){
		$('#'+datagrid_id).datagrid('resize');
	}, 200);
}

/***显示贴票号窗口*/
function updateTicketNo(idx){
	datagrid.datagrid("selectRow", idx);
	var row = datagrid.datagrid('getSelected');
	showDialog("乘客信息", 950, 400, baseUrl+"order/goPassengerDetail?order_id="+row.id, true, function(){
		datagrid.datagrid('reload');
	});
}