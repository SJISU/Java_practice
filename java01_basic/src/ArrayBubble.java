
public class ArrayBubble {
	public static void main(String[] args) {
		//1~100������ ������ 10�� �����Ͽ� �迭�� ������ ������������ �����Ͽ� ����϶�.
		
		//10���� �����͸� ���� ��ü �����
		int[]num = new int[10];
		
		//���� ����
		for(int i =0; i<num.length; i++) {
			int random = (int)(Math.random()*(100-1+1))+1;
			num[i] = random;
			
		}
		System.out.println("���� �� ������");
		for(int i=0; i<num.length; i++){
			System.out.print(num[i]+",");
			
		}
		System.out.println();
		
		for(int j=0; j<num.length-1;j++ ) {
			for(int i=0; i<num.length-1-j;i++) {
				if(num[i]>num[i+1]) {
					//��ȯ�ϱ�
					int temp = num[i];
					num[i]=num[i+1];
					num[i+1] = temp;
				}
				
			}
			System.out.println(j+1+"�� ���� �� ������");
			for(int i =0; i<num.length;i++) {
				System.out.print(num[i]+",");
			}
			System.out.println();
		}
		
	
	
	}

}
