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
                <h2>忘記密碼</h2>
                <hr>
                <p>
				系統已發送一封「重設密碼」通知信件給您註冊的帳號，請至該信箱收取信件並點選內文的連結進行「重設密碼」。	
				</p>
            </div>
        </div>
    </div>
</div>    
</tiles:putAttribute>
</tiles:insertDefinition>