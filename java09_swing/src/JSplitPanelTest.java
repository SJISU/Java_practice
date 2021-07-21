import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class JSplitPanelTest extends JFrame{

	JSplitPane sp1,sp2;
	CalculatorEx2 cal = new CalculatorEx2();
	SwingCalendar2 calendar = new SwingCalendar2();
	
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	public JSplitPanelTest() {
		
		//����������
		sp2 =new JSplitPane(JSplitPane.VERTICAL_SPLIT,cal,calendar); // ���Ʒ��� ������ 
		
		//���򳪴���
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp2,sp); //�¿�� ������-JSplitPane�� HORIZONTAL_SPLIT���
																  //�¿�� �������ʿ� ���Ʒ��γ���sp2 �ִ´�
															     // ������dps JTextArea 
		add(sp1); 		
		 
		//��輱�� ��ġ�� ������ �� �մ�. - �������������� �������������� ��輱 //�¿�-sp1 ���������Ʒ�-sp2
		sp2.setDividerLocation(350); //���ʿ� 350px(�ȼ�)
		sp1.setDividerLocation(800); //������ 800px
		
		//��輱�� �β� ���� 
		sp2.setDividerSize(1); //px���� -> ���β��� 1 �ȼ��� �ϰٴ�
		sp1.setDividerSize(20);
		
		//����ġ
		sp1.setOneTouchExpandable(true); // ������ �ƽ��� Ȯ���ϴ±��
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		new JSplitPanelTest();
	}

}
