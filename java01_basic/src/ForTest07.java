class  ForTest07
{
	public static void main(String[] args) 
	{
		//중첩 for문
		/*
		1  2  3  4  5
		6  7  8  9  10
		11 12 13 14 15
		16 17 18 19 20
		21 22 23 24 25
		*/
		
		
		int a = 1; //초기값이 1 이면 a++ , 0이면 ++a
		for (int i = 1 ; i <=5 ;i++ ){//1,2,3,4,5  -행
			
			for ( int j=1; j<=5 ; j++){//1,2,3,4,5 -열(칸수)
				System.out.print(a++ +"\t");
			}
			
			System.out.println(); //줄바꿈
		}

		System.out.println("===================================");
		
		//중첩안하고 하나의 for문으로 만들기
		for (int i = 1; i<=25 ; i++ ){//1,2,3,4...25
			System.out.print(i+"\t");
			//System.out.print("*");

			if (i%5 == 0){
				System.out.println();
			}

		}
		System.out.println("===================================");
        /*
		1
		1 2
		1 2 3
		1 2 3 4
		1 2 3 4 5
		*/
		for (int i =1; i<=5 ; i++ ){
			for ( int j =1 ;j<=i ; j++ ){
				System.out.print(j+" ");
			}
			System.out.println();
		}

		System.out.println("===================================");
		/*
		12345
		1234
		123
		12
		1
		*/	
		for (int i = 5; i>=1 ; i-- ){//5,4,3,2,1
		for (int j=1;j<=i ;j++ ){
				System.out.print(j);
			}
				System.out.println();

		}
        
		System.out.println("===================================");
		
		/*
		*****
		****
		***
		**
		*
		*/
	
		for(int i=5; i>=1; i--) {
			
			for(int x=1; x<=i; x++ ) {
				System.out.print("*");
			}
			System.out.println();
		}		
		
		System.out.println("===================================");
		
		/*
		
		*****
		 ****
		  ***
		   **
		    *
		
		*/
		for (int i=5; i>0 ;i-- ){//5,4,3,2,1
			//공백
			for(int s=1; s<=5-i ; s++ ){ //0,1,2,3,4
				System.out.print(" ");
			}
			//문자
			for(int j=1;j<=i ;j++ ){ //한줄찍히고 그다음줄찍히고
				System.out.print("*");
			}
			//줄바꿈
			System.out.println();
		}
		System.out.println("===================================");

	/*
	        *
		   ***
		  *****
         *******
        *********
	   ***********

	*/

	for(int i =1; i<=11 ;i+=2 ){//1,3,5,7,9,11
        //공백 : 11(총문자수)-한줄에출력할별문자수 나누기 2 한만큼
		for(int s=1 ;s<=(11-i)/2 ;s++ ){
			System.out.print(" ");
		}
		//문자출력-별찍기
		for(int j =1; j<=i; j++){
			System.out.print("*");
		}
		//줄바꿈
		System.out.println();

	}

	/*
	***********
	 *********
	  *******
	   *****
	    ***
		 *	
	*/



	}
}





