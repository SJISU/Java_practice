import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test4 extends JFrame {

	JPanel pane =new JPanel();
	Image img;
	MyCanvas mc = new MyCanvas();
	
	public test4() {
		
		add(pane);
		
		add(mc);
		
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public class MyCanvas extends Canvas{
		
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
			
		}
		public void paint(Graphics g) {
			
			int imgW = img.getWidth(this); //400 //노랑동그라미8개 // 1개에 50
			int imgH = img.getHeight(this); //50 
			
			//g.drawImage(img,1,1,this);
			//g.drawImage(img,100,100,imgW+50,imgH+50,imgW/5,imgH/5,imgW/2,imgH/2,this);
			
			
			//일부그리기
			//    컨버스의 좌표 왼쪽시작점,오른쪽끝점  그림의좌표 왼쪽의시작점,오른쪽끝점
			int a =0; int b=50; int c=0;			
			for(int i=0; i<8; i++){
				g.drawImage(img, a,c, b, b, a,c, b,b, this);
				a+=50; b+=50;
			}
//			g.drawImage(img, 0,0, 50, 50, 0,0, 50,50, this);
//			g.drawImage(img, 50,0, 100, 100, 50,0, 100,100, this); 
//			g.drawImage(img, 100,0, 150, 150, 100,0, 150,150, this); 
//			
//			g.drawImage(img, 150,0, 200, 200, 150,0, 200,200, this); 
//			g.drawImage(img, 200,0, 250, 250, 200,0, 250,250, this); 
//			g.drawImage(img, 250,0, 300, 300, 250,0, 300,300, this); 
//			g.drawImage(img, 300,0, 350, 350, 300,0, 350,350, this); 
//			g.drawImage(img, 350,0, 400, 400, 350,0, 400,400, this); 
//			g.drawImage(img, 400,0, 450, 450, 400,0, 450,450, this); 	
				
			
		}
		
		
		
	}
	
public static void main(String[] args) {
		
		new test4();
	}


}
