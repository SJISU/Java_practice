package test;

public class DefaultData {
	String name = "ȫ�浿"; //�տ��ƹ��͵��Ⱥ��̸� default ����.. staic���� ������� �����ϸ� �����Ȱ�ü���� name�������� �����������Ƿ�
								 // ���ü���� name�� �ٲٸ� ��簴ü�� name�� �ٲ��...
	String tel = "010-1234-5678";
	
	public DefaultData() {
	
	}
	
	public DefaultData(String name,String tel ) { //�ΰ��� �����͸� �޾� ����� �ű�� �޼ҵ�...
		this.name = name; //����Ŭ������ �����̶�� ���� :�������...
		this.tel = tel;
	}
	
	public static void sum() { //�޼ҵ� �տ�static���̸� dd2.sum(); ���� DefaultData.sum(); ���ε� ����Ҽ��ִ�.. 
							  // ��ü��.�޼ҵ� ---> Ŭ������.�޼ҵ�� ��� ����...
							  // tot�� i�� ������������ sum�� ����Ǹ� ���������� ���� -28��°�ٰ���
		int tot=0;
		for(int i=1; i<=100; i++) {
			tot+=i;
		}
		System.out.println("tot="+tot);
	}
	
	
	public String getName() { //���⿡�� static ���Ұ�..name�� ��������μ� ��ü new �����ؾ��Ѵ�...
							 // ��������� ��������⶧���� Ŭ������.�޼ҵ�� ���Ұ�..�ƴϸ� ��������տ� static�� �����
		return name;
	}
}

