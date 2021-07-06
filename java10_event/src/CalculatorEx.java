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
	Font fnt = new Font("굴림체",Font.BOLD,25);
	JTextField tf = new JTextField("0.0");
	
	JPanel allBtnPane = new JPanel(new BorderLayout());
		JPanel northPane = new JPanel(new GridLayout(1,3));
		JPanel centerPane = new JPanel(new GridLayout(4,4));
	
	//버튼 목록 LIST
	String btnStr[] = {"BackSpace", "Clear", "End", 
						"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0",".","=","/"};
	//////////////////////////////////////////////////////
	double result; //0.0    //연산결과값 :계산후 계산기에 뜨는 결과값
	String operator;//null  //보관
	
	public CalculatorEx() {
		
		setTitle("계산기");
		add(BorderLayout.NORTH,tf); //0.0이 뜨는걸 계산기에 나타냄
		tf.setHorizontalAlignment(JTextField.RIGHT); //텍스트박스의 내용을 오른쪽 정렬: 글자 오른쪽으로
		tf.setFont(fnt);
		
		add(allBtnPane);
		allBtnPane.add(BorderLayout.NORTH,northPane);
		allBtnPane.add(BorderLayout.CENTER,centerPane);
		////////////////////////////////////////////////////////////////
		//버튼을 JPanel에 추가
		for(int i=0; i<btnStr.length; i++) {
			JButton btn = new JButton(btnStr[i]);
			btn.setFont(fnt);
			btn.setBackground(Color.GRAY);
			
			if(i<=2) {
				northPane.add(btn);
			}else {
				centerPane.add(btn);
			}	
			//버튼을만들고 다음버튼이 만들기전,반복문올라가기전
			//**버튼들을 이벤트 등록
			btn.addActionListener(this); //모든버튼들
		}		
		
		setSize(500,350);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	//오버라이딩
	public void actionPerformed(ActionEvent ae) {
		
		JButton event= (JButton)ae.getSource(); //방금눌러진버튼은 여기에 담겨있음
		String btnLb1 = event.getText(); //담겨져 있는걸 꺼낸다?
		
		switch(event.getText()) {
		
		case "End" :  //프로그램종료
			System.exit(0);
			break;
		
		case "0" : case "1": case "2": case "3": case "4": 
		case "5" : case "6": case "7": case "8": case "9":
			//break를 안만났기때문에 0 도 여기로 ..1도여기로...
			inNumber(btnLb1); //숫자가 눌러지면inNumber로 온다..
			break;
		
		case "BackSpace":
			setBackSpace(); //끝에입력한 스트링 지우는메소드
			break;
		
		case ".":
			setPoint();
			break;
			
		case "+":  case "-": case "*": case "/":
			setResultOperator(btnLb1); //btnLb1 : 방금누른연산자
			break;
		
		case "=":
			setResult();
			break;
		
		case "Clear" :
			setClear();
		}		
	}
	
	//숫자버튼 선택되었을때
	public void inNumber(String btnLb1) { //방금눌러진값
		
		String tfTxt = tf.getText(); //0.0
		
		if(tfTxt.equals("0.0")) {//초기값 0.0 일때는 방금이벤트가 발생한 버튼의 값을 셋팅
			tf.setText(btnLb1); // 0.0지워지고 눌린 숫자를 넣어준다...			
		}else { //0.0이 아니고 그전에 누른숫자가 있을때는
			tf.setText(tfTxt+btnLb1); // 3 먼저누르고 4 누르면 --> 34
		}		
	}
	
	//백스페이스 버튼 선택되엇을때
	public void setBackSpace() {
		//문자열의 길이의 영향을 받아서 subString 이용하여 뒤의입력된 스트링 지운다
		String str = tf.getText();
		int len = str.length();
		String cutStr = str.substring(0,len-1);
		tf.setText(cutStr);
				
	}
	
	//소수점 버튼이 선택되었을때
	public void setPoint() { //소수점이없으면 붙이고 있으면 버린다?
		//indexOf() -> 있으면 어디에있는지 index구해주고 없으면 -1
		String str = tf.getText();
		int idx = str.indexOf("."); // . 가 있으면 index위치를 구하고... 없으면 -1을 리턴한다
		
		if(idx==-1) {
			tf.setText(str+"."); //.을 입력했을때 .이없으면 뒤에 . 을붙여준다
		}				
	}
	
	//+,-,*,/ 연산자를 선택 하였을때 
	public void setResultOperator(String btnLb1) { //연산자 누르기전에 눌럿던 숫자보관 , 연산자누르면 연산자도 보관,그다음 입력된값을 계산 그리고 계산결과를 담는다
													// 전에 눌럿던거를 보관하는곳에 계산된결과가 담기고 그다음에 눌린연산자르 연산자보관하는곳에 넣는다
		double second = Double.parseDouble(tf.getText()); //연산자를 눌렀을때 그전까지 눌렷던숫자???????
		
		if(operator==null) { //처음으로 연산자 선택했을때 //그전에 연산자가 눌렸는지 확인하는 것
			result =second;//tf의 값을 보관	
			
		}else {
			//이미 연산자가 잇으면 보관값과 tf의 값을 계산하여 result에 보관
			calcu(second);
		}
		//방금눌러진 연산자도 보관
		operator = btnLb1;//방금눌러진 연산자도보관 //처음이어도 보관.......
		tf.setText(" ");//tf의 값을 초기화 한다 //연산자누르면 원래있던숫자는 사라지고 새로운숫자 입력할수있게...
	}
	
	
	public void calcu(double second) {
		switch(operator) {
		case "+" : result +=second; break;
		case "-" : result = result-second; break;
		case "*" : result = result*second; break;
		case "/" : result = result/second; 				
	}			
		
		
	}
	
	// = 연산자 선택되면 result ,operator ,tf의 값을 계산한다
	public void setResult() {
		//  result 처음입력된 연산할데이터???
		double num2 = Double.parseDouble(tf.getText());
		calcu(num2);			
		//스트링으로 찍어야 하기때문에 더불을 스트링으로 바꾼다....
		tf.setText(String.valueOf(result)); //결과를 tf에 보여주기
		operator = null;//계산결과셋팅...보관된연산자 지우기....
			
	
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
