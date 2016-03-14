<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/customer_service/header_s.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">

<div class="booking-header">
	<div class="container">
		<div class="service-top">
			<h3>客戶服務</h3>
		</div>
		
		<div class="col-md-6 col-md-offset-3" align="center">
			<div class="faq-c">
			    <a href="orderlist"> 訂單管理 </a>			    
			</div>
			
			<div class="faq-c">
			    <a href="memberprofile">會員資料</a>
			</div>
			
			<div class="faq-c">
			    <a href="faq">常見問題</a> 
			</div>
			
		</div>
	</div>
</div>    
    
</tiles:putAttribute>
</tiles:insertDefinition>