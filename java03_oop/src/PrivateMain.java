
public class PrivateMain {

	public static void main(String [] a) {
		
		//PrivateParent pp = new PrivateParent();
		//System.out.println("pp.num="+pp.num); //프라이베이트 멤버변수는 외부에서 사용불가
		//pp.getData(); //프라이베이트 메소드는 외부에서 사용불가
	
		PrivateChild pc = new PrivateChild();
		//pc.getData(); //오버라이딩도 안됨...
	
	}

}
