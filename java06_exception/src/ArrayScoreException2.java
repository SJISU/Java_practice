import java.util.Scanner;
public class ArrayScoreException2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print("�л���=");
			int cnt = Integer.parseInt(scan.nextLine());
			
				
			//������ ������ ���� Ȯ��
			String name[] = new String[cnt]; //�л��̸��� ������ �迭,
			int [][]jumsu = new int[cnt+2][6];//������ ������ �迭 //�л��������� //3���̸� 5��6�� 7���̸� 9��6�� 10�� 12��6��
											 //[�Է¹��� �̸���+2(����,���)][����+���� ��� ����]
			//�̸��� ������ �Է¹޾� �迭�� ����
			String title[] = {"����","����","����"}; //����Ÿ��Ʋ���̶� ����Ǵ� ��ġ�� ����
			
			for(int i=0;i<cnt; i++){ //0,1,2 <-���ȣ
				
				System.out.print("�̸�=");
				name[i] = scan.nextLine();
				
				for(int j=0; j<title.length; j++){ //0,1,2 <-����ȣ
					
					System.out.print(title[j]+"=");
					jumsu[i][j]= Integer.parseInt(scan.nextLine());
				}			
			} //������� �̸����ְ� ���� �� �ִ�.
			
			//***************************��±����ϰ� �ö�ͼ� �ٽ� ���κ� ������ ��� ,���� ������ ���Ѵ�.
			//���κ� ����, ���
			//���� ����
			for(int i=0; i<cnt; i++) { // 0,1,2//�л�����ŭ������ //0��0���϶���
				for(int j=0; j<3; j++) {//0,1,2
				jumsu[i][3]+=jumsu[i][j]; //���κ�����
				jumsu[cnt][j]+=jumsu[i][j];//��������
				
				}
				//���κ����
				//0���� 3�����ִ°� 3���� ����� 4����
				jumsu[i][4]=jumsu[i][3]/3;
			}
			//**************************************** �ٱ��ϰ� ���� ������հ� ���� ���ϱ�
			//���� ��� //���ó���� ������ ������� ���Ҽ��ִ�.
			for(int i =0; i<3; i++) {
			jumsu[cnt+1][i]= jumsu[cnt][i]/cnt;		
			}
			
			//�������ϱ�-�л�����ŭ������
			for(int i=0; i<cnt;i++) { //0,1,2,3
				//i�� ����������ġ
					for(int j=0; j<cnt; j++) {//j�� ���� �ٸ����������
						// ������           ��������
						if(jumsu[i][3] < jumsu[j][3]) { //i��°3���� ������
							jumsu[i][5]++; //������ �������� ��������� 0���� +1�� ����,�����پ�ũ�����ȵ�
						}
					}
					jumsu[i][5]++; //*****?
			}
			//���������� ���� -��������
			for(int i=0; i<cnt-1; i++) { //3���̸� ->0,1 
				//               3-1-0
				for(int j=0; j<cnt-1-i; j++) { //3���̸�->0,1
					if(jumsu[j][5] > jumsu[j+1][5]){ //������ �� 5���� ����
						//��ȯ
						//�̸��ٲٱ�
						String nameTemp = name[j];
						name[j]=name[j+1];
						name[j+1]= nameTemp;
						
						for(int k=0; k<jumsu[j].length;k++) {//j ����ĭ����ŭ
							int temp = jumsu[j][k]; //j���� ���������� k�� �ΰ�
							jumsu[j][k] = jumsu[j+1][k];
							jumsu[j+1][k] = temp;
						}  					
					}
				}
			}		
			
			System.out.println("===================================================");
			System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
			System.out.println("===================================================");
			
			//�̸��� ���ʿ� ��� �̸��� �����迭�� �ε����� ������ �����ؼ� ���� �л�����ŭ������
			//���
			for(int i=0;i<cnt; i++){ //i=0
				//�̸��������
				System.out.print(name[i]+"\t");
				//���� ��� : ù��° ����� ���� ���� ���� ���� ��� ���� ������ //���ȣ�� �������� ���� �ٲ��ȴ�
				for(int j=0; j<jumsu[i].length; j++) {
					System.out.print(jumsu[i][j]+"\t");				
				}
				System.out.println();			
			}
			//3���϶� ������ ����� 3��4��,10���϶��� 10��11��// ���κ������� �̵����������� ���������� �����δ�
			// �л���+1
			//��������
			System.out.print("����\t");
			for(int i=0;i<3; i++){  //3����
				System.out.print(jumsu[cnt][i]+"\t");
			}
			System.out.println();
			//�������
			System.out.print("��� \t");
			for(int i=0;i<3; i++){ 
				System.out.print(jumsu[cnt+1][i]+"\t");
			}
		}catch(NumberFormatException e) {
			System.out.println("Exception--> "+e.getMessage());
		}catch(Exception d) {
			System.out.println("Exception ~~>"+d.getMessage());
		}
	}		
}

/*
 �л����� �Է¹޾� �̸���,�������� ������ �Է¹����� 
 �� �л��� ����, ���, ����,����,��������� ���Ͽ�
 ���������� ����϶�
 
 ����
 �л���=3
 �̸�=ȫ�浿
 ����=90
 ����=89
 ����=90
 �̸�=�̼���
 ����=
 ����=
 ����=
 .
 .
 .
 ===============
 �̸�		����		����		����		����		���		����		
 ȫ�浿   	90		89		90		269				1
 �̼��� 		90		90		43		223				2
 .
 .
 .
 ��������  ��������
 ������� 
 
 */
