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
	
	public class MyCanvas extends Canvas{ //����Ŭ����
		
		public MyCanvas() {			
			System.out.println("MyCanvas");
		}
		
		public void paint(Graphics g) {
			//�����׸���
			g.drawLine(100,100,500,500); //�������� ����
			//�׸��� �׸������� �÷� �����ϰ� �׸��� �׸���.
			g.setColor(Color.RED);
			g.drawLine(100,500,500,100); // ��
			//			x  y   ��w  ����h
			g.drawOval(150,150,300,300); // ��
			
			g.drawRect(150,150,300,300);// �簢��
			
			g.setColor(Color.green);
			
			g.fillOval(300,300,300,300);// ����ä���� ��
			g.fillRect(100,100,150,150);// ����ä���� �簢��
			
			g.setColor(Color.blue);
			
			//�ٰ��� :�ð�����̳� �ݽð�������� ����Ŭ
			int [] x = {100,170,250,50}; //x��ǥ
			int [] y = {50,50,230,200};
			g.drawPolygon(x,y,x.length); //drawPolygon(int[] xPoints, int[] yPoints, int numPoints)
																//   ���������
			//drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
			g.drawRoundRect(300,300,500,500,50,50);
			
			//���� �׸��� ,drawString(String str, int x, int y): ���ڸ� �׸��� �޼ҵ�:���ʾƷ�������ǥ
			String txt = "JAVA ���α׷���";
			g.setColor(Color.magenta);
			g.setFont(new Font("����ü",Font.BOLD,40));
			g.drawString(txt,100,200);	
			
		}		
	}

	public static void main(String[] args) {
		new GraphicsTest();
	}
}
