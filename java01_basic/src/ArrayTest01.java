
public class ArrayTest01 {

	public static void main(String[] args) { //main���� String[]
		//�迭�� '���� ���������� ����'�� ������ �����Ҷ� �ʿ��ϴ�.
		//�迭�� �ѹ� �����Ǹ� ũ�⸦ �����Ҽ�����. -> �ذ��ϴ� �پ��� ����� �ִ�.
		
		//int[]num;			1.�迭 num�� ����(1�����迭)-��������
		//num = new int[5];  2.�迭�� ����(int�������x5)
		//�迭�� ����� ������ ���ÿ�
		int num[] = new int[50]; //����:0(�ʱⰪ), �Ǽ�:0.0 , ����:false(�ʱⰪ) :�޸𸮰� �Ҵ��
		
		String name[] = new String[5]; //null
		
		num[2] = 100; //�ε��� 2���� 100�����ž� �ٸ��ε������� ���� ���⶧���� null
		name[1] = "ȫ�浿"; //�ε���1���� ȫ�浿 �����ž�
		
		System.out.println("num[1]=>"+num[1]);
		System.out.println("name[1]=>"+name[1]);
		
		//num�迭�� ��簪�� ����϶�.
		// num[0], num[1], num[2] , num[3], num[4]
		//�迭��.length -> �迭�� ������ ���Ͽ� �ش�.	
		for(int idx=0; idx< num.length ; idx++) { //0
			System.out.println("num["+idx+"]="+ num[idx]);
		}
		
		//�迭�������ÿ� �ʱⰪ �������ϴ� �����ͷ� ����
		//�迭 ������ �ʱⰪ �����ϴ� ���
		int[] data2= new int[] {20,65,74,5,87,2} ;//�ʿ��ѵ����͸��� -6���� ������ Ȯ����
		for(int i=0; i<data2.length; i++) {
			System.out.println("data2["+i+"]="+data2[i]);
			
		}
		
		//�迭 ������ �ʱⰪ �����ϴ� ���2
		int data3[] = {8,7,5,37,75};
		for(int i=0;i<data3.length ; i++) {
			System.out.println("data3["+i+"]="+data3[i]);
		}
		
			

	}

}
