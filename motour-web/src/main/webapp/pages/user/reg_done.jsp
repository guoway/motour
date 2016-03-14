<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/components/header_not_login.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">

<div class="booking-header">
    <div class="container">
        <div class="account">
            <div class="col-md-6">
                <img src="images/account01.jpg" alt="">
            </div>
            <div class="col-md-6">
                <h2>完成註冊</h2>
                <hr>
                <p>
				您已完成註冊，您可立即回到「<a href="${pageContext.request.contextPath}/index">首頁重新登入</a>」。
				</p>
            </div>
        </div>
    </div>
</div>
    
</tiles:putAttribute>
</tiles:insertDefinition>