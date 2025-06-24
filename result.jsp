<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>:result page:</title>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/menu.css">
	</head>
	<body>
		<div id="container">
			<%@ include file="header.jsp" %>

			<div id="main_body">
				<c:choose>
					<c:when test="${success!=null}">
						<div class="result success">
							${success}
						</div>
					</c:when>
					<c:otherwise>
						<div class="result fail">
							${fail}
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>