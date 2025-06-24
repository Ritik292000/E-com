const form=document.querySelector('form');
const form_box=document.querySelector('table');
const error_msg=document.querySelector('#error_msg');
const button=document.querySelector('#button');

const userName=form.username;
const email=form.email;
const password=form.password;
const repassword=form.repassword;

const err_arr=new Array();

let i=0;

userName.onblur=checkUniqueKey;
email.onblur=checkUniqueKey;

let request=null;
function checkUniqueKey(){
	request=new XMLHttpRequest();
	request.open('GET','unique_check.do?key='+this.value,true);
	request.onreadystatechange=UniqueCheckResult;
	request.send();
}
function UniqueCheckResult(){
	if(request.readyState==4&&request.status==200){
		const resp=request.responseText;
			if(resp=='true'){
				console.log('1');
			}
			else{
				console.log('2');
			}
	}
}



userName.addEventListener('focus',()=>{
		userName.className='normal_input';
});

email.addEventListener('focus',()=>{
		email.className='normal_input';
});

password.addEventListener('focus',()=>{
		password.className='normal_input';
		repassword.className='normal_input';

});

repassword.addEventListener('focus',()=>{
		password.className='normal_input';
		repassword.className='normal_input';

});

form.addEventListener('submit',e=>{
		e.preventDefault();
		let flag=true;
		
		const unamepattern=/^[a-zA-Z][a-zA-Z0-9]{4,29}$/;
		if(!unamepattern.test(userName.value)){
			flag=false;
			userName.className='error';
			err_arr[i++]='Only alphabat and numeric characters are allowed..';
		}

		const emailpattern=/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
		if(!emailpattern.test(email.value)){
			flag=false;
			email.className='error';
			err_arr[i++]='Invalid Email';
		}

		if(password.value!=repassword.value){
			flag=false;
			password.className='error';
			repassword.className='error'
			err_arr[i++]='Password and Repassword must match';	
		}

		if(flag)
			form.submit();
		else{
			error_msg.style.display='block';
			err_arr.forEach(emsg=>{
					let p=document.createElement('p');
					p.innerHTML=emsg;
					error_msg.appendChild(p);
			});
		}
});

button.addEventListener('mouseover',()=>{
	i = 0;
	err_arr.length = 0;
	form_box.style.marginTop = '30px';
	error_msg.style.display = 'none';
	error_msg.innerHTML='';
});