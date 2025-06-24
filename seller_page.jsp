<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="ecom_tld" %>
<!DOCTYPE html>
<html>
	<head>
		<title>seller:page</title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/menu.css">
		<link rel="stylesheet" href="static/css/seller_page.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>
			<div id="main_body">
				<c:choose>
					<c:when test="${empty sellers}">
						<h3 id="msg">NO Seller Account Found</h3>
					</c:when>
					<c:otherwise>
						<table id="seller_box">
							<tr>
								<th>&nbsp;</th>
								<th>Seller Account Name</th>
								<th>Start Date</th>
							</tr>
							<c:forEach var="seller" items="${sellers}">
								<tr>
									<td class="center cl1">
										<input type="checkbox" name="seller_id" 
										value="${seller.sellerId}">
									</td>
									<td class="center cl2">
										<a href="seller_dashboard.do?sellerId=${seller.sellerId}&sellerName=${seller.sellerAccountName}">
										${seller.sellerAccountName}</a>
									</td>
									<td class="center cl3">
										${app:format(seller.startDate)}
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
				<div id="new_seller_box">
					<a href="new_seller.do" id="new_seller_account"> Create New Seller Account +</a>	
				</div>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>