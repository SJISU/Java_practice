import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		//file : 파일경로와 파일명으로 객체를 생서하여 객체의 정보를 얻을 수 있다.
		
		File f1 = new File("D://testFile");
		File f2 = new File("D://");
		File f3 = new File("D://testFile/Gugudan.java");
			
		File f4 = new File("D://testFile","Gugudan.java");
		File f5 = new File(f1,"Gugudan.java");
			
		File f6 = new File("D://testFile/createJava");//폴더생성 : 만들폴더위치/만들폴더명--1.객체만들기
		
		try {
			//2.폴더생성하기
			if(!f6.exists()){//폴더존재유뮤 확인-> 있으면 true ,없으면 false가 리턴되는 메소드-->f6이 있나없나 확인 --> 있으면할일이 없으니깐 없을때 물어보고 없으면true가 나와서 폴더 만들어준다
				//mkdirs() : 폴더생성하기
				if(f6.mkdirs()) { 
					System.out.println("폴더가 생성되었습니다");
				}else {
					System.out.println("폴더가 생성 실패하습니다");
				}				
			}
			
			//3.파일생성하기
			//create자바안에 파일만들기
			File f7 = new File(f6, "abcd.txt"); //확장자 : txt파일로
			if(!f7.exists()) {
				//createNewFile() : 파일생성하기
				if(f7.createNewFile()) {
					System.out.println("파일이 생성되었습니다");
				}else {
					System.out.println("파일이 생성 실패하습니다");
				}
			}
			
			//4.마지막 수정일 알아내기 -->구구단파일의 마지막수정일알아내기 -> f3,f4 둘다가능
			long lastDate =f3.lastModified();
			System.out.println("lastDate"+lastDate); //lastDate1623138346328 --> 이렇게 출력나오는걸 카렌더로 만들어야함
			
			Calendar now = Calendar.getInstance(); 
			now.setTimeInMillis(lastDate);//밀리초를 카렌다에 샛팅
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
			String modifieDate = sdf.format(now.getTime());
			System.out.println("마지막수정일"+modifieDate);
			
			//5.파일유무확인
			boolean exe = f5.canExecute();//실행형 파일유무확인			
			boolean read = f5.canRead();//읽기가능			
			boolean write = f5.canWrite();//쓰기가능
			
			System.out.println(exe+":"+read+":"+write);
			
			//6. 특정드라이브 혹은 폴더에 있는 파일 및 폴더정보 얻어오기
			// C://, D://
			File f8 =new File("C://"); // 객체만들기 
			File[] fileList = f8.listFiles(); //파일들을 배열에 넣어줌
			/*
			  getPath() : 폴더명 + 파일명
			  getName() : 파일명
			  getAbsolutePath() : 폴더명 + 파일명
			  getParent() : 폴더명
			 */
			for(File f:fileList) {
					//폴더인지 확인 : isDirectory()
					if(f.isDirectory()) {
						System.out.println(f.getPath());
					if(f.isHidden()) {
						System.out.println(f.getPath()+"[숨긴폴더]");
					}else {
						System.out.println(f.getPath()+"[폴더]");
					}					
					//파일인지 확인 : isFile()
					}else if(f.isFile()) {						
						if(f.isHidden()) {
							System.out.println(f.getPath()+"[숨긴파일]");
						}else {
							System.out.println(f.getPath()+"[파일]");
						}
					}
				}
			
			//7.현재 시스템의 드라이브를 구한다.
			File[] root =File.listRoots();
			for(File ff: root) {
				System.out.println(ff.getPath()); // c드라이브 d드라이브
			}
			
			//8.파일의크기 :byte
			long size =f3.length();
			System.out.println("size="+size);
			
			//9.파일삭제
			boolean result = f3.delete(); //->삭제하고나서 지워졋는지 안지워졋늦지를 리턴해줌
			if(result) {
				System.out.println("파일이 삭제되었습니다");
			}else {
				System.out.println("파일이 삭제 실패하였습니다");
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("~~~~~");
		
	}

	public static void main(String[] args) {
		new FileTest();
	}

}
