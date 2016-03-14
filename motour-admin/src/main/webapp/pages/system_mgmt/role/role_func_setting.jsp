<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tiles:insertDefinition name="baselayout">

<tiles:putAttribute name="moduleCSS">
	<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
</tiles:putAttribute>

<tiles:putAttribute name="moduleJS">
	<!-- Nestable List -->
    <script src="js/plugins/nestable/jquery.nestable.js"></script>
    
    <script>
         $(document).ready(function(){

             // activate Nestable for list 1
             $('#nestable').nestable({
                 group: 1
             });


             $('#nestable-menu').on('click', function (e) {
                 var target = $(e.target),
                         action = target.data('action');
                 if (action === 'expand-all') {
                     $('.dd').nestable('expandAll');
                 }
                 if (action === 'collapse-all') {
                     $('.dd').nestable('collapseAll');
                 }
             });
         });
    </script> 


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
		                <div class="col-lg-10">
		                    <div class="ibox ">
		                        <div class="ibox-title">
		                            <h5 class="fn-title-h5">${activeMenu.name}</h5>
				                    <div id="nestable-menu" style="margin:0px;">
				                        <button type="button" data-action="expand-all" class="btn btn-white btn-sm">Expand All</button>
				                        <button type="button" data-action="collapse-all" class="btn btn-white btn-sm">Collapse All</button>
				                    </div>		                            
		                        </div>
		                        <div class="ibox-content">
		                        	<form action="${pageContext.request.contextPath}/roleFuncSetting" method="post">
			                        	<div class="form-group">
				                            <div class="dd" id="nestable">				                            	
				                                <ol class="dd-list">
													<c:set var="funcs" value="${functions}" scope="request"/>
													<jsp:include page="role_func_setting_recur_node.jsp"/>
				                                </ol>				                               
				                            </div>
			                            </div>
										<div class="hr-line-dashed"></div>	
										
										<div class="form-group">
											<div class="col-lg-offset-5">
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