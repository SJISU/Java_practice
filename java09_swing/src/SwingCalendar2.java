import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingCalendar2  extends JPanel implements ActionListener{

	Font ft = new Font("����ü",Font.BOLD,20);
	Calendar now = Calendar.getInstance();
	
	//Frame-North
	JPanel frmNorth = new JPanel();
		JButton prevMonth = new JButton("��");
		JButton nextMonth = new JButton("��");
		JLabel yearLb1 = new JLabel("��");
		JLabel monthLb1 = new JLabel("��");
		
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();		
		DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer> ();
		
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer> ();
		
	//Frame-Center
	JPanel frmCenter = new JPanel(new BorderLayout());
		JPanel weekTitlePane = new JPanel(new GridLayout (1,7)); //frmCenter�� ����
		JPanel dayPane = new JPanel(new GridLayout(0,7)); //frmCenter�� ����
		
	public SwingCalendar2() {
		//super("����");
		
		setLayout(new BorderLayout());
		//Frame-North
		prevMonth.setFont(ft);
		nextMonth.setFont(ft);
		yearLb1.setFont(ft);
		monthLb1.setFont(ft);
		yearCombo.setFont(ft);
		monthCombo.setFont(ft);
		
		frmNorth.add(prevMonth);//��
		
		//�⵵ ����Ʈ
		int nowYear=setNowYear(); //�⵵�޼ҵ�ȣ��
		yearCombo.setModel(yearModel); //�޺��ڽ��ȿ� �⵵����
		yearCombo.setSelectedItem(nowYear);//����⵵����
		frmNorth.add(yearCombo);
		
		frmNorth.add(yearLb1); //"��"
		
		//������Ʈ
		int nowMonth = setNowMonth();
		monthCombo.setModel(monthModel); //�޺��ڽ��ȿ� ������
		monthCombo.setSelectedItem(nowMonth+1); //���� ������
		frmNorth.add(monthCombo);
		
		frmNorth.add(monthLb1);//��
		frmNorth.add(nextMonth); //��
		
		add(BorderLayout.NORTH,frmNorth);
		
		//Frame-Center
		frmCenter.add(BorderLayout.NORTH,weekTitlePane);
		frmCenter.add(dayPane);
		add(frmCenter);
		
		setWeekTitle(); //������� �޼ҵ�
		
		//��¥
		//�ش���� 1�Ͽ� ���� ����
		int week = getOneDayWeek(nowYear,nowMonth);
		//�ش���� ��������
		int lastDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		setSpaceLabel(week); //����		
		setDayLabel(nowYear,nowMonth,lastDay); //��¥ó��
		
//		setSize(400,300);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		
		//�̺�Ʈ���
		prevMonth.addActionListener(this);	
		nextMonth.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		
	}
	
	public int setNowYear() { //�⵵����Ʈ		
		int year = now.get(Calendar.YEAR); //�⵵	
		for(int y= year+20; y>=year-100; y--) {
			yearModel.addElement(y);
		}
		return year;
	}
	
	public int setNowMonth() {//������Ʈ
		for(int m =1; m<=12; m++) {
			
			monthModel.addElement(m);
		}
		return now.get(Calendar.MONTH);
	}
	
	public void setWeekTitle() {//�������
		String weekName= "�Ͽ�ȭ�������";
		for(int i=0; i<weekName.length(); i++) { // 0,1,2,3,4,5,6
			JLabel lb1 = new JLabel(weekName.substring(i,i+1),JLabel.CENTER);
			lb1.setFont(ft);
			if(i==0) lb1.setForeground(Color.RED);
			if(i==6) lb1.setForeground(Color.BLUE);
			weekTitlePane.add(lb1);			
		}		
	}
	
	//���ϱ��ϱ�
	public int getOneDayWeek(int y, int m) {
		now.set(y,m,1);
		return now.get(Calendar.DAY_OF_WEEK);
	}
	
	
	//�������߰��ϴ¶�
	public void setSpaceLabel(int w) {
		for(int i=1; i<w; i++) {
			JLabel lb1 = new JLabel(" ");
			dayPane.add(lb1); //��������
		}
	}	
	//��¥�߰��ϴ� ����
	public void setDayLabel(int year, int month ,int lastDay) {
		for(int day=1; day<=lastDay; day++) {
			JLabel lb1 = new JLabel(String.valueOf(day),JLabel.CENTER); //day�� �����ϰ� String ���� ����ȯ
			lb1.setFont(ft);
			now.set(year,month, day); // �ٵ� �� �ٽ� �������ִ°�?��--> ���ϱ��Ϸ���? �Ф�
			int week =now.get(Calendar.DAY_OF_WEEK); //������ ������ week�� 1������������ϱ� ���μ���
			if(week==1) lb1.setForeground(Color.RED);
			if(week==7) lb1.setForeground(Color.BLUE);
			dayPane.add(lb1);			
		}		
	}
	
	//�����޺��ڽ� ���ý�  �߻��ϴ� �̺�Ʈ �޼ҵ�
	//�гΰ�ä��.removeAll() : �гξ��� ������Ʈ�����... //�гΰ�ü��.setVisible()
	public void setNewDate() {
		//�޺��ڽ����� �� �����ϴ� ����� �´�..select������ ��´�
			int year = (Integer)yearCombo.getSelectedItem();
			int month =(int)monthCombo.getSelectedItem();
			now.set(year, month-1,1); //��ǻ�Ͱ� �˾ƺ����ϴϱ�....
			//������ ���� ���� ��� ������ �Ѵ�.
			dayPane.removeAll();
			//�гμ����
			dayPane.setVisible(false);
			setSpaceLabel(now.get(Calendar.DAY_OF_WEEK));
			setDayLabel(year,month-1,now.getActualMaximum(Calendar.DAY_OF_MONTH));	
			//�ٽ��гκ����հ�
			dayPane.setVisible(true);
	}
	
	//���ʹ�ư�϶�
	public void setPrevMonth() {
		//���� ���õ� �޺��ڽ��� ���� �����´� 
		int y = (int)yearCombo.getSelectedItem();
		int m = (int)monthCombo.getSelectedItem();
		//1���϶� ���ʹ�ư�� ������ ���Ұ���,�ٸ����� ��������
		
		if(m==1) { //1���̸� �⵵�� �����ϰ� ���� 12���� ���� //1���϶� ���ʹ�ư������ ���ݳ⵵-1 �⵵ 12������µǰŤ�
			y--;
			m=12;			
		}else {
			m--; 
		}			
		 setButtonEvent(y,m);//ComboBox�� �����̺�Ʈ���� --> �����ǳ�¥���� ����� �гμ���� ��¥�����ϰ� �ٽ� �гκ��̰�	
	}
	//�����ʹ�ư�϶�
	public void setNextMonth() {
		int y = (int)yearCombo.getSelectedItem();
		int m = (int)monthCombo.getSelectedItem();		
		if(m==12) {
			y++;
			m=1;
		}else {
			m++;
		}
		setButtonEvent(y,m);
	}
		
	
	public void setButtonEvent(int y, int m) {
		//ComboBox�� �����̺�Ʈ���� --> �����ǳ�¥���� ����� �гμ���� ��¥�����ϰ� �ٽ� �гκ��̰�
				yearCombo.removeActionListener(this);
				monthCombo.removeActionListener(this);
				yearCombo.setSelectedItem(y);
				monthCombo.setSelectedItem(m);
				setNewDate();
				//������ �����̺�Ʈ �ٽõ��
				yearCombo.addActionListener(this);
				monthCombo.addActionListener(this);
	}

	//�̺�Ʈ �߻�޼ҵ� �������̵�
	// instanceof ������ : ��ü�� � Ŭ������ �����Ǿ����� ���ϴ� ������
	public void actionPerformed(ActionEvent ae) {
		//�޺��ڽ��� �������� �޷��� �ٲ��...
		Object obj = ae.getSource(); //JButton,JComboBox �Ѵ� �߻�
		
		//��ü�� � Ŭ������ �����Ǿ����� ���ϴ� ������
		if(obj instanceof JButton) { //obj��ü�� JButton���� ���� ��ü�� �´��� 
			
		//�޺��ڽ��̺�Ʈ����� ��¥�������� �ٽ� �̺�Ʈ ���....
			//����,�����ʹ�ư
			if(obj == prevMonth) {//���� ����Ű
				setPrevMonth();
			}else if (obj == nextMonth) {// �����ʹ���Ű
				setNextMonth();
			}
			
		}else if(obj instanceof JComboBox) { 
			
			setNewDate(); //�����޺��ڽ��� �����ϸ� �߻��Ǵ� �޼ҵ�
		}		
	}
	
	

}
