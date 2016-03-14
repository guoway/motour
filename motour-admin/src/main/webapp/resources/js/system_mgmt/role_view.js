$(function() {
	$('#actionForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
		    "id" :{required:true},
		    "name" :{required:true},
		    "enabled" :{required:true}
		  }		
	});
});


