const form=document.forms[0];
const otp_box_wrapper=document.querySelector("#otp_box_wrapper");
const otp_box=document.querySelector('#otp_box');
const loader_box=document.querySelector('#loader_box');
const close=document.querySelector('#close');

close.addEventListener('click',()=>{
	otp_box_wrapper.style.display="none";
	otp_box.style.display="none";
});

const sendOTP= async ()=>{
	const mobile=form.mobile.value.trim();
	const data= await fetch("sendsms.do?mobile="+mobile);
	//const data =await response.json();
	return data;
}

const updateUI= ()=>{
	otp_box_wrapper.style.display="block";
	loader_box.style.display="none";
	otp_box.style.display="block";
}

form.addEventListener('submit',e=>{
	if(form.otp.value.trim().length==4){
		console.log("#############");
	}
	else{	
		e.preventDefault();

		sendOTP().
				then(data=>{
					console.log(data);
					updateUI();
				}).
				catch(error=>{
					console.log(error);
				});
			
		otp_box_wrapper.style.display="block";
		loader_box.style.display="block";
	}
});