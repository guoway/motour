/**
 * 
 */

$(function() {
	initialBizReportList();
});
    	
function initialBizReportList() {
	var gridtable = $("#businessOrderList") ;
	gridtable.jqGrid({
		url : contextPath + '/orderSearch',
		prmNames:{
			page:'pageRequest.page',
			rows:'pageRequest.rows',
			sort:'pageRequest.sidx',
			order:'pageRequest.sord',
		},
		postData:{
			orderCode:function(){
				return $('#orderCode').val();
			},
			mobile:function(){
				return $('#mobile').val();
			},
			identity:function(){
				return $('#identity').val();
			},
			renter:function(){
				return $('#renter').val();
			},
			orderDate:function(){
				return $('#orderDate').val();
			},
			rentDate:function(){
				return $('#rentDate').val();
			}, 
			/*
			officeIds:function(){
				var oIds = [] ;
				oIds.push(1);
				return JSON.stringify(oIds);
			},
			orderStatus:function(){
				var status =[] ;
				status.push('FINISH') ;
				return JSON.stringify(status) ;
			}
			*/
		},
        datatype: "json",
        height: "100%",
        autowidth: true,
        shrinkToFit: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        colNames: ['功能清單', '訂單編號', '訂單日期', '預約日期','租用人', '聯絡電話', '識別ID'],
        colModel: [
            {name: 'action', sortable: false, align:'center'},
            {name: 'orderCode', index: 'orderCode', sorttype: "string"},
            {name: 'orderDate', index: 'orderDate', sorttype: "string"},
            {name: 'rentDate', index: 'rentDate', sorttype: "string"},
            {name: 'renter', index: 'renter', align: "right", sorttype: "string"},
            {name: 'mobile', index: 'mobile', align: "right", sorttype: "string"},
            {name: 'identity', index: 'identity', align: "right", sorttype: "string"},                   
        ],
        pager: "#businessOrderList_pager",
        viewrecords: true,
        gridComplete: function() {
        	//取得當前功能有哪些能列在列表中的子功能
        	var functions = getListActionsByFunction(activeMenuId);
        	
        	var ids = gridtable.jqGrid('getDataIDs');
        	$(ids).each(function(i, e){
        		var actions = [];
        		var _actionForm = $('#actionForm') ; 
        		$(functions).each(function(j, f) {
        			/**
        			 * 為每個子功能建立Action物件(建立子功能button需要它)
        			 */        			
        			if(f.id == 'order_view') {
        				actions.push(new ListAction(f, function(dataId) {
        					var elementId = gridtable.jqGrid('getCell', dataId, 'orderCode');
        					_actionForm.attr('action', contextPath + '/orderView');
        					_actionForm.find('input[id="orderCode"]').val(elementId);
        					_actionForm.submit();
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