import java.util.Calendar;

public class GenericMain {

	public GenericMain() {
		String data = "서울시 마포구 백범로";
		GenericTest gt = new GenericTest();
		gt.setUsername(data);
		//System.out.println(gt.getUsername());
		
		GenericTest gt2 = new GenericTest();
				
		
		GenericTest<MemberVO> gt3 = new GenericTest<MemberVO>();
		gt3.setUsername(new MemberVO("홍","기획부","2021-01-21",8000)); //제너릭테스트에 저장되었다가 나온것

		MemberVO vo = gt3.getUsername();		
		System.out.println(vo.toString());
		
		Calendar now = Calendar.getInstance();
		GenericTest<Calendar> gt4 = new GenericTest<Calendar>(now); //(now)한게 setUsername메소드로 안하고 바로 매개변수가지고있는 생성자메소드로set해준것
				
		System.out.println(gt4.getUsername()); //달력찍힘
	}

	public static void main(String[] args) {
		new GenericMain();
	}

}
