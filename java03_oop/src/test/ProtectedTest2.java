package test;

public class ProtectedTest2 {
	protected String tel = "010-1234-8959";
	//�����ص�尡 �پ��ֱ⶧���� ��ü�����ȵ�
	protected ProtectedTest2(){
		System.out.println("�ٸ���Ű���� �����ڸ޼ҵ�");
	}
	protected void telOutput() {
		System.out.println("��ȭ��ȣ="+tel);
	}
	public String gettel() { //�ٸ���Ű��,����� �ƴϾ ��밡���Ѹ޼ҵ��ε�
			return tel;       
		}
		
	public static ProtectedTest2 getInstance() { //*****
		return new ProtectedTest2();
	} // static�� �ٿ��� //��ü������� �޼ҵ带 �̿��Ͽ� ��ü�����޼ҵ�Ҹ��� -�޼ҵ���
		
	
	
}
