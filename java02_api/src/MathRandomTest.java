
public class MathRandomTest {

	public static void main(String[] args) {
		//���� : ��ǻ�Ͱ� ����Ǵ� ������ 0.0~1.0 ������ ���� �����ȴ�.
		
		// *100 -> 0~99		*50->0~99		���ϴ¼���100�̸� 0����99�������´�
		
		//Q.	->50~100   ������ 50����100���� ����϶�
		for(int i=1; i<=1000; i++){
			double ran= Math.random();
			
			//			(����ȭ)����*(ū��-������+1)+������  : ������ ���ϴ� ����
			//							6-1+1
			int ranInt = (int)(ran*(100-50+1))+50;
			
			//int ranInt= (int)(ran*10); // (ran*50) (ran*100) (ran*1000)
			System.out.print(ranInt+"\t");
			if(i%10==0)System.out.println(); //10���� ���
			
		}
		
		//===================================================
		for(int i=1; i<=1000; i++) {
			int random =(int)(Math.random()*51)+50;
			System.out.print(random+"\t");
			if(i%10==0) {
				System.out.println();
			}
		}

	}

}
