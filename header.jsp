<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<div id="hd1">
		<img src="static/images/logo.png" id="logo">
	</div>
	<div id="hd3">
		<img src="static/images/cart.png" id="cart">
			<span id="cart_count">
				<c:choose>
					<c:when test="${cartItemCount!=null}">
						${cartItemCount}
					</c:when>
					<c:otherwise>
						0
					</c:otherwise>
				</c:choose>
			</span>
		</img>
		<img src="static/images/ctrl.png" id="ctrl">
		<div id="ctrl_pnl">
			<div id="user">
				<span id="grt">Welcome</span>
				<c:if test="${user!=null}">
					<span>${user.userName}</span>
				</c:if>
			</div>
			<span id="auth_ctrl_box">
				<c:choose>
					<c:when test="${user==null}">
						<a href="signin.do">Sign-In</a>
						<a href="signup.do">Sign-Up</a>
					</c:when>
					<c:otherwise>
						<a href="profile.do" id="profpic_box">
							<img src="showprofpic.do" id="profpic_id">
						</a>
						<a href="signout.do">Sign-Out</a>
					</c:otherwise>
				</c:choose>
			</span>	
		</div>
	</div>
	<div id="menu_box">
		<div id="search_box_container">
			<span id="search_box">
				<span id="categories">All</span>
				<input type="search" name="search" id="search">
				<img src="static/images/search.png" id="search_button">
			</span>
		</div>
	</div>
</div>
	
<div id="menu">
	<a href="#" class="menu_link">Electronic</a>
	<a href="#" class="menu_link">Books</a>
	<a href="#" class="menu_link">Kids</a>
	<a href="#" class="menu_link">Men's Fashion</a>
	<a href="#" class="menu_link">Women's Fashion</a>
	<a href="#" class="menu_link">Sports</a>
	<div id="seller_button_box">
		<a href="seller_page.do">Seller Account</a>
	</div>
</div>

<script src="static/js/header.js"></script>
