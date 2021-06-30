import java.util.StringTokenizer;
public class StringTokenizerTest { //스트링과 스트링버퍼의 차이 : 스트링버퍼는 자료가 추가되어도 주소가 이동되지 않는다..

	public StringTokenizerTest() {
		String txt = "서울시, 마포구, 신수동. 거구빌딩, 3층. 비트캠프, 교육센터";
		
		StringTokenizer st = new StringTokenizer(txt,",.") ; 
		//배열이없기때문에 index없다..토큰갯수만큼반복해서꺼내줌
		// countTokens() : 토큰의 개수 확인
		int tokenCount = st.countTokens();
		System.out.println("토큰수->"+ tokenCount);
		
		//hasMoreElements() : 토큰이 더 남아있는지 확인
		while(st.hasMoreElements()) { //조건식이 true일때만실행 true:남은 토큰이 있을때,false:남은 토큰이 없을때
			String token = st.nextToken(); //nextToken() : 다음 토큰을 불러옴
			System.out.println(token);
			
		}
	}	
	
	public static void main(String[] args) {
		new StringTokenizerTest();
	}

}
