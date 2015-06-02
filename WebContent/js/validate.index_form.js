$(document).ready(function() {

	$("#register_form").validate({
		errorPlacement : function(error, element) {
			var error_td = element.next('em');
			error_td.find('.field_notice').hide();
			error_td.append(error);
		},
		success : function(label) {
			label.addClass('validate_right').text('ok!');
			label.css("color","green");
		},
		onkeyup : false,
		rules : {
			username : {
				required : true,
				minlength : 3,
				maxlength : 40,
			/**		                    remote:{
			 url :'index.php?ajax=1',
			 type:'get',
			 data:{
			 name : function(){
			 return $('#name').val();
			 }
			 },
			 beforeSend:function(){
			 var _checking = $('#checking');
			 _checking.prev('.field_notice').hide();
			 _checking.next('label').hide();
			 $(_checking).show();
			 },
			 complete :function(){
			 $('#checking').hide();
			 }
			 }
			 */
			},

			email : {
				required : true,
				email : true
			},
			web : {
				url : true
			},
			password : {
				required : true,
				minlength : 3,
				maxlength : 40
			},
			password2 : {
				equalTo : "#password"
			}
		},
		messages : {
			username : {
				required : "需要输入用户名",
				minlength : "名称长度在3-40个字符之间",
				maxlength : "名称长度在3-40个字符之间",
				remote : "用户名已存在"
			},
			email : {
				required : "需要输入电子邮箱",
				email : "电子邮箱格式不正确"
			},
			web : {
				url : "URL地址格式不正确,您可以去除前方的'http://'将此空置为空"
			},
			password : {
				required : "需要输入密码",
				minlength : "密码长度在3-40个字符之间",
				maxlength : "密码长度在3-40个字符之间"
			},
			password2 : {
				equalTo : "两次密码不一致"
			}
		},
	});

	$("#login_form").validate({
		errorPlacement : function(error, element) {
			var error_td = element.next('em');
			//error_td.find('.field_notice').hide();
			error_td.append(error);
		},
		success : function(label) {
			//label.addClass('validate_right').text('OK!');
		},
		onkeyup : false,
		rules : {
			username : {
				required : true,
				minlength : 3,
				maxlength : 40,
			},

			password : {
				required : true
			},
		},
		messages : {
			username : {
				required : "需要输入用户名",
				minlength : "名称长度在3-40个字符之间",
				maxlength : "名称长度在3-40个字符之间"
			},
			password : {
				required : "需要输入密码"
			},
		},
	});
});
