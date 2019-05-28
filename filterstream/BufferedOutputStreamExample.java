package filterstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		File file = new File("C:/TEMP/ltemp/");
		
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int data = -1;
		long start = 0;
		long end = 0;
		
		fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\0528\\src\\filterstream\\shot.JPG");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:/TEMP/ltemp/shot.JPG");
		start = System.currentTimeMillis();
		
		while((data = bis.read()) != -1) {
			fos.write(data);
		}
		
		fos.flush();
		end = System.currentTimeMillis();
		fos.close();bis.close();fis.close();
		System.out.println("사용하지 않았을 때 : "+(end-start)+"ms");
		
		fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\0528\\src\\filterstream\\shot.JPG");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:/TEMP/ltemp/shot.JPG");
		bos = new BufferedOutputStream(fos);
		start = System.currentTimeMillis();
		
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		
		bos.flush();
		end = System.currentTimeMillis();
		bos.close();fos.close();bis.close();fis.close();
		System.out.println("사용했을 때 : " +(end-start) + "ms");

	}

}
