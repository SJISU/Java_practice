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
		
		
		//��ӹ����ʰ� ��ü������ִ�--���콺 �̺�Ʈó��
		//�͸��� ���� Ŭ����
		mc.addMouseListener(new MouseAdapter() {//--> �������̵��Ѱ��� ��� ������ ��,MouseAdapterŬ���� �ȿ� �������̵��صи޼ҵ����� -> ��������̵�,�������Ͽ� ����
		
		
			public void mouseReleased(MouseEvent me) {
				
				//getButton() :  ���ʹ�ư :1 , �����:2 , �����ʹ�ư :3
				//���콺�� Ŭ���Ȱ��� ��ǥ�� �����´� --> ������ִ� x,y�� ��ǥ���ٰ�...				
				if(me.getButton()==1){//���ʹ�ư ������������ �׸��� ��ǥ ��������
					x=me.getX();
					y=me.getY();
					mc.repaint(); //����Ŭ������ ������Ʈ����� -> �״����� �俣ƴ�޼ҵ�����
				}				
			}		
		});
		
		
		
	}

	
	public class MyCanvas extends Canvas {
		
		public void paint(Graphics g) {			
			Random ran = new Random();
			g.setColor(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)));
			g.fillOval(x-25,y-25,50,50); //���콺�� ���������� x,y��ǥ�� �޾Ƽ� �ű⿡ ���� �׸���
										 //x,y�� ���콺Ŀ���� �������� ���� �׷����� ��ġ
		}
		
		public void update(Graphics g) {
			paint(g);
		}		
	}
	
	
	public static void main(String[] args) {		
		new  MouseAdapterTest();
	}

}
