<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/seller_common.css">
		<link rel="stylesheet" href="static/css/search_result.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>
			<div id="msg">Product added successfully...</div>
			<input type="hidden" id="search_key" value="${param.search}">
	
			<div id="main_body">
				<div id="outer_box">
					<div id="inr_rht">
						<div id="blk1" class="blk">
							<div id="allprod_ttl">All Products</div>
						</div>
					</div>
				</div>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
		<script src="static/js/search_result.js"></script>
	</body>
</html>