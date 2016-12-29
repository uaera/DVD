import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class DVDAdd extends JPanel implements ActionListener {
	Connection con;
	Statement sql;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b;
	Box baseBox,bv1,bv2;
	int flag=0;
	
	DVDAdd(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(ClassNotFoundException e){}
		try{
			con=DiverManager.getConnection("jbdc:odbc:dvd","","");
			sql=con.createStatement();
		}
		catch(SQLException ee){}
		
		setLayout(new BorderLayout());
		b=new JButton("����");
		b.setBackground(Color.orange);
		b.addActionListener(this);
		
		t1=new JTextField(8);
		t2=new JTextField(16);
		t3=new JTextField(16);
		t4=new JTextField(16);
		t5=new JTextField(16);
		t6=new JTextField(16);
		t7=new JTextField(16);
		
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t7.setEditable(false);
		
		JPanel p1=new JPanel(),p2=new JPanel();
		p1.add(new Label("������DVD��ţ�"));
		p1.add(t1);
		p1.add(b);
		bv1=Box.createVerticalBox();
		bv1.add(new JLabel("ӰƬ����"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("���"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("����"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("����"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("���"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("��ӳʱ��"));
		bv1.add(Box.createVerticalStrut(8));
		
		bv2=Box.createVerticalBox();
		bv2.add(t2);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t3);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t4);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t5);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t6);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t7);
		bv2.add(Box.createVerticalStrut(8));
		
		baseBox=Box.createHorizontalBox();
		baseBox.add(bv1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(bv2);
		
		p2.add(baseBox);
		add(p1,"North");
		add(p2,"Center");
		setSize(350,300);
		setBackground(Color.white);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		flag=0;
		try{query();}
		catch(SQLException ee){}
		}
	public void query() throws SQLException{
		String num,movienum,moviename,region,style,year,price;
		con=DriverManager.getConnection("jdbc:odbc:student","","");
		num=t1.getText().trim();
		ResultSet rs=sql.executeQuery("SELECT * FROM dvd WHERE id='"+num+"'" );
		
		if(rs.next()){
			moviename=rs.getString("moviename");
			movienum=rs.getString("movienum");
			region=rs.getString("region");
			style=rs.getString("style");
			year=rs.getString("year");
			price=rs.getString("price");
			t2.setText(moviename);
			t3.setText(movienum);
			t4.setText(region);
			t5.setText(style);
			t6.setText("year");
			t7.setText("price");
			
			flag=1;
			
			
		}else
		{
			JOptionPane.showMessageDialog(this,"û�и�ӰƬ��","��ʾ�Ի���",JOptionPane.INFORMATION_MESSAGE);
		}
		con.close();
		if(flag==0){t1.setText("û�и�ӰƬ");}
	}

}
��Ϊ�������ݿ�ķ�����ʵ��DVD�Ľ���



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.border .*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.border .*;

public class DVDAdd extends JPanel implements ActionListener{
	
		public static void main(String[] args){
		Connection con;
		
	
	//��������
	JFrame frm=new JFrame();
	frm.setTitle("ӰƬ��Ϣ");
	frm.setLayout(new BorderLayout());
	JTextArea textArea=new JTextArea();
	textArea.setLineWrap(true);
	textArea.setColumns(10);
	textArea.setRows(3);
	textArea.append("1.������� 10Ԫ "+"\n"
			      + "2.�����ӻ����� 10Ԫ"+"\n"
			      + "3.�����ڶ��� 10Ԫ"+"\n"
			      + "4.����Ȼ�Ƕ��� 10Ԫ"+"\n"
			      + "5.����ȸ�� 20Ԫ"+"\n"
			      + "6.������־�� 20Ԫ"
			      );

	textArea.setBounds(300,5,120,60);
	frm.getContentPane().add(textArea);
	
	
	frm.setBounds(400,200,400,200);
	frm.setVisible(true);
	

}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
}

