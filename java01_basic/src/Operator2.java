class Operator2 
{
	public static void main(String[] args) 
	{
		// ��Ʈ ������ : &, |, ^(XOR), ~  -> 2���� �����͸� �̿��� ������
		 int a = 12;
		 int b = 4;

		 int result = a & b; // 1:true , 0:false //and true false 
		 System.out.println("result="+result);

		 int result2 = a | b; //or true false
		 System.out.println("result2="+result2);

		 //^(XOR) �ΰ��� �ٸ��� ���̴�	
		 int result3 = a ^ b;
		 System.out.println("result3="+result3);

		 //~ (����) true�� false�� false�� true
		 // ������ �����͸� ȯ���ϴ� ��� : 2���� -> 1�Ǻ��� +1
		 // 1�Ǻ����� 0�� 1�� 1�� 0���� �ٲٴ°��̴�.
		 
		 int result4 = ~ a; //-13
		 System.out.println("result4="+result4);

		 // ����Ʈ ������ : ��Ʈ�� �̵�
		 // << : ��Ʈ�� �������� �̵��Ѵ�. *���(������ ���� ���ϱ���)
		 // >>(��ȣ),>>>(0) : ��Ʈ�� ���������� �̵��Ѵ�. : ������(��ȣ)�� ä��Ͱ����� 0�� ä�������, /(��������)
		 
		 int result5 = a << 2; //�������� 2bit�̵� , �������� 0���� ä��
		 System.out.println("result5="+result5);

		 int result6 = a >> 2; //���������� 2bit�̵��ϰ� ���� ���� �ڸ��� ��ȣ�� ä������. /3 12������4
		 int result7 = result4 >> 2; //-4
		 System.out.println("result6="+ result6);
		 System.out.println("result7="+ result7);

		 int result8 = result4 >>> 2;
		 System.out.println("result8="+result8);

		

		 
		 
	}
}
