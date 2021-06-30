import java.util.Scanner;
import java.util.Calendar;
class  CalendarEx
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�⵵=");
		int year = scan.nextInt();
		System.out.print("��=");
		int month = scan.nextInt();


		//�������
		System.out.printf("\t\t%d�� %d��\n",year,month);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

		//���� ��¥ �ð� ��ü ���ϱ�
		Calendar date = Calendar.getInstance();
		date.set(year,month-1,1);  // ��¥ ����  1��->0 2��->1.....5��->4,6��->5 
								   //��ǻ�ʹ�0������ ����ϱ⶧���� �Է¹��� ������ 1�������� ����ؾ� �Է��� ���� ���´�.
		
		//���ϱ��ϱ� //���鱸�Ҽ��ְԵ�-���Ͻ����ϴ� �������� ������ ������ ����
		int week = date.get(Calendar.DAY_OF_WEEK); 

		//���Ǹ�������
		// 1 , 3 , 5 , 7 , 8 , 1 0 , 12 ->31��
		// 4, 6 , 9 , 11 ->30��
		//2 -> 28,29��
		
		
		/*
		int lastDay = 31 ; //31�� ���� �����ϱ� �ʱⰪ�� 31�� ����
		switch (month){
			case 4 : 
			case 6 :
			case 9 :
			case 11 :
				lastDay=30; break;		
			case 2 :
				//�⵵�� 4�� ���������� 100���� �ȳ��������� 28��(���)
			    //400���� ���������� ����
				if(year%4==0 && year%100 !=0 || year%400==0 ){
					lastDay = 29;
					}else{
					lastDay=28;
				}
		}
	    */

		//�������� //getActualMaximum - ()�߿�����ū����������ش� ex)���߿� ����ū��-12
		int lastDay =date.getActualMaximum(Calendar.DAY_OF_MONTH);		
			
		
		//������� ����= ����-1
		//���� ������� �ٹٲ�
		for(int s=1; s<week; s++){
			System.out.print("\t");			
		}		
		//��¥��� :1���� lastDay���� ���
		for(int d=1; d<=lastDay;d++){
			System.out.print(d+"\t");
			if((d+week-1)%7==0){ //����ѹ����� ������ 7�� ������̸� �ٹٲٱ� //week-1 = ����
				System.out.println();				
			}			
		}		
	}
}


/*
1. �޷�: ù��°���� *��⿡Ȱ�� -> ������ ���ؼ� ����+�ϼ�
��ĭ(����-1)
	  ��ĭ
��-> 1  0
��   2  1
ȭ   3  2
.
.
.
��  7    6

2.������ �����Ͱ� 7���� ������ �� �����ٷ� �Ѿ���Ѵ� 
�����ʹ� 1�� ����
---1234 : ��7��
��ĭ+���� �� 7�� ����� �Ǿ���� //��ĭ�� ������ ����-1

3.�������� -> ������ �ٸ���



*/
