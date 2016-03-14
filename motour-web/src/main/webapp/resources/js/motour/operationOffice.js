/**
 * 
 */
var types = [] ;
$(function(){
	init();
	$('#motorTypeSelect').change(function(){
		$(this.parentElement.parentElement).find('#motorQuantity option').remove()
		var numOfMotor = parseInt($('#motorTypeSelect option:selected').attr('numOfMotor'));
		for(var i=1; i< (numOfMotor+1) ;i++){
			if(i==1){
				$('#motorQuantity').append('<option value="" disabled selected>數量</option>');
			}
			$('#motorQuantity').append('<option value="'+i+'">'+i+'</option>');
		}
	});
	
	$('#motorOffice').blur(function(){
		if($("#bookingForm").validate().element('#startDatetime')){
			$.ajax({
				  type: "POST",
				  url: "getMotorTypeListOfOffice",
				  data:  {
					  startDatetime : function(){
						  	var selectDatetime = $('#startDatetime').val()+' '+$('#startTime').val(); 
							return selectDatetime;
					  },
					  officeId : function(){
							return $('#motorOffice').val();
					  },
					  rentDay :function(){
						  	if($('#rentPlan').val()=='F'){
						  		return $('#rentDay').val();
						  	}else{
						  		return '0' ;
						  	}
					  }
					},
				  contentType : 'application/x-www-form-urlencoded',
				  async : false,
				  error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
				  },
				  success : function(data){
					  $('#motorTypeSelect option').remove() ;
					  for(var i=0;i<data.length;i++){
						  $('#checkboxMotour').append('<div class="quan-select checkbox"><input type="checkbox" id="motourTypeSelect'+data[i].mtId+'" name="motorTypeSelect" value="'+data[i].mtId+'"><label for="motourTypeSelect'+data[i].mtId+'">'+data[i].name+'</label></div>') ;
						  var _quantity = $("<select></select>").attr("id", "motorQuantity"+data[i].mtId).attr("name", "motorQuantity"+data[i].mtId).attr("class","in-drop form-control").attr('onchange','javascript:checkQuantity(this);');
						  for(var j=1;j<data[i].count+1;j++){
							  if(j==1){
								  _quantity.append('<option value="" disabled selected>數量</option>');
								}
							  _quantity.append('<option value="'+j+'">'+j+'</option>');
						  }
						  $('#checkboxMotour').append(_quantity) ;
						  $('#checkboxMotour').append('<br>') ;
					  }
				  }
			});
		}
	});
	
	//
	$('#rentPlan').change(function(){
		if($(this).val()=='H'){
			$('#rentDay').hide();
		}else{
			$('#rentDay').show();
		}
	});
})
//超過10台，警示
function checkQuantity(obj){
	var num = parseInt($(obj).val()) ;
	if(num>10){
		MTMessage.showMessage('0015', [], MTMessage.options.codeType.warning ) ;
		$(obj).val('');
	}
}

function submitForm() {
	
	var valid = false;
	var notSelect = false ;
	$('input[id^=motourTypeSelect]:checked').each(function(i,value){
		var mType = $(value).val();
		var mTypeText = $('label[for=motourTypeSelect'+mType+']').text();
		var mQuan = $('#motorQuantity'+mType+' option:selected').val();		
		if(mQuan==''){
			notSelect=true;
			return ;
		}		
		var mQuanText = $('#motorQuantity'+mType+' option:selected').text();
		$("#bookingForm").append('<input type="hidden" name="motorTypesList['+i+'].motorTypeCode" value="'+mType+'">');
		$("#bookingForm").append('<input type="hidden" name="motorTypesList['+i+'].motorQuantityCode" value="'+mQuan+'">');
		$("#bookingForm").append('<input type="hidden" name="motorTypesList['+i+'].motorType" value="'+mTypeText+'">');
		$("#bookingForm").append('<input type="hidden" name="motorTypesList['+i+'].motorQuantity" value="'+mQuanText+'">');
		valid = true ;
	}) ;
	
	if(notSelect){
		var vars = [] ;
		var msgType = MTMessage.options.codeType.warning ;
		MTMessage.showMessage('0032', vars, msgType) ;
		notSelect =false ;
		return false;
	}
	
	var officeName = $('#motorOffice option:selected').text() ;
	var locationName = $('#motorLocation option:selected').text() ;
	
	$('#bookingForm').append('<input type="hidden" name="motorOfficeName" value="'+officeName+'">');
	$('#bookingForm').append('<input type="hidden" name="motorLocationName" value="'+locationName+'">');
	
	if(!valid){
		var vars = [] ;
		var msgType = MTMessage.options.codeType.warning ;
		MTMessage.showMessage('0009', vars, msgType) ;
		return false;
	}
	
	$('#bookingForm').submit();
}

function init(){
	$("#bookingForm").validate({
		  onfocusout:function(element){
			//this.element(element);
		  },
		  rules: {
		  //  "motorTypeSelect": {required: true},
		  //  "motorQuantity" :{required:true},
		    "motorOffice" :{required:true},
		    "motorLocation":{required:true},
		    "startDatetime" :{required:true},
		    "rentPlan":{required:true},
		    "rentDay":{required:true},
		    "startTime":{required:true}
		  }
	});
	
	$('#startDatetime').datetimepicker({
		lang: $dateLang,
		timepicker : false,
		scrollInput : true,
		minDate: 0,
		format : $datepickerDateFormat
	});
	$('#startTime').datetimepicker({
		lang: $dateLang,
		datepicker:false,
		scrollInput : true,
		minDate: 0,
		minTime:'9:00',
		maxTime:'18:00',
		format : $datepickerTimeFormat
	});
	
	$('#motorOffice').val('');
}

function removeMotor($this){
	$this.parentElement.parentElement.remove();
}


