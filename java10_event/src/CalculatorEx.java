import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorEx extends JFrame implements ActionListener{
	Font fnt = new Font("����ü",Font.BOLD,25);
	JTextField tf = new JTextField("0.0");
	
	JPanel allBtnPane = new JPanel(new BorderLayout());
		JPanel northPane = new JPanel(new GridLayout(1,3));
		JPanel centerPane = new JPanel(new GridLayout(4,4));
	
	//��ư ��� LIST
	String btnStr[] = {"BackSpace", "Clear", "End", 
						"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0",".","=","/"};
	//////////////////////////////////////////////////////
	double result; //0.0    //�������� :����� ���⿡ �ߴ� �����
	String operator;//null  //����
	
	public CalculatorEx() {
		
		setTitle("����");
		add(BorderLayout.NORTH,tf); //0.0�� �ߴ°� ���⿡ ��Ÿ��
		tf.setHorizontalAlignment(JTextField.RIGHT); //�ؽ�Ʈ�ڽ��� ������ ������ ����: ���� ����������
		tf.setFont(fnt);
		
		add(allBtnPane);
		allBtnPane.add(BorderLayout.NORTH,northPane);
		allBtnPane.add(BorderLayout.CENTER,centerPane);
		////////////////////////////////////////////////////////////////
		//��ư�� JPanel�� �߰�
		for(int i=0; i<btnStr.length; i++) {
			JButton btn = new JButton(btnStr[i]);
			btn.setFont(fnt);
			btn.setBackground(Color.GRAY);
			
			if(i<=2) {
				northPane.add(btn);
			}else {
				centerPane.add(btn);
			}	
			//��ư������� ������ư�� �������,�ݺ����ö󰡱���
			//**��ư���� �̺�Ʈ ���
			btn.addActionListener(this); //����ư��
		}		
		
		setSize(500,350);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	//�������̵�
	public void actionPerformed(ActionEvent ae) {
		
		JButton event= (JButton)ae.getSource(); //��ݴ�������ư�� ���⿡ �������
		String btnLb1 = event.getText(); //����� �ִ°� ������?
		
		switch(event.getText()) {
		
		case "End" :  //���α׷�����
			System.exit(0);
			break;
		
		case "0" : case "1": case "2": case "3": case "4": 
		case "5" : case "6": case "7": case "8": case "9":
			//break�� �ȸ����⶧���� 0 �� ����� ..1�������...
			inNumber(btnLb1); //���ڰ� ��������inNumber�� �´�..
			break;
		
		case "BackSpace":
			setBackSpace(); //�����Է��� ��Ʈ�� ����¸޼ҵ�
			break;
		
		case ".":
			setPoint();
			break;
			
		case "+":  case "-": case "*": case "/":
			setResultOperator(btnLb1); //btnLb1 : ��ݴ���������
			break;
		
		case "=":
			setResult();
			break;
		
		case "Clear" :
			setClear();
		}		
	}
	
	//���ڹ�ư ���õǾ�����
	public void inNumber(String btnLb1) { //��ݴ�������
		
		String tfTxt = tf.getText(); //0.0
		
		if(tfTxt.equals("0.0")) {//�ʱⰪ 0.0 �϶��� ����̺�Ʈ�� �߻��� ��ư�� ���� ����
			tf.setText(btnLb1); // 0.0�������� ���� ���ڸ� �־��ش�...			
		}else { //0.0�� �ƴϰ� ������ �������ڰ� ��������
			tf.setText(tfTxt+btnLb1); // 3 ���������� 4 ������ --> 34
		}		
	}
	
	//�齺���̽� ��ư ���õǾ�����
	public void setBackSpace() {
		//���ڿ��� ������ ������ �޾Ƽ� subString �̿��Ͽ� �����Էµ� ��Ʈ�� �����
		String str = tf.getText();
		int len = str.length();
		String cutStr = str.substring(0,len-1);
		tf.setText(cutStr);
				
	}
	
	//�Ҽ��� ��ư�� ���õǾ�����
	public void setPoint() { //�Ҽ����̾����� ���̰� ������ ������?
		//indexOf() -> ������ ����ִ��� index�����ְ� ������ -1
		String str = tf.getText();
		int idx = str.indexOf("."); // . �� ������ index��ġ�� ���ϰ�... ������ -1�� �����Ѵ�
		
		if(idx==-1) {
			tf.setText(str+"."); //.�� �Է������� .�̾����� �ڿ� . ���ٿ��ش�
		}				
	}
	
	//+,-,*,/ �����ڸ� ���� �Ͽ����� 
	public void setResultOperator(String btnLb1) { //������ ���������� ������ ���ں��� , �����ڴ����� �����ڵ� ����,�״��� �ԷµȰ��� ��� �׸��� ������� ��´�
													// ���� �������Ÿ� �����ϴ°��� ���Ȱ���� ���� �״����� ���������ڸ� �����ں����ϴ°��� �ִ´�
		double second = Double.parseDouble(tf.getText()); //�����ڸ� �������� �������� ���Ǵ�����???????
		
		if(operator==null) { //ó������ ������ ���������� //������ �����ڰ� ���ȴ��� Ȯ���ϴ� ��
			result =second;//tf�� ���� ����	
			
		}else {
			//�̹� �����ڰ� ������ �������� tf�� ���� ����Ͽ� result�� ����
			calcu(second);
		}
		//��ݴ����� �����ڵ� ����
		operator = btnLb1;//��ݴ����� �����ڵ����� //ó���̾ ����.......
		tf.setText(" ");//tf�� ���� �ʱ�ȭ �Ѵ� //�����ڴ����� �����ִ����ڴ� ������� ���ο���� �Է��Ҽ��ְ�...
	}
	
	
	public void calcu(double second) {
		switch(operator) {
		case "+" : result +=second; break;
		case "-" : result = result-second; break;
		case "*" : result = result*second; break;
		case "/" : result = result/second; 				
	}			
		
		
	}
	
	// = ������ ���õǸ� result ,operator ,tf�� ���� ����Ѵ�
	public void setResult() {
		//  result ó���Էµ� �����ҵ�����???
		double num2 = Double.parseDouble(tf.getText());
		calcu(num2);			
		//��Ʈ������ ���� �ϱ⶧���� ������ ��Ʈ������ �ٲ۴�....
		tf.setText(String.valueOf(result)); //����� tf�� �����ֱ�
		operator = null;//���������...�����ȿ����� �����....
			
	
	}
	
	public void setClear() {
		result = 0.0;
		operator = null;
		tf.setText("0.0");
		
	}
	
	
	
	public static void main(String[] args) {
	new CalculatorEx();

	}

}
