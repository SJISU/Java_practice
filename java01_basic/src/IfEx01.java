import java.util.Scanner;
class IfEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		//1.데이터입력 
		// int first=0, second=0, add=0,minus=0,mul=0,divide=0; 라고 해놓으면 뒤에 int 안붙이고 
		System.out.print("첫번째 정수=");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수=");
		int num2 = scan.nextInt();
        
		 //2.계산
		if(num1>0 && num2>0){

			int add = num1 + num2;
			int minus = num1-num2;
			int multiple= num1*num2;
			int divide= num1/num2;
			//3. 출력
			System.out.println("add="+add); //printf("%5d+%5d=%5d\n",num1,num2,add)
			System.out.println("minus="+minus); //printf(%5d-%5d=%5d\n",num1,num2,minus)
			System.out.println("multiple="+multiple);//printf
			System.out.println("divide="+divide); //printf
		
		}else{
			System.out.println("데이터를 잘못입력하였습니다.");

		}
		}

	
		
}
/*
   두수를 입력받아 입력받은 모두 수가 양수일때는 사칙연산을 한 결과를 출력하고
   두수 모두 양수가 아닐때는 "데이터를 잘못입력하였습니다."라는 메세지를 출력하라
*/