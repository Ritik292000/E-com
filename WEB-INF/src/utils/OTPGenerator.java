package utils;

import java.util.Random;

public class OTPGenerator{
	public static String generateOTP(){
		Random r=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<4;i++){
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}
}