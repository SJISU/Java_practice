import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelRead { //엑셀 읽기 // 엑셀읽어오기

	public ExcelRead() {		
	}	
	
	public void start() {
		try {
			
			File file = new File("D://testFile","member.xls");
			FileInputStream fis = new FileInputStream(file);
			
			//byteCode인 InputStream 엑셀 파일로 변환하는 클래스
			POIFSFileSystem poi = new POIFSFileSystem(fis); //FileInputStream을 넣어준다 //poi안에 워크북이 잇음 -> 그안에 시트가..행이..셀이
			
			//1. workbook객체 얻어오기
			HSSFWorkbook workbook = new HSSFWorkbook(poi); 
			
			// 시트의 수 구하기
			int sheetcnt =workbook.getNumberOfSheets();
			//System.out.println("시트수= "+sheetcnt);		
			
			//2.sheet객체 얻어오기 -> 시트명 or 인덱스
			HSSFSheet sheet = workbook.getSheet("회원목록"); // workbook.getSheetAt(1);
			
			//행의 수 구하기
			int rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("행의수= "+rowCount);
			
			//제목
			System.out.println("번호\t이름\t연락처\t\t나이\t등록일");
			
			for(int rowIdx=1; rowIdx<rowCount; rowIdx++) {
				//3. 행객체 구하기
				HSSFRow row=sheet.getRow(rowIdx);
				
				// 셀수 구하기
				int cellCount = row.getPhysicalNumberOfCells();
				//System.out.println("셀의 수= "+cellCount);
				for(int cellIdx=0; cellIdx<cellCount; cellIdx++) {
					
					HSSFCell cell = row.getCell(cellIdx); //셀이구해짐
					//번호,나이
					if(cellIdx==0 || cellIdx==3) {
						int date =(int)cell.getNumericCellValue();
						System.out.print(date+"\t");
					}else if(cellIdx==1 || cellIdx==2) { //이름,연락처
						String data = cell.getStringCellValue();
						System.out.print(data+"\t");
					}else if(cellIdx==4) { //등록일
						Date data = cell.getDateCellValue(); //날짜형식으로 데이터 가져오기
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						String dateStr = format.format(data);
						System.out.print(dateStr);
					}
				}
				System.out.println();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	public static void main(String[] args) {
		new ExcelRead().start();

	}

}
