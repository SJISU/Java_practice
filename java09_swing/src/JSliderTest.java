import java.awt.BorderLayout;
import java.sql.SQLClientInfoException;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class JSliderTest extends JFrame {
	JSlider s1 = new JSlider(JSlider.HORIZONTAL,0,100,40); //방향을 가로로
	JSlider s2 = new JSlider(JSlider.VERTICAL,0,100,50); //방향을 가로로
	
		
	public JSliderTest() {
		
		//s1에 옵션설정
		//s1객체에 눈금설정
		s1.setMajorTickSpacing(10);//주눈금표시
		s1.setMinorTickSpacing(2);//보조눈금
		s1.setPaintTicks(true);//눈금보여주기 ->표시만 한다고 나오지않음 화면에 보이게 
		s1.setPaintLabels(true);//라벨표시->눈금숫자나오게
		
		//상중하 표시하고싶음 -> 컬렉션을 만들어서 셋팅....슬라이드바의 위치
		//s2
		//	라벨만들기
		Hashtable<Integer, JLabel> ht = new Hashtable<Integer, JLabel>(); //Integer은 눈금범위
		ht.put(0,new JLabel("상"));
		ht.put(50,new JLabel("중"));
		ht.put(100,new JLabel("하"));
		
		s2.setMajorTickSpacing(50); //주눈금은50단위
		s2.setLabelTable(ht);
		s2.setPaintTicks(true);//눈금보이기
		s2.setPaintLabels(true);//라벨보이기
		
		//자동 눈금선으로 이동하기
		s2.setSnapToTicks(true);
		
		add(BorderLayout.NORTH,s1);
		add(BorderLayout.WEST,s2);
		
		setSize(500,500);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
	
		new JSliderTest();
	}

}
