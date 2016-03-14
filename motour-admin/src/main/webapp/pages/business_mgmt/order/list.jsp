<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="moduleJS">
    <!-- jqGrid -->
    <script src="js/plugins/jqGrid/i18n/grid.locale-tw.js"></script>
    <script src="js/plugins/jqGrid/jquery.jqGrid.min.js"></script>
    <!-- Date Picker -->
    <script src="js/plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="js/common/function.js"></script>
    <script src="js/business_mgmt/order_list.js"></script>
    <script>
    $(function() {
    	$('.datepicker').datepicker({
    		format: 'yyyy-mm-dd',
    		todayHighlight: true,
    		clearBtn: true,
    	});
    });
    	
    </script>
</tiles:putAttribute>
<tiles:putAttribute name="content">
	<div class="p-w-md m-t-sm">
		<div class="row">
			<div class="col-lg-12">
				<div class="ibox">
					<div class="ibox-content m-b-sm border-bottom">
		                <div class="row">
		                    <div class="col-sm-4">
		                        <div class="form-group">
		                            <label class="control-label" for="orderCode">訂單編號</label>
		                            <input type="text" id="orderCode" name="orderCode" value="" placeholder="訂單編號" class="form-control">
		                        </div>
		                    </div>
		                    <div class="col-sm-4">
		                        <div class="form-group">
		                            <label class="control-label" for="mobile">電話</label>
		                            <input type="text" id="mobile" name="mobile" value="" placeholder="電話" class="form-control">
		                        </div>
		                    </div>
		                    <div class="col-sm-4">
		                        <div class="form-group">
		                            <label class="control-label" for="identity">識別ID(身份證、護照號碼、居留證號)</label>
		                            <input type="text" id="identity" name="identity" value="" placeholder="識別ID(身份證、護照號碼、居留證號)" class="form-control">
		                        </div>
		                    </div>
		                </div>
		                <div class="row">
		                    <div class="col-sm-4">
		                        <div class="form-group">
		                            <label class="control-label" for="userName">姓名</label>
		                            <input type="text" id="renter" name="renter" value="" placeholder="姓名" class="form-control">
		                        </div>
		                    </div>
		                    <div class="col-sm-4">
		                        <div class="form-group">
		                            <label class="control-label" for="orderDate">訂單日期</label>
		                            <div class="input-group date">
		                                <span class="input-group-addon">
		                                	<i class="fa fa-calendar"></i>
		                                </span>
		                                <input id="orderDate" type="text" class="form-control datepicker">
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col-sm-4">
		                        <div class="form-group">
		                            <label class="control-label" for="rentDate">租車日期</label>
		                            <div class="input-group date">
		                                <span class="input-group-addon">
		                                	<i class="fa fa-calendar"></i>
		                                </span>
		                                <input id="rentDate" type="text" class="form-control datepicker">
		                            </div>
		                        </div>
		                    </div>
		                </div>				                
				    </div>
					<div class="ibox-content">
						<div class="jqGrid_wrapper">
							<table id="businessOrderList"></table>
							<div id="businessOrderList_pager"></div>
						</div>
						<form id="actionForm" method="get">
							<input type="hidden" id="orderCode" name="orderCode"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>    
    
</tiles:putAttribute>
</tiles:insertDefinition>