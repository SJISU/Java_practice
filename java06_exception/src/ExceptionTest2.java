import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {
	Scanner scan = new Scanner(System.in);
	
	public ExceptionTest2() {}

	public void start()   {
		do {
			try {
				//�μ��� �Է¹޾� ��Ģ�����Ͽ� ����϶�
				System.out.print("ù��°��=");				//String�� �־��ָ� int�����...scan.nextInt���� ����������
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
			
				String names[] = {"ȫ�浿","��浿"}; //runtime ���� //�������� ������ ���࿡�� ��������.....
				for(int i=0; i<=names.length; i++) {
					System.out.println("names["+i+"]="+names[i]);
				}
				
				  //��翡���� ����Ŭ������ Exception�� �������ִ�
			
			}catch(ArrayIndexOutOfBoundsException aioo) { //Exception���� ���� �;��Ѵ�..
				System.out.println("�迭�� ÷�ڰ� ����");
			
			}catch(Exception e) {
				System.out.println("Exception--->"+e.getMessage());
			}
			
		}while(true);
	//catch�� ����
	//System.out.println("���α׷�����"); //do-while���� �߰����� ���������
	}	
	
	public static void main(String[] args) {
		ExceptionTest2 et = new ExceptionTest2();
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

