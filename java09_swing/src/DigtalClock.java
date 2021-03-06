import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigtalClock extends JFrame  {
	
	Font fnt = new Font("굴림",Font.BOLD,100);//폰트설정	
	Calendar now; // = Calendar.getInstance(); //현재시간
	JLabel lb1 = new JLabel("00:00:00",JLabel.CENTER);
	public DigtalClock() {
		
		super("시계"); //setTitle("시계");
		add(lb1);
		lb1.setFont(fnt);

		setSize(500,200);		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
	
		startClock();
	
	}	
	//시간변경--->화면이 뜨고나서 호출해야한다-->무한루프니깐
	public void startClock() {
		do {
			lb1.setText(getTimer());
			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				
			}			
		}while(true);
		
		
	}
	//현재시간을 (시분초)을 00:00:00 형식으로 리텀
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
		
		
	}
	
	public static void main(String[] args) {
		new DigtalClock();		
	}
}
