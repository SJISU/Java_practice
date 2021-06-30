class ForTestBreak2 
{
	public static void main(String[] args) 
	{
		abc://라벨링
		for (int i =1 ; i<=10 ; i++ ){

			for (int j =1 ; ;j++ ){
				System.out.println("i="+i+",j="+j);
				if (j>5){
					break abc;
				}
			}
			//////break 는 여기로 넘어옴
			/// 라벨링이 없었다면 break다음 다시6열로가서 i=2가 실행되었을것이나 라벨링이 되어 for전체가 멈춤
			

			/*
			if (i>3){
				break;
			}
			*/
		
		}//for
		System.out.println("========");
	}
}
