import java.util.Scanner;
class IfElseTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //스캔너는 래퍼선스 변수,변수는 한번만 정의할수있다
		//입력받음 임의의 값이 짝수면 100을 곱하여 출력
		//                홀수면 200을 곱하여 출력

		System.out.print("양의 정수를 입력=");
		int data = scan.nextInt();

		/*
			if(data%2 == 0){//짝수
		    int result = data*100; //data = data*100로 만들면 위에 data값이 100곱한값으로 바뀌니깐 변수 int result로 설정
			System.out.printf("%d--> %d\n", data, result);

		}else{//홀수
			int result = data*200;
			System.out.printf("%d-->%d\n",data, result);

		}
         */

      int result = 0;
      if (data%2 == 1){ //홀수
		 result = data*200;
      } else{//짝수
		 result = data*100;
	  }

       System.out.printf("%d-->%d\n", data, result);

	}
}


/* 

  if ~ else 문

  if (조건문){
	  조건문이 참일때 실행;
  }else{
	  조건뭔이 거짓일때 실행;
  }

  */