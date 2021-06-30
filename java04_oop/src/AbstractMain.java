
//numOutput 메소드를 쓰고싶은데 추상클래스이기때문에 포함이 아니라 상속받아야함
//							추상클래스 상속
public class AbstractMain extends AbstractTest{

	public AbstractMain() {
		
	}

	//상속받은 추상클래스내의 모든 추상메소드를 오버라이딩 한다.
	
	public void print() { //상속받은 클래스에서 기능구현해줌
		System.out.println("num="+num +",name="+name);
	}
						//데이터형,갯수는 같아야하고 변수명은 달라도됨
	public void setData(int num , String name) {
		this.num = num; //super.num = num; //현재클래스에 이름과번호없으니깐 사용못함
		this.name =name;// super.name=name;
	}

	
	
	public void start() {
		numOutput();
		setData(5000,"이순신");
		print();
	}
	
	
	public static void main(String[] args) {
	
		AbstractMain am = new AbstractMain(); //이클래스를사용하기위해 객체만들고
		am.start(); //메소드 호출
	}
	
	
}

//29,30번째줄---21,22,23실행

