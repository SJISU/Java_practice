import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<String> stack = new Stack<String>();
		
		// stack�� ���� �Էµ� ������ ���߿� ��µȴ�.(FILO:first in last out)
		// <->queue : �������ְ� ���� ���´�. (FIFO) :����Ͱ��� �� �������� �����
		
		//push():�Է�,  pop():���
		stack.push("ȫ�浿");
		stack.push("�������");
		stack.push("�̼���");
		stack.push("������"); //�������������ϰ� pop�ϸ� ���ϸ��� ���´�///
		//System.out.println(stack.pop());--->"������"�� ���ϸ��� ���´�,,,,
		
		//empty(): satck��ü������ false, ��ü������ true-> ��������� ������ �ƴϸ� pop�ݺ�
		while(!stack.empty()) {
			String name = stack.pop();
			System.out.println(name); //->����غ��� �������� ���߿� �����°� Ȯ���Ҽ��ִ�.
		}
		
		
	}

	public static void main(String[] args) {
		new StackTest();
	}

}
