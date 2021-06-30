import java.util.Random;
public class RandomTest {

	public static void main(String[] args) {
		//Random : 난수 생성클래스 //static이 없기때문에 객체만들어야함
		Random ran = new Random();
		
		for(int i =1; i<=1000; i++) {
			
			//정수(int)를 구해주는 난수 //객체명.nextInt();
			//int random = ran.nextInt(); //-21억~21억
			//int random = ran.nextInt(100); //0~99사이의 난수
			//int random = ran.nextInt(50); //0~49사이의 난수
			//boolean random = ran.nextBoolean(); //논리형-true,false
			//50~100 사이의 값을 나오게해라 -> 큰값-작은값+1 하면 0~51 나오니깐 +작은값(50)
			int random = ran.nextInt(51)+50;
			System.out.print(random+"\t");
			
			if(i%10==0){
				System.out.println();
				
			}
		}
	}

}
