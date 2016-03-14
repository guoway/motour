<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="header" value="/pages/booking/header_b.jsp" />	
<tiles:putAttribute name="content">
    <div class="booking-header">
	<div class="container">
		<div class="col-md-12">
			<p>預訂成功，請至 email信箱查看你的訂單資訊或進入會員服務查詢您的訂單資訊!!!</p>
		</div>
	</div>
	</div>	
</tiles:putAttribute>
</tiles:insertDefinition>