class Variable //클래스다음에 오는것은 대문자로 시작하고 합성어 일때는 각단어의 첫번째문자를 대문자로 한다.
               //길이는 256글자까지 가능
{
	public static void main(String[] args) //main은 메소드
	{
		//변수란 : 값 또는 데이터를 보관하는 기능을 가진다.
		//국어 50점, 영어 80점, 수학 70점
		//데이터를 보관할때 변수사용
		//기본데이터 형(타입) : 정수 -> byte(1byte=8bit), short(2byte),int(4byte),long(8byte)-8바이트 즉 8칸을 만들어서 한데이터를 넣는것
		//                  실수 -> float(4byte),double(8byte)
		//                  논리 -> boolean(1byte)
		//                  문자 -> char(2byte)

		//                  래퍼런스형
		
		//byte kor = 50, // 1byte-바이트 잘안씀...정수형 //kor은변수
		int kor2 = 50; //4byte-4바이트를 확보해서 50저장 -은50상수
		int eng = 80;
		int math = 70;
		               // 정수형 상수는 "int"(기본데이터타입)형이다. 
		//변수 생성 규칙
		//        첫번째글자는 소문자로 시작하거나,_,$로 시작할수 있다.
		//        합성어일때는 두번째 이후 단어는 대문자로 시작한다.
		//        명령어(예약어)를 변수로 사용할수 없다.
		//        name,_name,$name -가능
		//        9name,*name,if(예약어-명령어).... -불가능

		//계산
		// 연산자 : +,-,*,/,%(나머지구하기)

		int sum = kor2+ eng + math ;
		//          정수 , 정수 = 정수 (정수랑 정수를 계산하면 정수)
		//          정수 , 실수 = 실수
		//          실수 , 정수 = 실수
		//          실수 , 실수 = 실수

		double ave = sum/3.0; // 실수의 기본 데이터타입은 "double", 정수랑 실수랑 계산하면 실수니깐 더블
		                      // 31.4(float 형)

		System.out.println("총점="+ sum);
		System.out.println("평균="+ave);

		boolean state = true; // true,flase(1byte) "state는변수"
		char lastName= '홍';
		String firstName = "길동";

		//float data = 3562.3265; //(3562,.3625는 더블형데이터로 float에 넣을수 없다.)
	    //double data = 3562.3265;- 가능
		//int data2=12.1; -불가능
	
       //형변환
      float data = (float)3562.3265;
      int data2=(int)12.1;
	  

      //큰 데이터형의 데이터를 작은 데이터형의 변수에 대입할때는 형변환을 하면된다.
      //작은 데이터형의 데이터를 큰 데이터형의 변수에 대입할때는 형변환 하지 않아도 된다,
	  double data3 = 1234567;
	           
	}
}