import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Test01 extends JFrame{

	JPanel pane1 = new JPanel(new GridLayout(6,0));
	JPanel pane2 = new JPanel(new BorderLayout());	
	JPanel pane3 = new JPanel(new GridLayout(1,0));
	JPanel pane4 = new JPanel(new FlowLayout());
	
	JTextField tf, tf2;
	JLabel lbt;
	JButton jbtn, jbtn2;
	String str[]= {"번호","이름","전화번호","이메일","주소","등록일"};
	String jbtnStr[]= {"추가","수정","삭제","지우기","종료","엑셀로저장","엑셀불러오기"};
	
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	
	String title[]= {"번호","이름","전화번호","이메일","주소","등록일"};
	
	public Test01() {	
	
		add(BorderLayout.NORTH,pane1); //JFrame에 패널 추가
		add(pane2);
		pane2.add(BorderLayout.NORTH,pane3);
	
		for(int i=0; i<str.length; i++) {
			lbt = new JLabel(str[i]);			
			pane1.add(lbt);
			
			if(i==0) {
				tf = new JTextField(4);
				pane1.add(tf);
			}else if(i==1) {
				tf = new JTextField(6);
				pane1.add(tf);
			}else if(i==2 || i==3){
				tf = new JTextField(14);
				pane1.add(tf);
			}else if(i==4 || i==5) {
				tf = new JTextField(20);
				pane1.add(tf);
			}			
		}	
		//pane3 안에 버튼
		for(int i=0; i<jbtnStr.length; i++) {
			jbtn = new JButton(jbtnStr[i]);
			pane3.add(jbtn);
		}
		
		model = new DefaultTableModel(title,0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		pane2.add(table);
		
		
		tf2 = new JTextField(16);
		pane4.add(tf2);
		jbtn2 = new JButton("Search");
		pane4.add(jbtn2);
		pane2.add(BorderLayout.SOUTH,pane4);
		
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Test01();
	}

}
