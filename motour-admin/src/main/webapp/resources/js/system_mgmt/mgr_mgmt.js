$(function() {
	initialMgrList();
});

function initialMgrList() {
	var gridtable = $('#mgrList');
	gridtable.jqGrid({
		url: contextPath + '/mgrSearch',        
        datatype: "json",
        height: "100%",
        autowidth: true,
        shrinkToFit: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        colNames: ['功能清單', '管理員ID', '姓名', '是否啟用', '最後登入時間'],
        colModel: [
            {name: 'action', sortable: false, align:'center'},
            {name: 'id', index: 'id', sorttype: "string"},
            {name: 'user.name', index: 'user.name', sorttype: "string"},
            {name: 'user.ss3aMember.enabled', index: 'user.ss3aMember.enabled', align: "left", sorttype: "boolean", formatter:'select', editoptions:{value:"true:是;false:否"}},
            {name: 'user.ss3aMember.lastLoginTime', index: 'user.ss3aMember.lastLoginTime', align:"left"}
         ],
        pager: "#mgrList_pager",        
        viewrecords: true,       
        gridComplete: function() {
        	//取得當前功能有哪些能列在列表中的子功能
        	var functions = getListActionsByFunction(activeMenuId);
        	
        	var ids = gridtable.jqGrid('getDataIDs');
        	$(ids).each(function(i, e){
        		var actions = [];
        		$(functions).each(function(j, f) {
        			/**
        			 * 為每個子功能建立Action物件(建立子功能button需要它)
        			 */
        			if(f.id == 'mgr_mgmt_delete') {
        				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'id');
        					MTMessage.showConfirm("確認是否移除管理員權限", "是，請移除", "我反悔了", "取消移除", "取消移除管理員權限", function() {        						
            					$.ajax({
            						url: 'mgrDelete',
            						method: 'get',
            						data: {mgrId:elementId},
            						async: false,
            					}).done(function(result) {
            						if(result.result) {
            							MTMessage.showDeleteSuccess();
            							gridtable.jqGrid().trigger('reloadGrid');
            						} else {
            							MTMessage.showMessage(result.messageCode, "", "warning");
            						}
            					});
        					});
        				}, ids[i], gridtable.jqGrid('getInd', ids[i])));
        			}
        			
        			if(f.id == 'mgr_mgmt_update') {
        				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'id');
        					$('#actionForm').attr('action', contextPath + '/mgrUpdate');
        					$('#mgrId').val(elementId);
        					$('#actionForm').submit();
        				}, ids[i], gridtable.jqGrid('getInd', ids[i])));
        			}
        			
        			if(f.id == 'mgr_mgmt_func_set') {
           				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'id');
        					$('#actionForm').attr('action', contextPath + '/roleFuncSetting');
        					$('#roleId').val(elementId);
        					$('#actionForm').submit();
        				}, ids[i], gridtable.jqGrid('getInd', ids[i])));
        			}
        			
        		});
        		var html = createListActionsButton(actions); //建立子功能button
        		gridtable.jqGrid('setRowData', ids[i], {
        			action : html,
        		});
        	});
        	
        },
    });
}

