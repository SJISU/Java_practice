import java.util.Scanner;
class  DoWhileEx
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int option=0;
			do{
			System.out.print("금액을 입력하세요.?");
			int data = scan.nextInt();
		
			while(true){
			
			int a = data/50000 ;
			System.out.println("50000원 ="+a+"장");

			int b = data-a ;
			int c = b/10000 ;
			System.out.println("10000원="+c+"장");

			int d =data-50000*a-10000*c;
			int e = d/5000;
			System.out.println("5000원="+e+"장");

			int f = data-50000*a-10000*c-5000*e;
			int g = f/1000;
			System.out.println("1000원="+g+"장");

			int h = f-1000*g;
			int i = h/100 ;
			System.out.println("10원="+i+"개");

			int j = h-100*i;
			int k =j/10;
			System.out.println("10원="+k+"개");

			if(data==0)
				break;
			}
		System.out.print("다시 하시겠습니까?(1.예, 2.아니오)");
		option = scan.nextInt();
		}while(option==2);

	}
}


/*
실행
금액을 입력하세요.? 126300
50000원 = 2장
10000원 = 2장
5000원 = 1장
1000원 = 1장
100원 = 3개
다시하시겠습니다(1.예, 2.아니오)?

금액을 입력하세요.?5435
5000원 = 1 장
100원 = 4개
10원= 3개
1원=5개
다시하시겠습니다(1.예, 2.아니오)?

*/