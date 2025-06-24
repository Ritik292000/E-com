<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/seller_common.css">
		<link rel="stylesheet" href="static/css/seller_dashboard.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>

			<div id="main_body">
				<div id="new_product_box">
					<a href="new_product.do" id="new_product">Add New Product +</a>
				</div>
				<div id="seller_navigation_line">
					<a href="seller_page.do" class="seller_home">Seller Account</a>
					<span class="seller_name">&nbsp;&nbsp;/&nbsp;&nbsp;${seller.sellerAccountName}</span>
					<input type="hidden" id="slrId" value="${seller.sellerId}">
				</div>
				<div id="outer_box">
					<div id="inr_lft">
						<div id="slr_act1" class="slr_act_tab act_tab_actv">All Product</div>
						<div id="slr_act2" class="slr_act_tab act_tab_dactv">Orders</div>
						<div id="slr_act3" class="slr_act_tab act_tab_dactv">Return Request</div>
					</div>
					<div id="inr_rht">
						<div id="blk1" class="blk">
							<div id="allprod_ttl">All Products</div>				
							<div class="no_recs" id="no_produc">No Product Found</div>
						</div>
						<div id="blk2" class="blk blk_hide">Hi</div>
						<div id="blk3" class="blk blk_hide">Nameste</div>
					</div>
				</div>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
		<script src="static/js/seller_dashboard.js"></script>
	</body>
</html>