package Boinfor;

import java.util.HashMap;

public class BoDataSet {

	public static HashMap<String,BooVO> booList = new HashMap<String,BooVO>();
	
	public BoDataSet() {
		
	}
	
	public static void basicBooSet() {
		booList.put("����",new BooVO("����","������","����Ұ�",813,"2020-05-05"));
		booList.put("����",new BooVO("����","������","���Ⱑ��",6000,"2021-01-01"));
		booList.put("�̵�",new  BooVO("�̵�","��Ʈ���̱�","����Ұ�",5500,"2020-10-10"));
		booList.put("�׷�",new BooVO("�׷�","������","���Ⱑ��",7000,"2009-03-01"));
		booList.put("����" ,new BooVO("����","���ǿ�","����Ұ�",4500,"2012-08-09"));
		
	}
	

}
