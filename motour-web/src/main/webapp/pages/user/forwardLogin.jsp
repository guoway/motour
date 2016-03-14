<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="baselayout">
<tiles:putAttribute name="header" value="/pages/booking/header_b.jsp" />
<tiles:putAttribute name="title" value="MotourClub" />
<tiles:putAttribute name="moduleJS">
	<script type="text/javascript">
		var forwardAction = "${forwardAction}" ;
		console.log(forwardAction);	
	</script>
	<script type="text/javascript" src="js/motour/forwardLogin.js"></script>
	<script type="text/javascript">
	// This is called with the results from from FB.getLoginStatus().
	  function statusChangeCallback(response) {
	    console.log('statusChangeCallback');
	    console.log(response);
	    // The response object is returned with a status field that lets the
	    // app know the current login status of the person.
	    // Full docs on the response object can be found in the documentation
	    // for FB.getLoginStatus().
	    if (response.status === 'connected') {
	      // Logged into your app and Facebook.
	     // testAPI();
	    	getUserAPI();
	    } else if (response.status === 'not_authorized') {
	      // The person is logged into Facebook, but not your app.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into this app.';
	    } else {
	      // The person is not logged into Facebook, so we're not sure if
	      // they are logged into this app or not.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into Facebook.';
	    }
	  }

	  // This function is called when someone finishes with the Login
	  // Button.  See the onlogin handler attached to it in the sample
	  // code below.
	  function checkLoginState() {
	    FB.getLoginStatus(function(response) {
	      statusChangeCallback(response);
	    });
	  }

	  window.fbAsyncInit = function() {
	  FB.init({
	    appId      : '1141417142558148',
	    cookie     : true,  // enable cookies to allow the server to access 
	                        // the session
	    xfbml      : true,  // parse social plugins on this page
	    version    : 'v2.5' // use graph api version 2.5
	  });

	  // Now that we've initialized the JavaScript SDK, we call 
	  // FB.getLoginStatus().  This function gets the state of the
	  // person visiting this page and can return one of three states to
	  // the callback you provide.  They can be:
	  //
	  // 1. Logged into your app ('connected')
	  // 2. Logged into Facebook, but not your app ('not_authorized')
	  // 3. Not logged into Facebook and can't tell if they are logged into
	  //    your app or not.
	  //
	  // These three cases are handled in the callback function.

	 // FB.getLoginStatus(function(response) {
	 //   statusChangeCallback(response);
	 // });

	  };

	  // Load the SDK asynchronously
	  (function(d, s, id) {
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "//connect.facebook.net/en_US/sdk.js";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));

	  // Here we run a very simple test of the Graph API after login is
	  // successful.  See statusChangeCallback() for when this call is made.
	  function testAPI() {
		  
	    console.log('Welcome!  Fetching your information.... ');
	    FB.api('/me', function(response) {
	      console.log('Successful login for: ' + response.name);
	      document.getElementById('status').innerHTML =
	        'Thanks for logging in, ' + response.name + '!';
	    });
	  }
	  
	  function getUserAPI(){
		  FB.login(function(response) {
			  	console.log("fb.login : " + JSON.stringify(response));
			    if (response.authResponse) {
			     console.log('Welcome!  Fetching your information.... ');
			     FB.api(
			    		  '/me',
			    		  'GET',
			    		  {"fields":"id,name,email"},
			    		  function(response) {
			    			  console.log("fb.api : " +JSON.stringify(response));
			    			  registerFromFB(response);
			    		  }
			    		);
			    } else {
			     console.log('User cancelled login or did not fully authorize.');
			    }
			}, {scope:'public_profile,email'});
	  }
	</script>
</tiles:putAttribute>
<tiles:putAttribute name="content">
<div class="booking-header">
	<div class="container">
		<div class="col-md-12">
		
		<div id="status"></div>
			<form id="loginAjaxForm" action="${pageContext.request.contextPath}/booking" method="post">
				<table class="booking-detail">
					<tr class="detail-thead">
						<td colspan="2">會員登入</td>
					</tr>
					<tr>
						<td class="detail-title">會員帳號 : </td>
						<td id="registerTD">
							<input type="text" name="userId" id="userId" />
							<a id="register" name="register" onclick="javascript:forwardToRegister();"> 立即加入  </a>
							<!-- <a id="register" name="register" href="#registerForm" rel="modal:open"> 立即加入  </a> -->
						</td>
					</tr>
					<tr>
						<td class="detail-title">密碼 : </td>
						<td>
							<input type="password" name="passwd" id="password"/>
							<a id="forgetPasswd" name="forgetPasswd"> 忘記密碼 </a>
						</td>
					</tr>
					<tr>
						<td class="detail-contract" colspan="2">
							<div class="detail-step">
								<input type="button" value="登入" onclick="javascript:loginAjax();" />
								<fb:login-button scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button>
							</div>
						</td>
					</tr>
				</table>	
			</form>

			<form id="registerAjaxForm" action="${pageContext.request.contextPath}/booking" method="post" style="display:none;">
				<table class="booking-detail">
					<tr class="detail-thead">
						<td colspan="2">會員註冊</td>
					</tr>
					<tr>
						<td class="detail-title">帳號(Email): </td>
						<td>
							<input type="text" id="id" name="id"/>
						</td>
					</tr>		
					<tr>
						<td class="detail-title">密碼 : </td>
						<td>
							<input type="password" id="passwd2" name="ss3aMember.password" />
						</td>
					</tr>
					<tr>
						<td class="detail-title">確認密碼 : </td>
						<td>
							<input type="password" id="passwdConfirm" name="passwdConfirm" />
						</td>
					</tr>
					<tr>
						<td class="detail-title">姓名 : </td>
						<td>
							<input type="text" id="name" name="name" />
						</td>
					</tr>
					<tr>
						<td class="detail-title">行動電話 : </td>
						<td>
							<input type="text" id="mobile" name="mobile" />
						</td>
					</tr>
					<tr>
						<td class="detail-contract" colspan="2">
							<div class="detail-step">
								<input type="button" value="註冊" onclick="javascript:registerAjaxForm();" />
								<input type="button" value="登入" onclick="javascript:returnToLogin();" />
							</div>
						</td>
					</tr>
					</table>
			</form>
			
			<form id="forwardForm" action="${pageContext.request.contextPath}/booking" method="post"></form>
			
		</div>
	</div>
</div>			
</tiles:putAttribute>
</tiles:insertDefinition>