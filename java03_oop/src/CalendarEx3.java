import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx3 {
	
	int year,month,week,lastDay;
	Scanner scan = new Scanner(System.in);
	public CalendarEx3() {
		
	}
	
	//������ �Է¹޶� ȣ��
	void setData(){
		System.out.print("�⵵=");
		year= scan.nextInt();
		System.out.print("��=");
		month= scan.nextInt();
		}
	//���� ��¥ �ð� ��ü ���ϱ�
	void now (){
		Calendar date = Calendar.getInstance();
		date.set(year,month-1,1);
		week = date.get(Calendar.DAY_OF_WEEK); 
		lastDay =date.getActualMaximum(Calendar.DAY_OF_MONTH);
	}	
	//ù°�� ���
	void print1 () {
		System.out.println("\t\t"+year+"��"+ month+"��");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

	}
	//�� ���
	void print2 () {
		for(int s=1; s<week; s++){
			System.out.print("\t");			
		}		
		
		for(int d=1; d<=lastDay;d++){
			System.out.print(d+"\t");
			if((d+week-1)%7==0){
				System.out.println();				
			}			
		}		
		
	}
	
	void start() {
		setData();
		now ();
		print1 ();
		print2 ();
	}
	
	public static void main(String[] args) {
		CalendarEx3 sw = new CalendarEx3();
		sw.start();

	}

}
