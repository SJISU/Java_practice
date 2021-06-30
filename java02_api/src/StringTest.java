
public class StringTest {

	public StringTest() {
		//
	}	
	public void start() {	
		
		//				0 1234 56 78 90 //���鵵 �Ű���
		String str1 = "����� ������ �ż���"; //�Ϲݵ������� ����ó�� ����
		String str2 = "����� ������ �ż���";
		String str3 = new String("����� ������ �ż���"); // new�� �̿��Ͽ� ��ü�� ����  ------- str1~3���� �����͵��� ������
		String data = str3; //�̹̰�ü�θ������ ���Խ�Ŵ-�����ǵ����͸� �־��ذ� // str3�� data�� �ּҰ� ������ //���Ҷ� equals�� �ƴ� == ��밡���ϰ�..//�ϳ��ǰ����� �ΰ��� ������ ����ϰ�����..
		
		byte[] byteData = {65,66,67,68}; //�ƽ�Ű�ڵ尪 -> ABCD :�ƽ�Ű�ڵ尪�� ���ڷ� ���
		String str4 = new String(byteData); //"ABCD" �� ������ -�ƽ�Ű�ڵ尡 ���ڷ� �� ����
		
		char[] charData = {'x','y','z'} ; //"xyz" - �Ѱ��� ���ڿ��� ��Ÿ��������� �Ʒ��ٷ� ǥ��
		String str5 = new String(charData); 
		
		int[] intData = {65,66,67,68,69,70};
		String str6 = new String(intData,2,3); //index 2���� 3���� ���ڷ� �����϶�. //67 68 69 -> cde
		
		System.out.println("byteData="+str4);
		System.out.println("charData="+str5);
		System.out.println("intData="+str6);
		
		
		
		if(str1 == str2) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ���");
		}
		

		if(str1 == str3) { //��ü�� �����ϴ� ����� �ٸ� str1,str3 // ==�� �Ϲݵ����� ���� �������̴� ��ü�� ���Ҷ��� == ���x.. �ƴϸ� ��ü�ȿ��ִ� ������������ؾ��Ѵ�..�޼ҵ带 ������Ѵ�
			System.out.println("����~~~");
		}else {
			System.out.println("�ٸ���~~~");
		}		
		
		if(str1.equals(str3)) { //��ü�� ��ü�� �������� ���Ѵ�...str3.equals(str1) �� ����ص� ����
			System.out.println("����----");
		}else {
			System.out.println("�ٸ���----");
		}		
		
		if(str3 == data) {
			System.out.println("����,,,,");
		}else {
			System.out.println("�ٸ���,,,,");
		}
		
		
		str3 = "����� ���α�";
		System.out.println(str3);
		System.out.println(data); // --str3�� �ּҴ� �ٲ������ data���ּҴ� ������� ��������
		
		//charAt()
		char c = str1.charAt(2);//index��ġ�� ���� 1���� ���´�.
		System.out.println("str1.charAt(2)->"+c); //�̸��Ͼ��� @�� �ȳ����� ������� ���ö� Ȱ���ϴ� ���
		
		//concat()
		String result = str1 + str2 ;//���ڿ� ����
		String result2 = str1.concat(str2); //���ڿ� ������
		System.out.println("result="+result);
		System.out.println("result2="+result2);
		
		//             01234567890123456789
		String data2 ="Java String Test....";
		String data3 ="java string test....";
		//equals
		if(data2.equals(data3)) { //�ڹٴ� ��ҹ��ڰ� ��Ȯ�ϱ⶧���� �ٸ��ٰ� ���´�...
			System.out.println("����$$$");
		}else {
			System.out.println("�ٸ���$$$");
		}		
		
		//equalsIgnoreCase ��ҹ��� �������� ��
		if(data2.equalsIgnoreCase(data3)) {
			System.out.println("����...");
		}else {
			System.out.println("�ٸ���...");	
		}
		
		// getBytes[] -����Ҷ� ���...
		byte[]byteCode = data2.getBytes(); //���ڿ��� byte�迭�� ���Ѵ�.
		for( byte b : byteCode) {
			System.out.println((char)b+"-->"+b);
		}
		
		//index0f Ư���� ���ڰ� ���° ��ġ))�� �ִ��� �˾Ƴ��°�
		int idx = data2.indexOf("t");//Ư�������� index��ġ�� ���Ѵ�..
		System.out.println("indexOf->"+idx); //��������t�����Ѱ� 
		//�ڿ������� t�� ���ϰ������ -> 1.ã�½��������������ֱ� 
		int idx2 = data2.indexOf("t",10); 
		System.out.println("indexOf->"+idx2);
		
		int idx3 = data2.lastIndexOf("t"); // 2.�ڿ�������ã�� -Ư�����ڸ� �ڿ��� �˻��Ͽ� index�� ���Ѵ�.
		System.out.println("lastindexOf->"+idx3);
		
		//length -������ ���̱��ϱ�
		System.out.println("length="+data2.length()); //���������ϰ� ���ڱ��� ���
		
		//String data2 ="Java String Test....";
		//Ư�����ڸ� �ٸ����ڷ� �����Ѵ�.
		data2 = data2.replaceAll("a", "����"); //a�� ���� �� �ٲ۴� - ������ ���Ծ��ϸ� �����̾ȵȴ�
		System.out.println("replaceAll->"+data2);
		
		//split ���ڸ� ���� ���ϴ� ��ġ�� �������°�...-ȸ�����Խ� ��ȭ��ȣ 3ĭ�� �Է��Ҷ� -������ 1���ε� �����ʹ� 3��...db�� �������� ��� �ִ´�..
		//Ư���� ���ڿ��� �������� �迭�� return���ش� - 
		String data4= "010-1234-5678" ;
		String [] tel =data4.split("-"); //�迭�� ����������..
		for(int i=0; i<tel.length; i++) {
			System.out.println("tel["+i+"]="+tel[i]);
		}
		
		//substring()-Ư�����ڿ����� �Ϻ� ���ڿ������´�.�ڵ�����ȣ ��� �ڸ��� �ʿ��Ҷ�..
		String tel1 = data4.substring(4); //1234-5678
		String tel2 = data4.substring(4,8); // (���۽���,�������)
		System.out.println(tel1+","+tel2);
		
		//toCharArray() ���ڿ��� char�迭�� �����ش� // data2=J����v���� String Test...
		char[]  charData2 = data2.toCharArray();
		for(char cc:charData2) {
			System.out.println(cc);
		}
		
		//toLowercase():�ҹ��� toUpperCase():�빮�� 
		String toLower = data2.toLowerCase();
		String toUpper = data2.toUpperCase();
		System.out.println(toLower+","+toUpper);
		
		//trim() : ���ڿ��� ���ʿ� ���鹮�� �����. - ���̵� �Է��Ҷ�....
		String data6 ="    Spring    FrameWork    "; 
		String dataTrim = data6.trim();
		System.out.println("AA"+dataTrim+"BB");
		
		//�����ε� valueOf - ���� �����͸� ���ڷ� ��Ÿ��������� 
		int num =1234;
		String s1 = num +"";//����ȭ
		String s2 = String.valueOf(num); //�տ� static�� �ֱ⶧���� ��ü�ȸ��� �ȴ�..
		System.out.println(s1+1234);
		System.out.println(s2+5678);
		
		char[] aa = {'S', 'T','U'};
		String sss = new String(aa); //�����ڸ޼ҵ��̿�
		String sss2 = String.valueOf(aa);//���ڸ޼ҵ��̿�
		
		System.out.println(sss);
		System.out.println(sss2);
		
		//compareTo - ���ڿ� ���ڸ� �� -ù��°�ִ±��ڳ����� -���ٸ� �ι�° ���ڳ�����- +�������� ������ū�� - �������� ��������ū��
		String data7 = "Apple";
		String data8 = "apple";
		int r1 = data7.compareTo(data8); //65-97 = -32 ����̸� ���ʰ�ü�� ũ�� , �����̸� �����ʰ�ü�� ũ�� ,0�� �ΰ�ü ũ�� ����.
		int r2 = data8.compareTo(data7); // 97-65 = 32
		System.out.println(r1+","+r2);
		
		int r3 = data7.compareToIgnoreCase(data8); //��ҹ��� ���о��ϰ� ��
		int r4 = data8.compareToIgnoreCase(data7); 
		System.out.println(r3+","+r4);
		}

	
	
	public static void main(String[] args) {
		//���θ޼ҵ�� ��ü�����ϴ� ������ ���...
		new StringTest().start(); //�� ��ü�ȿ� �ִ� start��� �޼ҵ带 ����ض�

	}

}
