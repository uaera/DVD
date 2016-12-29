import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class DVD_User extends JFrame implements ActionListener {
	JMenuBar bar=null;
	JMenu menu1,menu2,menu3,menu4,menu5;
	JMenuItem item1,item2,item3,item4,item5;
	
	
	DVDAdd jieyue;
	DVDQuery chaxun;
	DVDDelete shanchu;
	
	DVD_User(){
		super("DVD用户系统");
		
	    jieyue=new DVDAdd();
		chaxun=new DVDQuery();
		shanchu=new DVDDelete();
		bar=new JMenuBar();
		
		
		menu1=new JMenu("DVD增加");
		menu2=new JMenu("DVD查询");
		menu3=new JMenu("DVD删除");
		menu4=new JMenu("退出系统");
		
		item1=new JMenuItem("增加");
		item2=new JMenuItem("查询");
		item3=new JMenuItem("删除");
		item4=new JMenuItem("退出");
		
		menu1.add(item1);
		menu2.add(item2);
		menu3.add(item3);
		menu4.add(item4);
		
		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);
		
		setJMenuBar(bar);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		
        this.setLayout(new GridLayout(4,1));
		
		this.setTitle("DVD租借系统");
		
		this.setSize(500,500);
		
		this.setLocation(300, 150);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.setResizable(true);
		
		
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==item1){
			this.getContentPane().removeAll();
			this.getContentPane().add(jieyue,"Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
			dispose();
			DVDAdd m=new DVDAdd();
		}
		if(e.getSource()==item2){
			this.getContentPane().removeAll();
			this.getContentPane().add(chaxun,"Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
			
		}
		if(e.getSource()==item3){
			this.getContentPane().removeAll();
			this.getContentPane().add(shanchu,"Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
		}
		if(e.getSource()==item4){
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		DVD_User dvdU=new DVD_User();
		dvdU.setVisible(true);
		
		dvdU.addWindowListener(new WindowAdapter(){
			public void windowClosing(Window e){
				System.exit(0);
			}
		});
		}
	
}
