<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/booking/header_b.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />

<tiles:putAttribute name="moduleJS">
    <!-- masonry -->
    <script src="https://unpkg.com/masonry-layout@4.0/dist/masonry.pkgd.js"></script>
    
    
    <!-- masonry start -->
    <script>
    $('.grid').masonry({
        itemSelector: '.grid-item',
        columnWidth: 470,
        isFitWidth: true
    });
    </script>
    <!-- masonry end -->
        
</tiles:putAttribute>
<tiles:putAttribute name="moduleCSS">
<style type="text/css">
/* ---- grid ---- */

.grid-item {
    width: 450px;
    height: 300px;
    float: left;
    border: 1px solid #ccc;
    border-radius: 5px;
    overflow: hidden;
    margin: 10px;
}

.grid-item--height2 {
    height: 450px;
}

.grid-item--height3 {
    height: 600px;
}

.operation-deal {
    padding: 1em;
    position: absolute;
    bottom: 0;
    background: #fff;
    width: 100%;
}

@media(max-width:480px) {
    .grid-item {
        width: 320px;
        height: 366px;
    }
    .grid-item img {
        width: 100%;
    }
    .grid-item--height2 {
        height: 411px;
    }
    .grid-item--height3 {
        height: 503px;
    }
}

@media(max-width:320px) {
    .grid-item {
        width: 270px;
        height: 309px;
    }
    .grid-item--height2 {
        height: 347px;
    }
    .grid-item--height3 {
        height: 424px;
    }
}


/* ---- grid end ---- */
</style>
</tiles:putAttribute>
<tiles:putAttribute name="content">
    
<div class="booking-header">
    <div class="container">
        <div class="service-top">
            <h3>摩途據點</h3>
        </div>
        <div class="col-lg-12">
            <div class="dealer-top"> 
				<div class="deal-top-top">
					<div class="grid">
						<c:forEach items="${offices}" var="office" varStatus="status">
							<c:set var="officeURL" value="${pageContext.request.contextPath}/operationOffice?operationOfficeId=${office.oid}" scope="page"/>
                            <div class="grid-item">
                                <a href="${officeURL }">
                                    <img src="data/${office.image}" class="zoom-img">
                                </a>
                                <div class="operation-deal">
                                    <div class="top-deal1">
                                        <h5><a href="${officeURL }">${office.name}</a></h5>
                                    </div>
                                    <div class="top-deal2">
                                        <a class="hvr-sweep-to-right more" href="${officeURL }">More</a>
                                    </div>
                                </div>
                            </div>							
						</c:forEach>					
					</div>
				</div>
            </div>                        
        </div>
    </div>
</div>
    
    
    
    
</tiles:putAttribute>
</tiles:insertDefinition>