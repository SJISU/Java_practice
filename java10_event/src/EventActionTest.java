import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//											1.�������̽� ��ӹ޴´�
public class EventActionTest extends JFrame implements ActionListener {
	//		ActionEvent(class), ActionListener(interface) 
	JButton btn = new JButton("Ŭ���ϼ���");
	JButton btn2 = new JButton("Ȯ��");
	
	public EventActionTest() {
		add(BorderLayout.NORTH,btn);
		add(BorderLayout.SOUTH,btn2);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈó��
		//1.�������̽� ��ӹ޴´�
		//2.�̺�Ʈ�� �߻��ϴ� ���۳�Ʈ�� ����Ѵ�.
		btn.addActionListener(this); //�� this�� �� �ִ� //�������̵��� �޼ҵ带 �ִ´� ->��ư�� Ŭ���ϸ� actionPerformed�� ã�Ƽ� �������̵��� �޼ҵ带 ����
		btn2.addActionListener(this);//addActionListener -->	actionPerformed �޼ҵ带 �����Ų��
		
	}
	
	
	//3. �߻�޼ҵ带 �������̵��Ѵ�		�̺�Ʈ����
	public void actionPerformed(ActionEvent ae) {
		
		//getSource -> �̺�Ʈ���߻��� object��ü�� ����
		Object obj = ae.getSource(); //1��
		//������Ʈ�� �������� ������ ��ư �����ϴ¹��		
		if(obj == btn) {
			gugudan(7);
			
		}else if(obj == btn2) {
			System.exit(0);
			
		}		
		//JButton eventbtn = (JButton)ae.getSource(); //2�� -������ü������ȯ
	}	
	
	//3. �߻�޼ҵ带 �������̵��Ѵ�		�̺�Ʈ����
//	public void actionPerformed(ActionEvent ae) { //���ư�� ������ ����� �´�...���ư�� ���������� �˾ƾ� ���ε��� ��ɱ����Ҽ��ִ�
//												  //ae ���� ��ư�� ������ �����ü��ִ� //ActioneventŬ���������� �޼ҵ�����ִ�->getActionConnend()
//		//getActionConnend(): �̺�Ʈ�� �߻��� ���۳�Ʈ�� �󺧸� ���Ѵ�. //�̺�Ʈ�� �߻��� ��ư�� ���� �����ִ� �޼ҵ�
//		String event = ae.getActionCommand(); //->��ư�� value�� ���ϴ°�?
//		
//		if(event.equals("Ŭ���ϼ���")) {
//			//������
//			gugudan(6);		
//		}else if(event.equals("Ȯ��")) {
//			//����
//			System.exit(0);
//		}
//	}
	
	
	public void gugudan(int dan) {
		for(int i=2; i<10; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}		
	}
		
	
	public static void main(String[] args) {
		new EventActionTest();
	}

}
