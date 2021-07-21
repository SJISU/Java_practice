import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame{ //java.awt

	MyCanvas canvas = new MyCanvas();
	
	public GraphicsTest() {
		System.out.println("GraphicsTest");
		add(canvas);
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}	
	
	public class MyCanvas extends Canvas{ //내부클래스
		
		public MyCanvas() {			
			System.out.println("MyCanvas");
		}
		
		public void paint(Graphics g) {
			//직선그리기
			g.drawLine(100,100,500,500); //시작점과 끝점
			//그림을 그리기전에 컬러 설정하고 그림을 그린다.
			g.setColor(Color.RED);
			g.drawLine(100,500,500,100); // 선
			//			x  y   폭w  높이h
			g.drawOval(150,150,300,300); // 원
			
			g.drawRect(150,150,300,300);// 사각형
			
			g.setColor(Color.green);
			
			g.fillOval(300,300,300,300);// 색이채워진 원
			g.fillRect(100,100,150,150);// 색이채워진 사각형
			
			g.setColor(Color.blue);
			
			//다각형 :시계방향이나 반시계방향으로 싸이클
			int [] x = {100,170,250,50}; //x좌표
			int [] y = {50,50,230,200};
			g.drawPolygon(x,y,x.length); //drawPolygon(int[] xPoints, int[] yPoints, int numPoints)
																//   라운드사이즈
			//drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
			g.drawRoundRect(300,300,500,500,50,50);
			
			//문자 그리기 ,drawString(String str, int x, int y): 글자를 그리는 메소드:왼쪽아래끝이좌표
			String txt = "JAVA 프로그래밍";
			g.setColor(Color.magenta);
			g.setFont(new Font("굴림체",Font.BOLD,40));
			g.drawString(txt,100,200);	
			
		}		
	}

	public static void main(String[] args) {
		new GraphicsTest();
	}
}
