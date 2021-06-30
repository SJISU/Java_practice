import java.util.StringTokenizer;
public class StringTokenizerTest { //��Ʈ���� ��Ʈ�������� ���� : ��Ʈ�����۴� �ڷᰡ �߰��Ǿ �ּҰ� �̵����� �ʴ´�..

	public StringTokenizerTest() {
		String txt = "�����, ������, �ż���. �ű�����, 3��. ��Ʈķ��, ��������";
		
		StringTokenizer st = new StringTokenizer(txt,",.") ; 
		//�迭�̾��⶧���� index����..��ū������ŭ�ݺ��ؼ�������
		// countTokens() : ��ū�� ���� Ȯ��
		int tokenCount = st.countTokens();
		System.out.println("��ū��->"+ tokenCount);
		
		//hasMoreElements() : ��ū�� �� �����ִ��� Ȯ��
		while(st.hasMoreElements()) { //���ǽ��� true�϶������� true:���� ��ū�� ������,false:���� ��ū�� ������
			String token = st.nextToken(); //nextToken() : ���� ��ū�� �ҷ���
			System.out.println(token);
			
		}
	}	
	
	public static void main(String[] args) {
		new StringTokenizerTest();
	}

}
