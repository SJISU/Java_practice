import java.util.Scanner;
class ForDiamond 
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
    
		
		//�ﰢ�������
			for ( int row=1 ; row<=max ; row+=2){//�� 1,3,5,7,9,11......max

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
				System.out.println();
			}
	//===================================================================================
			 for (int row=max-2 ;row>=1 ;row-=2 ){ //13�� ���Ӵٰ� �ϸ� 11,9,7,5,3,1�� ��6�� ���
				
				//����
				for (int s=1;s<=(max-row)/2 ;s++){
					 System.out.print(" ");
				}
				//1�ٹ��� : row�� ���� ������ŭ ������ȴ� : 11,9,7,5,3,1 ��ŭ ���
				for (int cnt=1;cnt<=row ;cnt++ ){
					 System.out.print(txt++);
					if(txt>'Z'){
					   txt = 'A';
					}
				}
				//�ٹٲ�
				System.out.println();
			}
		
	}
}
