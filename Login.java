import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	//定义登录界面的组件
	JButton jb1,jb2,jb3=null;
	JRadioButton jrb1,jrb2=null;
	JPanel jp1,jp2,jp3,jp4=null;
    JTextField jtf=null;
	JLabel jlb1,jlb2,jlb3=null;
	JPasswordField jpf=null;
	ButtonGroup bg=null;
	
	//菜单项
	JMenuBar jmb=null;	
	JMenu jm=null;
	JMenuItem jmi1,jmi2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login  ms=new Login();
	}				
	//构造函数
	public Login(){
		//创建组件
		jb1=new JButton("登录");
		jb2=new JButton("重置");
		jb3=new JButton("退出");
		
		//设置监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jmb=new JMenuBar(); 
		jm=new JMenu("选项"); 
		jmi1=new JMenuItem("开始");
		jmi2=new JMenuItem("退出系统");
		jm.add(jmi1);
		jm.add(jmi2);
		jmb.add(jm);	
		
		jrb1=new JRadioButton("管理员",true);
		jrb2=new JRadioButton("用户");
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		jrb2.setSelected(true);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();				
		
		jlb1=new JLabel("用户名：");
		jlb2=new JLabel("密    码：");
		jlb3=new JLabel("权    限：");
		
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
		
		this.setTitle("DVD租借系统");
		
		this.setSize(500,500);
		
		this.setLocation(300, 150);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.setResizable(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()=="退出"){
			System.exit(0);
		}else if(e.getActionCommand()=="登录"){
			if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty()){
				GetSQL.ConnectSQL();
				if(jrb1.isSelected()){
					GetSQL.querytea("管理员",jtf.getText());
					if(GetSQL.pwd ==null){
                         this.clear();
					}else{
						this.Managerlogin();
					}
				}else if(jrb2.isSelected()){
					GetSQL.queryuser("用户",jtf.getText());
					
					if(GetSQL.pwd ==null){
                         this.clear();
					}else{
					
						this.Userlogin();
					}
				}
			}else if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"请输入用户名","提示消息",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}else if(jpf.getText().isEmpty())	
			{
				JOptionPane.showMessageDialog(null,"请输入密码","提示消息",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}
		}else if(e.getActionCommand()=="重置")
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
					JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
					this.clear();
					 dispose();
					 User_Choice ui=new User_Choice();
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
				   
					this.clear();
				}
			}
			
			
			public void Managerlogin()
			{
				if(GetSQL.pwd.equals(jpf.getText()))
				{
					 JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
					 this.clear();						
					 dispose();					 
					Manager_Choice t=new Manager_Choice();				 					
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
				    
					this.clear();
				}
			}
		
}

