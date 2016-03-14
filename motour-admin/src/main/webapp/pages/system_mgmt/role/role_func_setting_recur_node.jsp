<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach items="${funcs}" var="func">

	<spring:eval expression="(role.functions).contains(func)" var="existed"/>
	<li class="dd-item" data-id="${func.id}">
		<div class="dd-handle">
			<div class="i-checks">
				<label> 
					<input type="checkbox" id="${func.id}" value="${func.id}" name="selectedFuncs" ${existed ? 'checked="checked"':''}/> <i></i> ${func.name}
				</label>
			</div>
		</div>
		<c:if test="${fn:length(func.subFunctions) > 0 }">
			<ol class="dd-list">
				<c:set var="funcs" value="${func.subFunctions}" scope="request"/>
				<jsp:include page="role_func_setting_recur_node.jsp"/>
			</ol>
		</c:if>
	</li>
	
</c:forEach>