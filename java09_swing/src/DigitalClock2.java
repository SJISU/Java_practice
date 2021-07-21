import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JButton;

import javax.swing.JLabel; //�⺻���̾ƿ� : flowLayout
import javax.swing.JPanel;

public class DigitalClock2 extends JPanel implements Runnable { //�����̳ʰ� �������̸� �ٸ������̳ʿ��߰����ϹǷ� �гηκ���
	
	Font fnt = new Font("����",Font.BOLD,100);//��Ʈ����	
	Calendar now; // = Calendar.getInstance(); //����ð�
	//JPanel pane = new JPanel(new GridLayout(0,3));
		JLabel lb1 = new JLabel("00:00:00",JLabel.CENTER);

//		TimeZone time;
//		Date date = new Date();

		int x,y;
	public DigitalClock2() {
		
		setLayout(new BorderLayout()); //�����̳ʰ� �޶����鼭 ���̾ƿ��� �޶����� �ٽ� ��������
		//super("�ð�"); //setTitle("�ð�"); ->�гο����� �ʿ�x
		//add(BorderLayout.CENTER,pane);
		add(lb1);
	
		lb1.setFont(fnt);
		
		
	}	
	public DigitalClock2(int x, int y) {//��ǥ�� �Ű������� �޴´�
		this();						//�����ڸ޼ҵ忡�� �ٸ�������ȣ�� ->this(); 
		this.x = x;
		this.y = y;
		//setBounds(x,y,500,200); // �����޼ҵ忡������ �Ű��������޾����� ��ġ�� ->�гο����� �ʿ�x : �г�������ִ°Ϳ� ��������� ����
		//setVisible(true);
		
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
}
