<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="navigation">
			<div class="container-fluid">
				<nav class="pull">
					<ul>						
						<li><a href="${pageContext.request.contextPath}/customerservice">客戶服務</a></li>
                        <li><a href="${pageContext.request.contextPath}/operationOffices">摩途客拉部</a></li>
                        <c:if test="${user ne null}">
                        	<li><a href="${pageContext.request.contextPath}/logout">登出</a></li>
                        </c:if>
					</ul>
				</nav>
			</div>
		</div>

<div class="header">
	<div class="container">
		<!--logo-->
			<div class="logo">
				<a href="index"><img class="img-responsive" style="width:50%;" src="images/logo_web.png" alt=""></a>
			</div>
		<!--//logo-->
		<div class="top-nav">
			<div class="nav-icon">
				<div class="hero fa-2x nav_slide_button" id="hero">
					<a href="#"><i class="fa fa-bars"></i> </a>
				</div>
			</div>
			<!-- <ul class="right-icons">
				<li><a href="">登入</a></li>
				<li><a href="">註冊</a></li>
			</ul> -->
			
			<c:set var="locale" value="${pageContext.response.locale}" scope="session"/>
			<div class="language">
				<select onchange="javascript:changeLang(this);">
					 <option value="?language=zh_TW" <c:if test="${pageContext.response.locale =='zh_TW'}">selected</c:if>>繁體中文</option>
					 <!-- 
					 <option value="?language=cn" <c:if test="${pageContext.response.locale =='cn'}">selected</c:if>>简体中文</option>
					 <option value="?language=en" <c:if test="${pageContext.response.locale =='en'}">selected</c:if>>English</option>
					  -->
				</select>
			</div>
			
			<!-- Login related start-->
			<c:if test="${user eq null}">
				<div class="menu-left">
					 <ul class="menu" style="width:115px">
						<li class="item1"><a style="color:#000;" href="#"><spring:message code="mt.login"></spring:message></a>
							<ul class="cute">
								<li class="subitem1"><a href="#loginForm" rel="modal:open">會員登入</a></li>
								<!-- 
								<li class="subitem2"><a href="#ex3" rel="modal:open">特約商登入</a></li>
								 -->
								<li class="subitem2"><a href="#fgpwForm" rel="modal:open">忘記密碼</a></li>
								<li class="subitem2"><a href="#registerForm" rel="modal:open">會員註冊</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</c:if>
			<!-- Login related end -->
			
			<div class="clearfix"> </div>
			
			<form id="loginForm" action="${pageContext.request.contextPath}/login" method="post" class="login_form modal" style="display:none;">
				<h3>會員登入</h3>
				<p><label>會員帳號:</label><input type="text" name="userId" /></p>
				<p><label>密碼:</label><input type="password" name="passwd"/></p>
				<p><input type="submit" value="登入" /></p>
			</form>
			
			 
			<form action="" class="login_form modal" id="ex3" style="display:none;">
				<h3>特約商登入</h3>
				<p><label>會員帳號:</label><input type="text" /></p>
				<p><label>密碼:</label><input type="password" /></p>
				<p><input type="submit" value="登入" /></p>
			</form>
			 			
			

			<form id="fgpwForm" action="${pageContext.request.contextPath}/forgetPassword" class="login_form modal" style="display:none;">
				<h3>忘記密碼</h3>
				<p><label>會員帳號:</label><input type="text" name="userId" /></p>
				<p><input type="submit" value="送出" /></p>
			</form>
			
			<form id="registerForm" action="${pageContext.request.contextPath}/register" method="post" class="login_form modal" style="display:none;">
				<h3>會員註冊</h3>
				<p><label>帳號(Email):</label><input type="text" id="id" name="id"/></p>
				<p><label>密碼:</label><input type="password" id="passwd" name="ss3aMember.password" /></p>
				<p><label>確認密碼:</label><input type="password" id="passwdConfirm" name="passwdConfirm" /></p>
				<p><label>姓名:</label><input type="text" id="name" name="name" /></p>
				<p><label>行動電話:</label><input type="text" id="mobile" name="mobile" /></p>
				<p><input type="submit" id="register" name="register" value="註冊" /></p>				
			</form>
			
		</div>
		<div class="clearfix"> </div>
	</div>
</div>