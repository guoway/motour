<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/booking/header_b.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">
    
<div class="booking-header">
    <div class="container">
        <div class="service-top">
            <h3>摩途據點</h3>
        </div>
        <div class="col-md-12">
            <div class="dealer-top"> 
            		<c:if test="${fn:length(offices) mod 3 == 2}">
            			<c:set var="lastLoopRemainCount" value="2" scope="page"/>
            			
            			<c:set var="lastLoopClassName" value="col-md-offset-2"/>
            		</c:if>
            		<c:if test="${fn:length(offices) mod 3 == 1}">         
            			<c:set var="lastLoopRemainCount" value="1" scope="page"/>
            			<c:set var="lastLoopClassName" value="col-md-offset-4"/>
            		</c:if>                		                    		              
                	<c:forEach items="${offices}" var="office" varStatus="status">
                	
                		<c:if test="${status.count == 1 || status.count mod 3 == 1}">
                			<div class="deal-top-top">
                		</c:if>

                		<c:choose>               			
	                		<c:when test="${fn:length(offices)-status.count == 1 && lastLoopRemainCount == 2}">
								<div class="col-md-4 col-md-offset-2 top-deal-top">
	                		</c:when>
	                		<c:when test="${fn:length(offices)-status.count == 0 && lastLoopRemainCount == 1}">
	                			<div class="col-md-4 col-md-offset-4 top-deal-top">
	                		</c:when>	                		
	                		<c:otherwise>
	                			<div class="col-md-4 top-deal-top">
	                		</c:otherwise>
                		</c:choose>
	                        <div class=" top-deal">
	                            <a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=${office.oid}" class="mask">
	                            	<img src="data/${office.image}" class="img-responsive zoom-img" alt="">
	                            </a>
	                            <div class="deal-bottom">
	                                <div class="top-deal1">
	                                    <h5><a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=${office.oid}">${office.name}</a></h5>
	                                    <!-- 
	                                    <p>${office.address}</p>
	                                     -->
	                                </div>
	                                <div class="top-deal2">
	                                    <a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=${office.oid}" class="hvr-sweep-to-right more">More</a>
	                                </div>
	                                <div class="clearfix"> </div>
	                            </div>
	                        </div>
	                    </div>
	                     
                		<c:if test="${(status.count != 1 && status.count mod 3 == 0) || status.last}">
                			<div class="clearfix"> </div>
                			</div>  
                		</c:if>	                                   	
                	</c:forEach>                                        
            </div>                        
            <%--
            <div class="pagination pagination-centered">
                <ul>
                    <li><a href="#">«</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">»</a></li>
                </ul>
            </div>
             --%>
        </div>
    </div>
</div>
    
    
    
    
</tiles:putAttribute>
</tiles:insertDefinition>