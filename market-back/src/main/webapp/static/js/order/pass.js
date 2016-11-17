$(function(){
	initWindowResize();
	initPassList();
});

function initWindowResize(){
	$(window).resize(function(){
		resize("passList");
	});
}

function initPassList(){
	/***加载部门表格数据*/
	datagrid = $('#passList').datagrid({
		title:'<div style="width:100%;text-align:center;">乘客管理</div>',
		url:baseUrl+'order/getPassengers?order_id='+$('#order_id').val(),
		view:ext_view,
		nowrap: true, 
		width:'auto',
		striped: true, 
		border: true, 
		collapsible:true,
		fitColumns:true,
		remoteSort:false,  
		singleSelect:true,
		rownumbers:true,
		pageSize:50,
		fit:true,
		noheader:true,
		pageList:[20,30,40,50],
		loadMsg:"正在努力加载数据，请稍后...",
		emptyMsg:'没有相关记录！',
		columns:[[
			{field:'id',hidden:true},
			{field:'order_id',hidden:true},
			{field:'name',sortable:true,title:'<b>姓名</b>',align:'center'},
			{field:'gender',sortable:true,title:'<b>性别</b>',align:'center'},
			{field:'ageType',sortable:true,title:'<b>类型</b>',align:'center'},
			{field:'birthday',sortable:true,title:'<b>生日</b>',align:'center'},
			{field:'cardExpired',sortable:true,title:'<b>证件有效期</b>',align:'center'},
			{field:'cardIssuePlace',sortable:true,title:'<b>证件发行国</b>',align:'center'},
			{field:'cardNum',sortable:true,title:'<b>证件号</b>',align:'center'},
			{field:'cardType',sortable:true,title:'<b>证件类型</b>',align:'center'},
			{field:'nationality',sortable:true,title:'<b>国籍</b>',align:'center'},
			{field:'status',sortable:true,title:'<b>状态</b>',align:'center'},
			{field:'ticket_no',sortable:true,title:'<b>票号</b>',align:'center',
				formatter:function (value,row,index) {
					if (value == '' || value == null){
						return '<input id="'+row.id+'">';
					}
					return value;
				}
			},
			{field:'opera',sortable:true,title:'<b>操作</b>',width:250,align:'center',
				formatter: function(value,row,index) {
					var disabled = "";
					if (row.ticket_no != null && row.ticket_no != '')
						disabled = 'disabled="disabled"';
					return '<a '+disabled+' class="update c6" onclick="updateTicketNo('+index+')">贴票号</a>';
				}
			},
		]],
		onLoadSuccess:function(){
			updateButtonUI();
			resize("passList");
		}
	});
}

/***贴票号操作*/
function updateTicketNo(idx){
	datagrid.datagrid("selectRow", idx);
	var row = datagrid.datagrid('getSelected');
	var ticket_no = $('input[id="'+row.id+'"]').val();
	if (ticket_no == null || ticket_no == ''){
		return layer.tips('票号未填！', '#'+row.id, {tips: 1,time:1000});
	}

	post(baseUrl+"order/updatePassenger", false, 'json', {
		id:row.id,
		ticket_no:ticket_no
	}, function(data){
		var icon = 'info';
		if (data.code != '0'){
			icon = 'error'
		}
		$.messager.alert({title:'提示', msg:data.msg, icon:icon});
		datagrid.datalist("reload");
	});
}

/***重绘datagrid中的按钮*/
function updateButtonUI(){
	$(".update").linkbutton({iconCls:'icon-edit'});
}

/***调整datagrid的大小*/
function resize(datagrid_id){
	setTimeout(function(){
		$('#'+datagrid_id).datagrid('resize');
	}, 200);
}
