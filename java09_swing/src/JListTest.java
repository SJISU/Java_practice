import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;



public class JListTest extends JFrame implements ActionListener{
	JPanel pane = new JPanel(new GridLayout(2,1));
	JButton leftBtn = new JButton("<--");
	JButton rightBtn = new JButton("-->");
	
	DefaultListModel<String>leftModel = new DefaultListModel<String>();
	JList <String> leftList= new JList<String>(leftModel);
	JScrollPane sp1 = new JScrollPane(leftList);
	
	DefaultListModel<String>rightModel = new DefaultListModel<String>();
	JList <String> rightList= new JList<String>(rightModel);
	JScrollPane sp2 = new JScrollPane(rightList);
	
	
	String data[]= {"���","����","����","���ξ���","�ٳ���","ü��","Ű��","������","����","����"};
	String data2 = "���/����/ƫ��/�ڽ���/�ǵ���";
	public JListTest(){
		
		//��ϸ����
		for(int i=0; i<data.length; i++) {
			leftModel.addElement(data[i]); //��ϸ������
		}
		//��ϸ����
		StringTokenizer st = new StringTokenizer(data2,"/");
		while(st.hasMoreTokens()) {
			rightModel.addElement(st.nextToken());
		}
		
		add(pane);
		pane.add(leftBtn); pane.add(rightBtn);
				
		add(BorderLayout.WEST,leftList);
		add(BorderLayout.EAST,rightList);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == leftBtn) {
			listDataChanged(rightList,leftList); //rightList -->leftList
		}else if(event == rightBtn) {
			listDataChanged(leftList, rightList);	//leftList -->rightList
		}
	}
	
	//						 ���� ������		 �ű��
	public void listDataChanged(JList orgList, JList tarList) { //get�ؼ� add�ϰ� ������ �����-> data�� �𵨿� �������-���� ����Ʈ�� �־���
		//����� ���ϴ� �޼ҵ� JList- getModel,getSelected
		//����� �߰��ϴ� �޼ҵ�  Model �޼ҵ���-
		//�����ִ��� ����� �޼ҵ� Model �޼ҵ���-removeElemnet(object obj) 
		DefaultListModel<String> orgModel = (DefaultListModel)orgList.getModel(); //remove
		DefaultListModel<String> tarModel = (DefaultListModel)tarList.getModel(); // add
		
		List<String> list = orgList.getSelectedValuesList(); // ���,Ű��,������
		for(int i=0; i<list.size(); i++) {
			tarModel.addElement(list.get(i));//�߰�
			orgModel.removeElement(list.get(i));//����
		}
	}

	public static void main(String[] args) {
		new JListTest();

	}

}