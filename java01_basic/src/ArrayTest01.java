
public class ArrayTest01 {

	public static void main(String[] args) { //main옆에 String[]
		//배열은 '같은 데이터형의 변수'를 여러개 선언할때 필요하다.
		//배열은 한번 생성되면 크기를 변경할수없다. -> 해결하는 다양한 방법이 있다.
		
		//int[]num;			1.배열 num을 선언(1차원배열)-참조변수
		//num = new int[5];  2.배열의 생성(int저장공간x5)
		//배열의 선언과 생성을 동시에
		int num[] = new int[50]; //정수:0(초기값), 실수:0.0 , 논리형:false(초기값) :메모리가 할당됨
		
		String name[] = new String[5]; //null
		
		num[2] = 100; //인덱스 2번에 100넣을거야 다른인덱스에는 값이 없기때문에 null
		name[1] = "홍길동"; //인덱스1번에 홍길동 넣을거야
		
		System.out.println("num[1]=>"+num[1]);
		System.out.println("name[1]=>"+name[1]);
		
		//num배열의 모든값을 출력하라.
		// num[0], num[1], num[2] , num[3], num[4]
		//배열명.length -> 배열의 갯수를 구하여 준다.	
		for(int idx=0; idx< num.length ; idx++) { //0
			System.out.println("num["+idx+"]="+ num[idx]);
		}
		
		//배열생성동시에 초기값 내가원하는 데이터로 셋팅
		//배열 생성시 초기값 설정하는 방법
		int[] data2= new int[] {20,65,74,5,87,2} ;//필요한데이터를씀 -6개의 공간이 확보됨
		for(int i=0; i<data2.length; i++) {
			System.out.println("data2["+i+"]="+data2[i]);
			
		}
		
		//배열 생성시 초기값 설정하는 방법2
		int data3[] = {8,7,5,37,75};
		for(int i=0;i<data3.length ; i++) {
			System.out.println("data3["+i+"]="+data3[i]);
		}
		
			

	}

}
