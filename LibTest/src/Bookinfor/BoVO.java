package Bookinfor;

public class BoVO {
	private String name;//책이름
	private String writer;//저자
	private String check;//대여상태
	private String cate;//청구기호
	private String date;//반납예정일
	
	public BoVO() {
	
	}
	
	public BoVO(String name ,String writer,String check,String cate,String date) {
		this.name= name;
		this.writer = writer;
		this.check =check;
		this.cate=cate;
		this.date=date;		
	
	}
	//383줄
	public static void boVOPrint(BoVO onebook) {		
		//System.out.printf("%-13s %-13s %-10s %-22s %-15s\n",name,writer,check,cate,date); //한줄에 80글자
		String namePattern = setFiftyLetters(checkkorean(onebook.getName()));
		String writerPattern = setFiftyLetters(checkkorean(onebook.getWriter()));
		String checkPattern = setFiftyLetters(checkkorean(onebook.getCheck()));
		String catePattern = setFiftyLetters(checkkorean(onebook.getCate()));
		String datePattern = setFiftyLetters(checkkorean(onebook.getDate()));
		
		System.out.printf(namePattern,onebook.getName());
		System.out.printf(writerPattern,onebook.getWriter());
		System.out.printf(checkPattern ,onebook.getCheck());
		System.out.printf(catePattern ,onebook.getCate());
		System.out.printf(datePattern,onebook.getDate());
		System.out.println();
		
	}
	
	//간격메소드생성
	public static int checkkorean(String korean) {
		char[] charArray = korean.toCharArray();
		int realLength = charArray.length;
		for(int i=0; i<charArray.length; i++) {
			if(charArray[i]>127) {
				realLength++;
			}
		}
		return realLength;
	}
	
	public static String setFiftyLetters(int realLength) {
		int space = 30-realLength;
		String spaceStr ="";
		for(int i=0; i<space; i++) {
			spaceStr+=" ";			
		}
		String pattern = "%s"+spaceStr;
		return pattern;		
	}
	
	
	
	
	public static void titlePrint() {
		System.out.println("===============================================================================================================================");
		System.out.printf("\t%6s \t%6s \t\t%10s \t\t%15s \t\t%15s\n","책이름","저자","대출상태","청구기호","반납예정일");
		System.out.println("===============================================================================================================================");
	}
	
	public String toString() {
		String bookData=name+","+writer+","+check+","+cate+","+date;
		return bookData;
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

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
	

}
