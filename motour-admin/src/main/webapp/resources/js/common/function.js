/**
 * 所有列表頁均應include此js，以用來產生列表頁中的List Actions Button (如刪除，修改..etc)
 * 範例請參考role_mgmt.jsp, role_mgmt.js
 */

/**
 * 傳入Function class，回傳javascript object ListAction
 * @param f Function
 * @param callback callback function when action is clicked
 * @param dataId data id
 * @param rowId jqgrid row index
 */
function ListAction(f, callback, dataId, rowId) {
	this.name = f.name;
	this.id = f.id;
	this.callback = callback;
	this.dataId = dataId;
	this.rowId = rowId;
}

/**
 * 取得某Function之所有可出現於列表頁中ListAction的Function
 * @param functionId
 */
function getListActionsByFunction(functionId) {
	var actions = null;
	$.ajax({
		url: 'getListActions',
		method: 'post',
		data: {parentId:functionId},
		async: false,
	}).done(function(result) {
		actions = result;
	});
	return actions;
}

/**
 * 建立Drop-down action button
 * @param actions
 * @returns {String}
 */
function createListActionsButton(actions) {
	
	var cssArray = ['btn-primary', 'btn-success', 'btn-info', 'btn-warning'];
	
	var html = '';
	html += '<div style="margin:5px;">';
	$(actions).each(function(i, e) {
		var elementId = e.id + e.rowId;
		var btnCss = '';
		
		html += '<button type="button" class="btn btn-sm ' + cssArray[i] + '" style="margin:5px;" id="' + elementId + '">';
		html += e.name;
		html += '</button>';
		
		$('body').on('click', '#' + elementId, function() {
			if(e.callback) {
				e.callback(e.dataId);
			}
			
		});
	});
	html += '</div>';
	return html;
}