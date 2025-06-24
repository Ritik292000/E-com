package utils;

import java.util.Random;
import java.util.Date;

public class ActivationCode{
	public static String generateActivationCode(){
		Random r=new Random();
		long activationCode = r.nextLong();
		if(activationCode<0){
			activationCode *= -1;
		}
		return activationCode+"_"+new Date().getTime();
	}
}