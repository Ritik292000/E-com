<!DOCTYPE html>
<html>
	<head>
		<title>ecom::signup</title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/form.css">
		<link rel="stylesheet" href="static/css/address.css">
		<link rel="stylesheet" href="static/css/menu.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>

			<div id="main_body">
				<form action="address.do" method="post">
					<table id="form_box">
						<caption>Address Page</caption>
						<tr>
							<td class="lft">
								<label for="address">Address</label>
							</td>
							<td class="rht">
								<textarea name="address" rows=6 cols=35 maxlength=500 class="normal_input" id="address">${address.address}</textarea>
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="city">City</label>
							</td>
							<td class="rht" id="ct_box">
								<input type="hidden" name="city_id"
								class="normal_input" id="city_id"
								value="${address.city.cityId}">

								<input type="text" name="city"				class="normal_input" id="city" value="${address.city.city}">

								<div id="srch_res"></div>
							</td>
						</tr>
						<tr>
							<td class="lft">
								<label for="pin">Pin</label>
							</td>
							<td class="rht">
								<input type="text" name="pin"				class="normal_input" id="pin" value="${address.pin}">				
							</td>
						</tr>
						<tr>
							<td colspan=2 align="center">
								<input type="submit" value="Save" id="button">
								<a href="profpic.do" id="button2">SKIP&gt;&gt;</a>
							</td>
						</tr>
					</table>
				</form>								
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
		<script src="static/js/address.js"></script>
	</body>
</html>
