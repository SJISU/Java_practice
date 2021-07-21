import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PackMan3 extends JPanel implements KeyListener, Runnable {

	MyCanvas mc = new MyCanvas();
	
	Dimension dim;	//컨테이너의폭과높이
	//캔버스의 x,y:
	int x ,y ;   
	
	//이미지 포인트로 사용할 변수
	int p=0;
	
	

	public void PackMan2() {
		
		
		setLayout(new BorderLayout());
		
		add(mc); // 컨테이너 센터에	
		
//		setSize(500,500);  -----> 캔버스의크기가정해지지않게됨
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//화면이 띄워지고나면 , 창이 뜨고나서....
		//1.캔버스크기를 구한다.->전역변수에넣어논다
//		dim = mc.getSize(); //폭과높이가 구해진다 //mc.getBounds(); //rectangle 구해준다  --->setSize없어져서 하는일이 없어진
//		x = (int)( dim.getWidth()/2-25);//전체폭(dim에 있음)의 절반사이즈에서 -25 
//		y = (int)( dim.getHeight()/2-25);
		
		//커서를 캔버스에 설정하기
		mc.setFocusable(true);
		
		//반복문실행하기전에
		//이벤트등록
		mc.addKeyListener(this);	
		
		
	}
	
	public void setCanvasSize() {
		dim = mc.getSize(); //폭과높이가 구해진다 //mc.getBounds(); //rectangle 구해준다  --->setSize없어져서 하는일이 없어진
		x = (int)( dim.getWidth()/2-25);//전체폭(dim에 있음)의 절반사이즈에서 -25 
		y = (int)( dim.getHeight()/2-25);
		//System.out.println("w="+dim.getWidth()+"h="+dim.getHeight());
	}
	
	
	public void run() {
		
		//paint메소드를 반복호출
				while(true) {
					
					mc.repaint(); //일단그림그린다
					
					//이미지변환   왼쪽으로 이동  0,1 ,2,3 ,4,5, 6,7 -> 짝수일때는 1증가, 홀수일때는 1감소
					if(p%2==0) p++;
					else p--;     //0이면 입벌린그림 1이면 입벌린그림
					
					//좌표이동 	
					if(p==0 || p==1) { //왼쪽으로 이동  //왼쪽으로 갈때는x좌표가 줄어야한다	
						x-=5; //반복할때마다 5씩줄어들어서 왼쪽으로 간다
						if(x<=-50) //왼쪽으로사라지면
							x=(int) dim.getWidth(); //다시 나오게
					}else if(p==2 || p==3) { //x증가 : 오른족으로이동
						x+=5;
						if(x>=(int)dim.getWidth()) x=-50; //왼쪽에서 다시 나온다
					}else if(p==4 || p==5) {//y감소 : 위로이동
						y-=5;
					}else if(p==6 || p==7) {//y증가: 아래로이동
						y+=5;
					}
					
					try {Thread.sleep(3000);}catch(Exception e) {}
		
				}
		
		
	}
		
		//내부클래스
		class MyCanvas extends Canvas{			
			Image PackMan;			
			MyCanvas() { //생성자메소드			
				PackMan = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
			}					
			public void paint(Graphics g) {	
				
				
				//                  canvas              img			
				//                                   p=0  0    0    50   50
				//									 p=1  50   0   100   50  
				//									 p=2  100, 0   150   50
				//									 p=3  150, 0   200   50
				g.drawImage(PackMan, x, y, x+50, y+50,  p*50, 0, p*50+50,50, this);		
			}	
			
			
			
		}

		
	// 왼쪽은 0 오른쪽은 2 위쪽은4 아래쪽은6
	//keyEvent 오버라이딩
	public void keyPressed(KeyEvent ke) {}	
	public void  keyReleased(KeyEvent ke) {
		
		int code = ke.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) { //방향키 왼쪽 누르면
			p=0; //0,1 로 반복하게
		}else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) { //방향키 오른쪽 누르면
			p=2; //2,3반복
		}else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) { // 방향키 위쪽
			p=4; //4,5반복
		}else if(code == KeyEvent.VK_DOWN ||code == KeyEvent.VK_S ){ //방향키 아래쪽
			p=6; //6,7반복		
		}		
	}	
	public void keyTyped(KeyEvent ke) {}
	
	
	
}
