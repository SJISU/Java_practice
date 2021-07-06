import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarEx extends JFrame implements ActionListener ,  ItemListener{
	//�޸��ٲ�´޷¸����߰ٴ�......
	Calendar now = Calendar.getInstance();
	
	JPanel pane = new JPanel();	//��,��
	
	JPanel calpane = new JPanel(new BorderLayout());//�޷�ū��
	JPanel daypane = new JPanel(new GridLayout(1,7)); //������
	JPanel datepane = new JPanel(new GridLayout(6,7)); //��¥��
	
	String dayStr[] = {"��","��","ȭ","��","��","��","��"}; //���Ͻ�Ʈ���迭
	//String dateStr[] = new String[42];
	
	JComboBox<String> cb1 = new JComboBox<String>();  
	JLabel lb1 = new JLabel("��");
	JComboBox<String> cb2 = new JComboBox<String>();
	JLabel lb2 = new JLabel("��");
	
	JButton leftjbt = new JButton("��");
	JButton rightjbt = new JButton("��");
	
	//�޷³�¥
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH)+1;
	int date = now.get(Calendar.DAY_OF_MONTH);
	
	
	public CalendarEx() {
		
		
		add(BorderLayout .NORTH,pane);
		pane.add(leftjbt);//���ʹ�ư --> �̺�Ʈ��� --> ���ݿ�-1 �޷���
		pane.add(cb1); //cb1�� �⵵�Է� 
		cb1.addItem(String.valueOf(year));		
		//�⵵
		for(int i=year-10; i<=year+10; i++) {
			if(i==year) {}
			else {cb1.addItem(String.valueOf(i));}		
		}			
		pane.add(lb1); //"��"
		pane.add(cb2); //cb2�� �� �Է� //--->�̺�Ʈ��� ---> �Էµȿ��ٲ�
		cb2.addItem(String.valueOf(month));	
		for(int i=1; i<=12; i++) {
			if(i==month) {}
			else {cb2.addItem(String.valueOf(i));}			
		}		
		pane.add(lb2); //"��"	
		pane.add(rightjbt); //�����ʹ�ư --> �̺�Ʈ��� --.���ݿ�+1 �޷���
		pane.setBackground(Color.CYAN);
		
		add(calpane); //�޷�ū��		
		calpane.add(BorderLayout.NORTH,daypane); //�������߰�
		calpane.add(BorderLayout.CENTER,datepane); //��¥���߰�
		
		//���� ���� ����
		for(int i=0; i<dayStr.length; i++) {
			JLabel btn = new JLabel(dayStr[i],JLabel.CENTER);			
			btn.setBackground(Color.GRAY);
			if(i==0) {
				btn.setForeground(Color.red);
			}else if(i==6) {
				btn.setForeground(Color.blue);
			}
			daypane.add(btn); 			
		}
		
		
		//��¥����-��¥�ǿ� ���̶󺧷� ��¥ �߰�
		now.set(year, month-1,1); //�̰� ���⼭ �ϴ°Ը³�? ���������ΰ�.......
		cal(year,month); //�޷���¸޼ҵ�....

		setTitle("ī����");		
		setSize(300,300);
		setVisible(true);
		

		leftjbt.addActionListener(this);
		rightjbt.addActionListener(this);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		//���ʹ�ư������ ����
		//�����ʹ�ư ������ ������
		JButton event = (JButton)ae.getSource();
		String btnLb1 = event.getText();
		if(btnLb1.equals("��")) {
			
		}else if(btnLb1.equals("��")) {
			
		}
		
	}
	
	public void itemStateChanged(ItemEvent ie) { //�����޺��ڽ����� ��,�������ϸ�
		JComboBox event = (JComboBox)ie.getSource();
		if(event.equals(cb1)){ //�⵵
			String newYear = (String)cb1.getSelectedItem();
			
			//System.out.println(newYear);
			cal(Integer.parseInt(newYear),month);//���δ޷���� �ٲ����ϴµ� ......�ȹٲ� ��
		}else if(event.equals(cb2)) { //��
			
		}
		
		
	}
	//�޷���¸޼ҵ�
	public void cal(int year, int month) {		
				
		//now.set(year, month-1,1); //?		
		
		int week=now.get(Calendar.DAY_OF_WEEK);
		int lastDay =now.getActualMaximum(Calendar.DAY_OF_MONTH);	
		
		
		for(int space=1; space<week; space++) {
			datepane.add(new JLabel("\t"));			
		}
		//�������
		for(int day=1; day<=lastDay; day++) {
			JLabel dlb1 = new JLabel(String.valueOf(day),JLabel.CENTER);
			dlb1.setOpaque(true);
			now.set(year,month, day);
			week=now.get(Calendar.DAY_OF_WEEK);
			System.out.println(week);
			if(week==1) {//�Ͽ��� ���ڻ� ����				
				dlb1.setForeground(Color.red);
			}else if((day+week-1)%7==0) { //(week=7)����� ���ڻ� �Ķ�
				dlb1.setForeground(Color.blue);
				//System.out.println(week); //Ȯ���Ϸ������๮..�������-->��5����� ��
			}
			datepane.add(dlb1);
		}
		for(int space=1; space<=42-(lastDay+week); space++) {
			datepane.add(new JLabel("\t"));	
		}		
	}
	
	
	public static void main(String[] args) {
		
		new CalendarEx();
	}

}
