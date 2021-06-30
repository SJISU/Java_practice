
public class StringTest {

	public StringTest() {
		//
	}	
	public void start() {	
		
		//				0 1234 56 78 90 //공백도 매겨짐
		String str1 = "서울시 마포구 신수동"; //일반데이터형 변수처럼 생성
		String str2 = "서울시 마포구 신수동";
		String str3 = new String("서울시 마포구 신수동"); // new를 이용하여 객체로 형성  ------- str1~3값은 같은것들이 들어가있음
		String data = str3; //이미객체로만든것을 대입시킴-기존의데이터를 넣어준것 // str3와 data의 주소가 같아짐 //비교할때 equals가 아닌 == 사용가능하고..//하나의공간을 두개의 변수가 사용하고있음..
		
		byte[] byteData = {65,66,67,68}; //아스키코드값 -> ABCD :아스키코드값을 문자로 출력
		String str4 = new String(byteData); //"ABCD" 가 들어가있음 -아스키코드가 문자로 들어가 있음
		
		char[] charData = {'x','y','z'} ; //"xyz" - 한개의 문자열로 나타내고싶을때 아랫줄로 표현
		String str5 = new String(charData); 
		
		int[] intData = {65,66,67,68,69,70};
		String str6 = new String(intData,2,3); //index 2부터 3개를 문자로 생성하라. //67 68 69 -> cde
		
		System.out.println("byteData="+str4);
		System.out.println("charData="+str5);
		System.out.println("intData="+str6);
		
		
		
		if(str1 == str2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		

		if(str1 == str3) { //객체를 형성하는 방법이 다른 str1,str3 // ==는 일반데이터 비교형 연산자이다 객체를 비교할때는 == 사용x.. 아니면 객체안에있는 값을가지고비교해야한다..메소드를 사용행한다
			System.out.println("같다~~~");
		}else {
			System.out.println("다르다~~~");
		}		
		
		if(str1.equals(str3)) { //객체와 객체가 같은지를 구한다...str3.equals(str1) 을 사용해도 가능
			System.out.println("같다----");
		}else {
			System.out.println("다르다----");
		}		
		
		if(str3 == data) {
			System.out.println("같다,,,,");
		}else {
			System.out.println("다르다,,,,");
		}
		
		
		str3 = "서울시 종로구";
		System.out.println(str3);
		System.out.println(data); // --str3의 주소는 바뀌었지만 data의주소는 원래대로 쓰고있음
		
		//charAt()
		char c = str1.charAt(2);//index위치의 문자 1개를 얻어온다.
		System.out.println("str1.charAt(2)->"+c); //이메일쓸때 @이 안넣으면 넣으라고 나올때 활용하는 방식
		
		//concat()
		String result = str1 + str2 ;//문자열 연결
		String result2 = str1.concat(str2); //문자열 연결방법
		System.out.println("result="+result);
		System.out.println("result2="+result2);
		
		//             01234567890123456789
		String data2 ="Java String Test....";
		String data3 ="java string test....";
		//equals
		if(data2.equals(data3)) { //자바는 대소문자가 명확하기때문에 다르다고 나온다...
			System.out.println("같다$$$");
		}else {
			System.out.println("다르다$$$");
		}		
		
		//equalsIgnoreCase 대소문자 구별없이 비교
		if(data2.equalsIgnoreCase(data3)) {
			System.out.println("같다...");
		}else {
			System.out.println("다르다...");	
		}
		
		// getBytes[] -통신할때 사용...
		byte[]byteCode = data2.getBytes(); //문자열을 byte배열로 구한다.
		for( byte b : byteCode) {
			System.out.println((char)b+"-->"+b);
		}
		
		//index0f 특정한 글자가 몇번째 위치))에 있는지 알아내는것
		int idx = data2.indexOf("t");//특정문자의 index위치를 구한다..
		System.out.println("indexOf->"+idx); //먼저나온t를구한것 
		//뒤에나오는 t를 구하고싶을때 -> 1.찾는시작지점설정해주기 
		int idx2 = data2.indexOf("t",10); 
		System.out.println("indexOf->"+idx2);
		
		int idx3 = data2.lastIndexOf("t"); // 2.뒤에서부터찾기 -특정문자를 뒤에서 검색하여 index를 구한다.
		System.out.println("lastindexOf->"+idx3);
		
		//length -글자의 길이구하기
		System.out.println("length="+data2.length()); //변수설정하고 글자길이 출력
		
		//String data2 ="Java String Test....";
		//특정문자를 다른문자로 변경한다.
		data2 = data2.replaceAll("a", "에이"); //a를 에이 로 바꾼다 - 변수에 대입안하면 보관이안된다
		System.out.println("replaceAll->"+data2);
		
		//split 문자를 내가 원하는 위치에 조각내는것...-회원가입시 전화번호 3칸에 입력할때 -정보는 1개인데 데이터는 3개...db에 넣을때는 묶어서 넣는다..
		//특정문 문자열을 조각내어 배열로 return해준다 - 
		String data4= "010-1234-5678" ;
		String [] tel =data4.split("-"); //배열로 나누어진다..
		for(int i=0; i<tel.length; i++) {
			System.out.println("tel["+i+"]="+tel[i]);
		}
		
		//substring()-특정문자열에서 일부 문자열을얻어온다.핸드폰번호 가운데 자리만 필요할때..
		String tel1 = data4.substring(4); //1234-5678
		String tel2 = data4.substring(4,8); // (시작시점,종료시점)
		System.out.println(tel1+","+tel2);
		
		//toCharArray() 문자열을 char배열로 구해준다 // data2=J에이v에이 String Test...
		char[]  charData2 = data2.toCharArray();
		for(char cc:charData2) {
			System.out.println(cc);
		}
		
		//toLowercase():소문자 toUpperCase():대문자 
		String toLower = data2.toLowerCase();
		String toUpper = data2.toUpperCase();
		System.out.println(toLower+","+toUpper);
		
		//trim() : 문자열의 양쪽에 공백문자 지운다. - 아이디 입력할때....
		String data6 ="    Spring    FrameWork    "; 
		String dataTrim = data6.trim();
		System.out.println("AA"+dataTrim+"BB");
		
		//오버로딩 valueOf - 숫자 데이터를 문자로 나타내고싶을때 
		int num =1234;
		String s1 = num +"";//문자화
		String s2 = String.valueOf(num); //앞에 static이 있기때문에 객체안만들어도 된다..
		System.out.println(s1+1234);
		System.out.println(s2+5678);
		
		char[] aa = {'S', 'T','U'};
		String sss = new String(aa); //생성자메소드이용
		String sss2 = String.valueOf(aa);//문자메소드이용
		
		System.out.println(sss);
		System.out.println(sss2);
		
		//compareTo - 문자와 문자를 비교 -첫번째있는글자끼리비교 -같다면 두번째 문자끼리비교- +가나오면 왼쪽이큰거 - 가나오면 오른쪽이큰거
		String data7 = "Apple";
		String data8 = "apple";
		int r1 = data7.compareTo(data8); //65-97 = -32 양수이며 왼쪽객체가 크고 , 음수이면 오른쪽객체가 크다 ,0은 두객체 크기 같다.
		int r2 = data8.compareTo(data7); // 97-65 = 32
		System.out.println(r1+","+r2);
		
		int r3 = data7.compareToIgnoreCase(data8); //대소문자 구분안하고 비교
		int r4 = data8.compareToIgnoreCase(data7); 
		System.out.println(r3+","+r4);
		}

	
	
	public static void main(String[] args) {
		//메인메소드는 객체생성하는 정도로 사용...
		new StringTest().start(); //이 객체안에 있는 start라는 메소드를 사용해라

	}

}
