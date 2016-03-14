$(function() {
	initialRoleList();
});

function initialRoleList() {
	var gridtable = $('#roleList');
	gridtable.jqGrid({
		url: contextPath + '/roleSearch',        
        datatype: "json",
        height: "100%",
        autowidth: true,
        shrinkToFit: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        colNames: ['功能清單', '角色ID', '角色名稱', '是否啟用'],
        colModel: [
            {name: 'action', sortable: false, align:'center'},
            {name: 'id', index: 'id', sorttype: "string"},
            {name: 'name', index: 'name', sorttype: "string"},
            {name: 'enabled', index: 'enabled', align: "left", sorttype: "boolean", formatter:'select', editoptions:{value:"true:是;false:否"}}
         ],
        pager: "#roleList_pager",        
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
        			if(f.id == 'role_mgmt_delete') {
        				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'id');
        					MTMessage.showDeleteConfirm(function() {        						
            					$.ajax({
            						url: 'roleDelete',
            						method: 'get',
            						data: {roleId:elementId},
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
        			
        			if(f.id == 'role_mgmt_update') {
        				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'id');
        					$('#actionForm').attr('action', contextPath + '/roleUpdate');
        					$('#roleId').val(elementId);
        					$('#actionForm').submit();
        				}, ids[i], gridtable.jqGrid('getInd', ids[i])));
        			}
        			
        			if(f.id == 'role_mgmt_func_set') {
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

