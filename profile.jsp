
<!DOCTYPE html>
<html>
	<head>
		<title>ecom::signup</title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/form.css">
		<link rel="stylesheet" href="static/css/profile.css">
		<link rel="stylesheet" href="static/css/menu.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>

			<div id="main_body">
				<%@ include file="error.jsp" %>


				<form action="profile.do" method="post">
					<table id="form_box">
						<caption>Profile Page</caption>
						<tr>
							<td class="lft">
								<label for="firstname">FirstName :</label>
							</td>
							<td class="rht">
								<input type="text" name="firstname" class="normal_input" id="firstname" value="${user.firstName}">	
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="middlename">MiddleName :</label>
							</td>
							<td class="rht">
								<input type="text" name="middlename" class="normal_input" id="middlename" value="${user.middleName}">	
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="lastname">LastName :</label>
							</td>
							<td class="rht">
								<input type="text" name="lastname" class="normal_input" id="lastname" value="${user.lastName}">			
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="dob">Date-of-birth :</label>
							</td>
							<td class="rht">												<input type="date" name="dob" class="normal_input"				id="dob" value="${user.dob}">			
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="mobile">Mobile No. :</label>
							</td>
							<td class="rht">
								<input type="text" name="mobile" maxlength=10
								minlength=10 class="normal_input" id="mobile" value="${user.mobile}">	
							</td>
						</tr>
						<tr>
							<td colspan=2>
								<input type="submit" value="Send OTP" id="button">
								<a href="address.do" id="button2">SKIP&gt;&gt;</a>
							</td>
						</tr>
					</table>
					<div id="otp_box_wrapper">
						<div id="loader_box">
							<h3>Please wait for a while...</h3>
							<img src="static/images/loader.gif" id="loader">
						</div>
						<div id="otp_box">
							<div id="close_box">
								<img src="static/images/close.png" id="close">
							</div>
							<h3>Enter Your OTP</h3>
							<label for=>OTP :</label>
							<input type="text" maxlength="4" name="otp" id="otp"><br>
							<input type="submit" id="otp_btn">
						</div>
					</div>
				</form>				
			</div>
			
			
			<%@ include file="footer.jsp" %>
			<script src="static/js/profile.js"></script>
		</div>
	</body>
</html>

		