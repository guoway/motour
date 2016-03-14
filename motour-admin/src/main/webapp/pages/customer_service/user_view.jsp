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
	<script src="js/customer_service/user_view.js"></script>
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
									<form id="actionForm" class="form-horizontal" method="post" action="${actionType == 'create'? 'userCreate':'userUpdate' }">
										<div class="form-group">
											<label class="col-sm-2 control-label">會員ID</label>
											<div class="col-sm-2">
												<c:choose>
													<c:when test="${actionType == 'create' }">
														<input type="text" id="id" name="id" class="form-control"/>
													</c:when>
													<c:when test="${actionType == 'update' }">
														<p class="form-control-static">${user.id}</p>
													</c:when>
												</c:choose>
											</div>
										</div>
										<div class="hr-line-dashed"></div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">密碼</label>
											<div class="col-sm-2">
												<c:choose>
													<c:when test="${actionType == 'create' }">
														<input type="password" id="password" name="ss3aMember.password" class="form-control"/>
													</c:when>
													<c:when test="${actionType == 'update' }">
														<button type="button" class="btn btn-sm btn-warning" data-toggle="modal" data-target="#passwordModal">修改密碼</button>
													</c:when>
												</c:choose>												
											</div>
										</div>										
										<div class="hr-line-dashed"></div>		
										
										<c:if test="${actionType == 'create' }">
											<div class="form-group">
												<label class="col-sm-2 control-label">再一次輸出密碼</label>
												<div class="col-sm-2">
													<input type="password" id="password2" name="password2" class="form-control"/>
												</div>
											</div>	
											<div class="hr-line-dashed"></div>	
										</c:if>																			
																											
																				
										<div class="form-group">
											<label class="col-sm-2 control-label">姓名</label>
											<div class="col-sm-2">
												<input type="text" id="name" name="name" class="form-control" value="${user.name }"/>
											</div>
										</div>	
										<div class="hr-line-dashed"></div>	
										
										<div class="form-group">
											<label class="col-sm-2 control-label">手機號碼</label>
											<div class="col-sm-2">
												<input type="text" id="mobile" name="mobile" class="form-control" value="${user.mobile }"/>
											</div>
										</div>	
										<div class="hr-line-dashed"></div>	
										
										<div class="form-group">
											<label class="col-sm-2 control-label">備用Email</label>
											<div class="col-sm-2">
												<input type="text" id="email" name="email" class="form-control" value="${user.email }"/>
											</div>
										</div>	
										<div class="hr-line-dashed"></div>		
										
										<div class="form-group">
											<label class="col-sm-2 control-label">身份證字號</label>
											<div class="col-sm-2">
												<input type="text" id="identity" name="identity" class="form-control" value="${user.identity }"/>
											</div>
										</div>	
										<div class="hr-line-dashed"></div>																														
										
										<div class="form-group">
											<label class="col-sm-2 control-label">是否啟用</label>
											<div class="col-sm-10">
												<div class="i-checks">
													<label class="radio-inline"> 
														<input type="radio" id="managerEnabled" value="true" name="ss3aMember.enabled" ${user.ss3aMember.enabled? 'checked="checked"' : ''}/> <i></i> 是
													</label>
                                        			<label class="radio-inline"> 
                                        				<input type="radio" id="managerEnabled" value="false" name="ss3aMember.enabled" ${user.ss3aMember.enabled? '' : 'checked="checked"'}/> <i></i> 否
                                        			</label>													
												</div>
											</div>
										</div>	
										<div class="hr-line-dashed"></div>	
										
										<div class="form-group">
											<div class="col-sm-4 col-sm-offset-2">
												<button class="btn btn-white" type="button" onclick="javascript:window.location.href='userUpdateCancelPassAuth'">取消</button>
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

			<!-- 修改密碼Modal Start -->
			<div class="modal inmodal" id="passwordModal" tabindex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content animated bounceInRight">
						<form id="passwordForm" class="form-horizontal" method="post" action="mgrUpdatePassword">
							<div class="modal-header">
								<i class="fa fa-key modal-icon"></i>
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">結束</span>
								</button>
								<h4 class="modal-title">修改密碼</h4>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label class="col-xs-4 control-label">新密碼</label>
									<div class="col-xs-4">
										<input type="password" id="password3" name="newPassword" class="form-control"/>
									</div>
								</div>
								<div class="hr-line-dashed"></div>
								<div class="form-group">
									<label class="col-xs-4 control-label">再一次輸出新密碼</label>
									<div class="col-xs-4">
										<input type="password" id="password4" name="password4" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary" onclick="javascript:updatePassword();">儲存</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- 修改密碼Modal End -->
	</tiles:putAttribute>
</tiles:insertDefinition>