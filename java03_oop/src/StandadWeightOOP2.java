import java.util.Scanner;

public class StandadWeightOOP2 {
		
	//������ �Է°� ����
	int age,gender; //0
	double height , weight; //0.0
	double sWeight; //ǥ��ü��
	double sWeightIndex;	//ǥ��ü������
	String sWeightMsg; //�򰡱���
	
	
	public StandadWeightOOP2() { //������ �޼ҵ�
		
	}	
		//������ �Է¸޼ҵ�
		double getConData(String msg) {
			Scanner scan = new Scanner(System.in);
			System.out.print(msg+"=");
			return scan.nextDouble();
		}			
		
		void setData() { //�������� �Է¹����� ȣ��	
			age = (int)getConData("����");
			gender = (int)getConData("����");			
			height = getConData("Ű");		
			weight=getConData("������");
		}	
		//ǥ��ü�� index , ǥ��ü�� ���ϱ�		
		void setStandardWeight() {
			double index = 0.90;
			if (age<=35 && gender == 2) {
				 index = 0.85;
			}else if (age >=36 && gender == 1) {
			    index = 0.95; 
			}
			sWeight = (height-100)*index; //?ǥ��ü��
			}
		
		//�򰡱��� - ü�� ���ϱ�
		void setStandardWeightMsg() {  //�ΰ��� ������  sWeightIndex sWeightMsg
		   sWeightIndex = (weight/sWeight)*100;
			if (sWeightIndex <=85 )  sWeightMsg = "������";
		    else if (sWeightIndex <=95) sWeightMsg = "���ݸ�����";
			else if (sWeightIndex <=115) sWeightMsg = "ǥ����";
			else if (sWeightIndex <=125) sWeightMsg = "���ݺ���";
			else sWeightMsg = "����";
			
			}
		
		//���		
		void StandardWeightOutput(){
			System.out.println("ǥ��ü��="+sWeight);
			System.out.println("ǥ��ü��������"+sWeightIndex+"����"+sWeightMsg+"�Դϴ�.");
		
		}
		
		void startStandard() {
			setData();
			setStandardWeight();
			setStandardWeightMsg();
			StandardWeightOutput();
		}
		
		
	public static void main(String[] args) {
	
		StandadWeightOOP2 sw = new StandadWeightOOP2();
		sw.startStandard();
		

	}

}
