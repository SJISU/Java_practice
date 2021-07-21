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
		JMenu fileMenu = new JMenu("����");
			JMenuItem  newMenuItem = new JMenuItem("����");
			JMenuItem openMenuItem = new JMenuItem("����");
			JMenuItem  saveMenuItem = new JMenuItem("����");
			JMenuItem  endMenuItem = new JMenuItem("����");
		JMenu editMenu = new JMenu("����");
			JMenuItem cutMenuItem = new JMenuItem("�����α�");
			JMenuItem  copyMenuItem = new JMenuItem ("�����ϱ�");
			JMenuItem  pasteMenuItem = new JMenuItem ("�ٿ��ֱ�");
		JMenu runMenu = new JMenu("����");
			JMenuItem  chromeMenuItem = new JMenuItem ("ũ��");
			JMenuItem  editplusMenuItem = new JMenuItem ("����Ʈ�÷���");
			
		JTextArea ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		
		public static String buffer; //�����α�,�����Ұ�� �����͸� ������ ����
		
	public Memo() {
		setJMenuBar(mb);
		mb.add(fileMenu); mb.add(editMenu); mb.add(runMenu);
		
		fileMenu.add(newMenuItem); fileMenu.add(openMenuItem); fileMenu.add(saveMenuItem); 
		//addSeparator() : �и���
		fileMenu.addSeparator(); fileMenu.add(endMenuItem);
		
		editMenu.add(cutMenuItem); editMenu.add(copyMenuItem); editMenu.add(pasteMenuItem);
		
		runMenu.add(chromeMenuItem); runMenu.add(editplusMenuItem);
		
		add(sp);
		
		//����Ű ����
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
		if(event == endMenuItem) { //����
			System.exit(0);
		}else if(event == newMenuItem) { //����
			ta.setText(" ");//���鹮�ڼ���
		}else if(event == openMenuItem) { //���� //JFileChooserŬ������ �����ڸ޼ҵ�  JFileChooser(file currentDirectory)
			fileOpen();
			//JFileChooser hfc = new JFileChooser();
		}else if(event == saveMenuItem) { //����
			fileSave();
		}else if(event == cutMenuItem) {//�����α�
			stringCut();
		}else if(event == pasteMenuItem) {//���̱�
			stringPaste();
		}else if(event == copyMenuItem) {
			stringCopy();
		}else if(event == chromeMenuItem) {
			processStart("C://program Files/Google/Chrome/Application/chrome.exe http://www.nate.com");
		}else if(event == editplusMenuItem) {
			processStart("C:\\Program Files/EditPlus/editplus.exe");
		}
	}
	
	
	//JFileChooser(Component ) --> int�� ����, getSelecteFile()---> ���ϼ��ý� ���ϰ�ü�� �Ѿ�� ,setMultiSelectionEnabled() : ���ϴ��߼���
	public void fileOpen() {//����Ž���⳪����
		JFileChooser fc= new JFileChooser(new File("D://javaSrc")); //���ϴ� ��ΰ� ������ �ϱ����ؼ��� �Ű������� ��ġ�� �������ش� .�������ϸ� �ֱٰ�ΰ���
		
		//������ ������ �ѹ����ð����ϵ��� �����ϱ�
		fc.setMultiSelectionEnabled(true); //true: ���߼��� false:���ϼ���
		
		//���͸�(���ϸ�)-Ȯ���� //FileNameExtensionFilter(String description, String ...extesion)Ŭ����....�Ű������� ��Ʈ��Ÿ������ ������ ������ 
		FileFilter filter =new FileNameExtensionFilter("�ڹ�(*.java)","java","Java","JAVA"); //��ü����
		fc.setFileFilter(filter);
		
		FileFilter filter2 = new FileNameExtensionFilter("Ŭ����","class");
		fc.setFileFilter(filter2);
		
		//����
		//fc.showOpenDialog(this); 
		//���� : 0 ��� :1
		int choose = fc.showOpenDialog(this);
		if(choose==0) {//���⼱��
			try {
				//���� �Ѱ� ����
				//������ ���ϰ�ο� ���ϸ��� ������
				File f = fc.getSelectedFile(); //�� ���� ��ü�� ������
				FileReader fr = new FileReader(f);//���Ͽ� �ִ� ������ �о�;���: FileInputStream, BufferedReader
				BufferedReader br = new BufferedReader(fr);//���ٷ����
				ta.setText(" "); //������ ǥ�õ� ������ ���� ��� �����.
				while(true) {
					String inData = br.readLine();
					if(inData==null) break;
					ta.append(inData+"\n"); //������ �߰��� �ؽ�Ʈ�� ������ �Ѵ�...					
				}
				
				//������ ������ ����������
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
	
	//���������ϱ�
	public void fileSave() {
		//Textarea������ �����Ұǵ� ��̸����� ��� ����
		JFileChooser fc = new JFileChooser(new File("D:\\testFile"));
		int state = fc.showSaveDialog(this); //�����ϱ�
		// 0: ���� 1:���
		if(state ==0) {
			try {
				File ff =fc.getSelectedFile();//��ΰ�������
				FileWriter fw = new FileWriter(ff);//output�ϴ�...Ŭ���� : fileWriter()
				fw.write(ta.getText());
				fw.close();
				
			}catch(IOException e) {
				System.out.println(e.getMessage());}
		}
	}
	
	//������ -> ������ ���ڰ� �������� �޸𸮿� �����̵� //�����ϱ� -> ������ ���ڰ� �����ְ� �޸𸮿� �����̵� //
	//�����α�
	public void stringCut() {
		//1.�巡�׷� ������ ������ ���ڸ� buffer������ �����ϰ�
		buffer =ta.getSelectedText(); //getSelectedText() : �����ѿ����� ���ڸ� �������� : buffer�� ����
		//2.���ÿ����� ���ڸ� �������Ѵ�.
		ta.replaceSelection(" "); //replaceSelection(): �����ѿ��� ���� �ٲٱ�
	}
	//�ٿ��ֱ�
	public void stringPaste() {
		//buffer������ �ִ� ���ڸ� Ŀ���� �ִ°��� ���� //���̱��Ҷ� �����Ѻκп� ���ڿ��� ������ �����ִ����ڿ��� ������� ���ο�ڰ� �ٿ���
		ta.replaceSelection(buffer); // �����α⳪ �����ؼ� buffer�� �����Ѱ��� �����Ѱ��� ��ü�ϱ�
	}
	//�����ϱ�
	public void stringCopy() {
		buffer = ta.getSelectedText();
	}
	
	//�ܺ����� �����ϱ�
	public void processStart(String url) {
		Runtime runtime = Runtime.getRuntime(); //java.lang- RuntimeŬ����
		// c://program Files/Google/Chrome/Application/chrome.exe
		try {
			runtime.exec(url);			
		}catch(Exception e) {			
		}		
	}
	
	//����Ű �����ϱ�
	public void setShortCut() { //ctrl,altŰ �̿��Ͽ�
		//���� : ����Ű�� ����� Ű�� E
		//1.�޴��� ����Ű�� ����� Ű�� ����
		endMenuItem.setMnemonic(KeyEvent.VK_E); //KeyeventŬ����-vk.E -> 69���� �� ����
		//2.maskŰ ����										����Ű		����ũ
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK)); //javax.swing-keystroke
		
		//����޴� : O
//		openMenuItem.setMnemonic(KeyEvent.VK_O);
//		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
	}
	
	
	
//	public static void main(String[] args) {
//		new Memo();
//
//	}

}
