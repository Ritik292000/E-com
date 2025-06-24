<!DOCTYPE html>
<html>
	<head>
		<title>ecom::signup</title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/form.css">
		<link rel="stylesheet" href="static/css/profpic.css">
		<link rel="stylesheet" href="static/css/menu.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>

			<div id="main_body">
				<table id="outer_box">
					<tr>
						<td class="outer_box_cell">
							<img src="showprofpic.do" id="profpic">
						</td>
						<td class="outer_box_cell">
							<form action="profpic.do" method="post"							encType="multipart/form-data">
								<table id="form_box">
									<caption>Profile Pic</caption>
									<tr>
										<td class="lft">
											<label>Profile Pic :</label>
										</td>
										<td class="rht">
											<input type="file" name="profpic" class="normal_input" id="propic">
										</td>
									</tr>
									<tr>
										<td colspan=2 align="center">
											<input type="submit" value="Upload" id="button">
										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>
