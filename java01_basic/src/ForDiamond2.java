import java.util.Scanner;
class ForDiamond2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Ȧ��(1~49)�Է�=");
		int max = scan.nextInt(); //13�Է�
		
		//¦���ϰ�� Ȧ���� ����
		
		if(max%2==0){ 
			max ++;
		
		}
		//����� ���� �ʱⰪ
		char txt = 'A';
		int step = 2;    //���� ���� : �����ϴºκ��� ��Ÿ��������
    
		
		//�ﰢ�������
			for ( int row=1 ; row>0 ; row+=step){//�� 1,3,5,7,9,11......max // row<=max  ----> row>0

				//���� 
				for (int s =1; s<=(max-row)/2 ;s++ ){ //row:���ٿ� ����� �����Ǽ�
					System.out.print(" ");
				}

				//���� row��ŭ ���ڷ��
				//1�� �������
				for (int cnt=1;cnt<=row ;cnt++ ){ // 1~1 
					System.out.print(txt++);
					if(txt>'Z'){//z�� ����ϰ� ���� A�� �ǵ�����
						txt = 'A' ;
					}
				}
				//1�ٳ����� �ٽ� FOR�� �ö� �׸��� �Ʒ������� �ٹٲٰ� �ٽ�2������ ���� �ݺ�
				System.out.println();  //13�� ��� �����ϴ� ���� //���⼭ Ȯ���Ѵ�:max�� ���޿���
				
				if(row>=max){
					step=-2;
					
				}


			}
	// max �� �����ϸ� �����Ѵ� �̶� �������ϴ� ���� �ϳ��� ������ָ�ȴ�
		
	}
}
