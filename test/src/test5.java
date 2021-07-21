class Test8{}
public class test5 extends Test8{

	public test5() {
		
	}

	public static void main(String[] args) {
		Test8 t1 = new Test8(); // t1은 클래스테스트의객ㅊ[
		test5 e1 = new test5();
		test5 e2 = (test5)t1; //ex는 클래스테스를 상속받았기때문에 형변환 가능하다
		Object o1 = (Object)t1; //모든클래스는 오브젝트를 상속받았기 때문에 t1은가능하다
		//String s1 = (String)t1; 
		Test8 t2 = (Test8)e1;
		System.out.println(t2);

	}

}
