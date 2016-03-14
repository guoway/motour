$(function() {
	initialUserList();
});

function initialUserList() {
	var gridtable = $('#userList');
	gridtable.jqGrid({
		url: contextPath + '/userSearch',        
        datatype: "json",
        height: "100%",
        autowidth: true,
        shrinkToFit: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        colNames: ['功能清單', '會員ID', '姓名', '是否啟用', '最後登入時間'],
        colModel: [
            {name: 'action', sortable: false, align:'center'},
            {name: 'id', index: 'id', sorttype: "string"},
            {name: 'name', index: 'name', sorttype: "string"},
            {name: 'ss3aMember.enabled', index: 'ss3aMember.enabled', align: "left", sorttype: "boolean", formatter:'select', editoptions:{value:"true:是;false:否"}},
            {name: 'ss3aMember.lastLoginTime', index: 'ss3aMember.lastLoginTime', align:"left"}
         ],
        pager: "#userList_pager",        
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
        			if(f.id == 'member_profile_delete') {
        				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'id');
        					MTMessage.showDeleteConfirm(function() {        						
            					$.ajax({
            						url: 'userDelete',
            						method: 'get',
            						data: {userId:elementId},
            						async: false,
            					}).done(function(result) {
            						if(result.result) {
            							MTMessage.showDeleteSuccess();
            							gridtable.jqGrid().trigger('reloadGrid');
            						} else {
            							MTMessage.showMessage(result.messageCode, result.customMessage, "warning");
            						}
            					});
        					});
        				}, ids[i], gridtable.jqGrid('getInd', ids[i])));
        			}
        			
        			if(f.id == 'member_profile_update') {
        				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'id');
        					$('#actionForm').attr('action', contextPath + '/userUpdate');
        					$('#userId').val(elementId);
        					$('#actionForm').submit();
        				}, ids[i], gridtable.jqGrid('getInd', ids[i])));
        			}
        			
        			if(f.id == 'mgr_mgmt_func_set') {
           				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'id');
        					$('#actionForm').attr('action', contextPath + '/userRoleSetting');
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

