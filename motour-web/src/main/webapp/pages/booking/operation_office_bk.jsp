<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/booking/header_b.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="moduleJS">
	 
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2YdYQH3ael3RJpSXfQHo11cnbbCzn34g&callback=initMap"></script>
	 
	<script src="js/responsiveslides.min.js"></script>
	<script src="js/motour/operationOffice.js"></script>

		<script>
	
    	$(function () {
			
            var map = $('.map');
            var mapTop = map.offset().top;
            var mapHeight = map.outerHeight();
            var bookingForm = $('.booking-form');
            var bookingFormHeight = bookingForm.outerHeight();
            var bookingFormOuterWidth = bookingForm.outerWidth();
            var stop = mapTop + mapHeight +100;
            var count = 0;

            $(window).scroll(function() {

            	if($(this).scrollTop() > 500){
              		bookingForm.css('top',10);
              	}
            	console.log($(this).scrollTop());
            	if($(this).scrollTop() < 500){
            		console.log($('.booking-header').offset().top);
            		bookingForm.css('top',$('.booking-header').offset().top+50);
            	}
            	
            	/* 
                if ($(this).scrollTop() == 1) {
                    bookingFormTop = bookingForm.offset().top;
                    bookingFormOuterWidth = bookingForm.outerWidth();
                    count++;
                }
                
                if (count > 0) {
                  
                    scroll = $(this).scrollTop() + bookingFormTop;

                    if (!bookingForm.hasClass('bottom') && (scroll + bookingFormHeight) >= stop + 100) {
                        var bookingFormParentTop = bookingForm.parent().offset().top;
                        bookingForm.addClass('bottom');
                        bookingForm.css('top', (mapTop + mapHeight - bookingFormParentTop - bookingFormHeight));
                        bookingForm.outerWidth(bookingFormOuterWidth);
                    } else if (bookingForm.hasClass('bottom') ){//&& (scroll + bookingFormHeight) < stop) {
                        bookingForm.removeClass('bottom');
                        bookingForm.attr('style', '');
                    }
                }
                */
              

                
            });

            $(window).resize(function() {
                bookingFormOuterWidth = bookingForm.outerWidth();
            });    		
    		
    		
            //圖片輪轉初始化
	         $(".rslides").responsiveSlides({
	            auto: true,
	            pager: false,
	            nav: false,
	            speed: 500,
	
	        });	
    	});
	
		function initMap() {
			var latLng = new google.maps.LatLng(${office.latitude}, ${office.longitude});
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom:16,
				center:latLng,
			});
			
			var googleTagImage = 'images/googleTag.png';
			var marker = new google.maps.Marker({
				position:latLng,
				map: map,
				draggable: true,
				title: '${office.name}',
				icon: googleTagImage,
			});
			
			var infoWindow = new google.maps.InfoWindow({
				content:'${office.address}',
			});
			
			marker.setAnimation(google.maps.Animation.BOUNCE);
			
			infoWindow.open(map, marker);
		}
		

	</script>

	</tiles:putAttribute>
<tiles:putAttribute name="content">

    <div class="booking-header">
        <div class="container">
            <div class="col-md-2 location">
                <h4>租賃地區</h4>
                <ul>
                	<c:forEach items="${enabledOffices}" var="office">
                		<li>
                			<a href="${pageContext.request.contextPath}/operationOffice?operationOfficeId=${office.oid}">${office.name}</a>
                		</li>
                	</c:forEach>
                </ul>
            </div>
            <div class="col-md-10">
                <div class="col-md-8">
                    <div class="callbacks_container">
                      <ul class="rslides" id="slider4">
                      	<c:forEach items="${office.introImeges}" var="image">
                      		<li>
                      			<img src="data/${image.image.image }"/>
                      		</li>                      		
                      	</c:forEach>
                      </ul>
                    </div>
                    <div class="booking-body">
                        <h3>車型介紹</h3>
                        <c:forEach items="${motorTypes}" var="t">
	                         <div class="col-md-4">
	                            <a href=""><img class="img-responsive" src="data/${t.imagePath}" alt=""></a>
	                            <h4>${t.motorTypeName}</h4>
	                            <p>續航：${t.stamina }公里</p>
	                            <p>爬坡：${t.slope }度</p>
	                            <p>雙載：${t.doubleLoad }</p>
	                            <p>租金：NT${t.rentFee }</p>
	                            <p>駕照：${t.properLicense }</p>
	                        </div>
                        </c:forEach>
                        <div class="clearfix"></div>
                    </div>
                    <div class="booking-map">
                        <h3>據點位置</h3>
                        <div id="map" class="map" style="width:580px; height:400px;">
                        	<!-- 
                            <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3150859.767904157!2d-96.62081048651531!3d39.536794757966845!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sin!4v1408111832978"> </iframe>
                             -->
                        </div>
                    </div>

                </div>
                <div class="col-md-4">
                    <div class="booking-form">
                        <div class="form-title">預訂表單</div>
                        <form id="bookingForm" action="${pageContext.request.contextPath}/booking" method="post" class="form-inline">
							<!--開始日期 start-->
                            <div class="quan-select form-group" style="float:left; display:inline-block">
                             	
                                <input id="startDatetime" name="startDatetime" class="form-control" style="width:100%" type="text" placeholder="開始日期" readonly="readonly"/>
                                <label id="startDatetime-error" class="error" for="startDatetime" style="display: none;">必須填寫</label>
                            </div>
							<div class="quan-select form-group" style="float:left; display:inline-block">
                             	<label id="startTime-error" class="error" for="startTime" style="display: none;">必須填寫</label>
                                <input id="startTime" name="startTime" class="form-control" style="width:100%" type="text" placeholder="起租時間" readonly="readonly"/>
                            </div>
                            <!--開始日期 end-->

                            <!--結束日期 start-->
                            <div class="quan-select form-group" style="float:left;display:inline-block">
                            	<select class="in-drop loca-select form-control" id="rentPlan" name="rentPlan" style="width: 100%">
                                    <option value="" disabled selected>租賃方案</option>
                                    <option value="H">半日 (6H)</option>
                                    <option value="F">全日 (24H)</option>
                                </select>
                            </div>
                            <div class="quan-select form-group" style="float:left;display:inline-block">
                             <select class="in-drop loca-select form-control" id="rentDay" name="rentDay" style="width: 100%">
                                    <option value="" disabled selected>租期 (日)</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                           </div>     
                            <!--結束日期 end-->
                            <div class="clearfix"></div>
                            
                            <!--營業據點 start-->
                            <div class="quan-select form-group" style="float:left;display:inline-block">
                                <label id="motorOffice-error" class="error" for="motorOffice" style="display: none">必須填寫</label>
                                <select class="in-drop loca-select form-control" id="motorOffice" name="motorOffice" style="width: 100%">
                                    <option value="" disabled selected>營業據點</option>
                                    <option value="${office.id}">${office.name}</option>
                                </select>
                            </div>
                            <!--營業據點 end-->
                            <!--取車還車點 start-->
                            <div class="quan-select form-group">
                                <label id="motorLocation-error" class="error" for="motorLocation" style="display: none">必須填寫</label>
                                <select class="in-drop loca-select form-control" id="motorLocation" name="motorLocation" style="width: 100%">
                                    <option value="" disabled selected>取、還車點</option>
                                    <c:forEach items="${office.getMotorLocations}" var="location">
                                    	<option value="${location.id}">${location.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!--取車還車點 end-->
                            
                            <div class="clearfix"></div>
                            
                            <!--車型 start-->
                            <div id="motorTypes">
                            <div>
	                            <div class="quan-select form-group" style="float:left; display:inline-block">
	                                <label id="motorTypeSelect-error" class="error" for="motorTypeSelect" style="display: none">必須填寫</label>
	                                <select class="in-drop form-control" id="motorTypeSelect" name="motorTypeSelect" style="width:100%">
	                                	<option value="" numOfMotor="0" disabled selected>車型</option>
	                                </select>
	                            </div>
	                            <!--車型 end-->
	
	                            <!--數量 start-->
	                            <div class="quan-select form-group" style="display:inline-block">
	                                <label id="motorQuantity-error" class="error" for="motorQuantity" style="display: none;width: 50%">必須填寫</label>
	                                <select class="in-drop form-control" id="motorQuantity" name="motorQuantity" style="width:50%">
	                                    <option value="" disabled selected>數量</option>
	                                </select>
	                                <button type="button" id="addMotor" class="in-drop btn btn-default btn-lg form-add">
	  									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>增加
									</button>
	                             </div>    
								<!--數量 end-->
	                             <div class="clearfix"></div>
                             </div>
                             
                             </div>
                            
                            <a href="javascript:submitForm();" class="gobooking">我要預訂</a>
                        </form>
                    </div>
                    <a href="#ex8" rel="modal:open" class="gobooking-2" style="display:none">我要預訂</a>
                </div>
            </div>
        </div>
    </div>

    <form action="" class="login_form modal" id="ex8" style="display:none;">
        <div class="form-title">
            預訂表單
        </div>
        <select class="in-drop car-select">
            <option>車型</option>
            <option></option>
        </select>
        <select class="in-drop quan-select">
            <option>數量</option>
        </select>
        <select class="in-drop loca-select">
            <option>取車點</option>
        </select>
        <input class="quan-select" style="float: left" type="text" placeholder="開始日期" name="name">
        <input class="quan-select" type="text" placeholder="結束日期" name="name">
        <input class="loca-select" type="text" placeholder="折扣金使用" name="name">
        <a href="" class="gobooking">我要預訂</a>
    </form>



</tiles:putAttribute>
</tiles:insertDefinition>