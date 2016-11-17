$(function(){
	initSubmitButton();
	initClearButton();
	initExitButton();
});

function initSubmitButton(){
	$("#sub").click(function(){
		if (!validate())
			return;
		
		var cid = $("#cid").textbox('getValue');
		var vendor = $("#vendor").textbox('getValue');
		var begdelay = $("#begdelay").numberbox('getValue');
		var enddelay = $("#enddelay").numberbox('getValue');
		var add_price = $("#add_price").numberbox('getValue');
		var sub_price = $("#sub_price").numberbox('getValue');
		var add_ratio = $("#add_ratio").numberbox('getValue');
		var add_percent = $("#add_percent").numberbox('getValue');
		var cache_price = $("#cache_price").numberbox('getValue');
		var change_price = $("#change_price").numberbox('getValue');
		var data_source = $("#data_source").textbox('getValue');
		var is_valid = $("#is_valid").combobox('getValue');
		var trip_type = $("#trip_type").combobox('getValue');
		var ota_type = $("#ota_type").textbox('getValue');
		var ota_name = $("#ota_name").textbox('getValue');
		
		post(baseUrl+"policy/savePolicy", false, 'json', {
			cid:cid,
			vendor:vendor,
			begdelay:begdelay,
			enddelay:enddelay,
			add_price:add_price,
			sub_price:sub_price,
			add_ratio:add_ratio,
			add_percent:add_percent,
			cache_price:cache_price,
			change_price:change_price,
			data_source:data_source,
			is_valid:is_valid,
			trip_type:trip_type,
			ota_type:ota_type,
			ota_name:ota_name
		}, function(data){
			if (data.code == '0'){
				$.messager.alert('提示：','添加成功！','info', function(){
					parent.closeDialog();
				});
			}else{
				$.messager.alert('提示：','添加失败：'+data.msg,'error');
			}
		});
	});
}

function initClearButton(){
	$('#clear').click(function(){
		$("#cid").textbox('setValue', '');
		$("#vendor").textbox('setValue', '');
		$("#begdelay").numberbox('setValue', '');
		$("#enddelay").numberbox('setValue', '');
		$("#add_price").numberbox('setValue', '');
		$("#sub_price").numberbox('setValue', '');
		$("#add_ratio").numberbox('setValue', '');
		$("#add_percent").numberbox('setValue', '');
		$("#cache_price").numberbox('setValue', '');
		$("#change_price").numberbox('setValue', '');
		$("#data_source").textbox('setValue', '');
		$("#is_valid").combobox('setValue', '1');
		$("#trip_type").combobox('setValue', 'oneway');
		$("#ota_type").textbox('setValue', '');
		$("#ota_name").textbox('setValue', '');
	});
}

function initExitButton(){
	$('#exit').click(function(){
		parent.closeDialog();
	});
}

function validate(){
	return $("#cid").textbox('isValid')&&
	$("#vendor").textbox('isValid')&&
	$("#begdelay").numberbox('isValid')&&
	$("#enddelay").numberbox('isValid')&&
	$("#add_price").numberbox('isValid')&&
	$("#sub_price").numberbox('isValid')&&
	$("#add_ratio").numberbox('isValid')&&
	$("#add_percent").numberbox('isValid')&&
	$("#cache_price").numberbox('isValid')&&
	$("#change_price").numberbox('isValid')&&
	$("#data_source").textbox('isValid')
}
