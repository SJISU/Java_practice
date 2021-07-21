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

	JDesktopPane dp = new JDesktopPane(); // ����â�� ������ �ȳ�����
	JInternalFrame if1, if2,if3;
	
	ImageIcon openIcon = new ImageIcon("img/open01.gif");
	ImageIcon saveIcon = new ImageIcon("img/save01.gif");
	JToolBar tb = new JToolBar();
		JButton openBtn = new JButton(openIcon);	
		JButton saveBtn = new JButton(saveIcon);
		JButton foreColor = new JButton("���ڻ�");
		
	//�۲�
	JToggleButton boldBtn = new JToggleButton(" A ");//���ϰ�
	JToggleButton italicBtn = new JToggleButton(" A ");//����Ӱ�
	JComboBox<String> fontCombo = new JComboBox<String>(); //�۲�
	JComboBox<Integer> sizeCombo = new JComboBox<Integer>();//����ũ��
	DefaultComboBoxModel<String> fontModel = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<Integer> sizeModel = new DefaultComboBoxModel<Integer>();
	
	int bold=0; //1,0�� �Դٰ���
	int italic =0;
	
	//�޷� ���̾�α�â //���ͳ������Ӱ��´ٸ� //�����̳� // ���̾�α׾ȿ� ���ο� ���̾�α�â �����մ�
	JButton calBtn = new JButton("�޷�");
	
	
	public JInternalFrameTest() {
		
		//����
		tb.add(openBtn); //���ٿ� ��ư�ֱ�
		tb.add(saveBtn); 
		tb.addSeparator(); //��輱
		tb.add(foreColor);	
		
		//�۲ð��� �޴�
		boldBtn.setFont(new Font("����ü",Font.BOLD,12));
		italicBtn.setFont(new Font("����ü",Font.ITALIC,14));
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		//�۲� : ������ �ü������ �����ϴ� �۲��� �̿��Ͽ� �޺��ڽ������
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); //Ŭ������ü����
		String fontName[] = ge.getAvailableFontFamilyNames();//��Ʈ�� ��Ʈ�� �迭�� ����
		fontModel = new DefaultComboBoxModel<String>(fontName);
		fontCombo.setModel(fontModel);
		fontCombo.setSelectedItem("����");
		tb.add(fontCombo);
		
		
		//����ũ��
		for(int size=8; size<100; size+=2) {
			sizeModel.addElement(size); //����� �������
		}
		sizeCombo.setModel(sizeModel);//������������ �޺��ڽ��� ����
		sizeCombo.setSelectedItem(12);
		tb.add(sizeCombo);
		
		add(BorderLayout.NORTH,tb);		
		
		tb.add(calBtn);//�޷¹�ư
		
		
		add(dp); //����� ����� ��
		
		if1 = new JInternalFrame(); //âũ������, �ּ���, �ִ�ȭ,������ȭ ��κҰ�
		if1.setVisible(true);
		if1.setSize(300,200);
		dp.add(if1);
		
		if2 = new JInternalFrame("�޸���",true); //âũ����������
		if2.add(new JScrollPane(new JTextArea()));
		if2.setBounds(100,100, 500,400);
		if2.setVisible(true);
		dp.add(if2);
		
		if3 = new JInternalFrame("����",true,true,true,true); ////âũ������, �ּ���, �ִ�ȭ,������ȭ ����
		if3.add(new CalculatorEx2());
		if3.setSize(400,350);
		if3.setVisible(true);
		dp.add(if3);				
		
		setSize(1200,1000);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // â���� �ȴ����� ������ 
		
		//â Ȱ��ȭ - ����â���� ���� ���� �ö���� ����� 	setSelected(boolean selected), isSelected()
		try {					
			if3.setSelected(true);//���������� Ȱ��ȭ				
		}catch(Exception e) {}
	
	   openBtn.addActionListener(this);	
	   saveBtn.addActionListener(this);
	   foreColor.addActionListener(this);
	   boldBtn.addActionListener(this);
	   italicBtn.addActionListener(this);
	   fontCombo.addActionListener(this);
	   sizeCombo.addActionListener(this);
	   calBtn.addActionListener(this);
	   
	   //�͸��� ����Ŭ���� ����Ͽ� 
	   JInternalFrameTest ift = this;	   
	   addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent we) {
		  	//Ȱ��ȭ�� â���� ���ھ��� Ȱ��ȭ â ������ �����Ұ��� ���Ұ��� ���
		  	//Ŭ���� :JOptionPane -> showMessageDialog , showConfirmDialog
		  	JOptionPane op = new JOptionPane();//��ü����
		  	int que = op.showConfirmDialog(ift,"�����Ͻðٽ��ϱ�?","�����ϱ�",JOptionPane.YES_NO_CANCEL_OPTION);
		  	if(que == JOptionPane.YES_OPTION) {//yes =0
		  		//����������
		  		fileSave();
		  		dispose(); //�ڿ����� -> setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); ������
		  		System.exit(0);
		  	}else if(que == JOptionPane.NO_OPTION) {//no = 1
		  		//�׳�����
		  		dispose();//�ڿ�����
		  		System.exit(0);
		  	}else if(que == JOptionPane.CANCEL_OPTION){//cancel =2
		  		//�ƹ��ϵ� ����
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
				//���õȰ��� �ƴ����� Ȯ���ؼ� ���õȰŸ� ������ bold�� ���� 1�� �־���
				//�ٽ� ������ ���õǾ��������� ���°��Ǹ� bold�� ���� 0�� �־��� -> ���õǾ����� Ȯ���Ҽ��մ� �޼ҵ��ʿ�
				if(boldBtn.isSelected()) { // true: ���� false:����x
					bold = 1; //���ϰ� ���õǾ�����
				}else {
					bold  =0; //���ϰ� �������� �Ǿ�����
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
			if(event == fontCombo || event == sizeCombo) { // �۲� , ����ũ��
				fontSetting();
			}
		}	
	}

	//���Ͽ���
	public void fileOPen() {
		JFileChooser fc = new JFileChooser();
		//int --> ���ϼ����ϰ� ���� �ƴϸ� ��Ҹ� ������ -> ��Ҵ� :1 ���� :0
		//int�� �������� -> ������޾ƿ������ؼ�
		//int state= fc.showOpenDialog(this);
		if(fc.showOpenDialog(this)==0) { // ����
			//������ ���ϰ�ü����
			File f = fc.getSelectedFile();
			JTextArea ta = new JTextArea();
			
			try {
				FileReader  fr = new FileReader(f);//���ڴ����� ����´�
				BufferedReader br = new BufferedReader(fr); //���پ� �б� �����ؼ� ���۸����
				
				while(true) {
					String readData =br.readLine();
					if(readData == null) break;
					ta.append(readData+"\n");
				}					
				JScrollPane sp2 = new JScrollPane(ta);				
				
				JInternalFrame if5 = new JInternalFrame(f.getPath(),true,true,true,true); //���ϸ�
				if5.add(sp2);
				dp.add(if5);
				if5.setSize(500,500);
				if5.setSelected(true); //Ȱ��ȭ
				if5.setVisible(true);			
				
			}catch(Exception e) {}
		}
	}
	
	//��������
	public void fileSave() {
		JFileChooser fc = new JFileChooser();
		if(fc.showSaveDialog(this) == 0) {
			try {
				File f = fc.getSelectedFile();
				FileWriter fw = new FileWriter(f); //->String���ξ��� �޼ҵ� ����
				//���� ���õ� Frame ������ -> ��? -> �������ϱ� Ȱ��ȭ�������� ���´�
				//�Ĥ��Ͽ��⸦ ���� if5��ü�� ������ �����մ� - > ���߿��� dp�ȿ� Ȱ��ȭ�� intenalframe ��������
				JInternalFrame selectIf =dp.getSelectedFrame();
				JTextArea eventTa = (JTextArea)selectIf.getFocusOwner();				
				fw.write(eventTa.getText());
				fw.close();
				
			}catch(Exception e) {}					
		}		
	}
	
	//���ڻ��ٲ� 
	public void setFontFore() { //swing-JColorChooser
		JColorChooser cc = new JColorChooser(Color.green); //�÷�â�̶��
		Color selectColor =cc.showDialog(this,"���ڻ�",Color.PINK);//������� ��ũ����Ʈ�� ���� 
																	//�ʷϻ����� �؇J�ٰ� ��ũ //���õ��÷��� ���ϵǼ� ���⿡ ���
		JInternalFrame selectIf = dp.getSelectedFrame();
		JTextArea ta =(JTextArea)selectIf.getFocusOwner();
		ta.setForeground(selectColor);		
	}
	
	//�޷� ���̾�α� -> �޷�â �߸� â���������� ���� ��ư�� �ȴ�����
	public void getCalendarDialog() { //�����̳�
		SwingCalendar2 cal = new SwingCalendar2();
		
		//BorderLayout
		JDialog dialog = new JDialog(this,"�޷�",true); //�����ڿ����� �ִµ� ���� ����� �Ǵ°� ���
										// �θ������̳� Jframe -> this ��
		dialog.add(cal); // ����
		dialog.setSize(400,350);
		dialog.setVisible(true);
		
	}	
	
	// �ۼ�Ʈ��Ʈ��Ʈ
	public void fontSetting() {
		//Desktop���� ���õ� JInternalFrame�� ������ JTextArea������
		JInternalFrame activeIf= dp.getSelectedFrame(); //Ȱ��ȭ�Ǿ��ִ� ������
		JTextArea ta = (JTextArea)activeIf.getFocusOwner();
		
		ta.setFont(new Font((String)fontCombo.getSelectedItem(),bold+italic,(Integer)sizeCombo.getSelectedItem()));		
	}
	
	
	
	public static void main(String[] args) {
		new JInternalFrameTest();
	}

}
