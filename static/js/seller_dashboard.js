const slr_act_tab = document.querySelectorAll(".slr_act_tab");
const blk = document.querySelectorAll(".blk");

const actTabs = Array.from(slr_act_tab);
const Tabblock = Array.from(blk);

let i=0;
actTabs.forEach(tab=>{
	tab.blk=Tabblock[i++];
	tab.addEventListener('click',e=>{
		actTabs.forEach(tb=>{tb.className="slr_act_tab act_tab_dactv";});
		e.target.className="slr_act_tab act_tab_actv";

		Tabblock.forEach(block=>{block.className="blk blk_hide";});
		e.target.blk.className="blk";
	});
});

//#################### Method ###################################


const slr_act1 = document.querySelector("#slr_act1");
const slrId = document.querySelector("#slrId");
const blk1=document.querySelector("#blk1");
const noproduc=document.querySelector("#no_produc");


const allProducts = async ()=>{
	const URL="all_products.do?";
	const query=`seller_id=${slrId.value}`;
	const response=await fetch(URL+query);
	const data=await response.json();
	return data;
}

const showProducts = (products)=>{
	if(products.length>0){
		noproduc.style.display="none";
		blk1.innerHTML=`<div id="allprod_ttl">All Products</div>`;
		products.forEach(product=>{
				blk1.innerHTML+=`<div class="produc">
								<div class="produc_rht">
									<div class="produc_act">
										<img src="static/images/edit.png" class="produc_icon">
										<img src="static/images/del.png" class="produc_icon">
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
	}
	else{
		noproduc.style.display="block";
	}
}

slr_act1.addEventListener('click',()=>{
	allProducts()
		.then(data=>{
			showProducts(data);
		}).catch(err=>{
			console.log(err);
		});
});

allProducts()
.then(data=>{showProducts(data);})
.catch(err=>{console.log(err);});