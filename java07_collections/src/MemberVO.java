

public class MemberVO {
	// 1���� ���ڵ带 ������ ������ �����Ѵ� Ŭ����
	// ��������� ĸ��ȭ(private) �Ѵ�...(���������ڸ� �ܺο��� ���ٸ��ϰ��Ѵ�)-�޼ҵ带 ���ؼ� ����ϰԲ�
	private String name;
	private String depart;
	private String hire;
	private int sal;
	

	public MemberVO() {		
	}
	
	//���콺������ ������ source������ getter setter ������ �ڵ�����
	//ĸ��ȭ�� ���(����)�� �����Ҽ� �ִ� �޼ҵ�
	
	//��Ģ 		set���������(ù���ڴ� �빮�ڷ�...)	
	//SET �� �������� �Ҵ��ϴ� ������ �Լ��̱� ������ ���ڸ� �޾ƾ� �ϰ�
	//gET �� �������� ��ȯ�ϴ� �����̱� ������ return �� �ʿ�
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDepart() {
		return depart;
	}
	
	public void setHire(String hire) {
		this.hire = hire;
	}
	public String getHire() {
		return hire;
	}	

	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getSal() {
		return sal;
	}	

	
	public MemberVO(String name,String depart, String hire,int sal) {
		this.name = name;
		this.depart = depart;
		this.hire= hire;
		this.sal =sal;
	}
	
	
	//vo�� ������ �����ϴ� Ŭ����
	//������ ĸ��ȭ�ϰ� �������� �ʿ��Ҷ� setter-getter�̿�	
	
	////////////////////////////////////////////
	//��¸޼ҵ�
	public void  memberPrint() {
		System.out.println("�̸�="+name);
		System.out.println("�μ���="+depart);
		System.out.println("�Ի���="+hire);
		System.out.println("�޿�="+sal);
	}
	//////////////////////
	//����Ŭ������ object�� toString()�޼ҵ带 �������̵�->���� ���ϴ���������...
	public String toString() { //�������ϸ� ������ִ� �������� �ϳ��� ���ڿ��� ��Ÿ�ż�����
		String memberDate = name+","+depart+","+hire+","+sal;
		return memberDate;
	}
	
	
	

}
