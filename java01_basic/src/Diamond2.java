2import java.util.Scanner;
class Diamond2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("������ Ȧ���Է�=");
		int max = scan.nextInt();
		
		int result = 0;
		if(max%2==0){ 
			result = max + 1 ;
			
		}else{ 
			result= max;
			
		}
		
		System.out.print("������ Ȧ��="+result+"\n");

        char a = 'A';
		
		
		for ( int i=1 ; i<=max ; i+=2){

			//���� 
			for (int s =1; s<=(max-i)/2 ;s++ ){
				System.out.print(" ");
			}

			//����
			for (int j=1;j<=i ;j++ ){
				//for(char a = 'A'; a<='Z';a++){System.out.print(a);}
				System.out.print(a++);
			}
			System.out.println();


		}
		
		
		for (int i=max ;i>0 ;i-=2 ){
			
			//����
			for (int s=1;s<=(max-i)/2 ;s++){
				System.out.print(" ");
			}
			//����
			for (int j=1;j<=i ;j++ ){
				System.out.print(a++);
			}

			System.out.println();
		}
		

	}
}
