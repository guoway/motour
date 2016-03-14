<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:url value="/resources" var="resources" />
<spring:url value="/resources/images" var="imgPath" />



<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="header" value="" />
<tiles:putAttribute name="content">
    <input type="button" value="測試message" onclick="javascript:getMessage();">
    
</tiles:putAttribute>
<tiles:putAttribute name="footer" value="" />
</tiles:insertDefinition>

<script type="text/javascript" src="js/motour/mt_message.js"></script>
<script type="text/javascript">
	function getMessage() {
		var vars = [] ;
		vars.push(encodeURIComponent('abc')) ;
		vars.push('def') ;
		var msgType = MTMessage.options.codeType.success ;
		MTMessage.showMessage('0001', vars, msgType) ;
	}	
</script>