
import java.io.*;

public class DVDMessage {
	public static void main(String[] args)throws IOException{
		FileWriter fw;
		fw=new FileWriter("E:\\DVD.txt");
		
		String a[]={"1��","2��","3��","4��","5��","6��"};
		String b[]={"�������","�����ӻ�����","����Ȼ�Ƕ���","�����ڶ���","������־��","����ȸ��"};
		String c[] ={"10Ԫ","10Ԫ","10Ԫ","10Ԫ","20Ԫ","20Ԫ"};
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
		
		String a[]={"1��","2��","3��","4��","5��","6��"};
		String b[]={"�������","�����ӻ�����","����Ȼ�Ƕ���","�����ڶ���","������־��","����ȸ��"};
		String c[] ={"10Ԫ","10Ԫ","10Ԫ","10Ԫ","20Ԫ","20Ԫ"};
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
