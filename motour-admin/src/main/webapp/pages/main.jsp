<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<tiles:insertDefinition name="baselayout">

<tiles:putAttribute name="moduleJS">
    <!-- jqGrid -->
    <script src="js/plugins/jqGrid/i18n/grid.locale-tw.js"></script>
    <script src="js/plugins/jqGrid/jquery.jqGrid.min.js"></script>
    
	<script src="js/main.js"></script>
</tiles:putAttribute>
<tiles:putAttribute name="content">
            <div class="wrapper wrapper-content animated fadeIn">

                <div class="p-w-md m-t-sm">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox">
								<div class="ibox-title">
									<h5>今日新增訂單</h5>
								</div>
                                <div class="ibox-content">
									<div class="jqGrid_wrapper">
										<table id="todayOrderList"></table>
										<div id="todayOrderList_pager"></div>
									</div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>


            </div>
</tiles:putAttribute>
</tiles:insertDefinition>