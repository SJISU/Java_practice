import java.util.Scanner;
class SwitchEx 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//for(int i =1;;){ 
		System.out.print("����=");
		int kor = scan.nextInt();
		System.out.print("����=");
		int eng = scan.nextInt();
		System.out.print("����=");
	    int math = scan.nextInt();

		int total = kor+eng+math;
		double avg =total/3.; 
        		
		String grade = " ";
		switch((int)avg/10){    //10,9,8,7,6,5,4,3,2,1,0
		case 10 :
		case 9 :
			grade = "A";
			break;
		case 8 : 
		    grade = "B";
		    break;
	    case 7 :
			grade = "C";
			break;
	    case 6 :
			grade = "E";
			break;
		default:
			grade = "F";
		}//swtich

		System.out.printf("����=%d\n���=%f\n����=%s\n", total,avg,grade);
		// } //for��
	}//main
}//class

/*
           ����,����,���������� �Է¹޾� ����,���,������ ���Ͽ� ����϶�.
		   �������� ������ 0~100�� ������ ���̴�.
		   ����� �Ǽ��� ���Ѵ�.

           ������ switch������ �ۼ��Ѵ�.
		   ����
		   90~100 A
		   80~89 B
		   70~79 C
		   60~69 D
		   0~59  F

		   ����
		   ����=
		   ����=
		   ����=
		   ===================
		   ����=
		   ���=
		   ����=

*/
