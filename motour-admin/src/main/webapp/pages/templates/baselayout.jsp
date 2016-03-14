<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>MoTour Administration</title>	
    
    <tiles:importAttribute name="tilesDefinitionName" scope="request" ignore="true"/>
	
	<!-- 所有共用到的css -->
	<jsp:include page="../components/css_declaration.jsp"></jsp:include>
	<tiles:insertAttribute name="moduleCSS" ignore="true"/>
	
	<title><tiles:getAsString name="title" /></title>
	<link rel="bookmark" href="img/favicon.ico"/>
	<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico"  />
	
</head>
<body id="wrapper">

	<!-- LEFT Nav Bar Start -->
	<nav id="leftNav" class="navbar-default navbar-static-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav metismenu" id="side-menu">
				<!-- 個人頭像及相關訊息 Start -->
            	<li class="nav-header">
                    <div class="dropdown profile-element"> 
                    	<span>
                        	<img alt="image" class="img-circle" src="img/profile_small.jpg" />
                        </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
	                        <span class="clear"> 
	                        	<span class="block m-t-xs"> 
	                        		<strong class="font-bold">${user.name}</strong>
	                         	</span> 
	                         	<span class="text-muted text-xs block">
	                         		${user.id}<b class="caret"></b>
	                         	</span> 
	                        </span> 
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html">Profile</a></li>
                            <li><a href="contacts.html">Contacts</a></li>
                            <li><a href="mailbox.html">Mailbox</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>			
                <!-- 個人頭像及相關訊息 End -->
				
				<!-- Menu Start -->
				<jsp:include page="../components/menu.jsp"/>
				<!-- Menu End -->
			</ul>
		</div>
	</nav>
	<!-- LEFT Nav Bar End -->
	
	<div id="page-wrapper" class="gray-bg">
	
		<!-- Top Nav Bar Start -->
		<jsp:include page="../components/top_nav_bar.jsp"/>
		<!-- Top Nav Bar End -->
	
		<!-- Title & Breadcrumb Start -->
		<jsp:include page="../components/breadcrumb.jsp"/>
		<!-- Title & Breadcrumb End -->
		
		<!-- Main content Start -->
		<tiles:insertAttribute name="content" />
		<!-- Main content Start -->
		
		<!-- footer Start -->    
	    <jsp:include page="../components/footer.jsp"/>
	    <!-- footer End -->		
	</div>

	<!-- Right Side Message Bar Start -->
    <jsp:include page="../components/right_side_msg_bar.jsp"/>
    <!-- Right Side Message Bar End -->
    
    
    
    <!-- 所有共用到的 js -->
	<jsp:include page="../components/js_declaration.jsp"></jsp:include>
	<tiles:insertAttribute name="moduleJS" ignore="true"/>        
</body>
</html>