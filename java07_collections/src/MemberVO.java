

public class MemberVO {
	// 1개의 레코드를 보관할 변수를 선언한는 클래스
	// 멤버변수는 캡슐화(private) 한다...(접근제한자를 외부에서 접근못하게한다)-메소드를 통해서 사용하게끔
	private String name;
	private String depart;
	private String hire;
	private int sal;
	

	public MemberVO() {		
	}
	
	//마우스오른쪽 누르고 source에가서 getter setter 누르면 자동셋팅
	//캡슐화된 멤버(변수)를 접근할수 있는 메소드
	
	//규칙 		set멤버변수명(첫글자는 대문자로...)	
	//SET 은 변수값을 할당하는 목적의 함수이기 때문에 인자를 받아야 하고
	//gET 은 변수값을 반환하는 목적이기 때문에 return 이 필요
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
	
	
	//vo란 정보를 보관하는 클래스
	//정보를 캡슐화하고 그정보가 필요할땐 setter-getter이용	
	
	////////////////////////////////////////////
	//출력메소드
	public void  memberPrint() {
		System.out.println("이름="+name);
		System.out.println("부서명="+depart);
		System.out.println("입사일="+hire);
		System.out.println("급여="+sal);
	}
	//////////////////////
	//상위클래스인 object의 toString()메소드를 오버라이딩->내가 원하는형식으로...
	public String toString() { //투스링하면 멤버에있는 정보들을 하나의 문자열로 나타탤수있음
		String memberDate = name+","+depart+","+hire+","+sal;
		return memberDate;
	}
	
	
	

}
