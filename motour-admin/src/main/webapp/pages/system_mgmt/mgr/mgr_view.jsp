<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">

<tiles:putAttribute name="moduleCSS">
	<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
	<link href="css/plugins/chosen/chosen.css" rel="stylesheet">
	<link href="css/plugins/select2/select2.min.css" rel="stylesheet">
</tiles:putAttribute>

<tiles:putAttribute name="moduleJS">
	<script src="js/plugins/validate/jquery.validate.min.js"></script>
	<script src="js/system_mgmt/mgr_view.js"></script>
    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    
    <!-- Chosen -->
    <script src="js/plugins/chosen/chosen.jquery.js"></script>
    
    <!-- Select2 -->
    <script src="js/plugins/select2/select2.full.min.js"></script>
        
</tiles:putAttribute>

<tiles:putAttribute name="content">
            <div class="wrapper wrapper-content animated fadeIn">

                <div class="p-w-md m-t-sm">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox">
								<div class="ibox-title">
									<h5 class="fn-title-h5">
										${activeMenu.name}									
									</h5>									
								</div>
                                <div class="ibox-content">
									<form id="actionForm" class="form-horizontal" method="post" action="${actionType == 'create'? 'mgrCreate':'mgrUpdate' }">
										<div class="form-group">
											<label class="col-sm-2 control-label">管理員ID</label>
											<div class="col-sm-3">
												<c:choose>
													<c:when test="${actionType == 'create' }">
														<select id="userId" name="id" class="form-control">															
														</select>
													</c:when>
													<c:when test="${actionType == 'update' }">
														<p class="form-control-static">${manager.id}</p>
													</c:when>
												</c:choose>
											</div>
										</div>
										<div class="hr-line-dashed"></div>																																				
										
										<div class="form-group">
											<label class="col-sm-2 control-label">可管理營業據點</label>
											<div class="col-sm-2">
												<c:choose>
													<c:when test="${actionType == 'create' }">
														<select name="offices" data-placeholder="選擇營業據點..." class="form-control chosen-select" multiple >
															<option value="">Select</option>															
															<c:forEach items="${officesList }" var="office">
																<option value="${office.id}">${office.name }</option>
															</c:forEach>
														</select>
													</c:when>
													<c:when test="${actionType == 'update' }">
														<select name="offices" data-placeholder="選擇營業據點..." class="form-control chosen-select" multiple >
															<option value="">Select</option>
															<c:set var="ownedOffices" value="${manager.offices }"/>
															<c:forEach items="${officesList }" var="office">
																<spring:eval expression="(manager.offices).contains(office)" var="existed"/>
																<option value="${office.id}" ${existed? 'selected' : '' }>${office.name }</option>
															</c:forEach>
														</select>													
													</c:when>
												</c:choose>
											</div>
										</div>																													
										
										<div class="form-group">
											<div class="col-sm-4 col-sm-offset-2">
												<button class="btn btn-white" type="button" onclick="javascript:window.location.href='mgrUpdateCancelPassAuth'">取消</button>
												<button class="btn btn-primary" type="submit">儲存</button>
											</div>
										</div>																		
									</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>                
            </div>
	</tiles:putAttribute>
</tiles:insertDefinition>