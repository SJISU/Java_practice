import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Memo extends JFrame implements ActionListener,Serializable{
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem  newMenuItem = new JMenuItem("새글");
			JMenuItem openMenuItem = new JMenuItem("열기");
			JMenuItem  saveMenuItem = new JMenuItem("저장");
			JMenuItem  endMenuItem = new JMenuItem("종료");
		JMenu editMenu = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem  copyMenuItem = new JMenuItem ("복사하기");
			JMenuItem  pasteMenuItem = new JMenuItem ("붙여넣기");
		JMenu runMenu = new JMenu("실행");
			JMenuItem  chromeMenuItem = new JMenuItem ("크롬");
			JMenuItem  editplusMenuItem = new JMenuItem ("에디트플러스");
			
		JTextArea ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		
		public static String buffer; //오려두기,복사할경우 데이터를 보관할 변수
		
	public Memo() {
		setJMenuBar(mb);
		mb.add(fileMenu); mb.add(editMenu); mb.add(runMenu);
		
		fileMenu.add(newMenuItem); fileMenu.add(openMenuItem); fileMenu.add(saveMenuItem); 
		//addSeparator() : 분리선
		fileMenu.addSeparator(); fileMenu.add(endMenuItem);
		
		editMenu.add(cutMenuItem); editMenu.add(copyMenuItem); editMenu.add(pasteMenuItem);
		
		runMenu.add(chromeMenuItem); runMenu.add(editplusMenuItem);
		
		add(sp);
		
		//단축키 설정
		setShortCut();
		
		setSize(700,700);
		//setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		chromeMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == endMenuItem) { //종료
			System.exit(0);
		}else if(event == newMenuItem) { //새글
			ta.setText(" ");//공백문자셋팅
		}else if(event == openMenuItem) { //열기 //JFileChooser클래스의 생성자메소드  JFileChooser(file currentDirectory)
			fileOpen();
			//JFileChooser hfc = new JFileChooser();
		}else if(event == saveMenuItem) { //저장
			fileSave();
		}else if(event == cutMenuItem) {//오려두기
			stringCut();
		}else if(event == pasteMenuItem) {//붙이기
			stringPaste();
		}else if(event == copyMenuItem) {
			stringCopy();
		}else if(event == chromeMenuItem) {
			processStart("C://program Files/Google/Chrome/Application/chrome.exe http://www.nate.com");
		}else if(event == editplusMenuItem) {
			processStart("C:\\Program Files/EditPlus/editplus.exe");
		}
	}
	
	
	//JFileChooser(Component ) --> int를 리턴, getSelecteFile()---> 파일선택시 파일객체가 넘어옴 ,setMultiSelectionEnabled() : 파일다중선택
	public void fileOpen() {//파일탐색기나오게
		JFileChooser fc= new JFileChooser(new File("D://javaSrc")); //원하는 경로가 나오게 하기위해서는 매개변수로 위치를 설정해준다 .설정안하면 최근경로가뜸
		
		//파일을 여러개 한번선택가능하도록 선정하기
		fc.setMultiSelectionEnabled(true); //true: 다중선택 false:단일선택
		
		//필터링(파일명)-확장자 //FileNameExtensionFilter(String description, String ...extesion)클래스....매개변수는 스트링타입으로 여러개 가능한 
		FileFilter filter =new FileNameExtensionFilter("자바(*.java)","java","Java","JAVA"); //객체형성
		fc.setFileFilter(filter);
		
		FileFilter filter2 = new FileNameExtensionFilter("클래스","class");
		fc.setFileFilter(filter2);
		
		//열기
		//fc.showOpenDialog(this); 
		//열기 : 0 취소 :1
		int choose = fc.showOpenDialog(this);
		if(choose==0) {//열기선택
			try {
				//파일 한개 선택
				//선택한 파일경로와 파일명을 얻어오기
				File f = fc.getSelectedFile(); //고른 파일 객체가 생성됨
				FileReader fr = new FileReader(f);//파일에 있는 데이터 읽어와야함: FileInputStream, BufferedReader
				BufferedReader br = new BufferedReader(fr);//한줄로출력
				ta.setText(" "); //이전에 표시된 내용이 있을 경우 지운다.
				while(true) {
					String inData = br.readLine();
					if(inData==null) break;
					ta.append(inData+"\n"); //페이지 중간에 텍스트로 나오게 한다...					
				}
				
				//파일을 여러개 선택했을때
//			File[] f = fc.getSelectedFiles();
//			for(File ff : f){
//				FileReader fr = new FileReader(ff);
//				BufferedReader br = new BufferedReader(fr);
//				ta.setText(" ");
//				while(true) {
//					String txt = br.readLine();
//					if(txt==null) break;
//					ta.append(txt+"\n");
//				}
//				ta.append("=============================================================\n");
//			}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//파일저장하기
	public void fileSave() {
		//Textarea내용을 저장할건데 어떤이름으로 어디에 저장
		JFileChooser fc = new JFileChooser(new File("D:\\testFile"));
		int state = fc.showSaveDialog(this); //저장하기
		// 0: 저장 1:취소
		if(state ==0) {
			try {
				File ff =fc.getSelectedFile();//경로가져오기
				FileWriter fw = new FileWriter(ff);//output하는...클래스 : fileWriter()
				fw.write(ta.getText());
				fw.close();
				
			}catch(IOException e) {
				System.out.println(e.getMessage());}
		}
	}
	
	//오리기 -> 선택한 문자가 없어지고 메모리에 보관이됨 //복사하기 -> 선택한 문자가 남아있고 메모리에 보관이됨 //
	//오려두기
	public void stringCut() {
		//1.드래그로 선택한 영역의 문자를 buffer변수에 보관하고
		buffer =ta.getSelectedText(); //getSelectedText() : 선택한영역의 문자만 가져오기 : buffer에 저장
		//2.선택영역의 문자를 지워야한다.
		ta.replaceSelection(" "); //replaceSelection(): 선택한영역 글자 바꾸기
	}
	//붙여넣기
	public void stringPaste() {
		//buffer변수에 있는 문자를 커서가 있는곳에 변경 //붙이기할때 선택한부분에 문자열이 있으면 원래있던문자열이 사라지고 새로운문자가 붙여짐
		ta.replaceSelection(buffer); // 오려두기나 복사해서 buffer에 저장한것을 선택한곳에 대체하기
	}
	//복사하기
	public void stringCopy() {
		buffer = ta.getSelectedText();
	}
	
	//외부파일 실행하기
	public void processStart(String url) {
		Runtime runtime = Runtime.getRuntime(); //java.lang- Runtime클래스
		// c://program Files/Google/Chrome/Application/chrome.exe
		try {
			runtime.exec(url);			
		}catch(Exception e) {			
		}		
	}
	
	//단축키 설정하기
	public void setShortCut() { //ctrl,alt키 이용하여
		//종료 : 단축키로 사용할 키를 E
		//1.메뉴에 단축키로 사용할 키를 셋팅
		endMenuItem.setMnemonic(KeyEvent.VK_E); //Keyevent클래스-vk.E -> 69값이 들어가 있음
		//2.mask키 설정										단축키		마스크
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK)); //javax.swing-keystroke
		
		//열기메뉴 : O
//		openMenuItem.setMnemonic(KeyEvent.VK_O);
//		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
	}
	
	
	
//	public static void main(String[] args) {
//		new Memo();
//
//	}

}
