package utils;

public class EmailMessage{
	public static String generateActivationMail(String userName,String activationCode){
		String msg=		"<!doctype html>"+
						"<html lang='en'>"+
						"<head>"+
							"<meta charset='UTF-8'>"+
							"<style>"+
								"#container{"+
									"background-color:#ccc;"+
									"height:680px;"+
									"padding-top:50px;"+
								"}"+
								"#header{"+
									"background-color:white;"+
									"padding-top:20px;"+
									"padding-bottom:20px;"+
								"}"+
								"#image{"+
									"height:70px;"+
								"}"+
								"#main_body{"+
									"background-color:#ccc;"+
									"height:400px;"+
									"text-align:center;"+
								"}"+
								"#main_body h1{"+
									"margin:30px auto;"+
									"width:600px;"+
									"color:#3f74d6;"+
									"font-size:45px;"+
									"padding-bottom:20px;"+
									"border-bottom:4px solid #3f74d6;"+
									"font-family:Tahoma;"+
								"}"+
								"#main_body p{"+
									"font-size:28px;"+
								"}"+
								"#a1{"+
									"border:1px solid #fff;"+
									"background-color:#407bdd;"+
									"color:white;"+
									"margin-left:10px;"+
									"margin-right:10px;"+
									"font-size:25px;"+
									"text-decoration:none;"+
									"padding:5px 20px;"+
								"}"+
								"#a2{"+
									"border:1px solid #407bdd;"+
									"background-color:#fff;"+
									"color:#407bdd;"+
									"margin-left:10px;"+
									"margin-right:10px;"+
									"font-size:25px;"+
									"text-decoration:none;"+
									"padding:5px 10px;"+
								"}"+
							"</style>"+
							"</head>"+
							"<body>"+
								"<div id='container'>"+
									"<div id='header' align='center'>"+
										"<img src='http://localhost:8080/ecom_day_9/static/images/logo.png'	id='image'>"+
									"</div>"+
									"<div id='main_body'>"+
										"<h1> Welcome "+userName+" In ecart</h1>"+
										"<p>"+
											"Thank You for Registering in ecart.<br> "+
											"Just for confirmation its really you please click on Activate for Activation.<br>"+
											"Otherwise click on NO ITS NOT ME"+
										"</p><br>"+
										"<a href='#' id='a2'>NO ITS NOT ME</a>"+
										"<a href='http://localhost:8080/ecom_day_37/activation.do?ukey="+userName+"&actcode="+activationCode+"' id='a1'>Activate,Yes Its ME</a>"+
									"</div>"+
								"</div>"+
							"</body>"+
						"</html>";
		
		return msg;
	}
}