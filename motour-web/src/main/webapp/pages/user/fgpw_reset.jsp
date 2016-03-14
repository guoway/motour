<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/components/header_not_login.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />

<tiles:putAttribute name="moduleJS">
	<script src="js/motour/user/fgpw_reset.js"></script>
</tiles:putAttribute>

<tiles:putAttribute name="content">
<div class="booking-header">
    <div class="container">
        <div class="account">
            <div class="col-md-6">
                <img src="images/account01.jpg" alt="">
            </div>
            <div class="col-md-6">
                <h2>重設密碼</h2>
                <hr>
				<form id="resetPasswordForm" action="${pageContext.request.contextPath}/resetPassword" method="post">
					<table class="booking-detail">
						<input type="hidden" name="userId" value="${userId}"/>
						<tr>
							<td class="detail-title">新密碼</td>
							<td>
								<input id="password" name="password" type="password"/>
							</td>
						</tr>
						<tr>
							<td class="detail-title">再輸入一次新密碼</td>
							<td>
								<input id="password2" name="password2" type="password"/>
							</td>
						</tr>
						<tr>
							<td class="detail-contract" colspan="2">
								<div class="detail-step">
									<input type="submit" value="重設" />
								</div>
							</td>
						</tr>
					</table>
				</form>
            </div>
        </div>
    </div>
</div>  
    
</tiles:putAttribute>
</tiles:insertDefinition>