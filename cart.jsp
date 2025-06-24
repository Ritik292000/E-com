<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/cart.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>
			<div id="main_body">
				<c:forEach var="cartItem" items="${cart}">
					<input type="hidden" class="prodc_hidden" value="${cartItem.key}">
				</c:forEach>

				<h2><span>Your Cart</span></h2>

				<div id="cart_box">
					<div id="empty">
						<h3>No product is selected by you....</h3>
					</div>
					<c:forEach var="product" items="${products}">
						<div class="produc_recs">
							<div class="rec_rht">
								<div class="produc_ttl">${product.productName}</div>
								<div class="quantity_box">
									<b>Quantity</b>
									<select class="produc_qt" data-prodqt="${product.productId}">
										<c:forEach var="cartItem" items="${cart}">
											<c:choose>
												<c:when test="${cartItem.key==product.productId}">
													<c:forEach var="counter" items="${itemCount}">
														<c:choose>
															<c:when test="${cartItem.value==counter}">
																<option selected>${counter}</option>
															</c:when>
															<c:otherwise>
																<option>${counter}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</c:when>
											</c:choose>
										</c:forEach>
									</select>

									<span class="del_box" data-del="${product.productId}">
										<img src="static/images/del.png" height="23">
										Delete
									</span>
								
								</div>
								<div class="produc_price">
									<span class="prcartdis">${product.price*(100-product.discount)/100}
									</span>
									<span class="discount">${product.price}</span>
								</div>
							</div>
							<div class="rec_lft">
								<img src="product_image.do?product_id=${product.productId}" class="pro_img">
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="cart_total_box">
					<span class="ttl_lbl">Total (Rs.) </span>
					<span id="ttl">0</span>
				</div>
				<div id="button_box">
					<input type="button" value="Checkout" id="checkout">
				</div>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
		<script src="static/js/cart.js"></script>

	</body>
</html>