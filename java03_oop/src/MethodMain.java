
public class MethodMain {

	public static void main(String[] args) {
		//			객채명=instance=reference변수
		//					생성자메소드
		//같은 클래스를 받아 멤버변수를 두 객체 다 받는다 그러나 둘안에있는것은 같은 데이터 아님
		Methodtest mt = new Methodtest();
		Methodtest mt2 =new Methodtest("010-1134-5555");
		
		//객체내의 멤버영역의 변수를 다른 데이터로 수정하기
		mt.name ="이순신"; //mt객체내의 name 데이터를 홍길동에서 이순신으로 변경
		System.out.println("mt.name="+mt.name);
		System.out.println("mt2.name="+mt2.name); //mt2는 원래클래스안의 데이터인 홍길동이 출력됨
		
		//
		Methodtest mt3 = new Methodtest(100,"세종대왕");
		System.out.println("mt3.num="+mt3.num); //100
		System.out.println("mt3.name="+mt3.name); //세종대왕
		System.out.println("mt3.tel="+mt3.tel); //02-1234-1234
		
		Methodtest mt4 = new Methodtest("장영실",200);
		System.out.println("mt4.num="+mt4.num); //200
 		System.out.println("mt4.name="+mt4.name);//장영실
		System.out.println("mt4.tel="+mt4.tel); //02-1234-1234
	}

}
