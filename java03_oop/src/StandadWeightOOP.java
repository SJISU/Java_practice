import java.util.Scanner;

public class StandadWeightOOP {
	
	int age;
	int gender;
	double height;
	double weight;
	double idx = 0.90;
	double sWeight;
	double sWeightIndex;
	String sWeightMsg = "";
	
	public StandadWeightOOP() {
		
	}	
	void dataInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("����=");
		age = scan.nextInt();
		System.out.println("����(1.���� ,2.����)=");
		gender = scan.nextInt();
		System.out.println("Ű=");
		height = scan.nextInt();
		System.out.println("ü��=");
		weight=scan.nextInt();
	}	//ǥ��ü�� ���ϱ�
	
	void idx() {
		if (age<=35 && gender == 2)
			idx = 0.85;
		else if (age >=36 && gender == 1)
		    idx = 0.95; 
		
		       }
	
	void sWeight() {
		sWeight = (height-100)*idx;
		
	        }
	 //ǥ��ü������
	void print(){
	System.out.printf("ǥ��ü������=%.2f\n",sWeightIndex);
	System.out.printf("����� ǥ��ü�������� %.2f���� %s�Դϴ�\n",sWeightIndex,sWeightMsg);
	}
	//ǥ��ü�������򰡱���
	public static void main(String[] args) {
	
		StandadWeightOOP sw = new StandadWeightOOP();
		

	}

}
