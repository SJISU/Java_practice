import java.util.Arrays;

public class ArraysTest {

	public ArraysTest() {
		// Arrays : �迭���� ó�� Ŭ����
		int [] data = {15,90,45,75,26,95,48,9,12,40};
		//Arrays.sort(data); //�迭�� ����Ǿ� �ִ� �ּҰ� ����....
		//������������ �迭�� ���ĵ�
		Arrays.sort(data); //�Ϻθ� ���� ..2~4��°�� �ִ� �͸� ���ĵ�...2�������� 5�ձ����� ���ĵ�..
		
		//toString() : �迭���
		System.out.println(Arrays.toString(data));//�ּҰ� �����Ƿ� toString���� �迭�� ������������ ������ ����..
	}

	public static void main(String[] args) {
		new ArraysTest();

	}

}
