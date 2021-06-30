class PrintfTest 
{
	public static void main(String[] args) 
	{
		//format : 포맷형식
		//  정수: %10d ,실수: %10.3f , 문자열 : %8S , %o(Octal:8진수), %x(hex:16진수) , %c(char) ,
		// 제어문자 : \n, \t, \\, \", \' -애네가 들어오면 줄이 바귄다

        
		int num = 1234;
		System.out.printf("num변수의 \n값은 %10d입니다.\n", num);
		System.out.printf("일정한 \"가격\" \t띄울때...\n"); //""이 출력되게 하고싶을때는 \"문자\"

		double num2 = 2548.2351;
		System.out.printf("num2=%10.3f이다.\n", num2);

		String nameKor = "홍길동";
		String nameEng = "hong";
		System.out.printf("이름은 %-10s이다. \n", nameKor); //-는왼쪽에 배치
	    System.out.printf("이름은 %10s이다. \n", nameEng); //- 없는것은 오른쪽에 배치

		int num3 = 12;
		System.out.printf("%d,  %o,  %x\n" , num3, num3, num3);

	}
}
