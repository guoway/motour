<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 全域變數定義 -->
<script>
	var contextPath = '${pageContext.request.contextPath}';
	var activeMenuId = '${activeMenu.id}';
</script>
<!-- Mainly scripts -->
<script src="js/jquery-2.1.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
<!-- 
<script src="js/motour-menu.js" type="text/javascript"></script>
 -->
 
<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>
<script src="js/common/mt_message.js"></script>

<script>
//Show Message Start
var msg = "${mtMessage}";
if(msg != null && msg != '') {		
	new MTMessage().basicMessage(msg) ;
	<c:remove var="mtMessage" scope="session"/>
}	
//Show Message End
</script>
