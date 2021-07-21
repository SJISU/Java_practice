import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class JSplitPaneEx2 extends JFrame{
	
	JSplitPane spHori, spClockCalendar,spCalcu,spPack ;	
	
	DigitalClock2 dc = new DigitalClock2(0,0);
	SwingCalendar2 sc = new SwingCalendar2();
	CalculatorEx2 cal = new CalculatorEx2();
	PackMan2 pm = new PackMan2();
			
	ImageIcon ii = new ImageIcon("img/packman.jpg");
	JLabel lb1 = new JLabel(ii);
	public JSplitPaneEx2() {
		
		//����
		//�ð�,�޷�
		spClockCalendar = new JSplitPane(JSplitPane.VERTICAL_SPLIT,dc,sc);
		spCalcu= new JSplitPane(JSplitPane.VERTICAL_SPLIT,spClockCalendar,cal);
		
		//������
		spPack = new JSplitPane(JSplitPane.VERTICAL_SPLIT,lb1,pm);
		
		
		//
		spHori = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,spCalcu,spPack);
		
		add(spHori);
		
		
		setSize(1200,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false); // Jframe�ȿ��ִ¸޼ҵ� //true:âũ����������,false:âũ�� ����
		
		
		
		pm.packmanStart(pm);
	}

	public static void main(String[] args) {
		new JSplitPaneEx2();

	}

}
