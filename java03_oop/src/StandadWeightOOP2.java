import java.util.Scanner;

public class StandadWeightOOP2 {
		
	//데이터 입력값 저장
	int age,gender; //0
	double height , weight; //0.0
	double sWeight; //표준체중
	double sWeightIndex;	//표준체중지수
	String sWeightMsg; //평가기준
	
	
	public StandadWeightOOP2() { //생성자 메소드
		
	}	
		//데이터 입력메소드
		double getConData(String msg) {
			Scanner scan = new Scanner(System.in);
			System.out.print(msg+"=");
			return scan.nextDouble();
		}			
		
		void setData() { //ㄷㅔ이터 입력받을때 호출	
			age = (int)getConData("나이");
			gender = (int)getConData("성별");			
			height = getConData("키");		
			weight=getConData("몸무게");
		}	
		//표준체중 index , 표준체중 구하기		
		void setStandardWeight() {
			double index = 0.90;
			if (age<=35 && gender == 2) {
				 index = 0.85;
			}else if (age >=36 && gender == 1) {
			    index = 0.95; 
			}
			sWeight = (height-100)*index; //?표준체중
			}
		
		//평가기준 - 체형 구하기
		void setStandardWeightMsg() {  //두개가 구해짐  sWeightIndex sWeightMsg
		   sWeightIndex = (weight/sWeight)*100;
			if (sWeightIndex <=85 )  sWeightMsg = "마른형";
		    else if (sWeightIndex <=95) sWeightMsg = "조금마른형";
			else if (sWeightIndex <=115) sWeightMsg = "표준형";
			else if (sWeightIndex <=125) sWeightMsg = "조금비만형";
			else sWeightMsg = "비만형";
			
			}
		
		//출력		
		void StandardWeightOutput(){
			System.out.println("표준체중="+sWeight);
			System.out.println("표준체중지수는"+sWeightIndex+"으로"+sWeightMsg+"입니다.");
		
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
