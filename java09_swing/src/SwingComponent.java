import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingComponent {

	JFrame frm = new JFrame("������Ʈ������"); //������
	Rectangle frmSize = new Rectangle(200,200,500,500);	
	
	public SwingComponent() {
		
		frm.setTitle("Component");
		
		//JFrame -> FlowLayout(Ȯ������ʰ� ������ũ�⸸ŭ ũ�� �����Ǵ�) ���� ���̾ƿ�����
		frm.setLayout(new FlowLayout());
		
		//JTextField : ������ ���ڿ��� �Է��Ҽ��ִ� ������Ʈ		
		JTextField tf = new JTextField(10);
		frm.add(tf);		
		//								String int ���ڼ��ڽ���ũ��
		JTextField tf2 = new JTextField("ABCDEFG",20);
		
		//���� �����ϱ�
		tf2.setText("�ؽ�Ʈ �ʵ��� ���� ����Ǿ����ϴ�");
		//getText setText
		try{	
			String str1 = tf2.getText();
			//						index count(����)
			String str2 = tf2.getText(2,3);
			System.out.println("str1--->"+str1);
			System.out.println("str2--->"+str2);
		}catch(Exception e) {}		
		frm.add(tf2);
		
		//JPasswordField : ���ڸ� ��ũ�����ش�.
		JPasswordField pf = new JPasswordField(20);
		frm.add(pf);
		
		//JTextArea : �������� ���ڿ��� �Է��ϴ� �ڽ� ������Ʈ
		JTextArea ta = new JTextArea(5,30);
		//��ũ�ѱ���� �ִ� �����̳�
		JScrollPane sp = new JScrollPane(ta); //JTextArea�ڽ�������Ʈ�ȿ� ��ũ�ѹ� �ʿ� -> ��ũ�ѹٴ� ������ �����̳�-> JTextArea�� ���⿡ ������ �ִ�
		frm.add(sp); //sp�ȿ� ta�� ���������
		
		//JCheckBox : �������� �����Ҽ� �ִ� ���۳�Ʈ
		JCheckBox cb1 = new JCheckBox("���");
		JCheckBox cb2 = new JCheckBox("��",true);
		frm.add(cb1);
		frm.add(cb2);
		
		//JSlider :��ƽ�� �̿��� �� ���� 
		JSlider s1 = new JSlider(JSlider.HORIZONTAL, 1 ,10,5);
		frm.add(s1);
		
		
		
		// x, y, w ,h
		frm.setBounds(frmSize);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
	new SwingComponent();

	}

}