
public class test2 {
	//1~100사아의 난수를 10개 생성하여 배열에 대입후 오름차순으로 정렬하여 출력
	
	public test2() {
		
		
	
	}
		
		
	public static void main(String[] args) {
	
		
int num [] = new int[10];
		
		//난수생성
		for(int i =0; i<num.length; i++) { // i = 0,1,2,...9
			int random =(int)( Math.random()*(100-1+1))+1;
			num[i] = random;						
		}
		
		//정렬전데이터출력
		System.out.println("정렬전 데이터=====================");
		for(int i =0; i<num.length; i++) {
			System.out.print(num[i]+",");
		}
		System.out.println();
		
		// 몇번째 정렬후 데이터
		for(int j =0; j<num.length; j++) { // 0,1,2,3...8
		
			for(int i=0; i<num.length-1-j; i++){ // *length-1 : 마지막전칸에서 비교하면 비교는 끝나기때문에 (전체길이-1) 번 반복하여 비교한다
				if(num[i] > num[i+1]) { //오름차순일때
					// 교환하기
					int temp = num[i];  //첫번째 데이터가 지워지기때문에 임시로 따로 보관해둔다
					num[i] = num[i+1]; //i는 지워지고 i+1이 된다.
					num[i+1] = temp;
				}	
				
				
			}	
			
			
			
		
		}
		System.out.println("정렬후 데이터=====================");
		for(int i =0; i<num.length; i++) {
			
			System.out.print(num[i]+",");
		
	
		    
						
		}
		
		
	}

}
