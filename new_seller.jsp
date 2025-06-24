<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/menu.css">
		<link rel="stylesheet" href="static/css/form.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>

			<div id="main_body">
				<form action="new_seller.do" method="post">
					<table id="form_box">
						<caption>Create Seller Account</caption>
						<tr>
							<td class="lft">1.</td>
							<td class="rht">
								<input type="text" name="accname" id="accname" class="normal_input">
							</td>
						</tr>
					
						<tr>
							<td colspan=2 align="center">
								<input type="submit" value="Save Seller" id="button">
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>