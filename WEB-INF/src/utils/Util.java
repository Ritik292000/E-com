package utils;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util{
	public static void streamPic(ServletContext context,OutputStream os,String picPath) throws IOException{
		InputStream is=context.getResourceAsStream(picPath);

		byte[] ar=new byte[1024];
		int count=0;
		while((count=is.read(ar))!=-1){
			os.write(ar);
		}
		os.flush();
		os.close();
	}
}
	