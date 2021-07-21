import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame { //JLabel,

	JTabbedPane tp ;
	
	JLabel lb1;
	ImageIcon ii = new ImageIcon("img/flower.jpg");
	
	JButton btn;
	ImageIcon iii = new ImageIcon("img/ha.jpg");
	
	DigitalClock2 dc = new DigitalClock2(0,0);
	
	CalculatorEx2 cal = new CalculatorEx2(); 
	
	SwingCalendar2 calendar = new SwingCalendar2();
	
	PackMan2 pm = new PackMan2();
	
	public JTabbedPaneTest() {
		super("�Ǹ޴�");
		
		tp = new JTabbedPane(JTabbedPane.LEFT);// ()�ȿ��� Jtab����� ������� ���Ѵ�
											  //JTabbedPane.LEFT //JTabbedPane.TOP
		
		lb1 = new JLabel(ii);
		tp.addTab("���̺�",lb1);
		
		btn = new JButton(iii);
		tp.addTab("��ư",btn);
		
		tp.addTab("�ð�",dc);
		
		tp.addTab("����",cal);
		
		tp.addTab("�޷�",null,calendar, "�޷�");
		
		tp.insertTab("Button",null,new JButton("�߰��ȹ�ư"),"�߰��� �Ǹ޴� �߰�",3); //0,1,2,3.. ->3��ġ�� �߰� 
		
		tp.addTab("�Ѹ�",pm);
		
		//���� Ȱ��ȭ �� ��Ȱ��ȭ : setEnabledAt
		// true : Ȱ��ȭ,		false:��Ȱ��ȭ
		//				��index,  true/false
		//tp.setEnabledAt(2,false); // 2����ġ�� �ִ� �� ��Ȱ��ȭ��Ŵ
	
		//ù��° ���� ������ ������ ��� ���� ��Ȱ��ȭ �Ѵ�. 
		//tp.setEnabled(false);
		
		
		
		add(tp);
		setSize(500,500); //����� ���⼭ ������...�� ���Ŀ� ũ�Ⱑ �ִ�		
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//ũ�⼳��
		pm.setCanvasSize();
		Thread  t = new Thread(pm); // ��Ŭ������ü�� ��ü�� �־���->run�޼ҵ嵵������
		t.start();  //----> �̷��Ը���� ��ü������ ���ָ�ȴ�
				
		//���� ���� : removeTabAt
//		try {Thread.sleep(3000);}catch(Exception e) {} //3���Ŀ�
//		tp.removeTabAt(3); //3��° �ڸ��� �ִ� �� ����
		
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();

	}

}
