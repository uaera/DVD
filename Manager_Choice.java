import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Manager_Choice extends JFrame implements ActionListener {
	// �������
	JButton jb1, jb2 = null;
	JPanel jp1, jp2 = null;

	public Manager_Choice() {
		// �������
		jb1 = new JButton("ӰƬ����");
		jb2 = new JButton("�û�����");
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp1 = new JPanel();
		jp2 = new JPanel();

		jp1.add(jb1);
		jp2.add(jb2);

		this.add(jp1);
		this.add(jp2);

		this.setLayout(new GridLayout(3, 3, 50, 50));
		this.setTitle("����Ա�ɲ���ѡ��");
		this.setSize(300, 250);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ӰƬ����") {
			dispose();
			Manager_movie l = new Manager_movie();
		}
		if (e.getActionCommand() == "�û�����") {
			dispose();
			Manager_user l = new Manager_user();
		}
	}
}
