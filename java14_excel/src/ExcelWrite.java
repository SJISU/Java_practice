import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelWrite { //엑셀쓰기
	
/*
 	엑셀환경설정
 	POI다운로드
 	jakarta.apache.org에서 왼쪽메뉴에서 POI를 선택한다
 	
 	poi-bin 5.0.0-20210120.zip을 다운로드한다.
 
 	압축을 푼후
 	poi-5.0.0.jar, commons-math3-3.6.1.jar build path를 설정한다.
 	
 	// 엑셀 워크북안에는 시트가 여러개 있다..
 	  시트안에는 행이 있다. 행안에는 셀 이라고 하는 칸들이 여러개 존재..셀안에는 데이터한개가 들어가있다.->값을 하나 넣으려면 워크북부터 필요....
 	 
  */	
	
	public ExcelWrite() {
	
	}
	
	//엑셀로저장하기
	public void start() {
		//1. workbook객체를 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//2. workbook객체를 이용하여 sheet객체를 생성
		HSSFSheet sheet1 = workbook.createSheet(); //시트명이 없이 만들어짐
		HSSFSheet sheet2 = workbook.createSheet("회원목록"); //시트명을 회원목록으로 만들어짐
				
		//3. sheet객체를 이용하여 row객체를 생성
		HSSFRow  row =sheet2.createRow(0); //매개변수로 int -> 행번호인덱스 //0행을 구함		
		
		//4. cell객체를 생성하고 값을 셋팅
		row.createCell(0).setCellValue("번호");//셀을구해서 값을 셋팅 //매개변수에는 셀인덱스.값셋팅 //첫번째줄첫번째칸에 값들어감
		row.createCell(1).setCellValue("이름");
		row.createCell(2).setCellValue("연락처");
		row.createCell(3).setCellValue("나이");
		row.createCell(4).setCellValue("등록일");
		
		//행생성 셀을 생성하여 값대입 
		//데이터셋팅
		HSSFRow row1 = sheet2.createRow(1);
		row1.createCell(0).setCellValue(100);
		row1.createCell(1).setCellValue("홍길동");
		row1.createCell(2).setCellValue("010-1234-5678");
		row1.createCell(3).setCellValue(25);
		row1.createCell(4).setCellValue(Calendar.getInstance());		
		
		HSSFRow row2 = sheet2.createRow(2);
		row2.createCell(0).setCellValue(200);
		row2.createCell(1).setCellValue("이순신");
		row2.createCell(2).setCellValue("010-1234-5678");
		row2.createCell(3).setCellValue(30);
		row2.createCell(4).setCellValue(Calendar.getInstance());
		
		HSSFRow row3 = sheet2.createRow(3);
		row3.createCell(0).setCellValue(300);
		row3.createCell(1).setCellValue("새종대왕");
		row3.createCell(2).setCellValue("010-1234-5678");
		row3.createCell(3).setCellValue(40);
		row3.createCell(4).setCellValue(Calendar.getInstance());
		
		//5. 파일로 쓰기
		File f = new File("D://testFile","member.xls");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			
			//workbook의 write메소드를 호출하면 파일로 저장된다..
			workbook.write(fos); //쓰기
			fos.close();
			workbook.close();
						
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("엑셀로 쓰기 완료....");		
		
	}
	public static void main(String[] args) {
		new ExcelWrite().start();
	}

}
