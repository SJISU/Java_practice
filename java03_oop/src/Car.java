
public class Car {
	int speed =0;
	final int SPEED_MAX = 180;
	final int SPEED_MIN=0;
	String carName = "�׷���";
	
	//������ �޼ҵ� 2��
	public Car() {//������ //��Ӱ����϶��� �Ű������� ���� ������ �� �־����..
		System.out.println("Car()�����ڸ޼ҵ� ����");
	}
	
	public Car(String carName) {//������
		this.carName = carName;
		System.out.println("Car(String)�����ڸ޼ҵ� ����");
	}	
	
	//�Ϲ� �޼ҵ� 2��
	public void speedUp() { //������������ ���ǵ�� ȣ���Ͽ� ���ǵ� �ö󰡰�
		speed++;
		if(speed>=SPEED_MAX) speed = SPEED_MAX;
		System.out.println("car.speedUp->speed="+speed);
	}
	
	public void speedDown() { //������������ ���ǵ�� ȣ���Ͽ� ���ǵ� �ö󰡰�
		speed--;
		if(speed<=SPEED_MIN) speed = SPEED_MIN;
		System.out.println("speedDown->speed="+speed);
	}
	

}
