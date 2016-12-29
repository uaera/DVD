import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Lookup extends JFrame implements ActionListener {

	// �������
	JLabel jl1, jl2 = null;
	JTextField jtf = null;
	JButton jb1, jb2 = null;
	JPanel jp1, jp2 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User_Lookup t = new User_Lookup();
	}

	// ���캯��
	public User_Lookup() {
		// �������

		jl1 = new JLabel("������Ӱ����ţ�");

		jl2 = new JLabel("Ӱ����Ϣ��");

		jtf = new JTextField(10);

		jb1 = new JButton("��ѯ");
		jb2 = new JButton("����");
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp1 = new JPanel();
		jp2 = new JPanel();

		jp2.setLayout(new BorderLayout());

		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2.add(jl2, BorderLayout.NORTH);

		this.add(jp1);
		this.add(jp2);

		this.setLayout(new GridLayout(6, 1));
		this.setTitle("Ӱ������--�û�");
		this.setSize(500, 300);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("��ѯ") && !jtf.getText().isEmpty()) {
			// �������ѯ��ťʱ�����������ݿ⽨������
			GetSQL.ConnectSQL();
		} else if (e.getActionCommand() == "����") {
			dispose();
			User_Choice l = new User_Choice();
		} else {
			JOptionPane.showMessageDialog(null, "������Ҫ��ѯ�ı��", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		}

	}
}
