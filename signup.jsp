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
				<form action="signup.do" method="post">
					<table id="form_box">
						<caption>Signup</caption>
						<tr>
							<td class="lft">
								<label for="username">UserName</label>
							</td>
							<td class="rht">
								<input type="text" name="username" maxlength=30				minlength=5 class="normal_input" id="username">
								
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="email">Email</label>
							</td>
							<td class="rht">
								<input type="email" name="email" class="normal_input" id="email">					
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="password">Password</label>
							</td>
							<td class="rht">
								<input type="password" name="password"						class="normal_input" id="password">
								
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="repassword">Retype Password</label>
							</td>
							<td class="rht">
								<input type="password" name="repassword"					class="normal_input" id="repassword">
								
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
								<input type="submit" value="Signup" id="button">
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
		<script src="static/js/signup.js"></script>
	</body>
</html>