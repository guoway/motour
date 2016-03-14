$(function(){
	 
	
	$('#contactUsForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
			  "name":{required:true},
			  "email":{required:true, email:true},
			  "subject":{required:true},
			  "content":{required:true}
		  },
		  submitHandler: function(form) {
			$.ajax({
				url: form.attributes['action'].value,
				type: form.method,
				data: $(form).serialize(),
				success: function(response) {
					new MTMessage().basicMessage(response.content);
					$("#contactUsForm").trigger("reset");
					$.modal.close();
				}
			});
		  },
	});
	
});