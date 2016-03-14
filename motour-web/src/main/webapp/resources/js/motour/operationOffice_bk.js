/**
 * 
 */
var types = [] ;
$(function(){
	init();
	
	$('#addMotor').click(function(){
		var _mType = $('#motorTypeSelect');
		var _mQuan = $('#motorQuantity');
		
		var mType = $('#motorTypeSelect option:selected').val();
		var mTypeText = $('#motorTypeSelect option:selected').text();
		var mQuan = $('#motorQuantity option:selected').val();
		var mQuanText = $('#motorQuantity option:selected').text();
		
		if(mType=='' || mQuan==''){
			MTMessage.showMessage('0010', [],  MTMessage.options.codeType.warning) ;
			return ;
		}
		
		if(parseInt(mQuan) > 10){
			MTMessage.showMessage('0015', [], MTMessage.options.codeType.warning ) ;
			return ;
		}
		
		$('#motorTypes').append(
				'<div id="item">'+
				'<div class="quan-select form-group" style="float:left; display:inline-block">'+
	                '<select class="in-drop form-control" id="motorTypeSelect" name="motorTypeSelect" style="width:100%" disabled="disabled">'+
	                	'<option value="'+mType+'" disabled selected>'+mTypeText+'</option>'+
	                '</select>'+
				'</div>'+
				'<div class="quan-select form-group" style="display:inline-block">'+
                	'<select class="in-drop form-control" id="motorQuantity" name="motorQuantity" style="width:50%" disabled="disabled">'+
                    	'<option value="'+mQuan+'" disabled selected>'+mQuanText+'</option>'+
                	'</select>'+
                	'<button type="button" class="in-drop btn btn-default btn-lg" style="padding:6px 12px;margin-top: -15px" onclick="javascript:removeMotor(this);">'+
						'<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>刪除'+
					'</button>'+
				'</div>'+
				'<div>'
		);
		_mType.val('') ;
		_mQuan.val('') ;
	});
	
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
						  if(i==0){
							$('#motorTypeSelect').append('<option value="" numOfMotor="0" disabled selected>車型</option>') 
						  }
						  $('#motorTypeSelect').append('<option value="'+data[i].mtId+'" numOfMotor="'+data[i].count+'">'+data[i].name+'</option>')
					  }
				  }
			});
		}
	});
	//超過10台，警示
	$('#motorQuantity').change(function(){
		var num = parseInt($('#motorQuantity option:selected').val());
		if(num>10){
			MTMessage.showMessage('0015', [], MTMessage.options.codeType.warning ) ;
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

function submitForm() {
	if($('div[id=item]').length==0){
		var vars = [] ;
		var msgType = MTMessage.options.codeType.success ;
		MTMessage.showMessage('0009', vars, msgType) ;
		return ;
	}
	
	$('div[id=item]').each(function(i,value){
		var mType = $(value).find('#motorTypeSelect option:selected').val();
		var mTypeText = $(value).find('#motorTypeSelect option:selected').text();
		var mQuan = $(value).find('#motorQuantity option:selected').val();
		var mQuanText = $(value).find('#motorQuantity option:selected').text();
		
		$("#bookingForm").append('<input type="hidden" name="motorTypesList['+i+'].motorTypeCode" value="'+mType+'">');
		$("#bookingForm").append('<input type="hidden" name="motorTypesList['+i+'].motorQuantityCode" value="'+mQuan+'">');
		$("#bookingForm").append('<input type="hidden" name="motorTypesList['+i+'].motorType" value="'+mTypeText+'">');
		$("#bookingForm").append('<input type="hidden" name="motorTypesList['+i+'].motorQuantity" value="'+mQuanText+'">');

	});
	
	var officeName = $('#motorOffice option:selected').text() ;
	var locationName = $('#motorLocation option:selected').text() ;
	
	$('#bookingForm').append('<input type="hidden" name="motorOfficeName" value="'+officeName+'">');
	$('#bookingForm').append('<input type="hidden" name="motorLocationName" value="'+locationName+'">');
	
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
//function initSessionData(){
//	var jsonData = '${bookingJSON}' ;
//	if(jsonData!=''){
//		var w = JSON.parse(jsonData) ;
//		console.log(w.motorLocationName);	
//	}
//}

