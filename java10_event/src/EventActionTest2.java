import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventActionTest2 extends JFrame {

	JButton okbtn = new JButton("ok");
	JLabel lb1 = new JLabel("jjjj",JLabel.CENTER); //�󺧵� �̺�Ʈ�� ���� //->�󺧹�ư������ ���ڹٲ�� ->�ٸ�Ŭ�������� �̺�Ʈó������
	
	public EventActionTest2() {
		add(BorderLayout.NORTH,okbtn);
		add(lb1);
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ���->�̺�Ʈ����� ��ü�� ����Ŭ������ �����ϱ�
		okbtn.addActionListener(new EventProcess(lb1)); //�̺�Ʈ������Ŭ������ �޼ҵ尡 �����
	}
	
	

	public static void main(String[] args) {
		new EventActionTest2();
		
	}

}
