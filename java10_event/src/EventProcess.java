import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class EventProcess implements ActionListener{
	
	JLabel lb1;
	
	public EventProcess() {
		
	}
	public EventProcess(JLabel lb1) {
		this.lb1=lb1;
	}
	
	
	//			actionPerformed(ActionEvent)
	public void actionPerformed(ActionEvent ae) {//�����Ϸ��� �̺�Ʈó���ɶ��� �����;��Ѵ�..?
		lb1.setText("�̺�Ʈ�� �߻���........"); //��ư������ ���� �ٲ����ϴϱ� ���� ���� �ٽú����ش�
		
	}
	
	
	

}
