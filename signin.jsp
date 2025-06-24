<!DOCTYPE html>
<html>
	<head>
		<title>ecom::signup</title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/form.css">
		<link rel="stylesheet" href="static/css/menu.css">
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>
			<div id="main_body">
				<%@ include file="error.jsp" %>

				<form action="signin.do" method="post">
					<table id="form_box">
						<caption>SignIn</caption>
						<tr>
							<td class="lft">
								<label for="unameEmail">Username/Email</label>
							</td>
							<td class="rht">
								<input type="text" name="unameEmail" id="unameEmail">
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="password">Password</label>
							</td>
							<td class="rht">
								<input type="password" name="password" id="password">
							</td>
						</tr>
						<tr>
							<td colspan=2 align="center">
								<div class="g-recaptcha"							
								  data-sitekey="6LdkjtIZAAAAACCk-fqQLqlK_dt4MbIQnXfJU3B8">
								</div>
							</td>
						</tr>
						<tr>
							<td colspan=2 align="center">
								<input type="submit" value="SignIn" id="button">
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>