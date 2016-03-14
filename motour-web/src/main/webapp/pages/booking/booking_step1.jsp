<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/booking/header_b.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="moduleCSS">
	<link href="css/motour/zip_select.css" rel="stylesheet" type="text/css" media="all" />
</tiles:putAttribute>
<tiles:putAttribute name="moduleJS">
	<script type="text/javascript" src="js/motour/zip_select.js"></script>
	<script type="text/javascript" src="js/motour/booking.js"></script>
</tiles:putAttribute>
<tiles:putAttribute name="content">
  <div class="booking-header">
	<div class="container">
		<div class="col-md-12">
		<form id="bookingForm" name="bookingForm" action="${pageContext.request.contextPath}/bookingStep1" method="post">
		<input type="hidden" name="formToken" value="${formToken}" />
			<table class="booking-detail detail-contract">
				<tr class="detail-thead detail-contract">
					<td colspan="4">訂單明細</td>
				</tr>
				<tr class="detail-contract">
					<td class="detail-title">營業據點</td>
					<td>${wrapper.motorOfficeName}</td>
					<td class="detail-title">取、還車點</td>
					<td>${wrapper.motorLocationName}</td>
				</tr>

				<tr class="detail-contract">
					<td class="detail-title">租車日期</td>
					<td>${wrapper.startDatetime}</td>
					<td class="detail-title">還車日期</td>
					<td>${wrapper.endDatetime}</td>
				</tr>
				<tr class="detail-contract">
					<td class="detail-title">租用人姓名</td>
					<td><input type="text" class="form-control" id="renterName" name="renterName" value="${user.name}"/></td>
					<td class="detail-title">識別ID<br><span style="font-size: 6px">(身份證、護照號碼)</span></td>
					<td><input type="text" class="form-control" id="identity" name="identity" value="${user.identity}"/></td>
				</tr>
				<tr class="detail-contract">
					<td class="detail-title">聯絡人手機</td>
					<td><input type="text" class="form-control" id="contactMobile" name="contactMobile" value="${user.mobile}"/></td>
					<td class="detail-title">聯絡人Email</td>
					<td><input type="text" class="form-control" id="contactEmail" name="contactEmail" value="${user.id}"/></td>
				</tr>
				
				<tr>
					
				</tr>
			</table>
			
			<table class="booking-detail">
				<tr class="detail-thead detail-contract" >
					<td colspan="6">車型明細</td>
				</tr>
				<c:forEach items="${wrapper.motorTypesList}" var="m">
					<tr class="detail-contract">
						<td class="detail-title">車型</td>
						<td style="width: 30%">${m.motorType} (${m.rentPlan.name})</td>
						<td class="detail-title">數量</td>
						<td>${m.motorQuantity}</td>
						<td class="detail-title">金額</td>
						<td>${m.subTotal}</td>
					</tr>
				</c:forEach>
				
				<tr class="detail-contract">
					<td class="detail-title">總金額</td>
					<td colspan="5">${wrapper.totalMoney }元</td>
				</tr>
				
			</table>
			<table class="booking-detail">
				<tr class="detail-thead detail-contract" >
					<td colspan="6">發票明細</td>
				</tr>
				<tr class="detail-contract">
					<td class="detail-title">發票形式</td>
					<td colspan="5">
						<select id="invType" name="invType" class="form-control invoice-wd">
							<c:forEach items="${invoiceTypes}" var="inv">
								<option value="${inv}">${inv.name}</option>
							</c:forEach>
						</select>
						<label>統一編號:</label><input type="text" class="form-control invoice-wd-2" id="invBid" name="invBid"/>
					</td>
				</tr>
				<tr class="detail-contract">
					<td class="detail-title">發票抬頭</td>
					<td colspan="5">
						<input type="text" class="form-control invoice-wd-2" id="invTitle" name="invTitle" />
					</td>
				</tr>
				<tr class="detail-contract">
					<td class="detail-title">發票地址</td>
					<td colspan="5">
						<input class="post form-control zipselect" type="text" placeholder="100" id="invZip" name="invZip"/>
						<input type="text" class="form-control invoice-wd-2" id="invAddress" name="invAddress" />
					</td>
				</tr>
				<tr class="detail-contract">
					<td class="detail-title">收件人</td>
					<td colspan="5"><input type="text" class="form-control invoice-wd-2" placeholder="收件人" id="invReceiver" name="invReceiver"/></td>
				</tr>
				<tr class="detail-contract">
					<td class="detail-contract" colspan="6">
						<ul class="detail-contract-2">
							<li>1.會員 (或企業會員之取車人) 須年滿20歲以上且為本國(中華民國籍)之自然人，並持有有效之汽車駕照。</li>
							<li>2.會員應於註冊時填寫完整、真實且最新之個人資料。</li>
							<li>3.本公司得修改或中止各項提供之服務內容，並於網站公告後生效(不須經過個別通知)，會員不得因此要求任何賠償。</li>
						</ul>
						<div class="detail-step">
							<input type="submit" value="上一步" />
							<input type="submit" value="下一步" />
						</div>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</div>
    
</tiles:putAttribute>
</tiles:insertDefinition>