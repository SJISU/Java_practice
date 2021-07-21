import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageDrawTest extends JFrame implements ActionListener{
	
	JPanel pane =new JPanel();
		JButton btn1 = new JButton("원본이미지");
		JButton btn2 = new JButton("축소이미지");
		JButton btn3 = new JButton("확대이미지");
		JButton btn4 = new JButton("좌우뒤집기");
		JButton btn5 = new JButton("상하뒤집기");
		JButton btn6 = new JButton("일부그리기");
		
	Image img; //이미지객체는 페인트메소드가 있는 클래스내에서 만들어야한다...//내부클래스는 외부클래스의 변수 사용할수있다.
	MyCanvas mc = new MyCanvas(); //내부클래스 객체생성
	
	String selectBtn = "원본이미지";//선택한 버튼의 정보를 저장할 변수
	
	
	public ImageDrawTest() {
		add(BorderLayout.NORTH,pane);
		pane.add(btn1);
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		pane.add(btn6);
		
		add(mc);//프레임센터에 내부클래스인 MyCanvas객채넣는다-> paint메소드실행됨
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		selectBtn = ae.getActionCommand();
		
		//버튼 누르면 내부클래스의 메소드 호출...객체명.메소드로 호출 : mc.paint(그래픽객체)->그래픽은 객체로만들수없는 클래스-> 그래픽메소드를 따로 호출해야한다 
		//페인트메소드는 임의대로 호출할수없는 메소드 이기때문에 repaint(매개변수없는메소드)로 호출....		
		//paint()호출
		mc.repaint(); 
		
	}
	

		public class MyCanvas extends Canvas{ //내부클래스
			public MyCanvas() {
				img = Toolkit.getDefaultToolkit().getImage("img/flower.jpg");
			}	
			
			
			public void paint(Graphics g) {
				//이미지 크기 구하기 : 반드시 paint()메소드내에서 구해야 한다.
				int imgW = img.getWidth(this);
				int imgH = img.getHeight(this);
				
				
				//이미지 그림을 그린다
				if(selectBtn.equals("원본이미지")) {				
					//원본사이즈 drawImage(Image img, int x, int y, ImageObserver observer)
					g.drawImage(img,1,1,this); //원본이미지 : 원래크기그대로
				}else if(selectBtn.equals("축소이미지")) {
					//축소이미지
					g.drawImage(img,1,1,imgW/2,imgH/2,this);
				}else if(selectBtn.equals("확대이미지")) {
					//확대이미지
					g.drawImage(img,1,1,imgW*2,imgH*2,this);
				}else if(selectBtn.equals("좌우뒤집기")) {
					//												캔버스                ,     이미지
					//좌우뒤집기 :drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,Observer)
					//				캔버스크기			이미지
					g.drawImage(img,1,1,imgW,imgH, imgW,1,1,imgH, this); // 
				}else if(selectBtn.equals("상하뒤집기")) {
					//상하뒤집기
					g.drawImage(img,1,1,imgW,imgH, 1,imgH,imgW,1, this);// 
				}else if(selectBtn.equals("일부그리기")) {
					//일부그리기         캔버스의 시작좌표       그림의시작            그림의슽
					g.drawImage(img, 1,1, imgW/2, imgH/2, imgW/5,imgH/5, imgW/3,imgH/3, this);
				}
			}
			
			//repaint() 를 하면 update()로오고 여기에서 g를 가지고 paint()호출
			//repaint() ->paint()호출 : update 메소드가 없을 경우에 : 바로 paint로 가는데 이경우에는 그전그림을 화면에 띄워주는 g를 가져갈수없다 
			public void update(Graphics g) {//update()메소드 → 그전에 그렸던 그림(이미지) 화면에 나옴,안지워짐
				
				paint(g);
			}
		
		} 
	public static void main(String[] args) {
	new ImageDrawTest();
	}

}
