import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasAdapterTest extends MouseAdapter{
	
	MouseAdapterTest2.MyCanvas mc; //����Ŭ���� ����
	
	public CanvasAdapterTest() {
		
	}
	
	public CanvasAdapterTest( MouseAdapterTest2.MyCanvas mc) {//�Ű������� ���ؼ� mc �Ѱܹ޴´� 
															 //����Ŭ������ �ܺ�Ŭ���������ؼ�
		this.mc =mc;
	}
	
	//�޼ҵ� ��������̵�
	public void mouseReleased(MouseEvent me) {
	
		if(me.getButton()==1) {
			// x,y,mc�� ����
			//�Ű������� ���ؼ� mc �Ѱܹ޴´�-> �Ѱܹ޾Ƽ� x,y 
			mc.x = me.getX();
			mc.y = me.getY();
			mc.repaint(); //����Ʈ�޼ҵ�ȣ��.....mc�� ����
			
			
		}
		
	}

}
