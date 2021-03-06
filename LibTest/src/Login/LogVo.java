package Login;

public class LogVo {
	
	private String id;
	private String pwd;	
	private String name; 
	private String tel; 


	public LogVo() {

	}

	public LogVo(String id, String pwd,String name, String tel) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
	}
	
	public String toString() {
		String memData=id+","+pwd+","+name+","+tel;
		return memData;
	}
	
	
	
	public void Print() {
		System.out.printf("%9s %13s %12s %14s\n",id,pwd,name,tel);
	}
	
	
	public void userPrint() {
		System.out.printf("%9s %13s %12s %14s\n",id,pwd,name,tel);
	}
	
	public static void userTitlePrint() {
		System.out.println("==================================================================");
		System.out.printf("%9s %10s %9s %15s\n","회원아이디","회원비밀번호","회원이름","회원전화번호뒷자리");
		System.out.println("==================================================================");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	

}
