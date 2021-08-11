import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigtalClock extends JFrame  {
	
	Font fnt = new Font("����",Font.BOLD,100);//��Ʈ����	
	Calendar now; // = Calendar.getInstance(); //����ð�
	JLabel lb1 = new JLabel("00:00:00",JLabel.CENTER);
	public DigtalClock() {
		
		super("�ð�"); //setTitle("�ð�");
		add(lb1);
		lb1.setFont(fnt);

		setSize(500,200);		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
	
		startClock();
	
	}	
	//�ð�����--->ȭ���� �߰����� ȣ���ؾ��Ѵ�-->���ѷ����ϱ�
	public void startClock() {
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
		new DigtalClock();		
	}
}