import java.util.Scanner;
class ForTest03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("단입력=");
		int data = scan.nextInt();

		for (int i =2 ; i<=9 ; i++ ){ //i=2,3,4,5,6,7,8,9

			int result = data * i;
			//System.out.println(data+"*"+i+"="+result);
			System.out.printf("%d * %d = %d\n",data,i,result);

		}
		
	}
}


/*

실행
단입력=5
5 * 2 = 10
5 * 3 = 15
:
:
5 * 9 = 45
*/
