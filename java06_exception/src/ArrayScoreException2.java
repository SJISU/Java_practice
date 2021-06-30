import java.util.Scanner;
public class ArrayScoreException2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print("학생수=");
			int cnt = Integer.parseInt(scan.nextLine());
			
				
			//데이터 저장할 공간 확보
			String name[] = new String[cnt]; //학생이름을 저장할 배열,
			int [][]jumsu = new int[cnt+2][6];//정수를 저장할 배열 //학생점수저장 //3명이면 5행6열 7명이면 9행6열 10명 12행6열
											 //[입력받은 이름수+2(총점,평균)][과목+총점 평균 석차]
			//이름과 점수를 입력받아 배열에 저장
			String title[] = {"국어","영어","수학"}; //과목타이틀명이랑 저장되는 위치가 동일
			
			for(int i=0;i<cnt; i++){ //0,1,2 <-행번호
				
				System.out.print("이름=");
				name[i] = scan.nextLine();
				
				for(int j=0; j<title.length; j++){ //0,1,2 <-열번호
					
					System.out.print(title[j]+"=");
					jumsu[i][j]= Integer.parseInt(scan.nextLine());
				}			
			} //여기까지 이름들어가있고 점수 들어가 있다.
			
			//***************************출력까지하고 올라와서 다시 개인별 총점과 평균 ,과목별 총점을 구한다.
			//개인별 총점, 평균
			//과목별 총점
			for(int i=0; i<cnt; i++) { // 0,1,2//학생수만큼돌린다 //0행0열일때는
				for(int j=0; j<3; j++) {//0,1,2
				jumsu[i][3]+=jumsu[i][j]; //개인별총점
				jumsu[cnt][j]+=jumsu[i][j];//과목별총점
				
				}
				//개인별평균
				//0행의 3열에있는걸 3으로 나눠어서 4열에
				jumsu[i][4]=jumsu[i][3]/3;
			}
			//**************************************** 다구하고 나서 과목별평균과 석차 구하기
			//과목별 평균 //모든처리가 끝나야 과목별평균 구할수있다.
			for(int i =0; i<3; i++) {
			jumsu[cnt+1][i]= jumsu[cnt][i]/cnt;		
			}
			
			//석차구하기-학생수만큼돌린다
			for(int i=0; i<cnt;i++) { //0,1,2,3
				//i가 본임점수위치
					for(int j=0; j<cnt; j++) {//j는 비교할 다른사람의점수
						// 내점수           상대방점수
						if(jumsu[i][3] < jumsu[j][3]) { //i번째3열이 내점수
							jumsu[i][5]++; //나보다 점수높은 사람나오면 0에서 +1씩 누적,나보다안크면실행안됨
						}
					}
					jumsu[i][5]++; //*****?
			}
			//석차순으로 정렬 -오름차순
			for(int i=0; i<cnt-1; i++) { //3명이면 ->0,1 
				//               3-1-0
				for(int j=0; j<cnt-1-i; j++) { //3명이면->0,1
					if(jumsu[j][5] > jumsu[j+1][5]){ //석차는 다 5열에 있음
						//교환
						//이름바꾸기
						String nameTemp = name[j];
						name[j]=name[j+1];
						name[j+1]= nameTemp;
						
						for(int k=0; k<jumsu[j].length;k++) {//j 행의칸수만큼
							int temp = jumsu[j][k]; //j행의 국어점수를 k에 두고
							jumsu[j][k] = jumsu[j+1][k];
							jumsu[j+1][k] = temp;
						}  					
					}
				}
			}		
			
			System.out.println("===================================================");
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t석차");
			System.out.println("===================================================");
			
			//이름을 왼쪽에 찍고 이름과 점수배열은 인덱스를 가지고 연결해서 쓴다 학생수만큼돌린다
			//출력
			for(int i=0;i<cnt; i++){ //i=0
				//이름먼저출력
				System.out.print(name[i]+"\t");
				//점수 출력 : 첫번째 사람의 국어 영어 수학 총점 평균 석차 찍어야함 //행번호를 기준으로 열만 바뀌면된다
				for(int j=0; j<jumsu[i].length; j++) {
					System.out.print(jumsu[i][j]+"\t");				
				}
				System.out.println();			
			}
			//3명일때 총점과 평균은 3행4행,10명일때는 10행11행// 개인별총점은 이동하지않지만 과목별총점은 움직인다
			// 학생수+1
			//과목별총점
			System.out.print("총점\t");
			for(int i=0;i<3; i++){  //3과목
				System.out.print(jumsu[cnt][i]+"\t");
			}
			System.out.println();
			//과목별평균
			System.out.print("평균 \t");
			for(int i=0;i<3; i++){ 
				System.out.print(jumsu[cnt+1][i]+"\t");
			}
		}catch(NumberFormatException e) {
			System.out.println("Exception--> "+e.getMessage());
		}catch(Exception d) {
			System.out.println("Exception ~~>"+d.getMessage());
		}
	}		
}

/*
 학생수를 입력받아 이름과,세과목의 점수를 입력받은후 
 각 학생의 총점, 평균, 석차,과목별,총점평균을 구하여
 석차순으로 출력하라
 
 실행
 학생수=3
 이름=홍길동
 국어=90
 영어=89
 수학=90
 이름=이순신
 국어=
 영어=
 수학=
 .
 .
 .
 ===============
 이름		국어		영어		수학		총점		평균		석차		
 홍길동   	90		89		90		269				1
 이순신 		90		90		43		223				2
 .
 .
 .
 과목별총점  국어총점
 과목별평균 
 
 */
