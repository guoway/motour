/**
 * 
 */

$(function(){
	preCheckUserValid();
	var valid = false ;
	$.validator.addMethod(
		"validUser",
		function(value,element){
			$.ajax({
				  type: "POST",
				  url: "validUser",
				  data: value,
				  contentType : 'application/json',
				  dataType:"json",
				  async : false,
				  error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
				  },
				  success : function(data){
					  valid = data ;
				  }
			});
			return valid ;
		}
	)
	
	
	
	$("#registerAjaxForm").validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
		    "id": { required: true, email: true ,validUser:true, maxlength:30},
		    "ss3aMember.password" :{required:true , rangelength: [6, 12]},
		    "passwdConfirm" :{equalTo:"#passwd2"},
		    "name" :{required:true, maxlength : 20},
		    "mobile":{required:true,maxlength : 20, digits: true}
		  }
	});
	
	$('#fgpwAjaxForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
			  "userId":{required:true, email:true},
		  }
	});
	
	$('#loginAjaxForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
			  "userId":{required:true, email:true},
			  "passwd":{required:true},
		  }
	});
});

function registerFromFB(res){
	
	$.ajax({
		  type: "POST",
		  url: "registerFromFB",
		  data: {
			  id : function(){
				return res.email; 
			  },
			  name : function(){
				return res.name ;  
			  },
			  fbId : function(){
				  return res.id;
			  }
		  },
		  contentType : 'application/x-www-form-urlencoded',
		  dataType:"json",
		  async : false,
		  error : function(xhr, ajaxOptions, thrownError) {
			console.log(thrownError);
		  },
		  success : function(data){
			  var _form = $('#loginAjaxForm') ;
			  $('#loginAjaxForm').submit();
		  }
	});
	
}

function registerAjaxForm(){
	
	if(!$('#registerAjaxForm').valid()){
		return ;
	}else{
		//ajax register
		var _form = $('#registerAjaxForm');
		var email = $(_form).find('#id').val() ;
		$.ajax({
			  type: "POST",
			  url: "registerAjax",
			  data: {
				  id : function(){
					return $(_form).find('#id').val();  
				  },
				  name : function(){
					return $(_form).find('#name').val();  
				  },
				  "ss3aMember.password" :function(){
						return $('#passwd2').val();  
				  },
				  mobile : function(){
					  return $(_form).find('#mobile').val();
				  }
			  },
			  contentType : 'application/x-www-form-urlencoded',
			  dataType:"json",
			  async : false,
			  error : function(xhr, ajaxOptions, thrownError) {
				console.log(thrownError);
			  },
			  success : function(data){
				  $('#loginAjaxForm').show();
				  $('#registerAjaxForm').hide();
				  $('#registerTD').find('a').remove();
				  $('#registerTD').append('<a href="resendVcode?userId='+ email+'" target="_blank">重送驗證信</a>');
			  }
		});
	}
	
}

function loginAjax(){
	console.log($('#password').val());
	if(!$('#loginAjaxForm').valid()){
		return false ;
	}else{
		var email = $('#userId').val() ;
		$.ajax({
			  type: "POST",
			  url: "loginAjax",
			  data: {
				  userId : function(){
					return $('#userId').val();  
				  },
				  password : function(){
					return $('#password').val();  
				  }
			  },
			  contentType : 'application/x-www-form-urlencoded',
			  async : false,
			  error : function(xhr, ajaxOptions, thrownError) {
				console.log(thrownError);
			  },
			  success : function(data){
				 if(data=='N'){
					 MTMessage.showMessage("0006", [], MTMessage.options.codeType.warning) ;
				 }else if(data=='F'){
					 MTMessage.showMessage("0017", [], MTMessage.options.codeType.warning) ;
					 $('#registerTD').find('a').remove();
					 $('#registerTD').append('<a href="resendVcode?userId='+ email +'" target="_blank">重送驗證信</a>');  
					 
				 }else{
					 var _form = $('#loginAjaxForm') ;
					 $('#loginAjaxForm').submit();
				 }
			  }
		});
	}
}

function forwardToRegister(){
	$('#loginAjaxForm').hide();
	$('#registerAjaxForm').show();
	
}
function returnToLogin(){
	$('#loginAjaxForm').show();
	$('#registerAjaxForm').hide();
}

function preCheckUserValid(){
	
	if($('#userId').val()!=''){
		callCheckEnableUser();
	}
	
	$('#userId').blur(function(){
			callCheckEnableUser();
	});
	
}

function callCheckEnableUser(){
	var email = $('#userId').val();
	if($('#userId').val()!=''){
		$.ajax({
			  type: "POST",
			  url: "checkEnableUser",
			  data: $('#userId').val(),
			  contentType : 'application/json',
			  async : false,
			  error : function(xhr, ajaxOptions, thrownError) {
				console.log(thrownError);
			  },
			  success : function(data){
				  if(data=='F'){
					  //尚未驗證
					  MTMessage.showMessage("0017", [], MTMessage.options.codeType.warning) ;	
					  $('#registerTD').find('a').remove();
					  $('#registerTD').append('<a href="resendVcode?userId='+ email +'" target="_blank">重送驗證信</a>');  
				  }else if(data=='N'){
					  //尚未註冊
					  MTMessage.showMessage("0004", [], MTMessage.options.codeType.warning) ;
					  $('#registerTD').find('a').remove();
					  $('#registerTD').append('<a id="register" name="register" onclick="javascript:forwardToRegister();"> 立即加入  </a>');
				  }else if(data=='S'){
					  $('#registerTD').find('a').remove();
				  }
			  }
		});	
	}
}