class ForTestBreak2 
{
	public static void main(String[] args) 
	{
		abc://�󺧸�
		for (int i =1 ; i<=10 ; i++ ){

			for (int j =1 ; ;j++ ){
				System.out.println("i="+i+",j="+j);
				if (j>5){
					break abc;
				}
			}
			//////break �� ����� �Ѿ��
			/// �󺧸��� �����ٸ� break���� �ٽ�6���ΰ��� i=2�� ����Ǿ������̳� �󺧸��� �Ǿ� for��ü�� ����
			

			/*
			if (i>3){
				break;
			}
			*/
		
		}//for
		System.out.println("========");
	}
}
