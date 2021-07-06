import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JComboBoxTest extends JFrame implements ItemListener{

	JPanel pane = new JPanel();
	JComboBox<String> cb1 = new JComboBox<String>();
	JComboBox<String> cb2,cb3,cb4;
	
	JLabel lb1 =new JLabel("선택값 표시되는 곳",JLabel.CENTER);
	Color clr[] = {Color.red,Color.blue,Color.green, Color.white,Color.black};
	
	public JComboBoxTest() {
		
		add(BorderLayout.NORTH,pane); //제이패널컨테이너위치설정
		pane.add(cb1);	//// 제이페널컨테이너에 넣음
		
		lb1.setOpaque(true);//투명처리해제
		add(lb1); //라벨센터에표시
		
		//목록추가
		cb1.addItem("자바");
		cb1.addItem("스프링");
		cb1.addItem("jsp");
		
		//배열의 데이터를 목록만들기
		String comboList[] = {"RED", "BLUE", "GREEN", "WHITE","BLACK"};
		cb2=new JComboBox(comboList); //만든배열을 넣어줌
		pane.add(cb2); // 제이페널컨테이너에 넣음
		
		//컬렉션(vector)을 이용한 목록만들기
		Vector<String> v = new Vector<String>();
		v.add("AAAAA");
		v.add("BBBBB");
		v.add("CCCCC");		
		cb3 = new JComboBox(v); //만든 백터v를 cb3에 넣음
		pane.add(cb3);
		
		//모델을 이용한 목록만들기
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("장미");
		model.addElement("국화");
		model.addElement("튤립");		
		cb4 = new JComboBox<String>(model);
		pane.add(cb4); 			
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
				
		//이벤트등록
		//ComboBox 에서 어떤이벤트가발생하는지 메소드 --->>ItemListener상속 ---> add~~~Listerner
		cb2.addItemListener(this); //여기에있는메소드쓸려고 상속받았으니간 this사용하여 이클래스 쓸수있게
		cb4.addItemListener(this); 
		
	}
	
	//오버라이딩 : 상속받은 상위클래스의 메소드 오버라이딩
	public void itemStateChanged(ItemEvent ie) { //오버라이딩
		
		JComboBox event =(JComboBox)ie.getSource();
		
		//선택하면 이벤트가 발생하여 백그라운드 색변경 -> 컬러설정할때는 컬러객체필요 ->배열에 컬러객체넣어서
		//산택하면 이벤트가발생하여 선택한글자가 나오게->제이라벨이용해서 멤버변수에서 우선선언한뒤 바뀔것
		if(event.equals(cb2)) {
			//제이콤보박스 메소드 ->getSelectedIcon,getSelectedIndex 
			//선택목록의 index가져오기
			int idx =cb2.getSelectedIndex(); 
			lb1.setBackground(clr [idx]); //배열에 컬러객체넣어서
			//투명처리해제
			
		}else if(event.equals(cb4)) {
			lb1.setText((String)cb4.getSelectedItem());
		}
		
		
		
		
	}

	public static void main(String[] args) {
		new JComboBoxTest();
	}

}
