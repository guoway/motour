$(function() {
	initialOrderList();
});

function initialOrderList() {
	var gridtable = $('#dispatchList');
	gridtable.jqGrid({
		url: contextPath + '/dispatchSearch',   
		prmNames: {
			page:'pageRequest.page',
			rows: 'pageRequest.rows',
			sort: 'pageRequest.sidx',
			order: 'pageRequest.order',
			
		},
		postData: {
			orderCode: null,
			mobile: '',
			identity: '',
			name: '',
			orderDate: null,
			rentDate: null,
		},
        datatype: "json",
        height: "100%",
        autowidth: true,
        shrinkToFit: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        colNames: ['功能清單', '訂單編號', '姓名', '電話', '識別ID', '訂單日期', '租車時間'],
        colModel: [
            {name: 'action', sortable: false, align:'center'},
            {name: 'orderCode', index: 'orderCode', sorttype: "string"},
            {name: 'user.name', index: 'user.name', sorttype: "string"},
            {name: 'user.mobile', index: 'user.mobile', sorttype: "string"},
            {name: 'user.identity', index: 'user.identity', sorttype: "stirng"},
            {name: 'orderTime', index: 'orderTime', sorttype: 'string'},
            {name: 'rentTime', index: 'rentTime', sorttype: 'string'},
         ],
        pager: "#dispatchList_pager",        
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
        			if(f.id == 'dispatch_motor') {
        				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'orderCode');
        					$('#actionForm').attr('action', contextPath + '/dispathMotor');
        					$('#orderCode').val(elementId);
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

