package utils;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonObject;

public class GoogleCaptcha{
	public static boolean checkReCaptcha(String recaptcha) throws IOException{
		String recaptchaURL="https://www.google.com/recaptcha/api/siteverify";
		String parameter="secret=6LdkjtIZAAAAALf4yRmQBM13SW0fV3DikE330IuM"+
							"&response="+recaptcha;
		URL url=new URL(recaptchaURL+"?"+parameter);
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		DataOutputStream dos=new DataOutputStream(con.getOutputStream());
		dos.flush();
		dos.close();
		InputStream inputStream;
		int status=con.getResponseCode();
		if(status!=HttpURLConnection.HTTP_OK){
			inputStream=con.getErrorStream();
		}
		else{
			inputStream=con.getInputStream();
		}
		
		JsonReader jsonReader=Json.createReader(inputStream);
		JsonObject jsonObject=jsonReader.readObject();
		boolean flag=jsonObject.getBoolean("success");
		jsonReader.close();
		
		return flag;
	}
}