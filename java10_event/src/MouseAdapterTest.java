import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MouseAdapterTest extends JFrame {

	int x,y;
	
	MyCanvas mc = new MyCanvas();
	
	public MouseAdapterTest() {
		add(mc);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//상속받지않고 객체만들수있는--마우스 이벤트처리
		//익명의 내부 클래스
		mc.addMouseListener(new MouseAdapter() {//--> 오버라이딩한곳이 없어서 갈곳이 없,MouseAdapter클래스 안에 오버라이딩해둔메소드잇음 -> 재오버라이딩,재정의하여 구현
		
		
			public void mouseReleased(MouseEvent me) {
				
				//getButton() :  왼쪽버튼 :1 , 가운데휠:2 , 오른쪽버튼 :3
				//마우스가 클릭된곳의 좌표를 가져온다 --> 멤버에있는 x,y의 좌표에다가...				
				if(me.getButton()==1){//왼쪽버튼 눌러졌을때만 그림의 좌표 찍을거임
					x=me.getX();
					y=me.getY();
					mc.repaint(); //마이클래스의 업데이트실행됨 -> 그다음에 페엔틈메소드실행됨
				}				
			}		
		});
		
		
		
	}

	
	public class MyCanvas extends Canvas {
		
		public void paint(Graphics g) {			
			Random ran = new Random();
			g.setColor(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)));
			g.fillOval(x-25,y-25,50,50); //마우스가 눌러진곳의 x,y좌표를 받아서 거기에 원을 그린다
										 //x,y는 마우스커서를 눌렀을때 원이 그려지는 위치
		}
		
		public void update(Graphics g) {
			paint(g);
		}		
	}
	
	
	public static void main(String[] args) {		
		new  MouseAdapterTest();
	}

}
