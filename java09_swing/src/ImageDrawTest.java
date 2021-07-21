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
		JButton btn1 = new JButton("�����̹���");
		JButton btn2 = new JButton("����̹���");
		JButton btn3 = new JButton("Ȯ���̹���");
		JButton btn4 = new JButton("�¿������");
		JButton btn5 = new JButton("���ϵ�����");
		JButton btn6 = new JButton("�Ϻα׸���");
		
	Image img; //�̹�����ü�� ����Ʈ�޼ҵ尡 �ִ� Ŭ���������� �������Ѵ�...//����Ŭ������ �ܺ�Ŭ������ ���� ����Ҽ��ִ�.
	MyCanvas mc = new MyCanvas(); //����Ŭ���� ��ü����
	
	String selectBtn = "�����̹���";//������ ��ư�� ������ ������ ����
	
	
	public ImageDrawTest() {
		add(BorderLayout.NORTH,pane);
		pane.add(btn1);
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		pane.add(btn6);
		
		add(mc);//�����Ӽ��Ϳ� ����Ŭ������ MyCanvas��ä�ִ´�-> paint�޼ҵ�����
		
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
		
		//��ư ������ ����Ŭ������ �޼ҵ� ȣ��...��ü��.�޼ҵ�� ȣ�� : mc.paint(�׷��Ȱ�ü)->�׷����� ��ü�θ�������� Ŭ����-> �׷��ȸ޼ҵ带 ���� ȣ���ؾ��Ѵ� 
		//����Ʈ�޼ҵ�� ���Ǵ�� ȣ���Ҽ����� �޼ҵ� �̱⶧���� repaint(�Ű��������¸޼ҵ�)�� ȣ��....		
		//paint()ȣ��
		mc.repaint(); 
		
	}
	

		public class MyCanvas extends Canvas{ //����Ŭ����
			public MyCanvas() {
				img = Toolkit.getDefaultToolkit().getImage("img/flower.jpg");
			}	
			
			
			public void paint(Graphics g) {
				//�̹��� ũ�� ���ϱ� : �ݵ�� paint()�޼ҵ峻���� ���ؾ� �Ѵ�.
				int imgW = img.getWidth(this);
				int imgH = img.getHeight(this);
				
				
				//�̹��� �׸��� �׸���
				if(selectBtn.equals("�����̹���")) {				
					//���������� drawImage(Image img, int x, int y, ImageObserver observer)
					g.drawImage(img,1,1,this); //�����̹��� : ����ũ��״��
				}else if(selectBtn.equals("����̹���")) {
					//����̹���
					g.drawImage(img,1,1,imgW/2,imgH/2,this);
				}else if(selectBtn.equals("Ȯ���̹���")) {
					//Ȯ���̹���
					g.drawImage(img,1,1,imgW*2,imgH*2,this);
				}else if(selectBtn.equals("�¿������")) {
					//												ĵ����                ,     �̹���
					//�¿������ :drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,Observer)
					//				ĵ����ũ��			�̹���
					g.drawImage(img,1,1,imgW,imgH, imgW,1,1,imgH, this); // 
				}else if(selectBtn.equals("���ϵ�����")) {
					//���ϵ�����
					g.drawImage(img,1,1,imgW,imgH, 1,imgH,imgW,1, this);// 
				}else if(selectBtn.equals("�Ϻα׸���")) {
					//�Ϻα׸���         ĵ������ ������ǥ       �׸��ǽ���            �׸��ǚ�
					g.drawImage(img, 1,1, imgW/2, imgH/2, imgW/5,imgH/5, imgW/3,imgH/3, this);
				}
			}
			
			//repaint() �� �ϸ� update()�ο��� ���⿡�� g�� ������ paint()ȣ��
			//repaint() ->paint()ȣ�� : update �޼ҵ尡 ���� ��쿡 : �ٷ� paint�� ���µ� �̰�쿡�� �����׸��� ȭ�鿡 ����ִ� g�� ������������ 
			public void update(Graphics g) {//update()�޼ҵ� �� ������ �׷ȴ� �׸�(�̹���) ȭ�鿡 ����,��������
				
				paint(g);
			}
		
		} 
	public static void main(String[] args) {
	new ImageDrawTest();
	}

}
