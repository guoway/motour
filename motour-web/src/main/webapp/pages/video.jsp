<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<tiles:insertDefinition name="baselayout">
	<tiles:putAttribute name="title" value="MotourClub" />
    <tiles:putAttribute name="content">

	<div class="header-right">
		<div class="banner">
			      <ul class="rslides" id="slider">	
					 <li>
			          	 <section class="no-padding video-half-screen position-relative overflow-hidden cover-background" style="background-image:url('http://placehold.it/1920x1080');" >
			          	     <video autoplay preload muted loop class="html-video">
			          	             <source type="video/mp4" src="resources/videos/index_movie.mp4">
			          	     </video>
			          	 </section>			          	 		          	 
			         </li>			         	         			         
			      </ul>
		</div>
	</div>
 
    </tiles:putAttribute>
</tiles:insertDefinition>