import java.util.Random;
public class RandomTest {

	public static void main(String[] args) {
		//Random : ���� ����Ŭ���� //static�� ���⶧���� ��ü��������
		Random ran = new Random();
		
		for(int i =1; i<=1000; i++) {
			
			//����(int)�� �����ִ� ���� //��ü��.nextInt();
			//int random = ran.nextInt(); //-21��~21��
			//int random = ran.nextInt(100); //0~99������ ����
			//int random = ran.nextInt(50); //0~49������ ����
			//boolean random = ran.nextBoolean(); //����-true,false
			//50~100 ������ ���� �������ض� -> ū��-������+1 �ϸ� 0~51 �����ϱ� +������(50)
			int random = ran.nextInt(51)+50;
			System.out.print(random+"\t");
			
			if(i%10==0){
				System.out.println();
				
			}
		}
	}

}
