
public class Car {
	int speed =0;
	final int SPEED_MAX = 180;
	final int SPEED_MIN=0;
	String carName = "그렌져";
	
	//생성자 메소드 2개
	public Car() {//생성자 //상속관계일때는 매개변수가 없는 생성자 꼭 있어야함..
		System.out.println("Car()생성자메소드 실행");
	}
	
	public Car(String carName) {//생성자
		this.carName = carName;
		System.out.println("Car(String)생성자메소드 실행");
	}	
	
	//일반 메소드 2개
	public void speedUp() { //엑셀눌렀을때 스피드업 호출하여 스피드 올라가게
		speed++;
		if(speed>=SPEED_MAX) speed = SPEED_MAX;
		System.out.println("car.speedUp->speed="+speed);
	}
	
	public void speedDown() { //엑셀눌렀을때 스피드업 호출하여 스피드 올라가게
		speed--;
		if(speed<=SPEED_MIN) speed = SPEED_MIN;
		System.out.println("speedDown->speed="+speed);
	}
	

}
