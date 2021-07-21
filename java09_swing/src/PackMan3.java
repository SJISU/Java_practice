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
	
	Dimension dim;	//�����̳�����������
	//ĵ������ x,y:
	int x ,y ;   
	
	//�̹��� ����Ʈ�� ����� ����
	int p=0;
	
	

	public void PackMan2() {
		
		
		setLayout(new BorderLayout());
		
		add(mc); // �����̳� ���Ϳ�	
		
//		setSize(500,500);  -----> ĵ������ũ�Ⱑ���������ʰԵ�
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//ȭ���� ��������� , â�� �߰���....
		//1.ĵ����ũ�⸦ ���Ѵ�.->�����������־���
//		dim = mc.getSize(); //�������̰� �������� //mc.getBounds(); //rectangle �����ش�  --->setSize�������� �ϴ����� ������
//		x = (int)( dim.getWidth()/2-25);//��ü��(dim�� ����)�� ���ݻ������ -25 
//		y = (int)( dim.getHeight()/2-25);
		
		//Ŀ���� ĵ������ �����ϱ�
		mc.setFocusable(true);
		
		//�ݺ��������ϱ�����
		//�̺�Ʈ���
		mc.addKeyListener(this);	
		
		
	}
	
	public void setCanvasSize() {
		dim = mc.getSize(); //�������̰� �������� //mc.getBounds(); //rectangle �����ش�  --->setSize�������� �ϴ����� ������
		x = (int)( dim.getWidth()/2-25);//��ü��(dim�� ����)�� ���ݻ������ -25 
		y = (int)( dim.getHeight()/2-25);
		//System.out.println("w="+dim.getWidth()+"h="+dim.getHeight());
	}
	
	
	public void run() {
		
		//paint�޼ҵ带 �ݺ�ȣ��
				while(true) {
					
					mc.repaint(); //�ϴܱ׸��׸���
					
					//�̹�����ȯ   �������� �̵�  0,1 ,2,3 ,4,5, 6,7 -> ¦���϶��� 1����, Ȧ���϶��� 1����
					if(p%2==0) p++;
					else p--;     //0�̸� �Թ����׸� 1�̸� �Թ����׸�
					
					//��ǥ�̵� 	
					if(p==0 || p==1) { //�������� �̵�  //�������� ������x��ǥ�� �پ���Ѵ�	
						x-=5; //�ݺ��Ҷ����� 5���پ�� �������� ����
						if(x<=-50) //�������λ������
							x=(int) dim.getWidth(); //�ٽ� ������
					}else if(p==2 || p==3) { //x���� : �����������̵�
						x+=5;
						if(x>=(int)dim.getWidth()) x=-50; //���ʿ��� �ٽ� ���´�
					}else if(p==4 || p==5) {//y���� : �����̵�
						y-=5;
					}else if(p==6 || p==7) {//y����: �Ʒ����̵�
						y+=5;
					}
					
					try {Thread.sleep(3000);}catch(Exception e) {}
		
				}
		
		
	}
		
		//����Ŭ����
		class MyCanvas extends Canvas{			
			Image PackMan;			
			MyCanvas() { //�����ڸ޼ҵ�			
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

		
	// ������ 0 �������� 2 ������4 �Ʒ�����6
	//keyEvent �������̵�
	public void keyPressed(KeyEvent ke) {}	
	public void  keyReleased(KeyEvent ke) {
		
		int code = ke.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) { //����Ű ���� ������
			p=0; //0,1 �� �ݺ��ϰ�
		}else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) { //����Ű ������ ������
			p=2; //2,3�ݺ�
		}else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) { // ����Ű ����
			p=4; //4,5�ݺ�
		}else if(code == KeyEvent.VK_DOWN ||code == KeyEvent.VK_S ){ //����Ű �Ʒ���
			p=6; //6,7�ݺ�		
		}		
	}	
	public void keyTyped(KeyEvent ke) {}
	
	
	
}
