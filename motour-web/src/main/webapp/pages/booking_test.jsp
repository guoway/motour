<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.net.URLDecoder"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">

<form name="form1" action=" https://test.esafe.com.tw/Service/Etopm.aspx" method="POST"> 
	<input type="hidden" name="web" value="${req.web}" /> <!-- 1.商店代號--> 
	<input type="hidden" name="MN" value="${req.MN}" /> <!--2.*交易金額--> 
	<input type="hidden" name="OrderInfo" value="${req.orderInfo}" /> <!--3.交易內容--> 
	<input type="hidden" name="Td" value="${req.td}" /> <!--4.商家訂單編號--> 
	<input type="hidden" name="sna" value="${req.sna}" /> <!--5.消費者姓名--> 
	<input type="hidden" name="sdt" value="${req.sdt}" /> <!--6.消費者電話--> 
	<input type="hidden" name="email" value="${req.email }" /> <!--7.消費者Email--> 
	<input type="hidden" name="note1" value="${req.note1 }" /> <!--8.備註--> 
	<input type="hidden" name="note2" value="${req.note2 }" /> <!--9.備註--> 
	<input type="hidden" name="Card_Type" value="${req.card_Type}" /> <!--10.交易類別--> 
	<input type="hidden" name="Country_Type" value="${req.country_Type}" /> <!--11.語言類別--> 
	<input type="hidden" name="Term " value="${req.term}" /> <!--12.分期期數--> 
	<input type="hidden" name="ChkValue" value="${req.chkValue }" />    <!--13.交易檢查碼--> 
	<input type="submit" name="button" id="button" value="送出" /> 
</form>
    
</tiles:putAttribute>
</tiles:insertDefinition>