import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//java.text-Class DecimalFormat
// .### .000 
public class DecimalDateFormat {

	public DecimalDateFormat() {
	 try{
		//�����͸� ���ϴ� ����������� ����� �մ� Ŭ����
		//���ڸ� ȭ������� �����...�׸��� �ٽ� ����..
		int data = 52123542;
		
		DecimalFormat format = new DecimalFormat("#,###��");//���ڸ� ǥ���ϰ� ���� �ٿ��� ǥ���Ҽ���
		
				//����ȭ�� ������
						  //��ü��.format()
		String dataFormat= format.format(data); //format api...formatŬ������ ��Ʈ����format�� api�� ���....//DecimalDateFormat�� api�� �޼ҵ� ����Ѱ�...
		System.out.println("dataFormat="+dataFormat);
		
		//�������� ��ȯ�� �����͸� ������� �ٲٱ� 
		//52,123,542�� -> 52123542   //���ڷ� �ٲٱ�...
		//NumberFormat�� ���������ڴ�  �̹Ƿ� ȣ����ؼ� ��ü�������ִ� �޼ҵ� �̿��Ͽ� ȣ��
		NumberFormat nf = NumberFormat.getInstance(); //��ü�������....
	    
		Number num=	nf.parse(dataFormat);//  ��ü��.parse() �� ��Ʈ���� �־��ָ� num�� ���������� //format()���ݴ��� //�ٽ� 5123542
	    int dataparse = num.intValue(); // intŸ������ ����ȯ..
	    System.out.println("dataparse="+dataparse);
	    
	    
	    //��¥����
	    //2021�� 6�� 4�� (��) 15:21
	    Calendar now = Calendar.getInstance();
	    
	    SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy�� MM�� dd�� (E) hh:mm:ss a");//��ü���� //���� ��Ÿ������� �������� ������� yyyy�� yy��..
	    //��¥ ����...ī���ٸ� ������ ������ ���õ����������� api������� ��¥ ����...
	    String dateStr= dateFormat.format(now.getTime()); //ī���ٰ�ä���� now.gettime
	    									//fotmat �� �����͸� �־��ָ� ��Ʈ������  ������ִ� �޼ҵ�
	    									//�츮�� ī������ ������ �ִµ� ����Ʈ�� �־�����ϱ⶧���� ī����Ŭ�������� �����͸� �������ִ� �޼ҵ带ã�Ƽ� 
	    									//format �����Ϳ� �ִ´�.....//getTime�޼ҵ尡 �����͸� �������ش�....
	    
	    System.out.println("dateStr--->"+dateStr);
		
	 }catch(Exception e) {}
	}

	public static void main(String[] args) {
		new DecimalDateFormat();
	}

}
//���ο��� ��ü������ �׸��� �����ڷ� ��