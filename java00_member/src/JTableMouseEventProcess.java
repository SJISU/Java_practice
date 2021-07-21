import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableMouseEventProcess extends MouseAdapter{
	
	JTextField[] formTf;
	JTable table;	

	public JTableMouseEventProcess() {
		
	}
	public JTableMouseEventProcess(JTextField[] formTf,JTable table ) {
		this.formTf=formTf;
		this.table = table;
	}
	//�̺�Ʈ ó��
	//Adapter - ���ϴ¸޼ҵ常 �������̵�
	public void mouseReleased(MouseEvent  me) {
		if(me.getButton()==1) { //���ʹ�ư Ŭ���Ǹ�
			//���� Ŭ���� ���� ���Ͽ�
			int row = table.getSelectedRow(); // 0,1,2,3,4... ->������ Ŭ���ߴ��� ����
			//				  table.getColumnCount();
			for(int col=0; col<formTf.length; col++) {
				if(col==0) {
					formTf[col].setText(String.valueOf(table.getValueAt(row, col)));
				}else {
					formTf[col].setText((String)table.getValueAt(row, col));
				}
			}
			
			
		}
		
	}
	
}