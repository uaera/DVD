import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager_user extends JFrame implements ActionListener {

	// �������
	JLabel jl1, jl2 = null;
	JTextField jtf = null;
	JButton jb1, jb2, jb3 = null;
	JPanel jp1, jp2, jp3 = null;

	DefaultTableModel model = null;
	JTable table = null;
	JScrollPane jsp = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager_user t = new Manager_user();
	}

	// ���캯��
	public Manager_user() {
		// �������
		jl1 = new JLabel("�������û���Ա�ţ�");

		jl2 = new JLabel("�û���Ϣ��");

		jtf = new JTextField(10);
		jb1 = new JButton("��ѯ");
		jb2 = new JButton("�޸�");
		jb3 = new JButton("����");
		// ���ü���
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		// ���ñ��1
		String[] colnames = { "����", "�û����", "����", "�Ա�", "��������¼", "����ʱ��" };
		model = new DefaultTableModel(colnames, 3);
		table = new JTable(model);
		jsp = new JScrollPane(table);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jp3.setLayout(new BorderLayout());

		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb3);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.setPreferredSize(new Dimension(20, 20));

		jp2.add(jb2);
		jp2.add(jsp);

		jp3.add(jl2, BorderLayout.SOUTH);
		this.add(jp1);
		this.add(jp3);
		this.add(jp2);

		this.setLayout(new GridLayout(6, 1));
		this.setTitle("�û�����--����Ա");
		this.setSize(500, 700);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("��ѯ") && !jtf.getText().isEmpty()) {
			// �������ѯ��ť1ʱ�����������ݿ⽨������
			GetSQL.ConnectSQL();

		} else if (e.getActionCommand().equals("��ѯ") && !jtf.getText().isEmpty()) {

			GetSQL.ConnectSQL();
			GetSQL.getdatastu(jtf.getText());
			jtf.setText("");
			System.out.println(GetSQL.record);
			System.out.println(GetSQL.sex);
			// ������������
			table.setValueAt(GetSQL.name, 0, 0);
			table.setValueAt(GetSQL.num, 0, 1);
			table.setValueAt(GetSQL.age, 0, 2);
			table.setValueAt(GetSQL.sex, 0, 3);
			table.setValueAt(GetSQL.record, 0, 4);
			table.setValueAt(GetSQL.time, 0, 5);

		} else if (e.getActionCommand() == "����") {
			dispose();
			Manager_Choice l = new Manager_Choice();
		} else {
			JOptionPane.showMessageDialog(null, "������Ҫ��ѯ�ı��", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		}

	}
	public static int InsertUser(String ID,String name,String old,String sex,String record,String time){
		int i = 0;
		try{
			String sql = "insert into DVDInfo(ID,name,country,genres,years,price)values(' "+ID+" ',' "+name+" ',' "+old+" ',' "+sex+" ',' "+record+" ',' "+time+" ')";
			i = GetSQL.executeUPdate(sql); //ִ��SQL���
		}catch(Exception e){
			System.out.println(e.getMessage()); //��ʾ�쳣�ַ���
		}

		return i; //��ִ�н������
	}

}
