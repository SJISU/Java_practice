class  Operator1
{
	public static void main(String[] args) 
	{
		//�����ڴ� : ���������, ���׿�����, ���Կ�����, ����(��)������, ���׿�����, ��������
		//1. ��������� : +, -, *, /(��, �Ǽ�),%(������)

		    int num1 = 10;
		    int num2 = 3;

            int result = num1 % num2;
		    System.out.println("result="+result);
			

			//2.���׿����� : ++(1����), --(1����)

			int a = 10;
			a = a + 1; // 1���� �ϴ� ����S
			           //���Կ����ڸ� �������� �����̰��� ���������Ѵ�  
			          
			System.out.println("a="+a);

			//a++;   //1�����ϴ� ����
			++a;
			System.out.println("a="+a);
                 
		    --a;  
			//a--; //1�����ϴ� ���� //a=a-1
			System.out.println("a="+a);
			//a=11

		    int b = a++; //11,12 // �����ڰ� ���� �������� �������� ���� 11�� b�� ���� a�� 12���ȴ�
		    System.out.println("b="+b+", a="+a);
            int c = ++a; //13,13 // ���ʿ� ++��������� a�� 1�����Ͽ��� a�� c�� 13�̴�
			System.out.println("c="+c+", a="+a);

			int result2 = b + c++; //11+13   c->14 //�켱������ �������� �Ұ��ϰ� b+c�� �����Ի��
			System.out.println("result2="+result2+" ,c="+c);

			//int result3 = b + ++c;
			//System.out.println("result3="+result3+" ,c="+c);

			//3.���Կ�����
			// a=13
			a += 4; // a = a+4; ���ʿ� ���� ������ �������� ���������� // a+= 1; a=a+1;   17
			// b=11
			b -= 3; // b = b-3;                                                    8
			// c=14
			c *= 2; // c = c*2;                                                   28
			System.out.println("a="+ a+",b="+b+",c="+c);

			c += a + b; // c= c+ a+ b;
			System.out.println("c="+c);

			//4.�񱳿����ڴ� boolean-true,flase
			
			int x = 200;
			int y = 300;
			 //�񱳿����� : >, >=, <, <=, ==, !=
			boolean boo = x > y; //false
			boolean boo2 = x < y; //true
			System.out.println("boo="+boo);
			System.out.println("boo2="+boo2);

			
			//5.���׿�����
			//�޿��� 10000�� �̻��϶��� ���ʽ� 50%
			//�޿��� 10000�� �̸��϶��� ���ʽ� 90%�� ���� ��� ���ʽ��� ������ ���
			int sal = 12000; //�޿�
			//��� = (���ǽ�)? ���϶� : �����϶�   //���ǽ��� �ݵ�� ���������Ͱ� ������ ����-true��fale�� �����¼��� // ex) a��b���� ũ��       
			double bonus = (sal>=10000)? sal*0.5 : sal*0.9 ;
		    
			System.out.println("sal="+sal+",bonus="+bonus);

			//6.�������� : &&(and), ||(or), !(not)
			int ave = 75; //55�� ������ "�׿�"�� ��õȴ�
			String grade = (ave>=70 && ave<80)? "C": "�׿�" ; 
			System.out.println("grade="+grade);
			
			char ch = 'A'; //char������ �����ϴ�.
			//ch++; // a ������ b �´�
			//ch = ch + 1; ������ ��� ch�� ĳ���͵��������̰� 1�� ������int�� ���� 
			ch = (char)(ch + 1);
			System.out.println("ch="+ch);

			char ch2 = (char)85; //�ƽ�Ű�ڵ� u��� //�빮�� A�� �ڵ尪�� 65 �ҹ��� a�� 97 , LE(10), CR(13)
			System.out.println("ch2="+ch2);

			//�����͵� -2������������ ����


	}
}
