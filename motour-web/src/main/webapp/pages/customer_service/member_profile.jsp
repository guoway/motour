<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/customer_service/header_s.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />

<tiles:putAttribute name="moduleCSS">
	<link href="css/motour/zip_select.css" rel="stylesheet" type="text/css" media="all" />
</tiles:putAttribute>

<tiles:putAttribute name="moduleJS">
	<script type="text/javascript" src="js/motour/zip_select.js"></script>
	<script type="text/javascript" src="js/motour/member_profile.js"></script>
</tiles:putAttribute>

<tiles:putAttribute name="content">
<div class="booking-header">
	<div class="container">
		<div class="service-top">
			<h3>會員資料</h3>
		</div>
		<div class="col-md-12">
			<form:form id="profileForm" class="general_form" method="post" action="${pageContext.request.contextPath}/updateMemberProfile" modelAttribute="userInReq">
				<table class="booking-detail">
					<tr class="detail-thead">
						<td colspan="2">會員基本資料</td>
					</tr>
					<tr>
						<td class="detail-title">帳號</td>
						<td>				
							<div class="col-md-12">
								<label>${userInReq.id}</label>
							</div>									
						</td>
					</tr>
					<tr>
						<td class="detail-title">姓名</td>
						<td>
							<div class="col-md-4">
								<form:input type="text" class="form-control" length="10" path="name" />
							</div>
							
						</td>
					</tr>
					<tr>
						<td class="detail-title">身份證字號</td>
						<td>
							<div class="col-md-8">
								<form:input type="text" class="form-control" placeholder="身份證字號、居留證號、或護照號碼" path="identity"/>
							</div>
							
						</td>
					</tr>
					<tr>
						<td class="detail-title">手機</td>
						<td>
							<div class="col-md-6">
								<form:input type="text" class="form-control" placeholder="手機號碼" path="mobile"/>
							</div>							
						</td>
					</tr>
					<tr>
						<td class="detail-title">發票地址</td>
						<td>
							<div class="col-md-4">
								<form:input type="text" class="form-control zipselect" placeholder="郵遞區號" path="invZip"/>
							</div>
							<div class="col-md-8">
								<form:input id="address" type="text" class="form-control" placeholder="詳細地址" path="invAddress"/>
							</div>
							
						</td>
					</tr>
					<tr>
						<td class="detail-contract" colspan="2">
							<div class="detail-step">
								<input type="button" value="儲存" onclick="javascript:submitUpdateProfile();"/>
								<input type="button" value="取消" onclick="javascript:window.history.back();"  />
							</div>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</div>    
    
</tiles:putAttribute>
</tiles:insertDefinition>