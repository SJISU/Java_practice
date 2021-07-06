import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		//file : ���ϰ�ο� ���ϸ����� ��ü�� �����Ͽ� ��ü�� ������ ���� �� �ִ�.
		
		File f1 = new File("D://testFile");
		File f2 = new File("D://");
		File f3 = new File("D://testFile/Gugudan.java");
			
		File f4 = new File("D://testFile","Gugudan.java");
		File f5 = new File(f1,"Gugudan.java");
			
		File f6 = new File("D://testFile/createJava");//�������� : ����������ġ/����������--1.��ü�����
		
		try {
			//2.���������ϱ�
			if(!f6.exists()){//������������ Ȯ��-> ������ true ,������ false�� ���ϵǴ� �޼ҵ�-->f6�� �ֳ����� Ȯ�� --> ������������ �����ϱ� ������ ����� ������true�� ���ͼ� ���� ������ش�
				//mkdirs() : ���������ϱ�
				if(f6.mkdirs()) { 
					System.out.println("������ �����Ǿ����ϴ�");
				}else {
					System.out.println("������ ���� �����Ͻ��ϴ�");
				}				
			}
			
			//3.���ϻ����ϱ�
			//create�ڹپȿ� ���ϸ����
			File f7 = new File(f6, "abcd.txt"); //Ȯ���� : txt���Ϸ�
			if(!f7.exists()) {
				//createNewFile() : ���ϻ����ϱ�
				if(f7.createNewFile()) {
					System.out.println("������ �����Ǿ����ϴ�");
				}else {
					System.out.println("������ ���� �����Ͻ��ϴ�");
				}
			}
			
			//4.������ ������ �˾Ƴ��� -->������������ �����������Ͼ˾Ƴ��� -> f3,f4 �Ѵٰ���
			long lastDate =f3.lastModified();
			System.out.println("lastDate"+lastDate); //lastDate1623138346328 --> �̷��� ��³����°� ī������ ��������
			
			Calendar now = Calendar.getInstance(); 
			now.setTimeInMillis(lastDate);//�и��ʸ� ī���ٿ� ����
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
			String modifieDate = sdf.format(now.getTime());
			System.out.println("������������"+modifieDate);
			
			//5.��������Ȯ��
			boolean exe = f5.canExecute();//������ ��������Ȯ��			
			boolean read = f5.canRead();//�бⰡ��			
			boolean write = f5.canWrite();//���Ⱑ��
			
			System.out.println(exe+":"+read+":"+write);
			
			//6. Ư������̺� Ȥ�� ������ �ִ� ���� �� �������� ������
			// C://, D://
			File f8 =new File("C://"); // ��ü����� 
			File[] fileList = f8.listFiles(); //���ϵ��� �迭�� �־���
			/*
			  getPath() : ������ + ���ϸ�
			  getName() : ���ϸ�
			  getAbsolutePath() : ������ + ���ϸ�
			  getParent() : ������
			 */
			for(File f:fileList) {
					//�������� Ȯ�� : isDirectory()
					if(f.isDirectory()) {
						System.out.println(f.getPath());
					if(f.isHidden()) {
						System.out.println(f.getPath()+"[��������]");
					}else {
						System.out.println(f.getPath()+"[����]");
					}					
					//�������� Ȯ�� : isFile()
					}else if(f.isFile()) {						
						if(f.isHidden()) {
							System.out.println(f.getPath()+"[��������]");
						}else {
							System.out.println(f.getPath()+"[����]");
						}
					}
				}
			
			//7.���� �ý����� ����̺긦 ���Ѵ�.
			File[] root =File.listRoots();
			for(File ff: root) {
				System.out.println(ff.getPath()); // c����̺� d����̺�
			}
			
			//8.������ũ�� :byte
			long size =f3.length();
			System.out.println("size="+size);
			
			//9.���ϻ���
			boolean result = f3.delete(); //->�����ϰ��� ���������� �������������� ��������
			if(result) {
				System.out.println("������ �����Ǿ����ϴ�");
			}else {
				System.out.println("������ ���� �����Ͽ����ϴ�");
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
