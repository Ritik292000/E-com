const form=document.forms[0];
const name=form.name;
const address=form.address;
const city_name_id=form.city_id;
const city_name=form.city;
const pin=form.pin;

const addNewAddress= async ()=>{
	const URL="addresses.do?";
	const query=`name=${name.value}&address=${address.value}&city_id=${city_name_id.value}&city=${city_name.value}&pin=${pin.value}`;
	const response=await fetch(URL+query,{method:'POST'});
	const data=await response.json();
	return data;
}

form.addEventListener('submit',e=>{
	e.preventDefault();

	addNewAddress().
		then(data=>{
			if(data.done==1){
				window.location="addresses.do";
			}
	}).catch(err=>{
		console.log(err);
	});
});


//################# Show Tabs #################################

const form_box_container=document.querySelector("#form_box_container");
const record_box_container=document.querySelector("#record_box_container");
const add_new=document.querySelector("#add_new");
const adrtab=document.querySelectorAll(".adrtab");

adrtab.forEach(tab=>{
	tab.addEventListener("click",()=>{
		record_box_container.style.display="block";
		form_box_container.style.display="none";
	});
});

add_new.addEventListener("click",()=>{
	record_box_container.style.display="none";
	form_box_container.style.display="block";
});