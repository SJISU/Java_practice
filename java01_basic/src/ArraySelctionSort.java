import java.util.Random;
public class ArraySelctionSort {

	public static void main(String[] args) {
		Random ran = new Random();
		//1-100사이의 난수를 10개 생성하여 배열에 대입후 오름차순으로 정렬하여 출려하라
		
		int ranInt[] = new int[10] ;
		
		//난수생성
		for(int i =0; i<ranInt.length ; i++) {
			ranInt[i] = ran.nextInt(100)+1 ; // (0~99)+ 1
						
		}
		//정렬(selection sort)
		for(int point=0; point<ranInt.length-1; point++) { //0,1,2,3,4,5,6,7,8, -앞에작은거빼고 뒤에 하나빼고
			                                                //point가 0이면 1부터 비교
															// point 0~7 -> 1~8 -> 1~8> 3~8
			//비교하여 교환
			for(int i=point+1; i<ranInt.length; i++) { //0->1,2,3,4,5,6,7,8,9
														//1->2,3,4,5,6,7,8,9
				if(ranInt[point] > ranInt[i]) { //0번째 있는게 1번째있는것보다 클때 바꾼다
					int temp=ranInt[point];
					ranInt[point] = ranInt[i];
					ranInt[i]=temp;
					
				}
			}
		}
		//출력
		for(int data :ranInt) {
			System.out.print(data+"\t");
		}
		System.out.println();
		
	}
	

}
