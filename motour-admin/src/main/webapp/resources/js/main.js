    
    	$(function() {
    		initialTodayOrderList();
    	});
    	
    	function initialTodayOrderList() {
    		var mydata = [
				{id:"1", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"2", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"3", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"4", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"5", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"6", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"7", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"8", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"9", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"10", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"11", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"12", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"13", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"14", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
				{id:"15", orderDate:"2015-09-22 12:32:23", bookingDate:"2015-09-23 08:00:00", estimateReturnDate:"2015-09-23 18:00:00", customerName:"候佩岑", motorType:"重型電動機車"},
			
			];
    		
    		$("#todayOrderList").jqGrid({
                data: mydata,
                datatype: "local",
                height: 250,
                autowidth: true,
                shrinkToFit: true,
                rowNum: 10,
                rowList: [10, 20, 30],
                colNames: ['id', '訂單日期', '預約日期', '預計歸還日期', '租用人', '車種'],
                colModel: [
                    {name: 'id', index: 'id', width: 60, sorttype: "int", hidden:true},
                    {name: 'orderDate', index: 'orderDate', width: 90, sorttype: "date"},
                    {name: 'bookingDate', index: 'bookingDate', width: 100, align: "right", sorttype: "date"},
                    {name: 'estimateReturnDate', index: 'estimateReturnDate', width: 100, align: "right", sorttype: "date"},
                    {name: 'customerName', index: 'customerName', width: 80, align: "right", sorttype: "string"},
                    {name: 'motorType', index: 'total', width: 80, align: "right", sorttype: "string"},
                ],
                pager: "#todayOrderList_pager",
                viewrecords: true,
                
                hidegrid: false
            });
    	}
    