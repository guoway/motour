$(function(){

	//郵遞區號autocomplete Start	
	registerOnZipSelectedCallback(onZipSelected);
	//郵遞區號autocomplete End
	
	// Validation Part Start
	$("#profileForm").validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
		    "name": { required: true, maxlength:10},
		    "identity" :{required:true , rangelength: [10, 12]},
		    "mobile" :{required:true, minlength:10, maxlength : 10},
		    "invZip" :{required:false, minlength:3, maxlength : 3},
		    "invAddress" : {required:false}
		  }
	});
	// Validation Part End
})


function submitUpdateProfile() {
	$('#profileForm').submit();
}

function onZipSelected(obj) {
	$('#address').val(obj.value);
}

