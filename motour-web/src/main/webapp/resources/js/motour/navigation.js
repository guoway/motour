
$(function(){
	 
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
	
	
	
	$("#registerForm").validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
		    "id": { required: true, email: true ,validUser:true, maxlength:30},
		    "ss3aMember.password" :{required:true , rangelength: [6, 12]},
		    "passwdConfirm" :{equalTo:"#passwd"},
		    "name" :{required:true, maxlength : 20},
		    "mobile":{required:true,maxlength : 20,digits: true}
		  }
	});
	
	$('#fgpwForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
			  "userId":{required:true, email:true},
		  }
	});
	
	$('#loginForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
			  "userId":{required:true, email:true},
			  "passwd":{required:true},
		  }
	});
})