<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/menu.css">
		<link rel="stylesheet" href="static/css/seller_common.css">
		<link rel="stylesheet" href="static/css/add_product.css">
		<link rel="stylesheet" href="static/css/form.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>

			<div id="main_body">
				<div id="seller_navigation_line">
					<a href="seller_page.do" class="seller_home">Seller Account</a>
					<span>&nbsp;&nbsp;/&nbsp;&nbsp;</span>
					<a href="seller_dashboard.do?sellerId=${seller.sellerId}&sellerName=${seller.sellerAccountName}" class="seller_home">${seller.sellerAccountName}</a>
					<span >&nbsp;&nbsp;/&nbsp;&nbsp;</span>
					<span class="seller_name">New Product</span>
				</div>
				<div id="steps">
					<ul>
						<li class="sell">1</li>&nbsp;&nbsp;------&nbsp;&nbsp;
						<li>2</li>&nbsp;&nbsp;------&nbsp;&nbsp;
						<li>3</li>&nbsp;&nbsp;------&nbsp;&nbsp;
						<li>4</li>&nbsp;&nbsp;------&nbsp;&nbsp;
						<li>5</li>&nbsp;&nbsp;------&nbsp;&nbsp;
						<li>6</li>&nbsp;&nbsp;------&nbsp;&nbsp;
						<li>7</li>&nbsp;&nbsp;------&nbsp;&nbsp;
						<li>8</li>&nbsp;&nbsp;&nbsp;&nbsp;
					</ul>

					<div id="step1_box" class="show step_box">
						<%@ include file="error.jsp" %>
						<form method="post">
							<table id="form_box">
								<caption>New Product</caption>
								<tr>
									<td class="lft">
										<label>Product Category</label>
									</td>
									<td class="rht">
										<select name="categor_id" class="normal_input">
											<option value="0">Select</option>
											<c:forEach var="category" items="${categories}">
												<option value="${category.categoryId}">${category.category}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td class="lft">
										<label for="product_name">Product Name</label>
									</td>
									<td class="rht">
										<input type="text" name="product_name" class="normal_input" id="product_name">					
									</td>
								</tr>
								<tr>
									<td class="lft">
										<label for="quantity">Quantity</label>
									</td>
									<td class="rht">
										<input type="number" name="quantity"				class="normal_input" id="quantity">	
									</td>
								</tr>
								<tr>
									<td class="lft">
										<label for="price">Price</label>
									</td>
									<td class="rht">
										<input type="number" name="price"				class="normal_input" id="price">		
									</td>
								</tr>
								<tr>
									<td class="lft">
										<label for="price">Discount</label>
									</td>
									<td class="rht">
										<input type="number" name="discount"				class="normal_input" id="discount" placeholder="percentage(%)">
									</td>
								</tr>
								<tr>
									<td colspan=2 align="center">
										<input type="submit" value="Save Product" id="button">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div id="step2_box" class="hide step_box">
						<h1 class="product_title"></h1>
						<form>
							<table id="form_box">
								<caption>Description</caption>
								<tr>
									<td class="onecol">
										<span class="instruction">Please enter your product description over here.</span>
										<textarea name="description" class="normal_input"
										cols="65" rows="10"></textarea>
									</td>
								</tr>
							
								<tr>
									<td colspan=2 align="center">
										<input type="submit" value="Save details" id="button">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div id="step3_box" class="hide step_box">
						<h1 class="product_title"></h1>
						<form>
							<table id="form_box">
								<caption>Warranty</caption>
								<tr>
									<td class="onecol">
										<span class="instruction">Please enter your product warranty over here.</span>
										<textarea name="warranty" class="normal_input"
										cols="65" rows="10"></textarea>
									</td>
								</tr>
							
								<tr>
									<td colspan=2 align="center">
										<input type="submit" value="Save details" id="button">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div id="step4_box" class="hide step_box">
						<h1 class="product_title"></h1>
						<form>
							<table id="form_box">
								<caption>Returning Policy</caption>
								<tr>
									<td class="onecol">
										<span class="instruction">Please enter your product returning policy over here.</span>
										<textarea name="Returning_policy" class="normal_input"
										cols="65" rows="10"></textarea>
									</td>
								</tr>
							
								<tr>
									<td colspan=2 align="center">
										<input type="submit" value="Save details" id="button">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div id="step5_box" class="hide step_box">
							<h1 class="product_title"></h1>
						<form>
							<table id="form_box">
								<caption>Shipment Details</caption>
								<tr>
									<td class="onecol">
										<span class="instruction">Please enter your product shipment details over here.</span>
										<textarea name="Shipment_details" class="normal_input"
										cols="65" rows="10"></textarea>
									</td>
								</tr>
							
								<tr>
									<td colspan=2 align="center">
										<input type="submit" value="Save details" id="button">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div id="step6_box" class="hide step_box">
						<h1 class="product_title"></h1>
						<form>
							<table id="form_box">
								<caption>Payment Details</caption>
								<tr>
									<td class="onecol">
										<span class="instruction">Please enter your product payment details over here.</span>
										<textarea name="Payment_details" class="normal_input"
										cols="65" rows="10"></textarea>
									</td>
								</tr>
							
								<tr>
									<td colspan=2 align="center">
										<input type="submit" value="Save details" id="button">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div id="step7_box" class="hide step_box">
						<form>
							<table id="form_box">
								<caption>Pointwise Product Details</caption>
								<thead>
									<tr class="record_header">
										<th class="label">.&nbsp;</th>
										<th class="label">Points-Title</th>
										<th class="label">Points-Value</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<td colspan=3 align="right" title="Add more">
											<span id="add_more_link">
												<img src="static/images/add_icon.png" id="add_icon">
												<span id="add_more">Add More</span>
											</span>
										</td>
									</tr>
									<tr>
										<td colspan=3 align="center">
											<input type="submit" value="Save" id="button">
										</td>
									</tr>
								</tfoot>
								<tbody id="product_point_record">
									<tr>
										<td class="block1">
											1.
										</td>
										<td class="block2">
											<input type="text" name="points_title" class="normal_input points_ttl">
										</td>
										<td class="block3">
											<textarea name="product_points" cols="22" rows="3" class="points_text"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</form>	
					</div>
					<div id="step8_box" class="hide step_box">
						<form action="upload_product_pic.do" method="post" enctype="multipart/form-data">
							<table id="form_box">
								<caption>Upload Product Pics</caption>
								<tbody id="upload_field_box">	
									<tr>
										<td class="lft">1.</td>
										<td class="rht">
											<input type="file" name="product_pic_1" id="product_pic" class="normal_input">
										</td>
									</tr>
								</tbody>	
								<tr>
									<td colspan=2 align="right">
										<img src="static/images/add_icon.png" id="add_file">
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

					<input type="hidden" id="product_id" name="product_id" value="">
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
		<script src="static/js/add_product.js"></script>
	</body>
</html>