import java.util.Arrays;

public class ArraysTest {

	public ArraysTest() {
		// Arrays : 배열관련 처리 클래스
		int [] data = {15,90,45,75,26,95,48,9,12,40};
		//Arrays.sort(data); //배열이 저장되어 있는 주소가 나옴....
		//오름차순으로 배열이 정렬됨
		Arrays.sort(data); //일부만 정렬 ..2~4번째에 있는 것만 정렬됨...2에서부터 5앞까지만 정렬됨..
		
		//toString() : 배열출력
		System.out.println(Arrays.toString(data));//주소가 나오므로 toString으로 배열을 오름차순으로 나오게 해줌..
	}

	public static void main(String[] args) {
		new ArraysTest();

	}

}
