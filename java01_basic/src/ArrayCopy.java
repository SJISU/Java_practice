
public class ArrayCopy {

	public static void main(String[] args) {
		//�迭�� ����
		int num[]= {20,67,15,95,36,48,23,14};
		//			�����迭��     �������index,��������     ����ٿ������ǹ迭��   index        �����ҵ������ǰ���
		// arraycopy(object src, int srcPos,          Objectdest,       int destPos, int length)
		//			num           2                     target          5              3
		//num�迭���� index 2�������� 3���� ���縦 �Ͽ� ���ο� �迭�� �����ϰڴ�
		int target []= new int [10]; // 0,0,0,0,0,0,0,0,0,0
		
		System.arraycopy( num,2,target,5,3);
		
		for(int i =0; i<target.length;i++) {
			System.out.println("target["+i+"]="+target[i]);
		}
		
		
	}

}
