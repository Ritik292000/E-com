<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="static/css/common.css">
  <link rel="stylesheet" href="static/css/product.css">
  <title>ecart::product</title>
 </head>
 <body>
  <div id="container">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menu.jsp" %>
	
	<div id="main_body">
		<h2 id="prod_ttl">Western Digital WD Green 240 GB 2.5 inch SATA III Internal Solid State Drive (WDS240G2G0A)</h2>
		<div id="product_box">	
			<div id="lft">
				<div id="all_pics_box">
					<img class="small_pic" src="static/images/a1.jpg">
					<img class="small_pic" src="static/images/a2.jpg">
					<img class="small_pic" src="static/images/a3.jpg">
					<img class="small_pic" src="static/images/a4.jpg">
					<img class="small_pic" src="static/images/a5.jpg">
					<img class="small_pic" src="static/images/a6.jpg">
				</div>
				<div id="pic_box">
					<img id="pic_focus" src="static/images/a1.jpg">
				</div>
			</div>
			
			<div id="rht">
				<p class="recs">
					<span class="ttl">Seller : </span>
					<span id="seller">Magix</span>
				</p>
				<p class="recs">
					<span class="ttl">Price : </span>
					<span id="price">Rs. 4500</span>
					<span id="aftdisc">After Discount</span>
				</p>
				<p class="recs">
					<span class="ttl">MRP. : </span>
					<s id="mrp">Rs. 6000</s>
				</p>
				
				<div id="all_tabs">					
					<div class="desc desc_sel">Description</div>
					<div class="desc desc_nsel">Warranty</div>
					<div class="desc desc_nsel">Returning Policy</div>
					<div class="desc desc_nsel">Shipment Details</div>
					<div class="desc desc_nsel">Payment Details</div>		
				</div>
				<div id="other_details_box">
					<div class="odtl odtl_show">
						<p>Enhance your system with AWD Green solid state Drive and improve the performance of your laptop or desktop computer For your daily computing needs. Slc caching (Single-Level cell caching) technology boosts write performance in a WD Green SSD to browse the web, play your favorite casual games, or simply start Up your system in a flash. Administrative rights are required for installation and execution of the application</p>
						
						<p>
						Enhance your system with AWD Green solid state Drive and improve the performance of your laptop or desktop computer For your daily computing needs. Slc caching (Single-Level cell caching) technology boosts write performance in a WD Green SSD to browse the web, play your favorite casual games, or simply start Up your system in a flash. Administrative rights are required for installation and execution of the application</p>
					</div>
					<div class="odtl odtl_hide">
						<p>
						HDD is like plain empty space where you keep filling data in FIFO manner.(First In First Out).
SSD on the other hand is like a "mini-computer" in itself. It is not just an empty space to fill. There is hundreds of operations that happens when writing and reading the data. There is a dedicated micro-computer/processor inside an SSD. It has it's own cache, it's own programming etc. So, it is like having a small computer within your computer that allocates space, manages read/write operations. You even have firmware upgrades to your SSD.</p>
					</div>
					<div class="odtl odtl_hide">
						<p>
							The product is cost effective, comes with 5 years warranty, and includes everything that is needed for its installation in any laptop running SATA hard-disk. If your laptop has standard 1 TB hard-disk, just replace it with 500GB Crucial MX500 SSD and you will literally be blown away by the change in performance. My son, who is a second year Engineering student, had thrown away a Dec, 2018 HP Model (Intel i5 Processor-8GB RAM-1TB HDD) laptop running Windows 10 just because it used to take 5 minutes to boot properly and then every app used to run only after two-three minutes upon clicking. Google Chrome was unable to run 4 tabs at a time, sometimes even tending to hang-up if a video was played from YouTube. Now that same laptop boots and logs in inside 10 seconds and Photoshop 2018 CC completely loads and works inside 15 seconds! My son is willing to bet that his laptop performance is now as good as models costing 1.25 lakh (or more). This is an honest, tried and tested review by a father who was almost ready to buy another laptop.
						</p>
					</div>
					<div class="odtl odtl_hide">
						<p>
							The SSD is really lightweight and sometimes would feel like there's nothing inside. Same was the case with my previous SSD which i return due to it having some fault causing my motherboard to malfunction. 40TBW is more than enough for normal users, i won't install any games because i want my SSD to long laster so i only have my OS and essential programs on it.
						</p>
					</div>
					<div class="odtl odtl_hide">
						<p>
							The first concern is the incomplete SMART health monitoring data set. The required data is there but a few fields are not correctly populated. Crucial do publish a table to convert the values to a more friendly format but that should not be necessary. This also means that some useful information cannot be read by automated health diagnostics, including the 'expected life remaining' value. Again, this can be worked around but the end user should not need to.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<%@ include file="footer.jsp" %>
  </div>

  <script src="static/js/product.js"> </script>
 </body>
</html>
