const ctrl=document.querySelector("#ctrl");
const ctrl_pnl=document.querySelector("#ctrl_pnl");

let ctrl_flag=0;

ctrl.addEventListener('click',()=>{
	if(ctrl_flag==0){
		ctrl_pnl.style.display="block";
		ctrl_flag=1;
	}
	else{
		ctrl_pnl.style.display="none";
		ctrl_flag=0;
	}
});

//################# Cart ##########################################

const cart=document.querySelector("#cart");
cart.addEventListener('click',()=>{
	window.location="showcart.do";
});

//################# Search ########################################


const search_button=document.querySelector("#search_button");
const search=document.querySelector("#search");

search_button.addEventListener('click',()=>{
	let searchKey=search.value;
	window.location=`search_result.jsp?search=${searchKey}`;
});