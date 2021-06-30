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
		System.out.println("나이=");
		age = scan.nextInt();
		System.out.println("성별(1.나이 ,2.여성)=");
		gender = scan.nextInt();
		System.out.println("키=");
		height = scan.nextInt();
		System.out.println("체중=");
		weight=scan.nextInt();
	}	//표준체중 구하기
	
	void idx() {
		if (age<=35 && gender == 2)
			idx = 0.85;
		else if (age >=36 && gender == 1)
		    idx = 0.95; 
		
		       }
	
	void sWeight() {
		sWeight = (height-100)*idx;
		
	        }
	 //표준체중지수
	void print(){
	System.out.printf("표준체중지수=%.2f\n",sWeightIndex);
	System.out.printf("당신의 표준체중지수는 %.2f으로 %s입니다\n",sWeightIndex,sWeightMsg);
	}
	//표준체중지수평가기준
	public static void main(String[] args) {
	
		StandadWeightOOP sw = new StandadWeightOOP();
		

	}

}
