import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{

   JTable table;
   JScrollPane sp; 
   DefaultTableModel model;
   
   //JTable���� �������� ����� �迭
   String title[] = {"��ȣ","�̸�","����ó","�ּ�"}; 
   //JTable���� ������� ����� �迭
   Object[][] data = { {100, "ȫ�浿","010-1234-5678","����� ������"},
                  {200,"�̼���","010-7878-9696","����� ���α�"},
                  {300,"�������","010-8787-5555","����� ��������"}
                 };
   
   JLabel lb1 = new JLabel (" ");
   
   public JTableTest() {
      model = new  DefaultTableModel(data,title);
      table = new JTable(model);
      sp = new JScrollPane(table);
      
      add(sp); //��ũ�� ����� �ִ� ���̺�
      add(BorderLayout.SOUTH,lb1);  //�ǾƷ���
      
      setSize(500,400);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      
      //try{Thread.sleep(3000);}catch(Exception e) {} //�ߴ� �ð����� 3��      
      //���߰� : addRow()
      Object[]row = {400,"���","010-1234-5555","����� ���ʱ�"};
      
      Vector<Object> v = new Vector<Object>();
      v.add(500);
      v.add("������");
      v.add("010-4567-8888");
      v.add("����� ����");      
      
      model.addRow(row);
      model.addRow(v);
      
      try{Thread.sleep(3000);}catch(Exception e) {} //�ߴ� �ð����� 3��
      //����� : insertRow()
      Object[]row2= {600,"��������","010-1111-2222","����� ������"};
      model.insertRow(2, row2);//2�࿡�� ������ ����2�࿡ �ִ� �����ʹ� �ڷιи�
      
      try{Thread.sleep(3000);}catch(Exception e) {} //�ߴ� �ð����� 3��
      //���̵� : moveRow() //Ư���ѹ����� ���� �̵���Ŵ
      //		start end to
      model.moveRow(2,4,0); //index 2�������� 4������ 0���� �̵���Ŵ      
      
      try{Thread.sleep(3000);}catch(Exception e) {} //�ߴ� �ð����� 3��
     
      /*
      //�÷��߰� : addColumn() ĭ�߰� 
      model.addColumn("��Ÿ");
      Object cData[]= {1,2,3,4,5,6};
      model.addColumn("�޸�",cData);
      
      try{Thread.sleep(3000);}catch(Exception e) {} //�ߴ� �ð����� 3��
      //�����
      model.removeRow(3); //ȫ�浿�����

      try{Thread.sleep(3000);}catch(Exception e) {} //�ߴ� �ð����� 3��
      //�÷� (ĭ) ���� // JTable �� ����
      table.removeColumn(table.getColumn("��Ÿ")); 
      
      */
      table.addMouseListener(new MyEvent()); //���̺��ִ°ɰ� ��� �̺�Ʈ���
      
   }
   
   //���콺 �̺�Ʈ ����Ŭ����
   public class MyEvent extends MouseAdapter{// ��Ͱ� �̹� �������̽� �������̵��ؼ� ��ӹ޾ұ⶧���� ��Ӿȹް� �̺�Ʈ����ϸ��
	   
	   //��������̵� - ��Ϳ��� �������̵��ȸ޼ҵ带 �ٽ� �������̵�
	   public void mouseClicked(MouseEvent me) { //Ŭ���ϸ� ����� �Ѿ���Բ�
		   //���ʹ�ư�϶��� ���� �ְ� �Ѵ�
		   //1.��ư�� ����(1: ���� 2: ��� 3:������)
		   int eventBtn = me.getButton();
		   String dataStr ="";
		   
		   if(eventBtn==1) {//���ʹ�ư���� �������� �����ϰ�
			  //������ ���ȣ ������
			  int row = table.getSelectedRow(); //���缱�õ����� �˾Ƴ��� //�������� �����ϰԵǸ� �迭�� ����
			  //				ĭ�Ǽ�
			  for(int c=0; c<table.getColumnCount(); c++) {
				  Object data = table.getValueAt(row,c); //���ϴ� ��ġ�� �����͸� ��������
				  dataStr+=data+",";
			  }
			   lb1.setText(dataStr); //�ǾƷ��� ���õ� ���� �����Ͱ� �Էµȴ�
		   }		   
	   }	   
   }

   public static void main(String[] args) {
      new JTableTest();
   }

}