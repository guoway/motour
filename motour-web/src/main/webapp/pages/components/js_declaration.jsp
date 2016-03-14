<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!--menu-->
<script type="text/javascript" src="js/scripts.js"></script>
<!-- 
<script type="text/javascript" src="js/modernizr.js"></script> 
<script type="text/javascript" src="js/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript" src="js/imagesloaded.pkgd.min.js"></script>
<script type="text/javascript" src="js/smooth-scroll.js"></script>
-->
<script type="text/javascript" src="js/owl.carousel.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/sweetalert.min.js"></script>
<!--//news-->
<!--!登入跳窗-->
<script src="js/jquery.modal.js" type="text/javascript" charset="utf-8"></script>

<!-- typeahead bloodhund https://github.com/twitter/typeahead.js -->
<script type="text/javascript" src="js/typeahead.bundle.js"></script>

<!-- Motour -->
<script src="js/motour/mt_message.js"></script>
<script src="js/motour/navigation.js"></script>
<script src="js/motour/google_analytics.js"></script>
<script src="js/motour/footer.js"></script>

<!-- jquery validation -->
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/localization/messages_${pageContext.response.locale}.js"></script>
<!-- end -->

<script type="text/javascript" src="js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="js/motour/mt_message.js"></script>
<script type="text/javascript" src="js/readmore.js"></script>

<!-- 不知何用 -->
<script type="application/x-javascript"> 
	addEventListener("load", function() { 
		setTimeout(hideURLbar, 0); 
	}, false); 
	function hideURLbar(){ 
		window.scrollTo(0,1); 
	} 
</script>
<!-- 不知何用 -->

<script>
	$('article').readmore({
		speed : 500
	});
</script>

<!-- FAQ Used Start -->
<script type="text/javascript">
	$(".faq-q").click(function() {
		var container = $(this).parents(".faq-c");
		var answer = container.find(".faq-a");
		var trigger = container.find(".faq-t");

		answer.slideToggle(200);

		if (trigger.hasClass("faq-o")) {
			trigger.removeClass("faq-o");
		} else {
			trigger.addClass("faq-o");
		}
	});
</script>
<!-- FAQ Used End -->

<script type="text/javascript">
var $datepickerDateFormat = "Y-m-d";
var $datepickerTimeFormat = "H:i";
var $dateLang = '${pageContext.response.locale}';

function changeLang(obj){
	location=obj.options[obj.selectedIndex].value ;
}	

//Show Message Start
var msg = "${mtMessage}";
if(msg != null && msg != '') {		
	new MTMessage().basicMessage(msg) ;
	<c:remove var="mtMessage" scope="session"/>
}	
//Show Message End
</script>

<!-- navigation start -->
<script>
$(function() {
    var menu_ul = $('.menu > li > ul'),
        menu_a = $('.menu > li > a');
    menu_ul.hide();
    menu_a.click(function(e) {
        e.preventDefault();
        if (!$(this).hasClass('active')) {
            menu_a.removeClass('active');
            menu_ul.filter(':visible').slideUp('normal');
            $(this).addClass('active').next().stop(true, true).slideDown('normal');
        } else {
            $(this).removeClass('active');
            $(this).next().stop(true, true).slideUp('normal');
        }
    });

});
</script>
<!-- navigation end -->
