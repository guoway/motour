<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<tiles:insertDefinition name="baselayout">
	<tiles:putAttribute name="title" value="MotourClub" />
	<tiles:putAttribute name="moduleJS">
		<script src="js/responsiveslides.min.js"></script>
		<script src="js/plugins/modernizr/modernizr-custom.js"></script>
		<script>
			
			$(function() {
				
				var deviceAgent = navigator.userAgent.toLowerCase();
				console.log(deviceAgent);
				var isTouchDevice = Modernizr.touch
							|| (deviceAgent.match(/(iphone|ipod|ipad)/)
									|| deviceAgent.match(/(android)/)
									|| deviceAgent.match(/(iemobile)/)
									|| deviceAgent.match(/iphone/i)
									|| deviceAgent.match(/ipad/i)
									|| deviceAgent.match(/ipod/i)
									|| deviceAgent.match(/blackberry/i) || deviceAgent
									.match(/bada/i));
				if(isTouchDevice) {
					$('#videoSlider').remove();
				}
				
				
				$(".rslides").responsiveSlides({
					auto : true,
					speed : 500,
					timeout : 5000,
					pause : false,
				});
			});
		</script>
	</tiles:putAttribute>
    <tiles:putAttribute name="content">

		<!--service-->
	<div class="services">
		<div class="container">
			<div class="service-top">
				<h3>踏上摩途</h3>
			</div>
			
			<div id="demo">

		      <article>
		        <div class="services-grid ">
				    <div class="col-md-6">
				        <div class=" ser-grid">
				            <img class="img-responsive" src="images/landing/landing_001.png" alt="">
				        </div>
				        <div class="ser-top">
				            <h4>開創綠能移動時代</h4>
				            <p>摩途的理念是落實讓「低碳旅遊」不再只是一句口號，多年來用心建立起專業的租賃營運體系及免費電池交換機置，提供一種「清、靜」的移動方式，讓消費者得以優雅之姿穿街走巷、漫遊徐行，拂面的風少了煙塵，週遭的蟲鳴鳥叫不再被震耳的引擎聲浪驅趕或掩蓋，回首來時路途，所經之處都不曾留下碳足跡，每一趟旅程都將更添質感，減少環境傷害，留給下一代子孫更乾淨的土地。</p>
				        </div>
				        <div class="clearfix"> </div>
				    </div>
				    <div class="col-md-6">
				        <div class=" ser-grid">
				            <img class="img-responsive" src="images/landing/landing_001.png" alt="">
				        </div>
				        <div class="ser-top">
				            <h4>摩途綠動漫遊網絡</h4>
				            <p>摩途針對電動機車的特性而發展出區域定點漫遊的租賃網絡，提供遊客在走路太累、交通不便、開車不適的區，或是在需要走走停停的旅遊地點能夠便利的移動，延伸距離。目前已在離島地區小有所成，更積極在各縣市開拓設點，期待您一同來支持使用、加入我們綠能移動的行列</p>
				        </div>
				        <div class="clearfix"> </div>
				    </div>
				</div>
				<div class="clearfix"> </div>
				<div class="services-grid ">
				    <div class="col-md-6">
				        <div class=" ser-grid">
				            <img class="img-responsive" src="images/landing/landing_001.png" alt="">
				        </div>
				        <div class="ser-top">
				            <h4>免費電池交換服務</h4>
				            <p>您在摩途租用的車輛除了有基本續航電力，在我們建議的行程範圍內也提供不限次數的免費電池交換，讓您安心放心的享受清靜的漫遊樂趣</p>
				        </div>
				        <div class="clearfix"> </div>
				    </div>
				    <div class="col-md-6">
				        <div class=" ser-grid">
				            <img class="img-responsive" src="images/landing/landing_001.png" alt="">
				        </div>
				        <div class="ser-top">
				            <h4>線上預約注意事項</h4>
				            <p>1.摩途提供之出租車輛分為不需要駕照的「電動自行車」以及需要駕照的輕型或重型「電動機車」兩大類別，因涉及法規及保險問題，請特別注意。取車時會要求您出示身份證件及駕照並影印存檔。<br>2.騎乘電動機車之相關法規同一般機車無異。外籍人士可使用國際駕照租用電動機車，唯中國核發之國際駕照不適用於台灣。<br>3.當您於線上預約成功後，取消預約之最後期限為取車日前二天。</p>
				        </div>
				        <div class="clearfix"> </div>
				    </div>
				</div>
			    <div class="clearfix"> </div>
		      </article>

		    </div>
		</div>
	</div>
<!--//services-->

<!--content-->
<div class="content">
	<div class="content-grid">
		<div class="container">
			<h3 class="content-grid-h3">摩途客拉部</h3>
				<c:forEach items="${operationOfficeList}" var="office">
						<div class="col-md-4 box_2">
							<a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=${office.id}" class="mask"> 
								<img class="img-responsive zoom-img" src="data/${office.mandatoryImage.image.image }" alt="">
							</a>
							<div class="most-1 bg-color-2">
								<h5>
									<a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=${office.id}">${office.name}</a>
								</h5>
							</div>
						</div>
				</c:forEach>
		 	<div class="clearfix"> </div>
		</div>
	</div>


<!--discount-->
	<!-- <div class="content-discount">
		<div class="container">
			<h3>折扣與分享</h3>
				 <div class="col-md-4 box_2 discount">
				    <a href="" class="mask">
				        <img class="img-responsive zoom-img" src="images/discount/discount_001.jpg" alt="">
				        <div class="discount-text">
				            <h5><a href="">如何獲得折扣甚至免費</a></h5>
				        </div>
				    </a>
				</div>
				<div class="col-md-4 box_2 discount">
				    <a href="" class="mask">
				        <img class="img-responsive zoom-img" src="images/discount/discount_002.jpg" alt="">
				    </a>
				    <div class="discount-text discount-text-2">
				        <h5><a href="">如何將折扣分享給朋友</a></h5>
				    </div>
				</div>
				<div class="col-md-4 box_2 discount">
				    <a href="" class="mask">
				        <img class="img-responsive zoom-img" src="images/discount/discount_003.jpg" alt="">
				    </a>
				    <div class="discount-text discount-text-3">
				        <h5><a href="">如何使用折扣</a></h5>
				    </div>
				</div>

		 	<div class="clearfix"> </div>
		</div>
	</div> -->

<!-- 
<div class="booking-header">
	<div class="container">
		<div class="service-top">
			<h3>折扣與分享</h3>
		</div>
		<div class="col-md-6">
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何獲得折扣並使用？</div>
			    <div class="faq-a">
			        <p>每一次的線上租車即可獲得20元折扣金，可於下次線上租車時抵用，也可無限期累積。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何將折扣分享給朋友？</div>
			    <div class="faq-a">
			        <p>使用網路預約最快可再預約後一小時租車出發，即使突然急需也能及時應付。您亦可來電至各據點或客戶服務專線查詢預約，但為了避免預約額滿的情形，請儘早進行預約手續。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何使用折扣？</div>
			    <div class="faq-a">
			        <p>您可以於本網站更改預約。更改預約並不需要繳交手續費。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何獲得折扣並使用？</div>
			    <div class="faq-a">
			        <p>如果預料到將會來不及於預約時間到達服務據點，請通知已預約之服務據點。如果於未取得聯絡的情況下，在預約時間後一小時仍未能取車，該預約將視為被取消，您將有可能不能租用選用車輛。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何將折扣分享給朋友？</div>
			    <div class="faq-a">
			        <p>使用網路預約最快可再預約後一小時租車出發，即使突然急需也能及時應付。您亦可來電至各據點或客戶服務專線查詢預約，但為了避免預約額滿的情形，請儘早進行預約手續。</p>
			    </div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何使用折扣？</div>
			    <div class="faq-a">
			        <p>如果預料到將會來不及於預約時間到達服務據點，請通知已預約之服務據點。如果於未取得聯絡的情況下，在預約時間後一小時仍未能取車，該預約將視為被取消，您將有可能不能租用選用車輛。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何將折扣分享給朋友？</div>
			    <div class="faq-a">
			        <p>使用網路預約最快可再預約後一小時租車出發，即使突然急需也能及時應付。您亦可來電至各據點或客戶服務專線查詢預約，但為了避免預約額滿的情形，請儘早進行預約手續。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何獲得折扣並使用？</div>
			    <div class="faq-a">
			        <p>您可以於本網站更改預約。更改預約並不需要繳交手續費。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>何將折扣分享給朋友？</div>
			    <div class="faq-a">
			        <p>如果預料到將會來不及於預約時間到達服務據點，請通知已預約之服務據點。如果於未取得聯絡的情況下，在預約時間後一小時仍未能取車，該預約將視為被取消，您將有可能不能租用選用車輛。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何使用折扣？</div>
			    <div class="faq-a">
			        <p>使用網路預約最快可再預約後一小時租車出發，即使突然急需也能及時應付。您亦可來電至各據點或客戶服務專線查詢預約，但為了避免預約額滿的情形，請儘早進行預約手續。</p>
			    </div>
			</div>
		</div>
		<div class="clearfix"> </div>
		<div class="share"><a href="" >我要分享</a></div>
	</div>
</div>
 -->


	</div>

        <!-- case study section -->
        <section class="bg-gray fadeIn event">
            <div class="container-fluid">
                <div class="row">
                    <div id="owl-demo-small" class="owl-carousel owl-theme dark-pagination  dark-pagination-without-next-prev-arrow">
                        <!-- case study item -->
                        <div class="item">
                            <div class="col-lg-6 col-md-6 case-study-img cover-background event-bg"></div>
                            <div class="col-lg-6 col-md-6 case-study-details">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 about-text position-relative xs-text-center">
                                    <h3>活動及優惠</h3>
                                    <span class="case-study-work letter-spacing-3">團體旅行的旅客</span>
                                    <p>
										您為什麼想參加團體旅行呢？想帶一家人快樂出國玩？
										渴望親身遊歷的夢想之地，遙遠又難以駕馭？
										想擁有一個回想起會和另一伴一起笑著懷念的蜜月旅？
										但您知道怎麼挑選真正適合的安心行程嗎？
										真的是越貴的越好、就越適合您嗎？

										旅遊咖了解您簡單卻難被滿足的心願，
										制訂了「快樂旅人嚴選系統」，將您最在乎的旅遊品質各項指標，化為嚴密程式，由系統自動運算出，最適合您的團體旅行選擇團體旅行的旅客
										</p>
                                    <a href="news" class="highlight-button-black-border btn btn-small no-margin-bottom sm-no-margin">查看更多</a>
                                </div>
                            </div>
                        </div>
                        <!-- end case study item -->
                        <!-- case study item -->
                        <div class="item">
                            <div class="col-lg-6 col-md-6 case-study-img cover-background event-bg"></div>
                            <div class="col-lg-6 col-md-6 case-study-details">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 about-text position-relative xs-text-center">
                                    <h3>活動及優惠</h3>
                                    <span class="case-study-work letter-spacing-3">團體旅行的旅客</span>
                                    <p>
										您為什麼想參加團體旅行呢？想帶一家人快樂出國玩？
										渴望親身遊歷的夢想之地，遙遠又難以駕馭？
										想擁有一個回想起會和另一伴一起笑著懷念的蜜月旅？
										但您知道怎麼挑選真正適合的安心行程嗎？
										真的是越貴的越好、就越適合您嗎？

										旅遊咖了解您簡單卻難被滿足的心願，
										制訂了「快樂旅人嚴選系統」，將您最在乎的旅遊品質各項指標，化為嚴密程式，由系統自動運算出，最適合您的團體旅行選擇團體旅行的旅客
										</p>
                                    <a href="news" class="highlight-button-black-border btn btn-small no-margin-bottom sm-no-margin">查看更多</a>
                                </div>
                            </div>
                        </div>
                        <!-- end case study item -->
                        <!-- case study item -->
                        <div class="item">
                            <div class="col-lg-6 col-md-6 case-study-img cover-background event-bg"></div>
                            <div class="col-lg-6 col-md-6 case-study-details">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 about-text position-relative xs-text-center">
                                    <h3>活動及優惠</h3>
                                    <span class="case-study-work letter-spacing-3">團體旅行的旅客</span>
                                    <p>
										您為什麼想參加團體旅行呢？想帶一家人快樂出國玩？
										渴望親身遊歷的夢想之地，遙遠又難以駕馭？
										想擁有一個回想起會和另一伴一起笑著懷念的蜜月旅？
										但您知道怎麼挑選真正適合的安心行程嗎？
										真的是越貴的越好、就越適合您嗎？

										旅遊咖了解您簡單卻難被滿足的心願，
										制訂了「快樂旅人嚴選系統」，將您最在乎的旅遊品質各項指標，化為嚴密程式，由系統自動運算出，最適合您的團體旅行選擇團體旅行的旅客
										</p>
                                    <a href="news" class="highlight-button-black-border btn btn-small no-margin-bottom sm-no-margin">查看更多</a>
                                </div>
                            </div>
                        </div>
                        <!-- end case study item -->
                    </div>
                </div>
            </div>
        </section>
        <!-- case study section -->
 
    </tiles:putAttribute>
</tiles:insertDefinition>