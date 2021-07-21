import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class JSplitPaneEx extends JFrame{

	JSplitPane sp1,sp2,sp3,sp4;
	DigitalClock2 dc = new DigitalClock2();
	SwingCalendar2 sc = new SwingCalendar2();
	CalculatorEx2 calcu = new CalculatorEx2();
	PackMan2 pm = new PackMan2();
	
	ImageIcon icon = new ImageIcon("img/hahaha.jpg");
	//Image icon =Toolkit.getDefaultToolkit().getImage("img/haha.jpg");	
	JButton btn1 = new JButton(icon);
	
	public JSplitPaneEx() {
	
		//수직나누기
		sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp2,calcu);
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,dc,sc);		
		sp3= new JSplitPane(JSplitPane.VERTICAL_SPLIT,pm,btn1);
		
		sp4= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp1,sp3);
		
		add(sp4);
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//팩맨
		pm.setCanvasSize();
		Thread  t = new Thread(pm); 
		t.start();
	}

	public static void main(String[] args) {
		new JSplitPaneEx();

	}

}
