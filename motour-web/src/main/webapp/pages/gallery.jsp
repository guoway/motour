<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="moduleCSS">

</tiles:putAttribute>
<tiles:putAttribute name="moduleJS">
	<script src="js/plugins/masonry/masonry.pkgd.js"></script>
	<script type="text/javascript">
	$(function() {
		$('.grid').masonry({
			itemSelector: '.grid-item',
			columnWidth: 100%,
		});
	});
		
	</script>
</tiles:putAttribute>
<tiles:putAttribute name="content">
<style>
	.grid-item { width: 400px; height:400px;}
	.grid-item--width2 { width: 400px; height:200x; }
</style>
<div class="booking-header">
    <div class="container">
        <div class="service-top">
            <h3>摩途據點</h3>
        </div>
        <div class="col-md-12">      
            <div class="dealer-top">
                <div class="grid">
                	<c:forEach items="${list}" var="image" varStatus="status">
                		
	                    <div class="${status.count mod 2 == 0 ? 'grid-item':'grid-item--width2' }">
	                        <div class="top-deal">
	                            <a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=2" class="mask">
	                            	<img src="data/${image.image}" class="img-responsive zoom-img" alt="">
	                            </a>
	                            <div class="deal-bottom">
	                                <div class="top-deal1">
	                                    <h5><a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=2">測試</a></h5>
	                                    <!-- 
	                                    <p>${office.address}</p>
	                                     -->
	                                </div>
	                                <div class="top-deal2">
	                                    <a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=2" class="hvr-sweep-to-right more">More</a>
	                                </div>
	                                <div class="clearfix"> </div>
	                            </div>
	                        </div>
	                    </div>                	
                	</c:forEach>                    
                    <div class="clearfix"> </div>
                </div>             
            </div>
        </div>
    </div>
</div>
</tiles:putAttribute>
</tiles:insertDefinition>	
