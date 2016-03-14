<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/customer_service/header_s.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="moduleCSS">
	<style>
		.hiddenRow {
 	   padding: 0 !important;
	}
	</style>
</tiles:putAttribute>
<tiles:putAttribute name="moduleJS">
	<script type="text/javascript" src="js/bootstrap/transition.js"></script>
	<script type="text/javascript" src="js/bootstrap/collapse.js"></script>
	<script type="text/javascript" src="js/motour/orderList.js"></script>
</tiles:putAttribute>
<tiles:putAttribute name="content">

<div class="booking-header">
	<div class="container">
		<div class="service-top">
			<h3>訂單管理</h3>
		</div>
		<c:choose>
			<c:when test="${empty orders}">
				<div class="col-md-12">
					<center>
						查無資料
					</center>
					
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-md-12">
					<table class="table table-condensed booking-detail" style="border-collapse:collapse;">
						<tr class="detail-thead">
							<td>訂單日期</td>
							<td class="hidden-xs">訂單編號</td>
							<td>取車日期</td>
							<td class="hidden-xs">還車日期</td>
							<td>訂單明細</td>
						</tr>
						<c:forEach items="${orders}" var="order">
						 <!-- <tr class="myorder-border" data-toggle="collapse" data-target="#collapseDetail${order.id}" class="accordion-toggle"> -->
						 <tr class="myorder-border">
							<td><fmt:formatDate pattern="yyyy/MM/dd" value="${order.orderTime}"/></td>
							<td class="hidden-xs">${order.orderCode }</td>
							<td><fmt:formatDate pattern="yyyy/MM/dd hh:mm" value="${order.rentTime}"/></td>
							<td class="hidden-xs"><fmt:formatDate pattern="yyyy/MM/dd hh:mm" value="${order.predictReturnTime}"/></td>
							<td class="myorder-border-2">
								<a class="btn" role="button" data-toggle="collapse" href="#collapseDetail${order.id}">
		  							查看
								</a>
								
								<c:choose>
									<c:when test="${order.status=='CANCEL'}">
										<a class="btn"><span style="color: red;"> 已退訂 </span></a>		
									</c:when>
									<c:otherwise>
										<a class="btn" target="_blank" href="${pageContext.request.contextPath}/printDetail?code=${order.orderCode}">列印</a>
										<a class="btn" id="cancel" onclick="javascript:cancel(${order.id},'${order.orderTime}','${order.rentTime}');" >退訂</a>	
									</c:otherwise>
								</c:choose>
								
							</td>
						 </tr>
						 <tr>
						 	<td class="hiddenRow" colspan="5">
						 	<div class="accordion-body collapse" id="collapseDetail${order.id}">
							  <div class="well">
							  	<!--查看-->
							  	<div class="booking-detail-2">
							  		<div class="detail-thead detail-contract">
							  			訂單明細
							  		</div>
							  		<ul class="booking-detail-ul">
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">營運據點</td>
							  						<td>${order.getMotorLocation.office.name}</td>
							  					</tr>
							  				</table>
							  			</li>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">取、還車點</td>
							  						<td>${order.getMotorLocation.name}</td>
							  					</tr>
							  				</table>
							  			</li>	
							   			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">租車日期</td>
							  						<td><fmt:formatDate pattern="yyyy/MM/dd hh:mm" value="${order.rentTime}"/></td>
							  					</tr>
							  				</table>
							  			</li>
										<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">還車日期</td>
							  						<td><fmt:formatDate pattern="yyyy/MM/dd hh:mm" value="${order.predictReturnTime}"/></td>
							  					</tr>
							  				</table>
							  			</li>
										<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">租用人姓名</td>
							  						<td>${order.user.name}</td>
							  					</tr>
							  				</table>
							  			</li>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">識別ID<br><span style="font-size: 6px">(身份證、護照號碼)</span></td>
							  						<td>${order.user.identity}</td>
							  					</tr>
							  				</table>
							  			</li>
										<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">聯絡人手機</td>
							  						<td>${order.phone}</td>
							  					</tr>
							  				</table>
							  			</li>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">聯絡人Email</td>
							  						<td class="email-work">${order.email }</td>
							  					</tr>
							  				</table>
							  			</li>
									</ul>
								</div>	
								<div class="booking-detail-2">
							  		<div class="detail-thead detail-contract">
							  			車型明細
							  		</div>
							  		<ul class="booking-detail-ul">
							  			<c:forEach items="${order.details}" var="m">
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">車型</td>
							  						<td>${m.motorcycleType.name} (${m.rentPlan.name})</td>
							  					</tr>
							  				</table>
							  			</li>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">數量</td>
							  						<td>${m.quantity}</td>
							  					</tr>
							  				</table>
							  			</li>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">金額</td>
							  						<td>${m.totalPrice}</td>
							  					</tr>
							  				</table>
							  			</li>
							  			</c:forEach>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">總金額</td>
							  						<td>${order.amount }</td>
							  					</tr>
							  				</table>
							  			</li>

							  		</ul>
							  	</div>
							  	<div class="booking-detail-2">
							  		<div class="detail-thead detail-contract">
							  			發票明細
							  		</div>
							  		<ul class="booking-detail-ul">
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">發票形式</td>
							  						<td>${order.invType.getName()}  統一編號: ${order.invBid}</td>
							  					</tr>
							  				</table>
							  			</li>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">發票抬頭</td>
							  						<td>${order.invTitle}</td>
							  					</tr>
							  				</table>
							  			</li>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">發票地址</td>
							  						<td>${order.invZip} &nbsp;&nbsp; ${order.invAddress}</td>
							  					</tr>
							  				</table>
							  			</li>
							  			<li>
							  				<table class="bottom-0 border-0">
							  					<tr>
							  						<td class="detail-title width-40">收件人</td>
							  						<td>${order.invReceiver}</td>
							  					</tr>
							  				</table>
							  			</li>

							  		</ul>
							  	</div>
							  	<!--//查看-->
							  </div>
							</div>
							</td>	
							</tr>	
						</c:forEach>
					</table>

				</div>
			</c:otherwise>
		</c:choose>
		
	</div>
</div>    
    
</tiles:putAttribute>
</tiles:insertDefinition>