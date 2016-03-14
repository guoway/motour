$(function() {
	
	var valid = false ;
	$.validator.addMethod(
		"validUser",
		function(value,element){
			$.ajax({
				  type: "POST",
				  url: "validUser",
				  data: JSON.stringify(value),
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
	
	$('#actionForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
		    "id" :{required:true, email:true, maxlength:30},
		    "name" :{required:true},
		    "mobile" :{required:true, number:true, minlength:10, maxlength : 10},
		    "email" :{required:false, email:true},
		    "identity" :{required:false},		    
		    "enabled" :{required:true}
		  }		
	});
});


