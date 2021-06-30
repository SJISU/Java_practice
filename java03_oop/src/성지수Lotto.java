import java.util.Scanner;

public class LottoHw {

	public LottoHw() {
			}

	
	public void start() {
		do {
			int cnt = inputCnt(); //게임수 입력
								  //로또 실행 -난수,중복,정렬
								 //실행
			int[] Lotto = new int[6];
			
			
			
		}while(true);
		
	}
	//로또 게임수 입력
	public int inputCnt() {
		Scanner scan = new Scanner(System.in);
		System.out.print("게임수=");
		return scan.nextInt();
	}
	
	//로또 숫자 나오게하기
	public void lottoranmake(int lotto[]) {
		for(int game=1; game<=cnt; game++) {
		int[] Lotto = new int[6];
		for(int i =0; i<Lotto.length;i++) {
			Lotto[i] = (int)(Math.random()*45)+1;
		}
			
	}
	//중복검사
		
	//정렬
	public void sort (int [] array)	{
		int [] array = lotto[6];
		int temp = 0;
         for (int i = 0; i < arr.length-1; i++) {
                 for (int j = i+1; j < arr.length; j++) {
                         
                         if(arr[i] > arr[j]){
                                 temp = arr[i];
                                 arr[i] = arr[j];
                                 arr[j] = temp;
                         }
                         
                 }
         }
	}
	
	//출력
	/*public void print(int cnt) {
		int game = cnt;
		System.out.print(game+"게임=");
		for(int i =0; i<lotto.length-1; i++) { 
			System.out.print(lotto[i]+",");							
		}
		System.out.println("bonus="+lotto[6]);	
	}
	
	*/
	public static void main(String[] args) {
		new LottoHw().start();

	}

}
