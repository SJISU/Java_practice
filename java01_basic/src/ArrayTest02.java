
public class ArrayTest02 {

	public static void main(String[] args) {
		//2���� �迭  : ��� ���� ������.
		
		//�迭�� ����
		//      �� ��
		int data[][] = new int[5][5] ; //int25���� ���尡���� ���� ������
		
		data[0][3] = 100;
		data[1][2] = 85;
		data[1][4] = 84;
		data[3][3] = 77;
		
		//2���� �迭 ��� //�� for���� '��' �� for���� '��'
		for(int r=0; r<data.length; r++) { //���� �� ��ŭ //length : 2�����迭�϶��� ���Ǽ�,1�����迭�϶��� �����ǰ���
			for(int c=0; c<data[r].length; c++){ // data[r].length -> r���� ĭ�� //r���� ĭ����ŭ ��������
				System.out.print(data[r][c]+"\t");
				
			}
			System.out.println();
		}	
		
		
		//2���� �迭�� �ʱⰪ ����
		String[][] jusorok = {
							   {"ȫ�浿","010-1234-5678","abcd@naver.com"},
							   {"�̼���","010-1234-5678","dfgh@naver.com"},
							   {"�������","010-2345-6789","tyui@naver.com"}						   
		
							  };
			for(int r=0; r<jusorok.length; r++) {
				for(int c =0; c<jusorok[r].length; c++) {
				System.out.print(jusorok[r][c]+"\t");
				
				}
				System.out.println();
			}
		}
}
							   	
