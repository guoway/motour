<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">

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
                                    <h4>活動日期: <span>2015/11/02</span></h4>
                                    <p>
										您為什麼想參加團體旅行呢？想帶一家人快樂出國玩？
										渴望親身遊歷的夢想之地，遙遠又難以駕馭？
										想擁有一個回想起會和另一伴一起笑著懷念的蜜月旅？
										但您知道怎麼挑選真正適合的安心行程嗎？
										真的是越貴的越好、就越適合您嗎？

										旅遊咖了解您簡單卻難被滿足的心願，
										制訂了「快樂旅人嚴選系統」，將您最在乎的旅遊品質各項指標，化為嚴密程式，由系統自動運算出，最適合您的團體旅行選擇團體旅行的旅客
										</p>

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