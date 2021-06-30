
public class MethodInner { //메소드내의내부클래스

	String name ="세종대왕";
	
	public MethodInner() {
		System.out.println("MethodInner");
	}

	public void start() { //***메소드안에 내부클래스 생성...	
		//내부클래스를 생성메소드가 아닌 메소드 에 만들면...따로 호출해야함
		class MethodInnerTest{
				int num=20;
				String email = "aaaaaaa@nate.com";
				
			MethodInnerTest(){ //MethodInnerTest클래스의 생성메소드
			}
			
			MethodInnerTest(int num){ //매개변수가있는 생성메소드
				this.num =num;
			}
			
			void emailOutput() {
				System.out.println("num="+num);
				System.out.println("email="+email);
				System.out.println("name="+name);
			}
		}
		
		//***내부클래스 객체를 생성
		MethodInnerTest mt = new MethodInnerTest(500);
		mt.emailOutput();
	
	}
	
	
	public static void main(String[] args) {
		MethodInner mi = new MethodInner(); //객체를 만들면 생성자메소드가 실행됨..
		mi.start(); //메소드내에 만든클래스를 호출
	}

}
//37번째줄이 실행되어 MethodInner클래스의 생성메소드가 찍히고
//38번째줄에서는 윗줄에서 만든 객체의 start메소드를 호출하여 메소드내의 내부클래스인 MethodInnerTest 클래스가 호출
//31번째줄에서 내부클래스인 MethodInnerTest의 개체를 생성하고 32번째줄에서 내부클래스의 emailOutput메소드를 실행한다..