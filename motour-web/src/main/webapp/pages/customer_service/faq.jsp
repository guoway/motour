<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/customer_service/header_s.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="content">

<div class="booking-header">
	<div class="container">
		<div class="service-top">
			<h3>常見問題</h3>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>如何取消線上預約？</div>
			    <div class="faq-a">
			        <p>請於摩途網站「客戶服務」→「訂單管理」點擊「取消交易」，客服人員收到取消通知後會進行退刷作業，金額將會退返在您下一期的信用卡帳單中。註：信用卡退刷作業速度將視個發卡銀行而有不同。</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>取消預約是否需要負擔取消費用？</div>
			    <div class="faq-a">
			        <p>
			        	當您完成線上預約車輛即會為您保留，為避免影響其他消費者租用權益，預約前詳閱以下規定：
			        	<br/>1、於預約取車日前10日(含10日)取消租車，將退還已付租金100%
			        	<br/>2、於預約取車日前7-9日取消租車，將退還已付租金50%
			        	<br/>3、於預約取車日前4-6日取消租車，將退還已付租金40%
			        	<br/>4、於預約取車日前2-3日取消租車，將退還已付租金30%
			        	<br/>5、於預約取車日前1日取消租車，將退還已付租金20%
			        	<br/>6、於預約取車日當日取消租車或怠於通知，將退還已付租金0%
			        </p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>來不及在預約的取車時間內前往取車的時候該怎麼辦？</div>
			    <div class="faq-a">
			        <p>1、在預約取車日期的當日，請撥打客服電話，讓客服人員為您延後取車時間，如超過取車點當日的營業時間(每日20:00)，視個案狀況給予最適當的協助。</p>
			        <p>2、超過預訂取車時間1小時未事先通知者，視同取消預約，本公司得以更改轉租他人。</p>
			        <p>※客服電話：04-2337-8138</p>
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>摩途出租的車輛是否都有保險？</div>
			    <div class="faq-a">
			        <p>於摩途出租的電動機車及電動自行車都投保了優於法規的保險，保額如下：</p>
			        <p>
			        	一、電動機車
			        	<ol>
			        		<li>乘    客   險：每一意外總額100萬，死殘50萬，體傷5萬。</li>
			        		<li>第三責任險：每一意外傷害200萬，每一個人傷害100萬，體傷5萬，財損5萬。</li>
			        		<li>車輛失竊險：2.8萬，自付額10％。</li>
			        	</ol>
			        </p>
			        <p>
			        	二、電動自行車
			        	<ol>
			        		<li>
			        			第三責任險
			        			<ul>
			        				<li>在台灣本島：每一個人傷害100萬，每一意外傷害200萬，財損最高30萬(自付額5千)。</li>
			        				<li>在台灣離島：每一個人傷害200萬，每一意外傷害100萬，財損最高200萬。</li>
			        			</ul>
			        		</li>
			        		<li>個人旅遊平安險：死殘200萬，醫療最高20萬(實支實付)</li>
			        	</ol>
			        </p>			        
			    </div>
			</div>
			<div class="faq-c">
			    <div class="faq-q"><span class="faq-t">+</span>騎乘電動機車的駕照規定？</div>
			    <div class="faq-a">
			        <p>
			        	<ol>
			        		<li>電動自行車：不需要駕照，可於台灣任何道路行駛，但仍需要尊守交通規則。</li>
			        		<li>輕型電動機車(綠牌)：駕駛人需持有輕型機車駕照或汽車駕照。外籍人士需出示國際駕照才可租用。中國核發之國際駕照不適用。</li>
			        		<li>重型電動機車(白牌)：駕駛人需持有重型機車駕照。外籍人士需出示國際駕照才能租用，中國核發之國際駕照不適用。</li>
			        	</ol>
			        </p>
			    </div>
			</div>
		</div>
	</div>
</div>    
    
</tiles:putAttribute>
</tiles:insertDefinition>