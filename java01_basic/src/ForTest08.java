import java.util.Scanner;
class ForTest08 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		for (; ; ){
		
			System.out.print("메뉴[1.사각형의 넓이, 2.원의넓이, 3.종료]?");
			int menu = scan.nextInt();
	
			if(menu == 1){
				System.out.print("가로=");
				int w = scan.nextInt();
				System.out.print("세로=");
				int h = scan.nextInt();
				int rect = w*h;
				System.out.println("사각형의 넓이"+rect);
			
			}else if(menu==2){
				System.out.print("반지름=");
				int r = scan.nextInt();
				double circle = r*r*3.141592;
				System.out.println("원의넓이="+circle);
			}else if(menu == 3){
				System.exit(0);
			}else{
				System.out.println("메뉴를 다시 선택하세요.....");
			}
		
		
			
		
		
		}//for문
	}
}
		
	


/*
사각형의 넓이 = 가로*세로
원의 넓이=반지름*반지름*3.141592

실행
메뉴[1.사각형의 넓이,2.원의넓이 3.종료]?1
가로=
세로=
사각형의 넓이=

메뉴[1.사각형의 넓이,2.원의넓이, 3.종료]?2
반지름=
원의 넓이=

메뉴[1.사각형의 넓이,2.원의넓이, 3.종료]?3

*/