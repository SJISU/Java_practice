import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelRead { //���� �б� // �����о����

	public ExcelRead() {		
	}	
	
	public void start() {
		try {
			
			File file = new File("D://testFile","member.xls");
			FileInputStream fis = new FileInputStream(file);
			
			//byteCode�� InputStream ���� ���Ϸ� ��ȯ�ϴ� Ŭ����
			POIFSFileSystem poi = new POIFSFileSystem(fis); //FileInputStream�� �־��ش� //poi�ȿ� ��ũ���� ���� -> �׾ȿ� ��Ʈ��..����..����
			
			//1. workbook��ü ������
			HSSFWorkbook workbook = new HSSFWorkbook(poi); 
			
			// ��Ʈ�� �� ���ϱ�
			int sheetcnt =workbook.getNumberOfSheets();
			//System.out.println("��Ʈ��= "+sheetcnt);		
			
			//2.sheet��ü ������ -> ��Ʈ�� or �ε���
			HSSFSheet sheet = workbook.getSheet("ȸ�����"); // workbook.getSheetAt(1);
			
			//���� �� ���ϱ�
			int rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("���Ǽ�= "+rowCount);
			
			//����
			System.out.println("��ȣ\t�̸�\t����ó\t\t����\t�����");
			
			for(int rowIdx=1; rowIdx<rowCount; rowIdx++) {
				//3. �ఴü ���ϱ�
				HSSFRow row=sheet.getRow(rowIdx);
				
				// ���� ���ϱ�
				int cellCount = row.getPhysicalNumberOfCells();
				//System.out.println("���� ��= "+cellCount);
				for(int cellIdx=0; cellIdx<cellCount; cellIdx++) {
					
					HSSFCell cell = row.getCell(cellIdx); //���̱�����
					//��ȣ,����
					if(cellIdx==0 || cellIdx==3) {
						int date =(int)cell.getNumericCellValue();
						System.out.print(date+"\t");
					}else if(cellIdx==1 || cellIdx==2) { //�̸�,����ó
						String data = cell.getStringCellValue();
						System.out.print(data+"\t");
					}else if(cellIdx==4) { //�����
						Date data = cell.getDateCellValue(); //��¥�������� ������ ��������
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
