import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	//�����¼��������
	JButton jb1,jb2,jb3=null;
	JRadioButton jrb1,jrb2=null;
	JPanel jp1,jp2,jp3,jp4=null;
    JTextField jtf=null;
	JLabel jlb1,jlb2,jlb3=null;
	JPasswordField jpf=null;
	ButtonGroup bg=null;
	
	//�˵���
	JMenuBar jmb=null;	
	JMenu jm=null;
	JMenuItem jmi1,jmi2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login  ms=new Login();
	}				
	//���캯��
	public Login(){
		//�������
		jb1=new JButton("��¼");
		jb2=new JButton("����");
		jb3=new JButton("�˳�");
		
		//���ü���
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jmb=new JMenuBar(); 
		jm=new JMenu("ѡ��"); 
		jmi1=new JMenuItem("��ʼ");
		jmi2=new JMenuItem("�˳�ϵͳ");
		jm.add(jmi1);
		jm.add(jmi2);
		jmb.add(jm);	
		
		jrb1=new JRadioButton("����Ա",true);
		jrb2=new JRadioButton("�û�");
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		jrb2.setSelected(true);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();				
		
		jlb1=new JLabel("�û�����");
		jlb2=new JLabel("��    �룺");
		jlb3=new JLabel("Ȩ    �ޣ�");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jlb3);
		jp3.add(jrb1);
		jp3.add(jrb2);
		
		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		
		this.setJMenuBar(jmb);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		
		this.setLayout(new GridLayout(4,1));
		
		this.setTitle("DVD���ϵͳ");
		
		this.setSize(500,500);
		
		this.setLocation(300, 150);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.setResizable(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()=="�˳�"){
			System.exit(0);
		}else if(e.getActionCommand()=="��¼"){
			if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty()){
				GetSQL.ConnectSQL();
				if(jrb1.isSelected()){
					GetSQL.querytea("����Ա",jtf.getText());
					if(GetSQL.pwd ==null){
                         this.clear();
					}else{
						this.Managerlogin();
					}
				}else if(jrb2.isSelected()){
					GetSQL.queryuser("�û�",jtf.getText());
					
					if(GetSQL.pwd ==null){
                         this.clear();
					}else{
					
						this.Userlogin();
					}
				}
			}else if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"�������û���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}else if(jpf.getText().isEmpty())	
			{
				JOptionPane.showMessageDialog(null,"����������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}
		}else if(e.getActionCommand()=="����")
		{
			this.clear();
		}			
		
	}


	public	void clear()
		{
			jtf.setText("");
			jpf.setText("");
		}

			public void Userlogin()
			{
				if(GetSQL.pwd.equals(jpf.getText()))
				{
					JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					this.clear();
					 dispose();
					 User_Choice ui=new User_Choice();
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
				   
					this.clear();
				}
			}
			
			
			public void Managerlogin()
			{
				if(GetSQL.pwd.equals(jpf.getText()))
				{
					 JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					 this.clear();						
					 dispose();					 
					Manager_Choice t=new Manager_Choice();				 					
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
				    
					this.clear();
				}
			}
		
}

