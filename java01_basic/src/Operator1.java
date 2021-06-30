class  Operator1
{
	public static void main(String[] args) 
	{
		//연산자는 : 산술연산자, 단항연산자, 대입연산자, 관계(비교)연산자, 삼항연산자, 논리연산자
		//1. 산술연산자 : +, -, *, /(몫, 실수),%(나머지)

		    int num1 = 10;
		    int num2 = 3;

            int result = num1 % num2;
		    System.out.println("result="+result);
			

			//2.단항연산자 : ++(1증가), --(1감소)

			int a = 10;
			a = a + 1; // 1증가 하는 수식S
			           //대입연산자를 기준으로 양족이같은 변수여야한다  
			          
			System.out.println("a="+a);

			//a++;   //1증가하는 수식
			++a;
			System.out.println("a="+a);
                 
		    --a;  
			//a--; //1감소하는 수식 //a=a-1
			System.out.println("a="+a);
			//a=11

		    int b = a++; //11,12 // 연산자가 변수 오른족에 있을때는 위에 11이 b로 간다 a가 12가된다
		    System.out.println("b="+b+", a="+a);
            int c = ++a; //13,13 // 왼쪽에 ++가있을대는 a가 1증가하여서 a도 c도 13이다
			System.out.println("c="+c+", a="+a);

			int result2 = b + c++; //11+13   c->14 //우선순위가 높은데도 불과하고 b+c가 먼저게산됨
			System.out.println("result2="+result2+" ,c="+c);

			//int result3 = b + ++c;
			//System.out.println("result3="+result3+" ,c="+c);

			//3.대입연산자
			// a=13
			a += 4; // a = a+4; 양쪽에 같은 변수가 있을때는 한족을빼고 // a+= 1; a=a+1;   17
			// b=11
			b -= 3; // b = b-3;                                                    8
			// c=14
			c *= 2; // c = c*2;                                                   28
			System.out.println("a="+ a+",b="+b+",c="+c);

			c += a + b; // c= c+ a+ b;
			System.out.println("c="+c);

			//4.비교연산자는 boolean-true,flase
			
			int x = 200;
			int y = 300;
			 //비교연산자 : >, >=, <, <=, ==, !=
			boolean boo = x > y; //false
			boolean boo2 = x < y; //true
			System.out.println("boo="+boo);
			System.out.println("boo2="+boo2);

			
			//5.삼항연산자
			//급여가 10000원 이상일때는 보너스 50%
			//급여가 10000원 미만일때는 보너스 90%를 받을 경우 보너스가 얼마인지 계산
			int sal = 12000; //급여
			//결과 = (조건식)? 참일때 : 거짓일때   //조건식은 반드시 논리형데이터가 나오는 수식-true나fale가 나오는수식 // ex) a가b보다 크냐       
			double bonus = (sal>=10000)? sal*0.5 : sal*0.9 ;
		    
			System.out.println("sal="+sal+",bonus="+bonus);

			//6.논리연산자 : &&(and), ||(or), !(not)
			int ave = 75; //55를 넣으면 "그외"가 출련된다
			String grade = (ave>=70 && ave<80)? "C": "그외" ; 
			System.out.println("grade="+grade);
			
			char ch = 'A'; //char연산이 가능하다.
			//ch++; // a 다음에 b 온다
			//ch = ch + 1; 오류가 뜬다 ch는 캐릭터데이터형이고 1은 문자형int라서 오류 
			ch = (char)(ch + 1);
			System.out.println("ch="+ch);

			char ch2 = (char)85; //아스키코드 u출력 //대문자 A는 코드값이 65 소문자 a는 97 , LE(10), CR(13)
			System.out.println("ch2="+ch2);

			//어려운것들 -2진수를가지고 연산


	}
}
