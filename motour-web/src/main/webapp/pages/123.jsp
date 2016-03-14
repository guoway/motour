<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="baselayout">
	<tiles:putAttribute name="title" value="MotourClub" />
	<tiles:putAttribute name="content">

		<html>
<body>
	<form name='PostForm' id='PostForm' action='http://59.120.143.38:8080/motour-web/receiverResp' method='POST'>
		<input type='hidden' name='buysafeno' value='N090001601250000146'>
		<input type='hidden' name='web' Value='S1601229014'>
		<input type='hidden' name='MN' Value='1000'>
		<input type='hidden' name='Td' Value='201601220001'>
		<input type='hidden' name='webname'	Value='%e6%a8%82%e5%93%81%e7%a7%91%e6%8a%80%e8%82%a1%e4%bb%bd%e6%9c%89%e9%99%90%e5%85%ac%e5%8f%b8'>
		<input type='hidden' name='Name' Value='r%e2%97%8b%e2%97%8b%e2%97%8b%e2%97%8b%e2%97%8b%e2%97%8b%e2%97%8bg'>
		<input type='hidden' name='note1' Value='%e5%82%99%e8%a8%bbtest'>
		<input type='hidden' name='note2' Value='%e5%82%99%e8%a8%bbtest2'>
		<input type='hidden' name='ApproveCode' Value='T0NCCC'>
		<input type='hidden' name='Card_NO' Value='1234'>
		<input type='hidden' name='UserNo' Value=''>
		<input type='hidden' name='BarcodeA' Value=''>
		<input type='hidden' name='BarcodeB' Value=''>
		<input type='hidden' name='BarcodeC' Value=''>
		<input type='hidden' name='PostBarcodeA' Value=''>
		<input type='hidden' name='PostBarcodeB' Value=''>
		<input type='hidden' name='PostBarcodeC' Value=''>
		<input type='hidden' name='EntityATM' Value=''>
		<input type='hidden' name='paycode' Value=''>
		<input type='hidden' name='PayType' Value=''>
		<input type='hidden' name='SendType' Value='2'>
		<input type='hidden' name='errcode' Value='00'>
		<input type='hidden' name='errmsg' Value='%e6%88%90%e5%8a%9f%e4%ba%a4%e6%98%93'>
		<input type='hidden' name='Card_Type' Value='0'>
		<input type='hidden' name='CargoNo' Value=''>
		<input type='hidden' name='ChkValue' Value='55906DCA422A5DF093C0F80D8B8AF00818508D8D'>
	</form>
	<script type='text/javascript'>
		document.PostForm.submit();
	</script>
	<noscript>
		您的瀏覽器JavaScript已關閉，網頁無法回到商家頁面。<br />您的繳款成功。<a
			href='https://test.esafe.com.tw/'>回紅陽科技首頁</a>
	</noscript>
</body>
		</html>
	</tiles:putAttribute>
</tiles:insertDefinition>