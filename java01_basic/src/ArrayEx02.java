
public class ArrayEx02 {

	public static void main(String[] args) {
		//���� 1~1000 �����ǰ��� 100�� ����� �迭�� �����ϰ�
		//	������ ������ ����ū���� ����������,����� ���Ͽ� ����϶�.
		
		//100���� ������ �迭�� ������
		int data[] = new int [100];  //100�� ������
		
		for(int i =0; i<data.length; i++) {  //����1~1000 �����ǰ�
			data[i]=(int)(Math.random()*1000) + 1; //1000:ū��-������+1 //Math.random()�� ����(?)
			System.out.println(data[i]);
			
		}
		
		//ū��, ������ , ��� - ����������� /�迭�ǰ��� ù��°���� �ִ´� /�׸��� �����迭�� �����̶� ���Ѵ�-��ʸ�Ʈ����
		//data����ŭ �ݺ��Ͽ����Ѵ�
		int sum=0;
		int max=data[0];
		int min=data[0];	
		
		for(int i =0; i<data.length; i++) {
			//sum=sum+data[i]; //�� 
			sum+=data[i];
			
			if(max <data[i]) {
				max = data[i];
			}
			
			if(min>data[i]){
				min = data[i];
				
			}
		}
		
		int ave = sum/data.length;
		
		System.out.println("��="+sum);
		System.out.println("���="+ave);
		System.out.println("�ִ밪="+max);
		System.out.println("�ּҰ�="+min);
		
		
	}

}
