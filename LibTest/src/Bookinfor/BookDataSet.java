package Bookinfor;

import java.util.HashMap;

public class BookDataSet {

	public static HashMap<String ,BoVO> boList = new HashMap<String, BoVO>();
	
	public BookDataSet() {
		
	}
	
	public static void basicBoSet() {
		boList.put("�������� �Ѿƻ�",new BoVO("�������� �Ѿƻ�","������","����Ұ�","813.7-��54��","2021-08-04"));
		boList.put("������ �ູ",new BoVO("������ �ູ","������","���Ⱑ��","813.7-��66��",""));
		boList.put("�̵峪�� ���̺귯��",new BoVO("�̵峪�� ���̺귯��","��Ʈ ���̱�","����Ұ�","843.6-��68��","2021-06-29"));
		boList.put("�׷��� �׷�",new BoVO("�׷��� �׷�","������","���Ⱑ��","818-��97��",""));
		boList.put("���� �ó�����",new BoVO("���ǽó�����","���ǿ�","���Ⱑ��","332.6-ũ296��",""));
		boList.put("�Ÿ��� ���",new BoVO("�Ÿ��� ���","�ں�â","����Ұ�","327.856-��44��","2021-07-12"));
		boList.put("��ũ���׽� �ͽ�������",new BoVO("��ũ���׽� �ͽ�������","�������̳�","���Ⱑ��","160.21-Ż29��",""));
		boList.put("���� �˰���",new BoVO("���� �˰���","��ȸ��","���Ⱑ��","325.211-��18��",""));
		boList.put("����",new BoVO("����","�縮","���Ⱑ��","813.8-��298�� ",""));
		boList.put("�ֽľ��ֻ���",new BoVO("�ֽľ��ֻ���","Ȳ��","����Ұ�","327.856-��68��","2021-08-21"));		
		
	}

}
