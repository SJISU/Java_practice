import java.util.Scanner;
class  WhileEx01
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("정수입력=");
		int dataInt = scan.nextInt();

		
		int i =1;
		int sum=0, evensum=0 ,oddsum=0 ,threesum=0;
		
		while(i<=dataInt){
           
		   //합
		   sum = sum+i;
		   //짝수합,홀수합
		   if(i%2==0){
				evensum= evensum+i;
		   }else {
				oddsum=oddsum+i;
		   }
		   //3의배수합
		   if(i%3==0){
				threesum+=i;
		   }

		   i++; // 다시 15번재 줄로
			

		}
		System.out.printf("1~%d까지의 합은 %d\n",dataInt,sum);
		System.out.printf("1~%d까지의 홀수의 합은%d\n",dataInt,oddsum);
		System.out.printf("1~%d까지의 짝수의 합은%d\n",dataInt,evensum);
		System.out.printf("1~%d까지의 3의배수의 합은%d\n",dataInt,threesum);
		System.out.println();
	}	
	
	}



/*
임의의 수(정수)를 입력받아 그 수까지 합과, 짝수합,홀수합, 3의배수의 합을 구하여 출력하라.
반드시 반복문은 while문을 활용하라.

실행
정수입력=15
1~15까지의 합은 _____
1~15까지의 홀수의 합은 _____
1~15까지의 짝수의 합은 _____
1~15까지의 3의 배수의 합은_______


*/
