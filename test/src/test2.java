
public class test2 {
	//1~100����� ������ 10�� �����Ͽ� �迭�� ������ ������������ �����Ͽ� ���
	
	public test2() {
		
		
	
	}
		
		
	public static void main(String[] args) {
	
		
int num [] = new int[10];
		
		//��������
		for(int i =0; i<num.length; i++) { // i = 0,1,2,...9
			int random =(int)( Math.random()*(100-1+1))+1;
			num[i] = random;						
		}
		
		//���������������
		System.out.println("������ ������=====================");
		for(int i =0; i<num.length; i++) {
			System.out.print(num[i]+",");
		}
		System.out.println();
		
		// ���° ������ ������
		for(int j =0; j<num.length; j++) { // 0,1,2,3...8
		
			for(int i=0; i<num.length-1-j; i++){ // *length-1 : ��������ĭ���� ���ϸ� �񱳴� �����⶧���� (��ü����-1) �� �ݺ��Ͽ� ���Ѵ�
				if(num[i] > num[i+1]) { //���������϶�
					// ��ȯ�ϱ�
					int temp = num[i];  //ù��° �����Ͱ� �������⶧���� �ӽ÷� ���� �����صд�
					num[i] = num[i+1]; //i�� �������� i+1�� �ȴ�.
					num[i+1] = temp;
				}	
				
				
			}	
			
			
			
		
		}
		System.out.println("������ ������=====================");
		for(int i =0; i<num.length; i++) {
			
			System.out.print(num[i]+",");
		
	
		    
						
		}
		
		
	}

}
