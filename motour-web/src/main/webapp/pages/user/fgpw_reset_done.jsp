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
                <h2>重設密碼</h2>
                <hr>
                <p>
				密碼重設完成，請使用新密碼登入Motour	
				</p>
            </div>
        </div>
    </div>
</div>
    
</tiles:putAttribute>
</tiles:insertDefinition>