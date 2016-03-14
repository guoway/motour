<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--header-->
<!--//-->
	<div class="header-right">
		<div class="banner">
			      <ul class="rslides" id="slider">
			         <li>
			         	<div>
			         		<img src="images/slider/index_banner1.jpg"/>
			         	</div>	         
			         </li>
			         <li>
			         	<div>
			         		<img src="images/slider/index_banner2.jpg"/>
			         	</div>	         
			         </li>
			         <li>
			         	<div>
			         		<img src="images/slider/index_banner3.jpg"/>
			         	</div>	   	         
			         </li>		
					 <li id="videoSlider">
			          	 <section class="no-padding video-half-screen position-relative overflow-hidden cover-background" style="background-image:url('http://placehold.it/1920x1080');" >
			          	     <video preload autoplay muted loop class="html-video">
			          	             <source type="video/mp4" src="resources/videos/index_movie.mp4">
			          	     </video>
			          	 </section>			          	 		          	 
			         </li>			         	         			         
			      </ul>
		</div>
	</div>

	<!--header-bottom-->
	<div class="banner-bottom-top">
		<div class="banner-bottom-top-2">
			<div class="container">
				<div class="bottom-header">
					<div class="header-bottom">
						<div class=" bottom-head">
							<a href="${pageContext.request.contextPath}/customerservice">
								<div class="buy-media">
									<i class="buy"> </i>
									<h6>客戶服務</h6>
								</div>
							</a>
						</div>
						<div class=" bottom-head">
							<a href="${pageContext.request.contextPath}/operationOffices">
								<div class="buy-media">
								<i class="rent"> </i>
								<h6>摩途客拉部</h6>
								</div>
							</a>
						</div>
						<!-- 
						<div class="tour">
							<input class="gowhere" type="text" name="fname" placeholder="想去哪裡玩?">
							<input class="day" type="text" name="fname" placeholder="日期">
							<input type="text" name="fname" placeholder="人數">
							<button class="search">GO!</button>
						</div>
						 -->
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
		</div>
	</div>
			<!--//-->

	<!--//header-bottom-->


<!--//header-->