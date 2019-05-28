package filterstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class DataInputOutputStreamExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		File file = new File("C:/TEMP/ltemp/bb.txt");
		FileWriter writer = new FileWriter(file, true);
		writer.write("와우와우아와웅아ㅗ아이우란아러ㅣㅇㄴ럿ㅂ" + "\r\n");
		writer.write("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅇㄹ나일나얼니아ㅓㄹ니ㅏㅇㄹ" + "\r\n");
		writer.flush();
		writer.close();
		
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		FileOutputStream fos = new FileOutputStream("C:/TEMP/primitive.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동");
		dos.writeDouble(95.5);
		dos.write(2);
		
		dos.writeUTF("감자바");
		dos.writeDouble(99.2);
		dos.write(4);
		
		dos.flush();
		dos.close();
		
		FileInputStream fis = new FileInputStream("C:/TEMP/primitive.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		for(int i = 0; i < 2; i++) {
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + " : " + score + " : " + order);
		}
		
		dis.close();
		fis.close();

	}

}
