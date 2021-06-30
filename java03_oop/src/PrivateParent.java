
public class PrivateParent {
	//private 접근제한자는 다른 클래스에서 객체를 통하여 접근할숭없다...
	private int num = 200;  //캡슐화
							//앞에 아무것도 없으면 접근제한자 : dafalut 이 생략되어 있는상태..
							//        privaet이면 메인에서 출력x
	//생성자 메소드에 private 접근 제한자는 객체를 생성할수없다.
//	private PrivateParent() {
//		
//	}
//	
	PrivateParent(){
		
	}
	//객체를 통해서 접근불가
	//상속안함...
	private void getData() {
		System.out.println("번호="+num); //private - 같은클래스에서는사용가능 외부에선x
	}

}
