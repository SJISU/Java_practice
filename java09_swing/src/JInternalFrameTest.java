import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class JInternalFrameTest extends JFrame implements ActionListener {

	JDesktopPane dp = new JDesktopPane(); // 내부창이 밖으로 안나가짐
	JInternalFrame if1, if2,if3;
	
	ImageIcon openIcon = new ImageIcon("img/open01.gif");
	ImageIcon saveIcon = new ImageIcon("img/save01.gif");
	JToolBar tb = new JToolBar();
		JButton openBtn = new JButton(openIcon);	
		JButton saveBtn = new JButton(saveIcon);
		JButton foreColor = new JButton("글자색");
		
	//글꼴
	JToggleButton boldBtn = new JToggleButton(" A ");//진하게
	JToggleButton italicBtn = new JToggleButton(" A ");//기울임골
	JComboBox<String> fontCombo = new JComboBox<String>(); //글꼴
	JComboBox<Integer> sizeCombo = new JComboBox<Integer>();//글자크기
	DefaultComboBoxModel<String> fontModel = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<Integer> sizeModel = new DefaultComboBoxModel<Integer>();
	
	int bold=0; //1,0이 왔다갔다
	int italic =0;
	
	//달력 다이얼로그창 //인터널프레임과는다름 //컨테이너 // 다이어로그안에 새로운 다이어로그창 띄울수잇다
	JButton calBtn = new JButton("달력");
	
	
	public JInternalFrameTest() {
		
		//툴바
		tb.add(openBtn); //툴바에 버튼넣기
		tb.add(saveBtn); 
		tb.addSeparator(); //경계선
		tb.add(foreColor);	
		
		//글꼴관련 메뉴
		boldBtn.setFont(new Font("굴림체",Font.BOLD,12));
		italicBtn.setFont(new Font("굴림체",Font.ITALIC,14));
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		//글꼴 : 윈도우 운영체제에서 지원하는 글꼴을 이용하여 콤보박스만들기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); //클래스객체생성
		String fontName[] = ge.getAvailableFontFamilyNames();//폰트를 스트링 배열로 리턴
		fontModel = new DefaultComboBoxModel<String>(fontName);
		fontCombo.setModel(fontModel);
		fontCombo.setSelectedItem("굴림");
		tb.add(fontCombo);
		
		
		//글자크기
		for(int size=8; size<100; size+=2) {
			sizeModel.addElement(size); //목록이 만들어짐
		}
		sizeCombo.setModel(sizeModel);//만들어진목록을 콤보박스에 셋팅
		sizeCombo.setSelectedItem(12);
		tb.add(sizeCombo);
		
		add(BorderLayout.NORTH,tb);		
		
		tb.add(calBtn);//달력버튼
		
		
		add(dp); //배경이 흰색이 됨
		
		if1 = new JInternalFrame(); //창크기조절, 최소하, 최대화,아이콘화 모두불가
		if1.setVisible(true);
		if1.setSize(300,200);
		dp.add(if1);
		
		if2 = new JInternalFrame("메모장",true); //창크기조절가능
		if2.add(new JScrollPane(new JTextArea()));
		if2.setBounds(100,100, 500,400);
		if2.setVisible(true);
		dp.add(if2);
		
		if3 = new JInternalFrame("계산기",true,true,true,true); ////창크기조절, 최소하, 최대화,아이콘화 가능
		if3.add(new CalculatorEx2());
		if3.setSize(400,350);
		if3.setVisible(true);
		dp.add(if3);				
		
		setSize(1200,1000);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 창꺼도 안닫히게 만든후 
		
		//창 활성화 - 여러창들중 제일 위로 올라오게 만든다 	setSelected(boolean selected), isSelected()
		try {					
			if3.setSelected(true);//계산기프레임 활성화				
		}catch(Exception e) {}
	
	   openBtn.addActionListener(this);	
	   saveBtn.addActionListener(this);
	   foreColor.addActionListener(this);
	   boldBtn.addActionListener(this);
	   italicBtn.addActionListener(this);
	   fontCombo.addActionListener(this);
	   sizeCombo.addActionListener(this);
	   calBtn.addActionListener(this);
	   
	   //익명의 내부클래스 사용하여 
	   JInternalFrameTest ift = this;	   
	   addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent we) {
		  	//활성화된 창에서 글자쓰고 활성화 창 닫으면 저장할건지 안할건지 물어봄
		  	//클래스 :JOptionPane -> showMessageDialog , showConfirmDialog
		  	JOptionPane op = new JOptionPane();//객체생성
		  	int que = op.showConfirmDialog(ift,"저장하시겟습니까?","저장하기",JOptionPane.YES_NO_CANCEL_OPTION);
		  	if(que == JOptionPane.YES_OPTION) {//yes =0
		  		//저장후종료
		  		fileSave();
		  		dispose(); //자원해제 -> setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 때문에
		  		System.exit(0);
		  	}else if(que == JOptionPane.NO_OPTION) {//no = 1
		  		//그냥종료
		  		dispose();//자원제거
		  		System.exit(0);
		  	}else if(que == JOptionPane.CANCEL_OPTION){//cancel =2
		  		//아무일도 안함
		  	}
		  	
		  	}
	   	}); 
		   
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		Object event = ae.getSource();
		if(event instanceof JButton) {
			if(event == openBtn) {
				fileOPen();
			}else if(event == saveBtn) {
				fileSave();
			}else if(event == foreColor) {
				setFontFore();
			}else if(event == calBtn) {
				getCalendarDialog();
			}
			
		}else if(event instanceof JToggleButton) {
			if(event == boldBtn) { //
				//선택된건지 아닌지를 확인해서 선택된거면 선언한 bold의 값에 1을 넣어줌
				//다시 눌러서 선택되어있지않은 상태가되면 bold의 값에 0을 넣어줌 -> 선택되엇는지 확인할수잇는 메소드필요
				if(boldBtn.isSelected()) { // true: 선택 false:선택x
					bold = 1; //진하게 선택되었을때
				}else {
					bold  =0; //진하게 선택해제 되었을때
				}
				fontSetting(); 
				
			}else if(event == italicBtn) {
				if(italicBtn.isSelected()) {
					italic = 2;
				}else {
					italic = 0;
				}
				fontSetting();
			}
		}else if(event instanceof JComboBox) {
			if(event == fontCombo || event == sizeCombo) { // 글꼴 , 글자크기
				fontSetting();
			}
		}	
	}

	//파일열기
	public void fileOPen() {
		JFileChooser fc = new JFileChooser();
		//int --> 파일선택하고 열기 아니면 취소를 누른다 -> 취소는 :1 열기 :0
		//int를 쓰는이유 -> 결과를받아오기위해서
		//int state= fc.showOpenDialog(this);
		if(fc.showOpenDialog(this)==0) { // 열기
			//선택한 파일객체얻어옴
			File f = fc.getSelectedFile();
			JTextArea ta = new JTextArea();
			
			try {
				FileReader  fr = new FileReader(f);//문자단위로 갖고온다
				BufferedReader br = new BufferedReader(fr); //한줄씩 읽기 불편해서 버퍼리드로
				
				while(true) {
					String readData =br.readLine();
					if(readData == null) break;
					ta.append(readData+"\n");
				}					
				JScrollPane sp2 = new JScrollPane(ta);				
				
				JInternalFrame if5 = new JInternalFrame(f.getPath(),true,true,true,true); //파일명
				if5.add(sp2);
				dp.add(if5);
				if5.setSize(500,500);
				if5.setSelected(true); //활성화
				if5.setVisible(true);			
				
			}catch(Exception e) {}
		}
	}
	
	//파일저장
	public void fileSave() {
		JFileChooser fc = new JFileChooser();
		if(fc.showSaveDialog(this) == 0) {
			try {
				File f = fc.getSelectedFile();
				FileWriter fw = new FileWriter(f); //->String으로쓰는 메소드 잇음
				//현재 선택된 Frame 얻어오기 -> 왜? -> 여러개니깐 활성화된프레임 얻어온다
				//파ㅑ일열기를 통해 if5겍체를 열개도 열수잇다 - > 그중에서 dp안에 활성화된 intenalframe 가져오기
				JInternalFrame selectIf =dp.getSelectedFrame();
				JTextArea eventTa = (JTextArea)selectIf.getFocusOwner();				
				fw.write(eventTa.getText());
				fw.close();
				
			}catch(Exception e) {}					
		}		
	}
	
	//글자색바뀜 
	public void setFontFore() { //swing-JColorChooser
		JColorChooser cc = new JColorChooser(Color.green); //컬러창이뜬다
		Color selectColor =cc.showDialog(this,"글자색",Color.PINK);//프리뷰로 핑크색폰트가 보임 
																	//초록색으로 해놧다가 핑크 //선택된컬러가 리턴되서 여기에 담김
		JInternalFrame selectIf = dp.getSelectedFrame();
		JTextArea ta =(JTextArea)selectIf.getFocusOwner();
		ta.setForeground(selectColor);		
	}
	
	//달력 다이어로그 -> 달력창 뜨면 창끄기전까지 툴바 버튼이 안눌려짐
	public void getCalendarDialog() { //컨테이너
		SwingCalendar2 cal = new SwingCalendar2();
		
		//BorderLayout
		JDialog dialog = new JDialog(this,"달력",true); //생성자여러개 있는데 그중 모달이 되는것 사용
										// 부모컨테이너 Jframe -> this 로
		dialog.add(cal); // 센터
		dialog.setSize(400,350);
		dialog.setVisible(true);
		
	}	
	
	// 글세트세트세트
	public void fontSetting() {
		//Desktop에서 선택된 JInternalFrame을 구현한 JTextArea얻어오기
		JInternalFrame activeIf= dp.getSelectedFrame(); //활성화되어있는 프레임
		JTextArea ta = (JTextArea)activeIf.getFocusOwner();
		
		ta.setFont(new Font((String)fontCombo.getSelectedItem(),bold+italic,(Integer)sizeCombo.getSelectedItem()));		
	}
	
	
	
	public static void main(String[] args) {
		new JInternalFrameTest();
	}

}
