class PrintfTest 
{
	public static void main(String[] args) 
	{
		//format : ��������
		//  ����: %10d ,�Ǽ�: %10.3f , ���ڿ� : %8S , %o(Octal:8����), %x(hex:16����) , %c(char) ,
		// ����� : \n, \t, \\, \", \' -�ֳװ� ������ ���� �ٱϴ�

        
		int num = 1234;
		System.out.printf("num������ \n���� %10d�Դϴ�.\n", num);
		System.out.printf("������ \"����\" \t��ﶧ...\n"); //""�� ��µǰ� �ϰ�������� \"����\"

		double num2 = 2548.2351;
		System.out.printf("num2=%10.3f�̴�.\n", num2);

		String nameKor = "ȫ�浿";
		String nameEng = "hong";
		System.out.printf("�̸��� %-10s�̴�. \n", nameKor); //-�¿��ʿ� ��ġ
	    System.out.printf("�̸��� %10s�̴�. \n", nameEng); //- ���°��� �����ʿ� ��ġ

		int num3 = 12;
		System.out.printf("%d,  %o,  %x\n" , num3, num3, num3);

	}
}
