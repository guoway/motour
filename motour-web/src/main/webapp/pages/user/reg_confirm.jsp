<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <h2>帳號驗證</h2>
                <hr>
                <p>
                <c:choose>
                	<c:when test="${returnMessage eq null}">
	                 	謝謝您加入Motour Club，只差一步您就完成了註冊的程序。
	                    <br /> 接下來請至您註冊的郵件信箱查看是否收到了Motour給您的認證信，點選驗證信上的連結後完成帳號開通程序！
	                    <br /> 如您未收到驗證信，請點「
	                    <a href="${pageContext.request.contextPath}/resendVcode?userId=${registererId}">重送驗證信</a>」，系統將再次寄信給您。               	
                	</c:when>
                	<c:otherwise>
                		${returnMessage.content}
                	</c:otherwise>                
                </c:choose>
				</p>
            </div>
        </div>
    </div>
</div>
     
</tiles:putAttribute>
</tiles:insertDefinition>