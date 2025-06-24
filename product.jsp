<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/menu.css">
		<link rel="stylesheet" href="static/css/product.css">
		<link rel="stylesheet" href="static/css/seller_common.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>
			<div id="main_body">
				<a href="seller_page.do" class="seller_home">Seller Account</a>
				<span>&nbsp;&nbsp;/<a href="seller_dashboard.do?sellerId=${seller.sellerId}&sellerName=${seller.sellerAccountName}" class="seller_home">${seller.sellerAccountName}</a></span>
				
				<span class="seller_name">&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;Product view</span>

				<input type="hidden" id="product_id" value="${product.productId}">
				
				<div id="product_box">
					<div id="lft">
						<div id="all_product_pics">
						<!--<img class="small_pics" src="static/images/a1.jpg">
							<img class="small_pics" src="static/images/a2.jpg">
							<img class="small_pics" src="static/images/a3.jpg">
							<img class="small_pics" src="static/images/a4.jpg">
							<img class="small_pics" src="static/images/a5.jpg">
							<img class="small_pics" src="static/images/a6.jpg">-->
						</div>
						<div id="pic_box">
						<!--<img id="pic_focus" src="static/images/a2.jpg">-->
						</div>
					</div>
					<div id="rht">
						<div id="prod_ttl">${product.productName}</div>
						<p class="recs">
							<span class="ttl">Seller : </span>
							<span id="seller">${product.seller.sellerAccountName}</span>
						</p>
						<p class="recs">
							<span class="ttl">Price : </span>
							<span id="price">Rs.&nbsp;&nbsp;${product.price*(100-product.discount)/100}</span>
							<span id="aftdisc">After Discount</span>
						</p>
						<p class="recs">
							<span class="ttl">MRP : </span>
							<span id="mrp">Rs.&nbsp;&nbsp;${product.price}</span>
						</p>
						<div id="all_tabs">
							<div class="desc desc_sel">Description</div>
							<div class="desc desc_nsel">Warranty</div>
							<div class="desc desc_nsel">Returning Policy</div>
							<div class="desc desc_nsel">Shipment Details</div>
							<div class="desc desc_nsel">Payment Details</div>
						</div>
						<div id="other_details_box">
							<div class="otdl otdl_show">
								${product.description}
							</div>
							<div class="otdl otdl_hide">
								${product.warranty}
							</div>
							<div class="otdl otdl_hide">
								${product.returningPolicy}
							</div>
							<div class="otdl otdl_hide">
								${product.shipmentDetails}
							</div>
							<div class="otdl otdl_hide">
								${product.paymentDetails}
							</div>
						</div>
						<div id="propt_box">
							<table id="propt_tbl">
								<caption>Other Details</caption>
							</table>
						</div>
					</div>
				<div>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
		<script src="static/js/product.js"></script>
	</body>
</html>