import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<String> stack = new Stack<String>();
		
		// stack은 먼저 입력된 정보가 나중에 출력된다.(FILO:first in last out)
		// <->queue : 먼저들어간애가 먼저 나온다. (FIFO) :빨대와같은 긴 관형태의 저장소
		
		//push():입력,  pop():출력
		stack.push("홍길동");
		stack.push("세종대왕");
		stack.push("이순신");
		stack.push("김정희"); //제일위에있으니간 pop하면 제일먼저 나온다///
		//System.out.println(stack.pop());--->"김정희"가 제일먼저 나온다,,,,
		
		//empty(): satck객체있으면 false, 객체없을때 true-> 비어있으면 끝나고 아니면 pop반복
		while(!stack.empty()) {
			String name = stack.pop();
			System.out.println(name); //->출력해보면 먼저들어간게 나중에 나오는거 확인할수있다.
		}
		
		
	}

	public static void main(String[] args) {
		new StackTest();
	}

}
