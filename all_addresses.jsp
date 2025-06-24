<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/all_addresses.css">
		<link rel="stylesheet" href="static/css/address.css">
		<link rel="stylesheet" href="static/css/form.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>
			<div id="main_body">
				<div id="address_box">
					<div id="rht_box">
						<div id="record_box_container">	
							<c:forEach var="address" items="${addresses}" varStatus="seq">
								<div id="record_box">
									<div class="hd">
										Address ${seq.count}
										<input type="button" value="Send to" id="sendto" class="send_btn">
									</div>
									<div class="addr">${address.name}</div>
									<div class="addr">${address.address}</div>
									<div class="addr">${address.city.city}</div>
									<div class="addr">${address.pin}</div>
								</div>
							</c:forEach>
						</div>
						<div id="form_box_container">
							<form>
								<table id="form_box">
									<caption>Address Page</caption>
									<tr>
										<td class="lft">
											<label for="name">Name</label>
										</td>
										<td class="rht">
											<input type="text" name="name"				class="normal_input" id="name">
										</td>
									</tr>
									<tr>
										<td class="lft">
											<label for="address">Address</label>
										</td>
										<td class="rht">
											<textarea name="address" rows=6 cols=35 maxlength=500 class="normal_input" id="address"></textarea>
										</td>
									</tr>
									<tr>
										<td class="lft">
											<label for="city">City</label>
										</td>
										<td class="rht" id="ct_box">
											<input type="hidden" name="city_id"
											class="normal_input" id="city_id">

											<input type="text" name="city"				class="normal_input" id="city">

											<div id="srch_res"></div>
										</td>
									</tr>
									<tr>
										<td class="lft">
											<label for="pin">Pin</label>
										</td>
										<td class="rht">
											<input type="text" name="pin"				class="normal_input" id="pin">				
										</td>
									</tr>
									<tr>
										<td colspan=2 align="center">
											<input type="submit" value="Save" id="button">
										</td>
									</tr>
								</table>
							</form>		
						</div>
					</div>
					<div id="lft_box">
						<c:forEach var="address" items="${addresses}" varStatus="seq">
							<div class="adrtab">Address${seq.count}</div>
						</c:forEach>
						<div id="add_new">+ Add Address</div>
					</div>
				</div>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
		<script src="static/js/all_address.js"></script>
		<script src="static/js/address.js"></script>
	</body>
</html>