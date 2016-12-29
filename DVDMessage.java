
import java.io.*;

public class DVDMessage {
	public static void main(String[] args)throws IOException{
		FileWriter fw;
		fw=new FileWriter("E:\\DVD.txt");
		
		String a[]={"1、","2、","3、","4、","5、","6、"};
		String b[]={"《心理罪》","《栀子花开》","《怦然星动》","《老炮儿》","《青云志》","《麻雀》"};
		String c[] ={"10元","10元","10元","10元","20元","20元"};
		for(int i=0;i<a.length;i++)
		{
			fw.write(a[i]);
			fw.write("\r\t");
			fw.write(b[i]);
			fw.write("\r\t");
			fw.write(c[i]);
			fw.write("\r\n");
		
		}
			
		fw.close();
		
	}
	

}
import java.io.*;

public class DVDMessage {
	public static void main(String[] args)throws IOException{
		FileWriter fw;
		fw=new FileWriter("E:\\DVD.txt");
		
		String a[]={"1、","2、","3、","4、","5、","6、"};
		String b[]={"《心理罪》","《栀子花开》","《怦然星动》","《老炮儿》","《青云志》","《麻雀》"};
		String c[] ={"10元","10元","10元","10元","20元","20元"};
		for(int i=0;i<a.length;i++)
		{
			fw.write(a[i]);
			fw.write("\r\t");
			fw.write(b[i]);
			fw.write("\r\t");
			fw.write(c[i]);
			fw.write("\r\n");
		
		}
			
		fw.close();
		
	}
	

}
