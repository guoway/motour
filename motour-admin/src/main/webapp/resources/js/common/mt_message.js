/**
 * 
 */

function MTMessage(){
	this.getMessage = function(code,vars){
		$.ajax({
			  type: "POST",
			  url: "getMessage/"+code+"/",
			  data: {vars:vars},
			  async : false,
			  error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
			  },
			  success : function(data){
					message = data.content;
			  }
		});
		return message ;
	};
	
	/**
	 * 一般訊息
	 */
	this.basicMessage = function(content){
		swal(content) ;
	};
	
	/**
	 * 成功訊息
	 */
	this.showSuccess = function(content){
		swal(content, "You clicked the button!", MTMessage.options.codeType.success);
	};
	
	this.showWarning = function(content){
		swal(content, "You clicked the button!", MTMessage.options.codeType.warning);
	};
	
	this.showDeleteConfirm = function(callback) {
		swal({
			title: "確認是否刪除",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "是的，刪除它",
			cancelButtonText: "我反悔了",
			closeOnConfirm: false,
			closeOnCancel: false
		}, function(isConfirm) {
			if(isConfirm) {
				if(callback) {
					callback();
				}				
			} else {
				swal("取消刪除", "已取消刪除此物件", "error");
			}
		});
	};	
	
	this.showDeleteSuccess = function() {
		swal("刪除成功", "資料已刪除", MTMessage.options.codeType.success);
	};
}

/**
 * 
 * @param code mt_message.msg_id
 * @param vars 定義 mt_message.content中的變數
 * @param msgType sweetalert type
 */
MTMessage.showMessage = function(code,vars, msgType){
	var content = new MTMessage().getMessage(code, vars) ;
	MTMessage.showDirectMessage(content, msgType);
}

MTMessage.showDirectMessage = function(content, msgType) {
	switch (msgType) {
	case 'success':
		new MTMessage().showSuccess(content)
		break ;
	case 'warning':
		new MTMessage().showWarging(content)
		break;
	default:
		new MTMessage().basicMessage(content) ;
		break;
	}	
}


/**
 * 所有刪除功能的提示都套用這個method即可。
 * @param callback 傳入callback可令此method於user按下確認後呼叫該callback
 */
MTMessage.showDeleteConfirm = function(callback) {
	new MTMessage().showDeleteConfirm(callback);
};

MTMessage.showConfirm = function(title, confirmBtnText, cancelBtnText, cancelTitle, cancelMessage, callback) {
	swal({
		title: title,
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#DD6B55",
		confirmButtonText: confirmBtnText,
		cancelButtonText: cancelBtnText,
		closeOnConfirm: false,
		closeOnCancel: false
	}, function(isConfirm) {
		if(isConfirm) {
			if(callback) {
				callback();
			}				
		} else {
			swal(cancelTitle, cancelMessage, "error");
		}
	});
};

/**
 * 所有刪除功能的刪除成功訊息都套用這個method即可。
 */
MTMessage.showDeleteSuccess = function() {
	new MTMessage().showDeleteSuccess();
}


/**
 * 定義 sweetalert的類型
 */
MTMessage.options = {
	codeType : {
		success: 'success',
		warning: 'warning',
		info   : 'info',
		danger : 'danger'
	}
};
