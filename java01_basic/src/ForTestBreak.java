class ForTestBreak 
{
	public static void main(String[] args) 
	{
		//반복문제어
		//break: 반복문을 중지
		//continue: 반복문을 한번 건너뛰기

		// 1+2+3+4+5.....
		//합이 2021을 최초로 초과하는 경우에 어디까지 더해야 하는지 구하라.
		int sum=0;
		for (int i =1; ;i++ ){
			//합을 게산하기
			sum = sum+i;
			if (sum>=2021){
				System.out.println("1~"+i+"까지의 합은"+sum);
				break;
			}
		} //for
		System.out.println("The End.....");
	}
}
