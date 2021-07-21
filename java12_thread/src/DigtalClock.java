import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigtalClock extends JFrame implements Runnable {
	
	Font fnt = new Font("����",Font.BOLD,100);//��Ʈ����	
	Calendar now; // = Calendar.getInstance(); //����ð�
	JPanel pane = new JPanel(new GridLayout(0,3));
		JLabel lb1 = new JLabel("00:00:00",JLabel.CENTER);

		TimeZone time;
		Date date = new Date();

		int x,y;
	public DigtalClock() {
		
		super("�ð�"); //setTitle("�ð�");
		add(BorderLayout.CENTER,pane);
		pane.add(lb1);
	
		lb1.setFont(fnt);
		
		
	}	
	public DigtalClock(int x, int y) {//��ǥ�� �Ű������� �޴´�
		this();						//�����ڸ޼ҵ忡�� �ٸ�������ȣ�� ->this(); 
		this.x = x;
		this.y = y;
		setBounds(x,y,500,200); // �����޼ҵ忡������ �Ű��������޾����� ��ġ��
		setVisible(true);
		
		Thread t = new Thread(this); // ��Ŭ������ü�� ��ü�� �־���->run�޼ҵ嵵������
		t.start();  //----> �̷��Ը���� ��ü������ ���ָ�ȴ�
	}
	
	
	//�ð�����--->ȭ���� �߰��� ȣ���ؾ��Ѵ�-->���ѷ����ϱ�
	public void run() {
		do {
			lb1.setText(getTimer()); 

			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				
			}			
		}while(true);
		
		
	}
	
	//����ð��� (�ú���)�� 00:00:00 �������� ����
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
				
	}

	public static void main(String[] args) {
//		DigtalClock dc1 = new DigtalClock(0,0); 
//		DigtalClock dc2 = new DigtalClock(500,0); //��ǥ���־�� ��ǥ���Ű������ι޴� �����޼ҵ尡 ����Ǿ� ����ȭ���̳���
//		DigtalClock dc3 = new DigtalClock(1000,0);
//		
//		Thread t1 = new Thread(dc1);
//		Thread t2 = new Thread(dc2);
//		Thread t3 = new Thread(dc3);
//		
//		
//		t1.start();
//		t2.start();
//		t3.start();
		
		
		new DigtalClock(0,0);
		new DigtalClock(500,0);
		new DigtalClock(1000,0); // ������ �޼ҵ�ȿ��� ������Ŭ������ü ����������� �����н�Ŭ������ü�� ������ָ�ȴ�
	}
}
