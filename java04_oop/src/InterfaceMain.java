//클래스에서 interface를 상속받을 경우 implements키워드를 이용한다..
//		interface는 여러개 상속받을 수 있다. 갯수의제한x
//		상속받은 모든 추상메소드는 오버라이딩을 해야한다
public class InterfaceMain implements InterfaceTest1 ,InterfaceTest2 { //1,2에 sum있고 3에 출력메소드있음..-->1,2를 상속받아야됨

	public InterfaceMain() {
		
	}
	
	//추상메소드 오버라이딩
	public void output() {} //할일없어도 오버라이딩 해줘야함
	
	public int sum() {
		return 5050;
		
	}
	
	public void oddSum() { 
		int sum =0;
		for(int i=1; i<=MAX; i+=2) {
			sum+=i;
		}
		System.out.println("1~"+MAX+"까지의 합은="+sum);
	}
	
	public int evenSum() { 
		int sum =0;
		for(int i=2; i<=MAX; i+=2) {
			sum+=i;
		}
		return sum;
	}
	
	
	public void resultPrint(int data) {
		System.out.println("결과값은"+data);
	}
	
	
		
	public void start() {
		
		resultPrint(sum()); //합1~100 결과값은5050
							//sum의결과를 리턴받아서 바로출력
		oddSum(); //1~100까지의 홀수의 합 2500
		resultPrint(evenSum()); //결과값은 =2550 	
								//return으로값만 나오기때문에 출력해주는 메소드 이용함
							
		
		
	}
	
	
	public static void main(String[] args) {
		
		new InterfaceMain().start();
	}

}

//1,2에 sum있고 3에 출력메소드있음..-->1,2를 상속받아야됨--4번째줄에서 상속받음
