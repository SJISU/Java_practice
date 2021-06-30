import java.util.Scanner;

public class EmailCheckEx_Ans {
	
		

	public EmailCheckEx_Ans() {		
	}
	
	//���ο��� ȣ��Ǿ ����Ǵ� �޼ҵ�...
	public void start() {
		do {
			String email = inputEmail();
			 if(emailCheck(email)) { //����ε� �̸���
				 //���̵�,������ �и��ؼ� ���
				 emailPrint(email);
			 }else {//�߸��� ����
				 errorMailMessage(email);
			 }			
		}while(true);		
	}
	
	//�̸��� �Է�
	public String inputEmail() {
		Scanner scan  = new Scanner(System.in);
		System.out.print("�̸��� �Է�=");
		return scan.nextLine();
	}
	
	//�̸����� ����,�߸� Ȯ�� 
	public boolean emailCheck(String email) {
		//���� : true , �߸� : false
		
		//@ : atmark
		//@�̰� �־����� -@��ġ ã�ƾ���...indexOf �Ǵ� laseindexOf
		int atmark = email.indexOf("@");  //������ -1�� ���´�..
		int point = email.indexOf(".");
		//@�̰� . ���� �տ� �;��Ѵ�, @�̿�.���̿� �������� �־���ϹǷ� .-@�̴� ��� 2���� Ŀ���Ѵ�
		if(atmark ==-1 || point==-1 || atmark>point || point-atmark<=2 ) {//�߸��� �����ּ��϶� 
			return false;
		}else {//������� �϶�
			return true;
		}		
	}
	
	//�߸��� ���� �޽���
	public void errorMailMessage(String email) {
		System.out.println(email+" �߸��� �̸��� �ּ��Դϴ�.");
	}
	
	//���̵�� �����κи��Ͽ� ���
	public void emailPrint(String email) {
	   /*
	    split ����Ͽ� ���ϴ¹��
		String emailSplit[] = email.split("@");//0��°�� ���̵� 1��°�� ������
	    System.out.println("���̵�"+emailSplit[0]);
	    System.out.println("������"+emailSplit[1]);	
	   */
	
		//substring ����Ͽ� ���ϴ¹��
		//@�� ��ġ���Ͽ� @��ġ�� �������� ���̵�� ������ ���Ѵ�...
		int atmark = email.indexOf("@");
		String id = email.substring(0,atmark);
		String domain = email.substring(atmark+1);
		System.out.println("���̵�"+id);
	    System.out.println("������"+domain);			
	}	
	
	
	public static void main(String[] args) { //���θ޼ҵ忡�� ��ü�� ����������..
		new EmailCheckEx_Ans().start();
	}

}
/*
 
 ����
 �̸��� �Է� = goguma@nate
 �̸����� �߸��Է��Ͽ����ϴ�..
 
 �̸��� �Է�=goguma777.com
 �̸����� �߸��Է��Ͽ����ϴ�
 
 �̸��� �Է�=goguma.nate@com
 �̸����� �߸��Է��Ͽ����ϴ� 
 
 �̸����Է�=goguma@nate.com
 ���̵� = goguma777
 ������ = nate.com
 
 �̸����Է�=
 
 
  */

// �Է� - Ȯ�� - ���� �Ǵ� ����
//�̸����Է�(�ݺ�) - �Է��ϰ��� �̸��� ��ȿ�� Ȯ��- �����̸����ΰ�쿡�� ���̵�� ������ �и��ؼ����
//								    - �����ΰ�쿡�� �����޽��� ���
