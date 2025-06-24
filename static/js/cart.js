const cart_box=document.querySelector("#cart_box");
let produc_recs=document.querySelectorAll(".produc_recs");
let produc_qts=document.querySelectorAll(".produc_qt");
const prcartdis=document.querySelectorAll(".prcartdis");
const cart_total_box=document.querySelector(".cart_total_box");

const ttl=document.querySelector("#ttl");
const cart_count=document.querySelector("#cart_count");
const empty=document.querySelector("#empty");
const button_box=document.querySelector("#button_box");
const checkout=document.querySelector("#checkout");

//############## Checkout ####################

checkout.addEventListener("click",e=>{
	window.location="addresses.do";
});

//############## Price Total #################

let total=0;
let itemCount=0;

const calcTotal = ()=>{
	produc_qts.forEach((sel,index)=>{
		total+=parseInt(prcartdis[index].innerHTML) * parseInt(sel.value);
		itemCount+=parseInt(sel.value);
	});
	ttl.innerHTML=total;
	cart_count.innerHTML=itemCount;

	if(itemCount==0){
		empty.style.display="block";
		cart_total_box.style.display="none";
		button_box.style.display="none";
	}
	else{
		empty.style.display="none";
		cart_total_box.style.display="block";
		button_box.style.display="block";
	}
	
};

calcTotal();

//############## Cart Update #################

produc_qts.forEach((sel,index)=>{
	total+=parseInt(prcartdis[index].innerHTML)*parseInt(sel.value);
	sel.addEventListener('change',e=>{
		let prodId=e.target.getAttribute('data-prodqt');
		updateCart(prodId,e.target.value)
			.then(data=>{
				if(data.done=="true"){
					total=0;
					itemCount=0;
					calcTotal();
				}
			}).catch(err=>{
			});
	});
});

const updateCart = async (productId,quantity)=>{
	const url="update_cart.do?";
	const query=`product_id=${productId}&quantity=${quantity}`;
	const response=await fetch(url+query);
	const data=await response.json();
	return data;
};

//################### Delete Record ####################

const del_box=document.querySelectorAll(".del_box");

del_box.forEach((del,index)=>{
	del.container_box=produc_recs[index];
	del.addEventListener("click",e=>{
		let prodId=e.target.getAttribute("data-del");
		deleteCartRecord(prodId).
			then(data=>{
				if(data.done=="true"){
					cart_box.removeChild(e.target.container_box);
					produc_qts=Array.from(document.querySelectorAll(".produc_qt"));
					produc_recs=Array.from(document.querySelectorAll(".produc.rec"));
					total=0;
					itemCount=0;
					calcTotal();
				}
		}).catch(err=>{
		});
	});

});

const deleteCartRecord = async (prodId)=>{
	const URL="delete_record.do?";
	const query=`product_id=${prodId}`;
	const response=await fetch(URL+query);
	const data=await response.json();
	return data;
}