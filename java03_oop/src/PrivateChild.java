
public class PrivateChild extends PrivateParent {

	public PrivateChild() {
		//상위클래스 private멤버변수는 상속되지 않는다.....
		//System.out.prinln("num--->"+num); --->error
		//getData();
	}

//	private void getData() {
//		System.out.println("PrivateChild~~~~~");
//	}
}
