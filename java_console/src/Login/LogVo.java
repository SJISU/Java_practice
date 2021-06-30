package Login;

public class LogVo {
	private String name;
	private String id;
	private String pwd;

	public LogVo() {

	}

	public LogVo(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void Print() {
		System.out.printf("%10s %10s %10s ", name, id, pwd);
	}

}
