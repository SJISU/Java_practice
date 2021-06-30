import java.util.Scanner;
class IfTest 
{
	public static void main(String[] args) 
	{
		// 어떤수를 입력받아 짝수일때 출력 아니면 출력하지말아라
		 //어떤수를 입력받아 3의배수일때 출력 아니면 출력하지말아라
	   Scanner scan = new Scanner(System.in);
       
	   System.out.print("0보다 큰 정수를 입력하세요...");
	   int num = scan.nextInt();

	   //if(num%2 == 0){
	   //if(num/2 == num/2.0){
	   if(num%3 == 0){ //3의배수
		// if(num/3 != num/3.0){ //3의배수가 아닐때
		  
		  //System.out.printf("%d는 짝수입니다.\n", num);
		    System.out.printf("%d는 3의 배수 입니다.\n", num);


	   }

	   System.out.println("End....");



		
		
		//int a = 100+200;
		//if(true){ //if(a>0)
		//System.out.printf("조건문 내의 문장이 실행됨..."); // if(a+b) : 논리형이 아니기 때문에 오류
		//}

	}
}


/*

   if문
   조건문은 반드시 논리형(참,거짓)결과여야 한다.

   if(조건문 or 수식 or 변수 or 상수){
	   참일때 실행할 실행문;
	   실행문;
	   실행문;

    }

	*/