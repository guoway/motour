<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/booking/header_b.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">

<div class="booking-header">
	<div class="container">
	
			
			
			<div class="col-md-12 amet-sed">
				<h4>據點加盟</h4>
				<hr>
				<p>只要您認同我們的理念，對於電動機車租賃事業有興趣、有企圖、有信心，就歡迎您加入我們的行列成為特約商，不需要龐大的購車資金，也不需要具備租賃經驗，我們提供車輛、電池、維修保養、租賃管理系統、網路租賃平台通路等支援，當然、最重要的是我們的經驗傳承。我們有三種特約商形式可供選擇修保養，也不需要具備租賃經驗，我們提供經驗養成、營運系統、行銷支援、招牌、輔銷製作物，讓您以最低的資金成本敬能開啟電動機車租賃事業。</p>
			</div>
			<div class="col-md-12 amet-sed ">
				<div class="col-md-4">
					<h5>一、資深特約商：</h5>
					<p>．長期向艾上綠能租用10輛以上，並成為艾上綠能之公開營運據點。<br>
						．提供租車客戶取車/還車服務。<br>
						．提供租車客戶電池交換及道路救援服務。<br>
						．享有Motour Club網站之租賃訂單拆帳。</p>
				</div>
				<div class="col-md-4">
					<h5>二、高級特約商：</h5>
					<p> ．成為艾上綠能之公開取車/還車據點<br>
						． 提供租車客戶取車/還車服務。<br>
						．提供租車客戶電池交換及道路救援服務。<br>
						．享有Motour Club網站之租賃訂單分潤。</p>
				</div>
				<div class="col-md-4">
					<h5>三、輕鬆特約商：</h5>
					<p>．享有Motour Club網站之優惠租賃價。</p>
					<!-- 					
					<a class="joinus" href="#ex7" rel="modal:open">聯絡我們</a>
					<a class="joinus" href="joinus.html">據點加盟</a>
					<a href="#"><i class="fa fa-facebook-official social"></i></a>
					 -->
				</div>
			</div>
			<div class="clearfix"> </div>
	
	
	
		<div class="col-md-12">
			<table class="booking-detail">
				<tr class="detail-thead">
					<td colspan="2">據點加盟</td>
				</tr>
				<tr>
					<td class="detail-title">聯絡人姓名</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td class="detail-title">電話</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td class="detail-title">據點地址</td>
					<td>
						<select>
							<option selected="true">縣市</option>
							<option></option>
						</select>
						<select>
							<option selected="true">區鄉鎮市</option>
							<option></option>
						</select>
						<label>地址:</label><input type="text" />
					</td>
				</tr>
				<tr>
					<td class="detail-title">放置空間坪數</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td class="detail-title">備載電力<br>(電壓V/電流A)</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td class="detail-title">據點簡介</td>
					<td><textarea name="Content"></textarea></td>
				</tr>
				<tr>
					<td class="detail-contract" colspan="2">
						<h3>注意須知</h3>
						<ul class="detail-contract-2">
							<li>一、加盟權利金：NT＄30,000。</li>
							<li>二、車輛租金：NT＄1,500/每輛/每月，最少10輛，加盟前半年只收9輛租金，並提供預備車輛。</li>
							<li>三、有足夠的放置車輛空間及電力供應。本項需經過我們現地查訪審核。</li>
							<li>四、提供道路救援服務。</li>
							<li>五、需配合我們的租金定價策略及行銷活動。</li>
							<li>六、據點合適度評估。本項需要經過我們現地訪查審合。</li>
						</ul>
						<div class="detail-step">
							<input type="submit" value="送出" />
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>    
    
</tiles:putAttribute>
</tiles:insertDefinition>