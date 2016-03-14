/**
 * 
 */

$(function(){
	//郵遞區號autocomplete Start	
	registerOnZipSelectedCallback(onZipSelected);
	//郵遞區號autocomplete End
	
	// Validation Part Start
	$("#bookingForm").validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
			"renterName" : {required:true,maxlength:20},
			"identity" :{required:true , rangelength: [10, 12]},
			"contactMobile" :{required:true, minlength:10, maxlength : 10},
			"contactEmail" :{required:true, email:true },
		    "invType": { required: true},
		    "invBid": { required: false, maxlength:8},
		    "invTitle": { required: true, maxlength:30},
		    "invZip" :{required:false, minlength:3, maxlength : 3},
		    "invAddress" : {required:false, maxlength:50},
		    "invReceiver" : {required:false, maxlength:20}
		  }
	});
	// Validation Part End
	
});


function onZipSelected(obj) {
	$('#invAddress').val(obj.value);
}