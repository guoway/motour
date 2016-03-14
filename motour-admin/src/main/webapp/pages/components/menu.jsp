<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:forEach items="${menus}" var="menu">
	<li ${(menu.id eq activeMenu.id)? 'class="active"' : ''}><a
		href="${pageContext.request.contextPath}${menu.url}"> <i
			class="fa fa-th-large"></i> <span class="nav-label">${menu.name}</span>
			<c:if test="${fn:length(menu.subFunctions) gt 0}">
				<span class="fa arrow"></span>
			</c:if>
	</a> <c:if test="${fn:length(menu.subFunctions) gt 0}">
			<ul class="nav nav-second-level collapse">
				<c:forEach items="${menu.subFunctions}" var="subMenu">
					<li><a href="${pageContext.request.contextPath}${subMenu.url}">${subMenu.name}</a></li>
				</c:forEach>
			</ul>
		</c:if></li>
</c:forEach>
