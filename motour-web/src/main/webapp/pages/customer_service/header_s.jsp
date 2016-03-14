<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="isUserLogged" value="${(user == null)? false : true}"/>

<div class="banner-member">
	<div class=" container">
	
	<div class="menu-right">
		 <ul class="menu">
			<li class="item1"><a href="#">客戶服務<i class="glyphicon glyphicon-menu-down"> </i> </a>
				<ul class="cute">
					<c:if test="${isUserLogged}">
						<li class="subitem1"><a href="orderlist">訂單管理</a></li>
						<li class="subitem2"><a href="memberprofile">會員資料</a></li>										
					</c:if>
					<%--
					<li class="subitem3"><a href="discount">折扣分享</a></li>
					 --%>					
					<li class="subitem2"><a href="faq">常見問題</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="clearfix"> </div>
		<!--initiate accordion-->
	</div>
</div>

