
public class MathRandomTest {

	public static void main(String[] args) {
		//난수 : 컴퓨터가 실행되는 시점에 0.0~1.0 사이의 값이 생성된다.
		
		// *100 -> 0~99		*50->0~99		곱하는수가100이면 0에서99까지나온다
		
		//Q.	->50~100   난수를 50에서100까지 출력하라
		for(int i=1; i<=1000; i++){
			double ran= Math.random();
			
			//			(정수화)난수*(큰값-작은값+1)+작은값  : 난수를 구하는 공식
			//							6-1+1
			int ranInt = (int)(ran*(100-50+1))+50;
			
			//int ranInt= (int)(ran*10); // (ran*50) (ran*100) (ran*1000)
			System.out.print(ranInt+"\t");
			if(i%10==0)System.out.println(); //10개씩 출력
			
		}
		
		//===================================================
		for(int i=1; i<=1000; i++) {
			int random =(int)(Math.random()*51)+50;
			System.out.print(random+"\t");
			if(i%10==0) {
				System.out.println();
			}
		}

	}

}
