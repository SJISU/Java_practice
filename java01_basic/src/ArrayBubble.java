
public class ArrayBubble {
	public static void main(String[] args) {
		//1~100사이의 난수를 10개 생성하여 배열에 대입후 오름차순으로 정렬하여 출력하라.
		
		//10개의 데이터를 넣을 객체 만들기
		int[]num = new int[10];
		
		//난수 생성
		for(int i =0; i<num.length; i++) {
			int random = (int)(Math.random()*(100-1+1))+1;
			num[i] = random;
			
		}
		System.out.println("정렬 전 데이터");
		for(int i=0; i<num.length; i++){
			System.out.print(num[i]+",");
			
		}
		System.out.println();
		
		for(int j=0; j<num.length-1;j++ ) {
			for(int i=0; i<num.length-1-j;i++) {
				if(num[i]>num[i+1]) {
					//교환하기
					int temp = num[i];
					num[i]=num[i+1];
					num[i+1] = temp;
				}
				
			}
			System.out.println(j+1+"번 정렬 후 데이터");
			for(int i =0; i<num.length;i++) {
				System.out.print(num[i]+",");
			}
			System.out.println();
		}
		
	
	
	}

}
