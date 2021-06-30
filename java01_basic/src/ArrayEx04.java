
public class ArrayEx04 {

	public static void main(String[] args) {
		
		 /*int num[][] = new int[10][10];
		
		for(int r=0; r<num.length; r++) {
			for(int i =0; i<num[r].length; i++) {
				
				num[r][i] =(r+1)*(i+1);				
				
				num[r][9]=num[r][9]+num[r][i]; //행의합-누적
				num[9][r]=num[9][r]+num[r][i]; //열의합-9행의0열				
			}
		}
			for(int r=0; r<num.length; r++) {
				for(int i =0; i<num[r].length; i++) {
					System.out.print(num[r][i]+"\t");
				}
				System.out.println();
			}
			*/
		int data[][] = new int[10][10];
			
		for(int row=0; row<data.length-1; row++) { //행번호 -마지막행빼고
			for(int col=0; col<data.length-1; col++) {//열번호 0~8 까지 반복
				data[row][col]= (row+1)*(col+1); //숫자셋팅
				data[row][9]=data[row][9]+ data[row][col]; //행의 합 //같은위치의 9열 
				data[9][col]=data[9][col]+ data[row][col]; //열의 합 //
			}
		}
		
		for(int d[]:data) { //data에있는 첫번째줄넘겨줌
			for(int r : d) {
				System.out.printf("%5d",r);				
			}
			System.out.println();		
		}
	
	}
}



/*
 	1    2    3    4    5    6    7    8    9   45
    2    4    6    8   10   12   14   16   18   90
    3    6    9   12   15   18   21   24   27  135
    4    8   12   16   20   24   28   32   36  180
    5   10   15   20   25   30   35   40   45  225
    6   12   18   24   30   36   42   48   54  270
    7   14   21   28   35   42   49   56   63  315
    8   16   24   32   40   48   56   64   72  360
    9   18   27   36   45   54   63   72   81  405
   45   90  135  180  225  270  315  360  405    

 */
