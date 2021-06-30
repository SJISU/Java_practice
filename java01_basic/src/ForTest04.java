import java.util.Scanner;
class ForTest04 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("정수입력");
		int max = scan.nextInt();

		int total = 0 , oddTotal=0 , evenTotal=0; //전체합,홀수합,짝수합
		for (int i =1 ; i <= max ; i++ ){ 
			total =total + i; //total+ = i;
			if (i%2 == 0){//짝수
			evenTotal  = evenTotal + i; //
			}else{//홀수
				oddTotal =oddTotal+ i; //		
			}
			
		}
		//결과출력
		System.out.printf("1~%d까지의 합은 %d\n",max,total);
		System.out.printf("1~%d까지의 합은 %d\n",max,oddTotal);
		System.out.printf("1~%d까지의 합은 %d\n",max,evenTotal);
	}
}

/*
실행
정수입력=100
1~100까지의 합은 5050
1~100까지의 홀수의 합은 2500
1~100까지의 짝수의 합은 2550
*/