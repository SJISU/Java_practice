import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JButton;

import javax.swing.JLabel; //기본레이아웃 : flowLayout
import javax.swing.JPanel;

public class DigitalClock2 extends JPanel implements Runnable { //컨테이너가 프레임이면 다른컨테이너에추가못하므로 패널로변경
	
	Font fnt = new Font("굴림",Font.BOLD,100);//폰트설정	
	Calendar now; // = Calendar.getInstance(); //현재시간
	//JPanel pane = new JPanel(new GridLayout(0,3));
		JLabel lb1 = new JLabel("00:00:00",JLabel.CENTER);

//		TimeZone time;
//		Date date = new Date();

		int x,y;
	public DigitalClock2() {
		
		setLayout(new BorderLayout()); //컨테이너가 달라지면서 레이아웃도 달라져서 다시 셋팅해줌
		//super("시계"); //setTitle("시계"); ->패널에서는 필요x
		//add(BorderLayout.CENTER,pane);
		add(lb1);
	
		lb1.setFont(fnt);
		
		
	}	
	public DigitalClock2(int x, int y) {//좌표를 매개변수로 받는다
		this();						//생성자메소드에서 다른생성자호출 ->this(); 
		this.x = x;
		this.y = y;
		//setBounds(x,y,500,200); // 생성메소드에있으면 매개변수를받았을때 위치가 ->패널에서는 필요x : 패널은담고있는것에 사이즈영향을 받음
		//setVisible(true);
		
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
}
