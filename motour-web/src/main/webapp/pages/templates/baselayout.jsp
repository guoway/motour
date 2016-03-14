<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Real Home Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<tiles:importAttribute name="tilesDefinitionName" scope="request" ignore="true"/>
	<!-- 自訂義各頁所需要的meta -->
	<tiles:insertAttribute name="meta"/>
	<!-- 所有共用到的css 和  js -->
	<jsp:include page="../components/css_declaration.jsp"></jsp:include>
	<tiles:insertAttribute name="moduleCSS" ignore="true"/>

	<title><tiles:getAsString name="title" /></title>
	<link rel="bookmark" href="images/favicon.ico"/>
	<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico"  />
	
</head>
<body>
		<tiles:insertAttribute name="navigation" />
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="footer" />
        <jsp:include page="../components/js_declaration.jsp"></jsp:include>
        <tiles:insertAttribute name="moduleJS" ignore="true"/>
</body>
</html>