<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<tiles:insertDefinition name="baselayout">

<tiles:putAttribute name="moduleJS">
    <!-- jqGrid -->
    <script src="js/plugins/jqGrid/i18n/grid.locale-tw.js"></script>
    <script src="js/plugins/jqGrid/jquery.jqGrid.min.js"></script>
    <script src="js/common/function.js"></script>
    <script src="js/system_mgmt/role_mgmt.js"></script>
</tiles:putAttribute>
<tiles:putAttribute name="content">
            <div class="wrapper wrapper-content animated fadeIn">

                <div class="p-w-md m-t-sm">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox">
								<div class="ibox-title">
									<h5 class="fn-title-h5">角色列表</h5>
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-info" onclick="javascript:window.location.href='roleCreate'">新增角色</button>
									</div>
								</div>
                                <div class="ibox-content">
									<div class="jqGrid_wrapper">
										<table id="roleList"></table>
										<div id="roleList_pager"></div>
									</div>
									<form id="actionForm" method="get">
										<input type="hidden" id="roleId" name="roleId"/>
									</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
</tiles:putAttribute>
</tiles:insertDefinition>