import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


class GetSQL {
	public static final Object mename = null;
	public static final Object menum = null;

	static String userword;
	static String pwd;

	static String num;
	static String name;
	static String age;
	static String sex;
	static String record;
	static String time;

	static String moviename;
	static String movienum;
	static String style;
	static String region;
	static String year;
	static String price;

	static Connection ct = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public static void ConnectSQL() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct = DriverManager.getConnection("jdbc:odbc:1512480301");
			System.out.println("The SQL is connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void queryuser(String s, String username) {
		try {
			ps = ct.prepareStatement("select * from info where Ȩ��=? and �û���=? ");

			ps.setString(1, s);
			ps.setString(2, username);

			rs = ps.executeQuery();

			if (rs.next()) {

				userword = rs.getString(2);
				pwd = rs.getString(3);
				System.out.println("�ɹ���ȡ��������û���from���ݿ�");
				System.out.println(userword + "\t" + pwd + "\t");

			} else {
				JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void querytea(String s, String name) {
		try {
			ps = ct.prepareStatement("select * from info_tea where Ȩ��=? and �û���=? ");

			ps.setString(1, s);
			ps.setString(2, name);

			rs = ps.executeQuery();

			if (rs.next()) {

				userword = rs.getString(2);
				pwd = rs.getString(3);
				System.out.println("�ɹ���ȡ��������û���from���ݿ�");
				System.out.println(userword + "\t" + pwd + "\t");
			} else {
				JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void getdatastu(String s) {
		try {
			ps = ct.prepareStatement("select * from info where �û���Ա��=? ");

			ps.setString(1, s);

			rs = ps.executeQuery();
			if (rs.next()) {

				num = rs.getString(4);
				name = rs.getString(5);
				age = rs.getString(6);
				sex = rs.getString(7);
				record = rs.getString(8);
				time = rs.getString(9);
			} else {
				JOptionPane.showMessageDialog(null, "�]�д��û�������������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void getdatatea(String s) {
		try {
			ps = ct.prepareStatement("select * from info_tea where ӰƬ��� =? ");

			ps.setString(1, s);

			rs = ps.executeQuery();
			if (rs.next()) {

				movienum = rs.getString(4);
				moviename = rs.getString(5);
				style = rs.getString(6);
				region = rs.getString(7);
				year = rs.getString(8);
				price = rs.getString(9);
			} else {
				JOptionPane.showMessageDialog(null, "�]�д�ӰƬ������������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	static ResultSet executeQuery(String sql){
		try{
			if(ct == null){
				new GetSQL();
				return ct.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sql); 
			}
	}catch(SQLException e){
		e.printStackTrace();	 	
	}finally{}
		return null;
}

	static int executeUPdate(String sql){
		try{
			if(ct == null){
				new GetSQL();
				return ct.createStatement().executeUpdate(sql); //�������ݿ���²���
	}
	}catch(SQLException e){
		System.out.println(e.getMessage()); //��ӡ��׽���쳣
		}finally {}
		return -1;
	}

	public static void close(){
		try{
			ct.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ct = null; //������ִ�п��н����ݿ������ÿ�
		}
	}
	

}

