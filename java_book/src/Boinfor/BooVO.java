package Boinfor;

public class BooVO {
	
	private String name;//å�̸�
	private String writer;//���ڸ�
	private String check;//�������
	private String date;//�ݳ���
	private int code;//�ڵ��ȣ

	public BooVO() {
	
	}
	
	public BooVO(String name, String writer, String check, int code,String date) {
		
		this.name = name;
		this.writer = writer;
		this.check =check;
		this.code = code;
		this.date = date;
		
	}
		//å1�����==========================
		public void BooPrint() {
			
			System.out.printf("%-10s %-10s %10s %-10d %-15s\n",name,writer,check,code,date); 
		}
		//Ÿ��Ʋ���
		public static void titlePrint() {
			System.out.printf("%-10s %-10s %-20s %-10s %-15s\n","å�̸�","���ڸ�","�������","�ڵ��ȣ","�ݳ���");
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
