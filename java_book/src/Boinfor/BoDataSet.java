package Boinfor;

import java.util.HashMap;

public class BoDataSet {

	public static HashMap<String,BooVO> booList = new HashMap<String,BooVO>();
	
	public BoDataSet() {
		
	}
	
	public static void basicBooSet() {
		booList.put("지구",new BooVO("지구","정세랑","대출불가",813,"2020-05-05"));
		booList.put("완전",new BooVO("완전","정유정","대출가능",6000,"2021-01-01"));
		booList.put("미드",new  BooVO("미드","메트헤이그","대출불가",5500,"2020-10-10"));
		booList.put("그러",new BooVO("그러","양희은","대출가능",7000,"2009-03-01"));
		booList.put("부의" ,new BooVO("부의","오건영","대출불가",4500,"2012-08-09"));
		
	}
	

}
