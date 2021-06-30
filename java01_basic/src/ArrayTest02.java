
public class ArrayTest02 {

	public static void main(String[] args) {
		//2차원 배열  : 행과 열을 가진다.
		
		//배열의 선언
		//      행 열
		int data[][] = new int[5][5] ; //int25개를 저장가능한 변수 생성됨
		
		data[0][3] = 100;
		data[1][2] = 85;
		data[1][4] = 84;
		data[3][3] = 77;
		
		//2차원 배열 출력 //밖 for문은 '행' 안 for문은 '열'
		for(int r=0; r<data.length; r++) { //행의 수 만큼 //length : 2차원배열일때는 행의수,1차원배열일때는 변수의갯수
			for(int c=0; c<data[r].length; c++){ // data[r].length -> r행의 칸수 //r행의 칸수만큼 돌고있음
				System.out.print(data[r][c]+"\t");
				
			}
			System.out.println();
		}	
		
		
		//2차원 배열의 초기값 설정
		String[][] jusorok = {
							   {"홍길동","010-1234-5678","abcd@naver.com"},
							   {"이순신","010-1234-5678","dfgh@naver.com"},
							   {"세종대왕","010-2345-6789","tyui@naver.com"}						   
		
							  };
			for(int r=0; r<jusorok.length; r++) {
				for(int c =0; c<jusorok[r].length; c++) {
				System.out.print(jusorok[r][c]+"\t");
				
				}
				System.out.println();
			}
		}
}
							   	
