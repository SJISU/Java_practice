import test.DefaultData; 
import test.LottoOOP;

public class ModfierTest {

	public ModfierTest() { //����Ŭ������ �����ڿ��� ��ü����
//		LottoOOP lotto =new LottoOOP(); //LottoOOP�� ������־���� - ��Ű��(����)�� �ٸ��� import����� ��밡����,,
//		lotto.lottoStart();
	
		DefaultData dd =new DefaultData();
		//��ü��.�������-�� ��ü�ȿ��ִ� �����Ϳ� ���ٰ���
		//System.out.println("�̸�="+dd.name); //��������տ� public �� �־�� �θ����ִ�..
		//System.out.println("����ó="+dd.tel); //class DefaultData���� ������� String�տ� public�̾��⶧�����Ұ�
		
		//������ ��������� �ʿ��ϸ� �޼ҵ带 ���ؼ� �ҷ��ü�����
		System.out.println("�̸�="+dd.getName());
		
		DefaultData dd2 =new DefaultData("�̼���","010-8888-8888"); 
		
		dd2.sum(); 
				
		
		DefaultData.sum(); //sum�տ� ststic�� �پ��־ ��ü�ȸ���� Ŭ������.�޼ҵ�()
		//DefaultData.getName(); -> �Ұ���
	
	}

	public static void main(String[] args) {
		//����������
		// Ŭ���� : public ,default(����)
		//������޼ҵ�, �޼ҵ� :  public ,protected, default, private
		
		new ModfierTest(); //��ü���� - �����޼ҵ���� �޼ҵ� ȣ���..
		
	} 

}
//33��° �ٿ��� ���簴ü�� �����޼ҵ带 �����Ų��..�����޼ҵ忡�� DefaultData Ŭ������ ��ü�� �������
//16�ٿ��� DefaultData��ü�� �޼ҵ带 �̿��Ͽ� ��ü�� �������� name ���...
//18��° �ٿ��� dd2 ��ü�� ���� DefaultData Ŭ������ �Ű������� �ִ� �����޼ҵ带 ����..
//20��°�� 23��° �� ��� �����...DefaultData Ŭ������sum�޼ҵ�� �տ�  static�� �־ Ŭ������.�޼ҵ�ε� ȣ�Ⱑ��