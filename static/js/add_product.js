const form = document.forms;

const product_id_field = document.querySelector("#product_id");
const steps = document.querySelectorAll(".step_box");
const steps_list = document.querySelectorAll("#steps li");
const product_titles=document.querySelectorAll(".product_titles");

const steps_li = Array.from(steps_list);

const add_more_link=document.querySelector("#add_more_link");
const product_point_record=document.querySelector("#product_point_record");

const add_file = document.querySelector("#add_file");
const upload_field_box = document.querySelector("#upload_field_box");

let n=1;

add_file.addEventListener('click',()=>{
	const urow = upload_field_box.insertRow(n++);
	const rcell1 = urow.insertCell(0);
	const rcell2 = urow.insertCell(1);

	rcell1.innerHTML=`${n}.`;
	rcell1.className="lft";
	rcell2.className="rht";

	const upload_field=document.createElement("input");
	upload_field.type="file";
	upload_field.className="normal_input";
	upload_field.name=`product_pic_${n}`;
	rcell2.appendChild(upload_field);
});

let row=1;
add_more_link.addEventListener('click',()=>{
	const nrow = product_point_record.insertRow(row++);
	
	const cell1=nrow.insertCell(0);
	const cell2=nrow.insertCell(1);
	const cell3=nrow.insertCell(2);

	cell1.innerHTML=`${row}`;
	cell1.className="block1";

	const input_field=document.createElement("input");
	input_field.className="normal_input points_ttl";
	cell2.appendChild(input_field);
	cell2.className="block2";

	cell3.innerHTML=`<textarea name="product_points" cols="22" rows="3" class="points_text"></textarea>`;
	cell3.className="block3";
});

//####################### Methods ######################################

const saveProductNextDetail= async (request)=>{

	const response= await fetch(request,{method:'post'});
	const data = await response.json();
	return data;
}

//####################### Save Pointwise Product Details ################

form[6].addEventListener('submit',e=>{
	e.preventDefault();
	const points_ttl=Array.from(document.querySelectorAll(".points_ttl"));
	const points_text=Array.from(document.querySelectorAll(".points_text"));
	
	const URL="save_product_points.do?";
	let query='';
	let i=0;
	points_ttl.forEach(points_ttl=>{
		if(i==0){
			query+=`p_ttl=${encodeURIComponent(points_ttl.value)}`;
		}
		else{
			query+=`&p_ttl=${encodeURIComponent(points_ttl.value)}`;
		}
		i++;
	});
	points_text.forEach(points_text=>{
		query+=`&p_val=${points_text.value}`;
	});
	
	
	saveProductNextDetail(URL+query).then(data=>{
		if(data.resp===1){
			steps[6].className="hide step_box";
			steps[7].className="show step_box";
			steps_li[7].className="sell";
		}
		else if(data.resp===0){
		}
		else{
			window.location="signin.do";
		}
	}).catch(error=>{
		console.log(error);
	});
	
});

//####################### Save Payment Details ##########################


form[5].addEventListener('submit',e=>{
	e.preventDefault();

	const URL="save_payment_details.do?";
	const query=`payment_details=${encodeURIComponent(form[5].Payment_details.value)}`;

	saveProductNextDetail(URL+query).then(data=>{
		if(data.resp===1){
			steps[5].className="hide step_box";
			steps[6].className="show step_box";
			steps_li[6].className="sell";
		}
		else if(data.resp===0){
		}
		else{
			window.location="signin.do";
		}
	}).catch(error=>{
		console.log(error);
	});

});



//####################### Save Shipment Details ##########################

form[4].addEventListener('submit',e=>{
	e.preventDefault();
	
	const URL="save_shipment_details.do?";
	const query=`shipment_details=${form[4].Shipment_details.value}`;

	saveProductNextDetail(URL+query).then(data=>{
		if(data.resp===1){
			steps[4].className="hide step_box";
			steps[5].className="show step_box";
			steps_li[5].className="sell";
		}
		else if(data.resp===0){
		}
		else{
			window.location="signin.do";
		}
	}).catch(error=>{
		console.log(error);
	});
});


//####################### Save Returning Policy ##########################

form[3].addEventListener('submit',e=>{
	e.preventDefault();
	
	const URL="save_returning_policy.do?";
	const query=`returning_policy=${encodeURIComponent(form[3].Returning_policy.value)}`;

	saveProductNextDetail(URL+query).then(data=>{
		if(data.resp===1){
			steps[3].className="hide step_box";
			steps[4].className="show step_box";
			steps_li[4].className="sell";
		}
		else if(data.resp===0){
		}
		else{
			window.location="signin.do";
		}
	}).catch(error=>{
		console.log(error);
	});
});


//####################### Save Warranty ##########################

form[2].addEventListener('submit',e=>{
	e.preventDefault();
	
	const URL="save_product_warranty.do?";
	const query=`warranty=${form[2].warranty.value}`;

	saveProductNextDetail(URL+query).then(data=>{
		if(data.resp===1){
			steps[2].className="hide step_box";
			steps[3].className="show step_box";
			steps_li[3].className="sell";
		}
		else if(data.resp===0){
		}
		else{
			window.location="signin.do";
		}
	}).catch(error=>{
		console.log(error);
	});
});


//####################### Save Description ##########################

form[1].addEventListener('submit',e=>{
	e.preventDefault();
	
	const URL="save_product_desc.do?";
	const query=`description=${form[1].description.value}&product_id=${product_id_field.value}`;

	saveProductNextDetail(URL+query).then(data=>{
		if(data.resp===1){
			steps[1].className="hide step_box";
			steps[2].className="show step_box";
			steps_li[2].className="sell";
		}
		else if(data.resp===0){
		}
		else{
			window.location="signin.do";
		}
	}).catch(error=>{
		console.log(error);
	});
});

//####################### Save Product ###############################

form[0].addEventListener('submit',(e)=>{
	e.preventDefault();

	const URL = 'new_product.do?';
	const query= `categor_id=${encodeURIComponent(form[0].categor_id.value)}&product_name=${form[0].product_name.value}&quantity=${form[0].quantity.value}&price=${form[0].price.value}&discount=${form[0].discount.value}`;

	saveProductNextDetail(URL+query).then((data)=>{
		if(data.resp==0){
			window.location="signin.do";
		}
		else{
			if(data.productId){
				product_id_field.value = data.productId;
				steps[0].className = 'hide step_box';
				steps[1].className = 'show step_box';	
				steps_li[1].className = 'sell';
				
				const pro_titles=Array.from(product_titles);
				pro_titles.forEach(title=>{
					title.innerHTML=data.productName;
				});

			}
		}
	}).catch((err)=>{
		console.log(err);
	});
});
