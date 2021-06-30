import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner scan = new Scanner(System.in);
	
	public ExceptionTest() {		
	}

	public void start() {
		do {
			try {
				//�μ��� �Է¹޾� ��Ģ�����Ͽ� ����϶�
				System.out.print("ù��°��=");				//String�� �־��ָ� int�� ���...
				int n1 = Integer.parseInt(scan.nextLine()); //-----------------------------------------
				System.out.print("�ι�°��=");
				int n2 = Integer.parseInt(scan.nextLine());//-----------------------------------------          
											//�ֿܼ��� int�� �ƴ� �����͸� �Է��ϸ� ������ ����....
				
				int plus = n1+n2;
				int minus = n1-n2;
				int mul = n1*n2;
				int devide = n1/n2;//=========== // Runtime-�����Ͽ����� ������ ������ ����ÿ� ������������...
												 //������ �������ְ� �ȳ������ִ�..��ǻ�ʹ� 0���� �����°��� ������ ����������..:0�� ������ ����������
				
				System.out.println(n1+"+"+n2+"="+plus);
				System.out.println(n1+"-"+n2+"="+minus);
				System.out.println(n1+"*"+n2+"="+mul);
				System.out.println(n1+"/"+n2+"="+devide);	
			
				String names[] = {"ȫ�浿","��浿"}; //runtime ����
				for(int i=0; i<=names.length; i++) {
					System.out.println("names["+i+"]="+names[i]);
				}
				
				
			}catch(InputMismatchException imie) { //����Ʈ�ؾ���,,//�����Է¿��� ���������� imie�� �����--���������� �߻��ϸ� �� ����ο´�... 
													// ���� ���������� �ñ��ϸ� ����imie �� ����...//imie�� �ͼ��� ��ӹް��ִ�
													//catch �ȿ��� ����ɾ� ���డ����
					System.out.println("������ �Է��Ͼ߿��մϴ�.");
					//imie.printStackTrace(); //�����޽��� ����� 
					System.out.println(imie.getMessage()); //���� ��ſ� getMessage ����Ҽ����ִ�-String���� return����
					
			}catch(ArithmeticException ae) { 	
					
					System.out.println("0���� ������ �����ϴ�.");
					//ae.printStackTrace();
					System.out.println(ae.getMessage());//by zero�� ��������
				
			}catch(ArrayIndexOutOfBoundsException aioo) {
					
					System.out.println("�迭�� �������� �߸��Ǿ����ϴ�.");
					System.out.println(aioo.getMessage());
			}catch(NumberFormatException nfe) {
				System.out.println("���ڸ� �Է��Ͽ��� �մϴ�...");
					
			
			}finally {
					//���ܹ߻��� ������� ������ �����.
					System.out.println("final�� �����...");
			}
		}while(true);
	//catch�� ����
	//System.out.println("���α׷�����"); //do-while���� �߰����� ���������
	}
	
	
	
	
	public static void main(String[] args) {
		ExceptionTest et = new ExceptionTest();
		et.start();
		//���α׷�����޽�������� �̰����� ������ 		
	}

}
/*
  		���� : �ϵ���� ���� ó�� ���α׷����� �����Ҽ� ���� ������ ���Ѵ�.
  		����ó�� : ���α׷����� �����Ҽ��ִ� ������ Exception�̶�� �Ѵ�.
  		
  		//1.���
  		 try{ 
  		 		���๮;
  		 		���ܹ߻��� ������ �ִ� ��ɾ� �Ǵ� ���ܹ߻��� ���ɼ��� ���� ��ɾ ��� ǥ���Ҽ� �ִ�.  		 
  		 }catch(��������){
  		 		���ܰ� �߻��ϸ� ������ ���๮
  		 }catch(��������){
  		 		���ܰ� �߻��ϸ� ������ ���๮
  		 }
  		 :
  		 :
  		 finally{
  		 		���ܰ� �߻��ϵ� ���ϵ� ������ ����Ǵ� ���๮;
  		 		-���������ϴ�.
  		 }
  		 
 */

