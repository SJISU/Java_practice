
//interface 에서 interface를 상속받을 경우
//extends 키워드를 이용하고 1개만 상속받을 수 있다.                
public interface InterfaceTest2 extends InterfaceTest3 {

	public void oddSum();
	public int evenSum(); //추상메소드 두개가 있는 인터페이스
}
