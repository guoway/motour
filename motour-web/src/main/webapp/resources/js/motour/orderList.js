/**
 * 
 */

$(function(){
	//退訂
	$('#cancel').click(function(){
		
	});
	//列印
//	$('#print').click(function(){
//		
//	});
});
	
/**
 * 1.取車日前1天可退訂。
 * 2.訂單日+23 >= 今日，是 : 可正常退訂
 *   否: 超過可刷退日期，訂講人需自行付擔退貨手續費。
 * @param orderId
 * @param rentTime
 */
function cancel(orderId, orderTime, rentTime){
	//console.log(orderId+"-"+rentTime) ;
	var d = new Date() ;
	d.setDate(d.getDate()+23);
	//不收手續費退訂日期:系統日+23
	var canCancelDate = Date.parse((d).toDateString());
	var orderDate = Date.parse((new Date(orderTime)).toDateString());
	// 取車日前一天不可退訂
	var rentDate = Date.parse((new Date(rentTime)).toDateString());
	var currDate = Date.parse((new Date()).toDateString());
	console.log( "currDate : "+currDate +"  rentDate:" + rentDate +"  orderDate :"+orderDate) ;
	if(rentDate <= currDate){
		//不可退訂，請洽客服
		MTMessage.showMessage("0035", [] , MTMessage.options.codeType.warning) ;	
		return false ;
	}
	
	if(canCancelDate >= orderDate){
		MTMessage.showConfirm("確認是否退訂", "是，請退訂", "我反悔了", "取消退訂", "取消退訂此筆交易", function() {        						
			$.ajax({
				  type: "POST",
				  url: "cancelOrder",
				  data: {oId:orderId},
				  async : false,
				  error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
				  },
				  success : function(data){
					  //退訂成功訊息: 7天內處理刷退流程
						if(data){
							MTMessage.showMessage("0034", [], MTMessage.options.codeType.success) ;
						}
				  }
			});

		});
	}else{
		//加收手續費訊息。 TODO: 是否要直接讓user 退訂
		var vars = [] ;
		vars.push('04-23378183') ;
		MTMessage.showMessage("0033", vars, MTMessage.options.codeType.warning) ;	
	}
	
	
}