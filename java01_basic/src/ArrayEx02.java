
public class ArrayEx02 {

	public static void main(String[] args) {
		//난수 1~1000 사이의값을 100개 만들어 배열에 저장하고
		//	생성된 난수중 제일큰값과 제일작은값,평균을 구하여 출력하라.
		
		//100개를 저장할 배열을 만들어라
		int data[] = new int [100];  //100개 만들어라
		
		for(int i =0; i<data.length; i++) {  //난수1~1000 사이의값
			data[i]=(int)(Math.random()*1000) + 1; //1000:큰값-작은값+1 //Math.random()이 난수(?)
			System.out.println(data[i]);
			
		}
		
		//큰값, 작은값 , 평균 - 변수를만든다 /배열의값중 첫번째값을 넣는다 /그리고 다음배열의 값들이랑 비교한다-토너먼트형식
		//data수만큼 반복하여구한다
		int sum=0;
		int max=data[0];
		int min=data[0];	
		
		for(int i =0; i<data.length; i++) {
			//sum=sum+data[i]; //합 
			sum+=data[i];
			
			if(max <data[i]) {
				max = data[i];
			}
			
			if(min>data[i]){
				min = data[i];
				
			}
		}
		
		int ave = sum/data.length;
		
		System.out.println("합="+sum);
		System.out.println("평균="+ave);
		System.out.println("최대값="+max);
		System.out.println("최소값="+min);
		
		
	}

}
