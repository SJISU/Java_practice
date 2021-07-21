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
	
	Font fnt = new Font("굴림",Font.BOLD,100);//폰트설정	
	Calendar now; // = Calendar.getInstance(); //현재시간
	JPanel pane = new JPanel(new GridLayout(0,3));
		JLabel lb1 = new JLabel("00:00:00",JLabel.CENTER);

		TimeZone time;
		Date date = new Date();

		int x,y;
	public DigtalClock() {
		
		super("시계"); //setTitle("시계");
		add(BorderLayout.CENTER,pane);
		pane.add(lb1);
	
		lb1.setFont(fnt);
		
		
	}	
	public DigtalClock(int x, int y) {//좌표를 매개변수로 받는다
		this();						//생성자메소드에서 다른생성자호출 ->this(); 
		this.x = x;
		this.y = y;
		setBounds(x,y,500,200); // 생성메소드에있으면 매개변수를받았을때 위치가
		setVisible(true);
		
		Thread t = new Thread(this); // 이클래스전체를 객체로 넣어줌->run메소드도들어가있음
		t.start();  //----> 이렇게만들면 객체생성만 해주면된다
	}
	
	
	//시간변경--->화면이 뜨고나서 호출해야한다-->무한루프니깐
	public void run() {
		do {
			lb1.setText(getTimer()); 

			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				
			}			
		}while(true);
		
		
	}
	
	//현재시간을 (시분초)을 00:00:00 형식으로 리턴
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
				
	}

	public static void main(String[] args) {
//		DigtalClock dc1 = new DigtalClock(0,0); 
//		DigtalClock dc2 = new DigtalClock(500,0); //좌표를넣어야 좌표를매개변수로받는 생성메소드가 실행되어 실행화면이나옴
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
		new DigtalClock(1000,0); // 생성자 메소드안에서 스레드클래스객체 만들었을때는 디지털식클래스객체만 만들어주면된다
	}
}
