<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/components/header_not_login.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">

<div class="booking-header">
	<div class="container">
		<div class="service-top">
			<h3>驗證失敗</h3>
		</div>
		<div class="col-md-12">
			此驗證碼或使用者帳號無效，請重試一次或連絡客服人員。
		</div>
	</div>
</div>    

<div class="booking-header">
    <div class="container">
        <div class="account">
            <div class="col-md-6">
                <img src="images/account01.jpg" alt="">
            </div>
            <div class="col-md-6">
                <h2>驗證失敗</h2>
                <hr>
                <p>
				此驗證碼或使用者帳號無效，請重試一次或連絡客服人員。
				</p>
            </div>
        </div>
    </div>
</div>
    
</tiles:putAttribute>
</tiles:insertDefinition>