
public class MethodTest2 {
	//4�ٿ��� 11�ٱ��� �������� -static ��������
	boolean power = false; //true:���� , false :����
	//ä��
	//	 ���ȭ  -�ѹ����ԵǸ� �ٲܼ� ����
	//			-�������� ���ʿ� finalŰ���带 ǥ��
	//			-���ȭ�� ������ ��纯������ �빮�ڷ� ǥ���Ѵ�.
	final int CHANNEL_MIN = 1;
	final int CHANNEL_MAX = 20;
	int channelNow = 11;
	
	public MethodTest2() { //�����ڸ޼ҵ� - Ŭ������ �� ���ƾ� �Ѵ�. -��ü�����Ҷ� �ѹ��ʿ�
		
	}
	//power��ư ���� ���
	//	   ��ȯ�� �޼ҵ��(�Ű�����,�Ű�����,.......){
	//		���๮; //��ɱ��� - ����� �������ִ� ���๮..
	// 		}	
	//�ҹ��ڷ� �����ϰ� �ռ����� ��� �ι�° �ܾ���� �빮�ڷ� ()�ִ�.
	void powerStart() {
		power = !power;
		/*
		if(power) {
			power = false;
		}else {
			power = true;
		}
		*/
		System.out.println("power="+power);				
	}
		
	    //���� �Է��ϸ� �������� ���Ͽ� ��ȯ�ϴ� �޼ҵ带 ����
		//void : ��ȯ���� ����.	
		String gugudan(int dan) { //String - ��ȭ�Ǵ� ������Ÿ�����ν��ش�
			//���๮ 1���� ��������.
			String result = "";
			for(int i=2; i<10; i++){
				result += dan+"*"+i+"="+dan*i+"\n";
			}
			return result;
		}	
	//ä�ι�ȣ�ø��� : ����ä�� +1 
	void channelUp() {
		if(channelNow == CHANNEL_MAX) {
			channelNow = CHANNEL_MIN;
		}else {
			channelNow++;
		}
		
		channelPrint(); //����Ŭ������ �ڸ��޼ҵ� ȣ��
		
	}
	//ä�ι�ȣ������
	void channelDown() {
		if(channelNow == CHANNEL_MIN) {
			channelNow= CHANNEL_MAX;
		}else {
			channelNow--;
		}
		
		channelPrint();
	}
	//ä�ι�ȣ ����ϴ� �޼ҵ�
	void channelPrint() {
		System.out.println("ä�ι�ȣ="+channelNow);
	}
	
	//static Ű���� -�޼ҵ�� ������ ���� ,������ �޼ҵ忡�� �Ⱦ���
	static void sum(int max) {
		int tot=0;
		for(int i=1; i<=max; i++) {
			tot+=i;
		}
		System.out.println("1~"+max+"�� ����="+tot);
	}
	
	
}
