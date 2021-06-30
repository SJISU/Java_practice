
public class ForExtensionArray {

	public static void main(String[] args) {
		int[] arr = {86,6,92,65,12,74,35};
		//확장된 for문
		//배열의 데이터형변수선언 : 배열명
		for( int data : arr ) {
			System.out.print(data+"\t"); // *arr의 배열이 순서대로 data에 들어가서 나온다....
		}
		System.out.println();
		
		/*
		 for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+"\t");
		
		 }
		System.out.println();
		 */
		
		//2차원 배열
		int arr2[][] = { 
						{60,80,40,60} ,
						{56,62,84,79} ,	
						{36,58,78,95} 
						};
		//1차원 배열변수 : 2차원배열명
		for( int[]data : arr2) {
			// 배열의 데이터형변수 : 1차원배열명
			for(int z : data) {
				System.out.print(z+"\t");
			}
			System.out.println();
		}
		
		/*
		
		for(int i=0; i<arr2.length; i++){
			for(int j=0; j<arr2[i].length; j++){
				System.out.print(arr2[i][j]+"\t");
				}
		System.out.println();
		}
		 
		 */
		
		
	}

}
