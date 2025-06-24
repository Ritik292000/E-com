const msg=document.querySelector("#msg");
msg.style.left=window.innerWidth/2-150+'px';

const searchKey=document.querySelector("#search_key");

const blk = document.querySelectorAll(".blk");

const blk1=document.querySelector("#blk1");
const noproduc=document.querySelector("#no_produc");

const cart_count = document.querySelector("#cart_count");

const allProducts = async ()=>{
	const URL="search.do?";
	const query=`search=${searchKey.value}`;
	const response=await fetch(URL+query);
	const data=await response.json();
	return data;
}

const addToCart = async (productId,quantity)=>{
	const URL="addtocart.do?";
	const query=`product_id=${productId}&quantity=${quantity}`;
	const response=await fetch(URL+query);
	const data=await response.json();
	return data;
}

const showProducts = (products)=>{
	if(products.length>0){
		//noproduc.style.display="none";
		blk1.innerHTML=`<div id="allprod_ttl">All Products</div>`;
		products.forEach(product=>{
				blk1.innerHTML+=`<div class="produc">
									<div class="produc_rht">
										<div class="produc_act">
											<span class="act_btn buynowbtn" data-bnb="${product.productId}">Buy Now</span><br>
											<span class="act_btn addtocartbtn" data-atcb="${product.productId}">Add to Cart</span>
											<select class="proqt">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
												<option>6</option>
												<option>7</option>
												<option>8</option>
												<option>9</option>
												<option>10</option>
											</select>
										</div>
										<div class="produc_ttl">
											<a href="viewproduct.do?product_id=${product.productId}">${product.productName}</a>
										</div>
										<div class="produc_otl">
											<span>Price :</span>
											<span class="price">Rs. ${product.price*(100-product.discount)/100}</span>
											<s class="mrp">(MRP Rs ${product.price})</s>
											<span>Quantity :</span>
											<span class="qt">${product.quantity}</span>
											<span>Sold :</span>
											<span class="sold">${product.sold}</span>
										</div>
									</div>
									<div class="produc_lft">
										<img  src="product_image.do?product_id=${product.productId}" class="produc_img">
									</div>
								</div>`;	
		});

		const buynowbtn=Array.from(document.querySelectorAll(".buynowbtn"));
		const addtocartbtn=Array.from(document.querySelectorAll(".addtocartbtn"));
		const proqt=Array.from(document.querySelectorAll(".proqt"));

		addtocartbtn.forEach((atcb,index)=>{
			atcb.qt=proqt[index];
			atcb.addEventListener('click',e=>{
			//	console.log(e.target.getAttribute('data-atcb'));
				let productId=e.target.getAttribute('data-atcb');

				addToCart(productId,e.target.qt.value).
					then(data=>{
						cart_count.innerHTML=data.productCount;
						msg.style.display='block';
						setTimeout(()=>{
							msg.style.display="none";
						},5000);
					}).
					catch(err=>{
						console.log(err);
					});
			});
		});
	}
	else if(products.length==0){
		blk1.innerHTML="";
		blk1.innerHTML+=`<div id="allprod_ttl">All Products</div>`;
		blk1.innerHTML+=`<div class="no_recs" id="no_produc">No Product Found</div>`;
	}
}


window.addEventListener('load',e=>{
	allProducts().
		then(data=>{
			showProducts(data);
		}).catch(err=>{
			console.log(err);
		});
});