<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">

<tiles:putAttribute name="moduleCSS">
	<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
</tiles:putAttribute>

<tiles:putAttribute name="moduleJS">
	<script src="js/plugins/validate/jquery.validate.min.js"></script>
	<script src="js/system_mgmt/role_view.js"></script>
    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script> 
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
									<form id="actionForm" class="form-horizontal" method="post" action="${actionType == 'create'? 'roleCreate':'roleUpdate' }">
										<div class="form-group">
											<label class="col-sm-2 control-label">角色ID</label>
											<div class="col-sm-2">
												<c:choose>
													<c:when test="${actionType == 'create' }">
														<input type="text" id="roleId" name="id" class="form-control"/>
													</c:when>
													<c:when test="${actionType == 'update' }">
														<p class="form-control-static">${role.id}</p>
													</c:when>
												</c:choose>
											</div>
										</div>
										<div class="hr-line-dashed"></div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">角色名稱</label>
											<div class="col-sm-2">
												<input type="text" id="roleName" name="name" class="form-control" value="${role.name }"/>
											</div>
										</div>	
										<div class="hr-line-dashed"></div>	
										
										<div class="form-group">
											<label class="col-sm-2 control-label">是否啟用</label>
											<div class="col-sm-10">
												<div class="i-checks">
													<label class="radio-inline"> 
														<input type="radio" id="roleEnabled" value="true" name="enabled" ${role.enabled? 'checked="checked"' : ''}/> <i></i> 是
													</label>
                                        			<label class="radio-inline"> 
                                        				<input type="radio" id="roleEnabled" value="false" name="enabled" ${role.enabled? '' : 'checked="checked"'}/> <i></i> 否
                                        			</label>													
												</div>
											</div>
										</div>	
										<div class="hr-line-dashed"></div>	
										
										<div class="form-group">
											<div class="col-sm-4 col-sm-offset-2">
												<button class="btn btn-white" type="button" onclick="javascript:window.location.href='roleUpdateCancelPassAuth'">取消</button>
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