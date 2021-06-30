class  Gugudan
{
	public static void main(String[] args) 
	{
		System.out.println("\t구구단");

		for (int dan=1 ;dan<=9; dan+=3){ //단=1,4,7 
			//단 타이틀
			for (int i =dan; i<dan+3 ;i++ ){ //dan =1 1,2,3, dan=4 4,5,6, dan=7 7,8,9 
				System.out.print("=="+i+"단==\t");
			
			}
			System.out.println();

			//3단 구구단 출력
			for (int k=2 ; k<=9; k++ ){// 2,3,4,5,6,7,8,9
				for (int z = dan; z<dan+3 ; z++){//dan =1 1,2,3, dan=4 4,5,6, dan=7 7,8,9
					int result = z*k;
					System.out.print(z+"*"+k+"="+result+"\t");
				}
				System.out.println();

			}
		}
	}
}
