package Boinfor;

public class BooVO {
	
	private String name;//책이름
	private String writer;//저자명
	private String check;//대출상태
	private String date;//반납일
	private int code;//코드번호

	public BooVO() {
	
	}
	
	public BooVO(String name, String writer, String check, int code,String date) {
		
		this.name = name;
		this.writer = writer;
		this.check =check;
		this.code = code;
		this.date = date;
		
	}
		//책1권출력==========================
		public void BooPrint() {
			
			System.out.printf("%-10s %-10s %10s %-10d %-15s\n",name,writer,check,code,date); 
		}
		//타이틀출력
		public static void titlePrint() {
			System.out.printf("%-10s %-10s %-20s %-10s %-15s\n","책이름","저자명","대출상태","코드번호","반납일");
			System.out.println("====================================================================");
			
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getCheck() {
			return check;
		}

		public void setCheck(String check) {
			this.check = check;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
		
		
		

}
