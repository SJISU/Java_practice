import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Test extends JFrame implements ActionListener{
	
	double num1, num2;	
	JLabel label;
	
	public Test() {	
		
		double a = 0.0;
		JLabel lb1 = new JLabel(String.valueOf(a)); //라벨안에 들어갈 실수......
		lb1.setHorizontalAlignment(SwingConstants.RIGHT); //스트링 오른쪽정렬
		add(BorderLayout.NORTH,lb1); //컨테이너안에 추가
		

		JPanel pane = new JPanel(); //큰제이패널
		pane.setLayout(new BorderLayout());
		add(pane);

		JPanel pane1 = new JPanel(new GridLayout(1,3)); //작은제이패널1
		JButton btn1 = new JButton("BackSpace"); 
		JButton btn2 = new JButton("Clear");
		JButton btn3 = new JButton("End"); 		
		pane1.add(btn1);		
		pane1.add(btn2);		
		pane1.add(btn3);		
		pane.add(BorderLayout.NORTH,pane1);
		
		//작은패널2
		JPanel pane2 = new JPanel(new GridLayout(4,4));		
		JButton jbtn[] = new JButton[16];
		
		jbtn[0] = new JButton("7");		
		jbtn[1] = new JButton("8");		
		jbtn[2] = new JButton("9");		
		jbtn[3] = new JButton("+");		
		jbtn[4] = new JButton("4");		
		jbtn[5] = new JButton("5");		
		jbtn[6] = new JButton("6");		
		jbtn[7] = new JButton("-");		
		jbtn[8] = new JButton("1");		
		jbtn[9] = new JButton("2");		
		jbtn[10] = new JButton("3");		
		jbtn[11] = new JButton("*");		
		jbtn[12] = new JButton("0");		
		jbtn[13] = new JButton(".");		
		jbtn[14] = new JButton("=");		
		jbtn[15] = new JButton("/");
		
		for(int i=0; i<16; i++ ) {
			jbtn[i].setBackground(Color.GRAY);
			pane2.add(jbtn[i]);			
		}			
		pane.add(BorderLayout.CENTER,pane2);

		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent ae) {
		
		String event =ae.getActionCommand();
		
//		if(event.equals("+")) {
//			label.setText(String.valueOf(plus(num1,num2)));
//		}else if(event.equals("-")) {
//			label.setText(String.valueOf(minus(num1,num2)));
//		}else if(event.equals("*")) {
//			label.setText(String.valueOf(mul(num1,num2)));
//		}else if(event.equals("/")) {
//			label.setText(String.valueOf(div(num1,num2)));
//		}
		
	}
	
	public double plus(double num1 , double num2) {		
		return num1+num2;		
	}
	
	public double minus(double num1 , double num2) {
		return num1-num2;
	}
	
	public double mul(double num1 , double num2) {		
		return num1*num2;		
	}
	
	public double div(double num1 , double num2) {		
		return num1/num2;		
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
