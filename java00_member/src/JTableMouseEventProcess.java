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
	//이벤트 처리
	//Adapter - 원하는메소드만 오버라이딩
	public void mouseReleased(MouseEvent  me) {
		if(me.getButton()==1) { //왼쪽버튼 클릭되면
			//현재 클릭한 행을 구하여
			int row = table.getSelectedRow(); // 0,1,2,3,4... ->몇행을 클릭했는지 나옴
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
