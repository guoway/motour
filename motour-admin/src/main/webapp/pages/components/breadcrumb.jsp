<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<!-- 主功能標題 -->
		<h2>${activeMenu.name}</h2>
		
		<!-- 麵包屑  Start -->
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/dashboard">Home</a></li>
			<c:forEach items="${breadcrumbs}" var="bc" varStatus="st">
				<li ${st.last? 'class="active"' : ''}>
					<c:choose>
						<c:when test="${bc.url != null && bc.url != ''}">
							<a href="${pageContext.request.contextPath}${bc.url}">${bc.name}</a>
						</c:when>
						<c:otherwise>
							${bc.name}
						</c:otherwise>
					</c:choose>					
				</li>
			</c:forEach>
		</ol>
		<!-- 麵包屑 End -->
	</div>
	<div class="col-lg-2"></div>
</div>
