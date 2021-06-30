package Bookinfor;

import java.util.HashMap;

public class BookDataSet {

	public static HashMap<String ,BoVO> boList = new HashMap<String, BoVO>();
	
	public BookDataSet() {
		
	}
	
	public static void basicBoSet() {
		boList.put("지구에서 한아뿐",new BoVO("지구에서 한아뿐","정세랑","대출불가","813.7-정54ㅈ","2021-08-04"));
		boList.put("완전한 행복",new BoVO("완전한 행복","정유정","대출가능","813.7-정66ㅇ",""));
		boList.put("미드나잇 라이브러리",new BoVO("미드나잇 라이브러리","매트 헤이그","대출불가","843.6-헤68ㅁ","2021-06-29"));
		boList.put("그러라 그래",new BoVO("그러라 그래","양희은","대출가능","818-양97ㄱ",""));
		boList.put("부의 시나리오",new BoVO("부의시나리오","오건영","대출가능","332.6-크296ㅇ",""));
		boList.put("매매의 기술",new BoVO("매매의 기술","박병창","대출불가","327.856-박44ㅁ","2021-07-12"));
		boList.put("소크라테스 익스프레스",new BoVO("소크라테스 익스프레스","에락와이너","대출가능","160.21-탈29ㅅ",""));
		boList.put("운의 알고리즘",new BoVO("운의 알고리즘","정회도","대출가능","325.211-스18ㅇ",""));
		boList.put("긴긴밤",new BoVO("긴긴밤","루리","대출가능","813.8-루298ㄱ ",""));
		boList.put("주식어휘사전",new BoVO("주식어휘사전","황족","대출불가","327.856-최68ㅈ","2021-08-21"));		
		
	}

}
