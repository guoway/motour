$(function() {
	$('#resetPasswordForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
		    "password" :{required:true , rangelength: [6, 12]},
		    "password2" :{equalTo:"#password"}
		  }		
	});
});