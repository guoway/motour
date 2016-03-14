<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--footer-->
<div class="footer footer-top-at">
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-sm-8 text-center center-col">
				<div class="col-xs-3">
					<a href="${pageContext.request.contextPath}/faq">
						<i class="fa fa-money"></i>
						<p>常見問題</p>
					</a>
				</div>
				<%--
				<a href="${pageContext.request.contextPath}/joinus">
					<i class="fa fa-users"></i>
					<p>據點加盟</p>
				</a>
				 --%>
				<div class="col-xs-3">
					<a href="">
						<i class="fa fa-facebook"></i>
						<p>FB粉絲團</p>
					</a>
				</div>
				<div class="col-xs-3">
					<a href="">
						<img src="images/line.png" alt="">
						<p>@ Line</p>
					</a>
				</div>
				<div class="col-xs-3">
					<a href="#contactUsForm" rel="modal:open">
						<i class="fa fa-envelope"></i>
						<p>聯絡我們</p>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="copyright">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			Copyright © 2015 MotourClub
			</div>
		</div>
	</div>
</div>

<form id="contactUsForm" class="form-horizontal contact-us-form modal" style="display:none;" action="${pageContext.request.contextPath}/contactUs">
	<h3>連絡我們</h3>
	<div class="form-group">
		<label class="col-sm-2 control-label" >姓名</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder="姓名" name="name" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Email</label>
		<div class="col-sm-6">
			<input type="text" class="form-control col-sm-4" placeholder="Email" name="email" />
		</div>		
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">主旨</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder="主旨" name="subject" />
		</div>		
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">內容</label>
		<div class="col-sm-9">
			<textarea class="form-control" rows="10" cols="30" placeholder="內容" name="content"></textarea>
		</div>		
	</div>
	
	<div class="form-group">
		<div class="col-sm-2 col-sm-offset-5">
			<input type="submit" class="form-control" value="送出" />
		</div>	
	</div>
</form>

<!--//footer-->

	

