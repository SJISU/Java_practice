import java.util.Calendar;
import java.util.Scanner; 

public class CalendarOOP {
	
		Scanner scan = new Scanner(System.in);
		Calendar date;
	
	public CalendarOOP() {		//������
		calendarStart();
		
	}
	
	public void calendarStart() {
		int year = getDate("�⵵");
		int month = getDate("��");
		titlePrint(year,month);//��������� �޼ҵ� ȣ��
		
			date = Calendar.getInstance();
			//�Է¹��� ��,�� ,1���� ����
			date.set(year, month-1,1);
			//���� ���ϱ�
			int week = date.get(Calendar.DAY_OF_WEEK); //-���ξƷ����޼ҵ�ȸ������
		
		spacePrint(week-1);//���� ������ �Է��Ͽ� �������
		
			//�������� ��������
			int lastDay =date.getActualMaximum(Calendar.DAY_OF_MONTH); //-���ξƷ����޼ҵ�ȸ������
		
		//��¥���
		dayPrint(week-1,lastDay);
	}
	
	//�ֿܼ��� �⵵ ���� �Է¹޴� �޼ҵ� ����
	public int getDate(String msg) {
			System.out.print(msg+"->");
			return Integer.parseInt(scan.nextLine());
	}
	
	//Ÿ��Ʋ ���
	public void titlePrint(int year, int month) { //�޼ҵ尡 �޶� ������ ���Ƶ� �������.
		System.out.println("\t\t"+year+"��"+month+"��");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
	}
	
	//1�� ����ϱ����� �������
	public void spacePrint(int cnt) {
		for(int i=1; i<=cnt; i++) {
		System.out.print("\t");
		}
	}
	
	//��¥���
	public void dayPrint(int space,int lastDay) {
		for(int day =1; day<=lastDay;day++ ) {
			System.out.print(day+"\t");
			if((day+space)%7==0){
				System.out.println();	
			}
		}
	}
		
	
		
	public static void main(String[] args) {
		new CalendarOOP(); //��ü���������� �����ɼ��ְ� ����-������ �޼ҵ尡 ȣ���
		
	}

}

/*
 �� ���� �Է¹޾� �޷����
 ������� Scanner ,Calendar �����Ѵ�.
 */
 