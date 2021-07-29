import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class StudentMain extends UI_2 implements ActionListener ,MouseListener {
	
	
	
	Font font = new Font("����", Font.BOLD, 20);
	
	JPanel centerPane = new JPanel(new BorderLayout());//UI_2 ���Ϳ� �гδ���
	
	//�л���������-�л���ü��ȸȭ��	
	JPanel northPane;
		JTextField tf;	
		JComboBox<String> jcb;
		JButton jbt;
		JButton jbt2;
		
	JPanel centercenterPane;	
		JTable table;
		JScrollPane sp; 
		DefaultTableModel model;
		String title;
		
	
	//�л���ȸ
	JPanel updatePane; //south-�����г�
		JPanel updateNorth;
			JLabel updateLb1;
		JPanel updateCenter; 		
			JTable updateTable;
			JScrollPane sp2; 
			DefaultTableModel updatemodel;
			String title2;
		JPanel updateSouth;		
			JButton updateJbt; //������ư
			JButton deleteJbt;
	
	//�л��߰�,����ȭ��
	JPanel insertPane;//centerPane - north
		JPanel insertlb1P; //insertPane-north
			JLabel insertlb1; 
		JPanel insertWestPane; //insertPane-west
			String insertLb1[]= {" �� �� �� ȣ "," �� �� �� ȣ "," �� �� �� ȣ "," �� �� "," �� �� "
								," �� �� �� "," �� ȭ �� ȣ "," �� �� "," �� �� �� �� "," �� �� �� �� "," �� �� �� �� "};
		JPanel insertCenter; //insertPane-center
			JTextField[] insertTf = {new JTextField(10), new JTextField(4), new JTextField(10),new JTextField(10)
									, new JTextField(4),new JTextField(30),new JTextField(15),new JTextField(45)
									, new JTextField(10),new JTextField(15), new JTextField(20),};  
		JPanel insertSouthP; //insertPane-south
			JButton insertJbt;
	JPanel deletePane;//centerPane- center
		JPanel deletelb1P; //deletrPane-north
			JLabel deletelb1; 
		JPanel deleteCenterP; //deletrPane-center
			JTextField deleteTf;
			JLabel deleteLb1;
			JButton deleteJbt2;
	
	public StudentMain() {
		
		init();
		add(centerPane);
//		
		showStudentAll();//1-1.��ȸ,����ȭ�� �⺻����
		studentAllList();//1-2.�л���ü��ȸ+�˻���ư�̺�Ʈó��
		
		//studentInsertView(); //2.�л��߰�,�л�����
		
	}

	//�л���������-�л���ü��ȸȭ��	
	public void showStudentAll() {
	
		northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));  //�����޺��ڽ� �ؽ����ʵ� �˻���ư

		System.out.println("�л���ü��ȸȭ��޼ҵ����"); //TEST
			String comboList[] = {"�л���ȣ", "�л��̸�", "�а�����"};
			jcb = new JComboBox(comboList);
			tf = new JTextField(15); //�˻�â
			jbt = new JButton("�˻�");
			jbt2 = new JButton("��ϻ��ΰ�ħ");
			northPane.add(jcb);
			northPane.add(tf);
			northPane.add(jbt);	
			northPane.add(jbt2);
			
		centerPane.add(BorderLayout.NORTH,northPane);//������ο� �˻�����߰�
			
		centercenterPane = new JPanel(new BorderLayout());
			
			title= "�л���ȣ/������ȣ/��й�ȣ/�л��̸�/�г�/�̸���/�ڵ���/�ּ�/��������/��������/�������"; 
			model = new  DefaultTableModel(title.split("/"),0);

		    table = new JTable(model);
		    sp = new JScrollPane(table);
		    centercenterPane.add(sp);
		    
		    table.addMouseListener(this);
		 
		    
		centerPane.add(BorderLayout.CENTER,centercenterPane); //������ο� ���Ϳ� �л����̺�߰�

		updatePane = new JPanel(new BorderLayout());	//�ǾƷ� �����г�
			//1
			updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
				updateLb1 = new JLabel("�л���������");				
			updateNorth.add(updateLb1); 
		updatePane.add(BorderLayout.NORTH,updateNorth);
			//2
			updateCenter = new JPanel(new BorderLayout());
				title2= "�л���ȣ/������ȣ/��й�ȣ/�л��̸�/�г�/�̸���/�ڵ���/�ּ�/��������/��������/�������"; 
				updatemodel = new  DefaultTableModel(title2.split("/"),0);
				updateTable = new JTable(updatemodel);
				sp2 = new JScrollPane(updateTable);
			updateCenter.add(sp2);
		updatePane.add(BorderLayout.CENTER,updateCenter);
			//3
			updateSouth = new JPanel();
	    	updateJbt = new JButton(" �� �� ");
	    	deleteJbt = new JButton(" �� �� ");
	    	updateSouth.add(updateJbt);
	    	updateSouth.add(deleteJbt);
	    updatePane.add(BorderLayout.SOUTH,updateSouth); 
	    
	    centerPane.add(BorderLayout.SOUTH,updatePane);    
	    
	    updatePane.setPreferredSize(new Dimension(0, 140));
			
		    jbt.addActionListener(this);
		    jbt2.addActionListener(this);
		    updateJbt.addActionListener(this);
		    deleteJbt.addActionListener(this);
		    
	}
	
	public void actionPerformed(ActionEvent ae) {
		//���콺�̺�Ʈ�� url�׽�Ʈ....
		String eventBtn = ae.getActionCommand(); 
		Object eventBtn2 =ae.getSource();
		if(eventBtn.equals("�˻�")) { //�л��˻�
			studentSearch();
		}else if(eventBtn2== updateJbt){//�л�����
			studentUpdate();
		
		}else if(eventBtn.equals(" �� �� ")) { //�л��߰�
			studentInsert();
			
		}else if(eventBtn2==deleteJbt) { //�л�����
			studentDelete();
		}else if(eventBtn2==jbt2) {
			studentAllList();
		}
	}
	
	//�л���ü��� �������� -JTable
	public void studentAllList() {

		System.out.println("�ø���Ʈ����");
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.allRecord(); //��ü�л����������
		setStudentModel(list);//�ҷ��°� ����
		
	}
	//�������̺� ��϶���ֱ�
	public void setStudentModel(List<StudentVO> list) { //����Ʈ���ް�		
		model.setRowCount(0);  
			for(int i=0; i<list.size(); i++) {
				
				StudentVO vo = list.get(i); //ȸ���Ѹ��� ���� ->�迭�� ���� model�� �߰���ų����
				Object[]obj = {vo.getStu_Code(),vo.getMajor_Code(),vo.getStu_pw(),vo.getStu_name(),vo.getStu_grade(),
						vo.getStu_email(),vo.getStu_tel(), vo.getStu_add(), vo.getStu_state(),vo.getStu_date(),vo.getStu_birth()};
					
				model.addRow(obj); //�迭�߰�		
			}
	}
	
	//�л��˻�
	public void studentSearch() {
			
			String search =tf.getText(); //�˻��Ҵܾ�
			
			if(search!=null && !search.equals(" ")) { // �˻�� �ִ�
				String searchField = (String)jcb.getSelectedItem(); // �˻��� : �л���ȣ", "�л��̸�", "�а�����"
				//�ʵ������ �����ͷ� ������
				String fieldName=" "; //��ʵ忡�� �˻����� �ܾ ������
				
				if(searchField.equals("�л���ȣ")) {
					fieldName="Stu_Code";
				}else if(searchField.equals("�л��̸�")) {
					fieldName="stu_name";
				}else if(searchField.equals("�а�����")) {
					fieldName="major_name";
				}
				StudentDAO dao = new StudentDAO();
				List<StudentVO>list = dao.searchRecord(search,fieldName);
				setStudentModel(list);
				tf.setText(" ");
			}
		}
	
	//�л���������
	public void studentUpdate() { 	
		System.out.println("����������Ʈ������");
		StudentVO vo = new StudentVO();
		
		vo.setStu_Code((Integer)(updateTable.getValueAt(0,0))); // ****not null //�������ѹ�
		vo.setMajor_Code((Integer)(updateTable.getValueAt(0,1))); // not null
		vo.setStu_pw((String)updateTable.getValueAt(0,2)); //�Է¹����� vo����ۿ� set
		vo.setStu_name((String)updateTable.getValueAt(0,3));
		vo.setStu_grade((String)updateTable.getValueAt(0,4));
		vo.setStu_email((String)updateTable.getValueAt(0,5));
		vo.setStu_tel((String)updateTable.getValueAt(0,6)); 
		vo.setStu_add((String)updateTable.getValueAt(0,7));
		vo.setStu_state((String)updateTable.getValueAt(0,8));
		vo.setStu_date((String)updateTable.getValueAt(0,9));
		vo.setStu_birth((String)(updateTable.getValueAt(0,10)));  
		
		System.out.println(vo.allprint());
		
		StudentDAO dao = new StudentDAO();
		int cnt = dao.updateRecord(vo); //DAOŬ������ update�޼ҵ带 �̿��Ͽ� ���������� ������
		
		if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
			System.out.println("main �л�������������");
			JOptionPane.showMessageDialog(this,"ȸ������ ���� �Ϸ��Ͽ����ϴ�");
			studentAllList();
		}else {
			//���������ϸ� �ȳ��޽��� ǥ��
			System.out.println("main �л�������������");
			JOptionPane.showMessageDialog(this,"ȸ������ ���� �����Ͽ����ϴ�");
		}
	}

	
	//======================================================================================
	//�л��߰�ȭ��
	public void studentInsertView() {
		//�����гο� �г�2������ -> �߰��г� /�����г�		
		
		insertPane = new JPanel(new BorderLayout());//1.�߰��г�
			
			insertlb1P = new JPanel(new BorderLayout());
			insertlb1P.setBorder(new LineBorder(Color.GRAY,1,true));
				insertlb1 = new JLabel("�л��߰�"); //��Ʈ����,�гξȿ��ָ�
				insertlb1.setFont(font);				
				insertlb1.setPreferredSize(new Dimension(150, 30));
			insertlb1P.add(BorderLayout.WEST,insertlb1);
			
			insertPane.add(BorderLayout.NORTH,insertlb1P); //�����г� ���ʿ� �� �߰�
			insertlb1P.setPreferredSize(new Dimension(0, 45));
			
			insertWestPane= new JPanel(new GridLayout(11,1,5,5));

			insertCenter = new JPanel(new GridLayout(11,1)); //�ڿ� �߰��� 5�� ������ 5px��ŭ �ִ°�
						
			insertPane.add(BorderLayout.WEST,insertWestPane); //�߰��г� ���ʿ� �г��߰�
				for(int i=0; i<insertLb1.length; i++) {
					JLabel lb1 = new JLabel(insertLb1[i]);
					insertWestPane.add(lb1);
				}
			insertPane.add(BorderLayout.CENTER,insertCenter);//�߰��г� ���Ϳ� �г��߰�
				for(int i=0; i<insertTf.length; i++) {
					JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //��������
					p.add(insertTf[i]);					
					insertCenter.add(p);
					
					//�ؽ�Ʈ�ʵ� ��Ȱ��ȭ
					if(i==0 || i==2 || i==9 )  insertTf[i].setEditable(false);
				}
				
			
			
			insertSouthP = new JPanel();	//���̾ƿ� �ַ�����	
			insertSouthP.setBorder(new LineBorder(Color.GRAY,1,true));
			insertJbt = new JButton(" �� �� "); //�߰��г� ���ʿ� ��ư �߰� //�гξȿ� �ָ�	
			insertJbt.setBackground(new Color(33, 140, 116));
			insertJbt.setForeground(Color.white);
			insertJbt.setFont(font);
			insertJbt.setPreferredSize(new Dimension(100, 30)); //��ư�������
			insertSouthP.add(insertJbt);
			insertPane.add(BorderLayout.SOUTH,insertSouthP);
			
			centerPane.add(BorderLayout.NORTH,insertPane);
			insertPane.setPreferredSize(new Dimension(0, 480));
		
		deletePane = new JPanel(new BorderLayout());	//2.�����г�
			
			deletelb1P = new JPanel(new BorderLayout());			
			//deletelb1P.setBorder(new LineBorder(Color.GRAY,1,true));			
				deletelb1 = new JLabel("�л�����"); 
				deletelb1.setFont(font);			
				deletelb1.setPreferredSize(new Dimension(150, 30));
			//deletelb1P.add(BorderLayout.WEST,deletelb1);
			
			deletePane.add(BorderLayout.NORTH,deletelb1P); //�����г� ���ʿ� �� �߰�
			deletelb1P.setPreferredSize(new Dimension(0, 45));
		
			deleteCenterP = new JPanel(); //���̾ƿ� ��ķ�
//				deleteLb1 = new JLabel("�л���ȣ"); //��Ʈ,������
//				deleteTf = new JTextField(15);
//				deleteJbt2 = new JButton(" �� �� ");
//				deleteJbt2.setFont(font);
//				deleteJbt2.setPreferredSize(new Dimension(100, 30));
//				deleteJbt2.setBackground(new Color(33, 140, 116));
//				deleteJbt2.setForeground(Color.white);
			//deleteCenterP.add(deleteLb1); deleteCenterP.add(deleteTf); deleteCenterP.add(deleteJbt); 
			
			deletePane.add(BorderLayout.CENTER,deleteCenterP);
			centerPane.add(BorderLayout.CENTER,deletePane);
			
			//�߰�,������ư �̺�Ʈó��
			insertJbt.addActionListener(this); //�߰���ư
			//deleteJbt2.addActionListener(this); // ������ư
	}
	
	//�л��߰�
	public void studentInsert() { //�л��߰� --- DAO- insertDAO
		//String Stu_code = insertTf[0].getText(); // not null //�������ѹ�
		String Major_Code = insertTf[1].getText(); // not null
		//String stu_pw = insertTf[2].getText();
		String stu_name = insertTf[3].getText();
		String stu_grade = insertTf[4].getText();
		String stu_email=insertTf[5].getText();
		String stu_tel=insertTf[6].getText();
		String stu_add=insertTf[7].getText();
		String stu_state=insertTf[8].getText();
		//int stu_date=insertTf[9].getText();
		String stu_birth = insertTf[10].getText();  // not null 
		
		
		if( Major_Code==null || Major_Code.equals(" ") || //stu_pw==null || stu_pw.equals(" ")||
			stu_name==null || stu_name.equals(" ") || stu_birth==null || stu_birth.equals(" ")	)  { //���������x �ٵ� ��......
				JOptionPane.showMessageDialog(this, "������ ���� �Է��ϼ���");
		}else {
			StudentVO vo = new StudentVO();
			
			vo.setMajor_Code(Integer.parseInt(Major_Code));
			//vo.setStu_pw(stu_pw); // �ʱ��й�ȣ�� �������
			vo.setStu_name(stu_name);
			vo.setStu_grade(stu_grade);
			vo.setStu_email(stu_email);
			vo.setStu_tel(stu_tel); 
			vo.setStu_add(stu_add);
			vo.setStu_state(stu_state);
			//vo.setStu_date((stu_date);
			vo.setStu_birth(stu_birth);		
			
			StudentDAO dao = new StudentDAO();
			int cnt = dao.insertRecord(vo);
			
			if(cnt>0) {//�л��߰� : �߰��� ���ڵ尡 ������
				formDataClear(); //ȸ���� �߰��Ǹ� ���� �����и� �����
				JOptionPane.showMessageDialog(this, "�л��߰� �Ǿ����ϴ�");
			}else{ //ȸ���߰�����
				JOptionPane.showMessageDialog(this, "�л��߰� �����Ͽ����ϴ�");
			}			
		}
		
	}
	
	//�������
	public void formDataClear() {
			//�л� �߰��ǰ��� form�� �ִ� �����͸� �����
			//���� ���� �����.
		for(int i=0; i<insertTf.length; i++) {
				insertTf[i].setText(" ");
		}
			
	}
	
	//�л�����
	public void studentDelete() {
		JOptionPane op = new JOptionPane();
		Object willBeRomoved = updatemodel.getValueAt(0,0);
		StudentDAO dao = new StudentDAO();
		int que =op.showConfirmDialog(this,"���� �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION );
		if(que == JOptionPane.YES_OPTION) {
			updatemodel.setRowCount(0); // updatemodel.remove(0);
			int result = dao.deleteRecord(willBeRomoved);
			
			if(result>0) {
				JOptionPane.showMessageDialog(this,"�л������͸� �����Ͽ����ϴ�");
				studentAllList();
			}else {
				JOptionPane.showMessageDialog(this,"�����ͻ����� ���� �Ͽ����ϴ�");
			}
			
		}else if(que==JOptionPane.NO_OPTION) {
			System.out.println("�л���������");
		}
		
		
	}
	
	//�л�����
//	public void studentDelete() {//��ȣ�� �����ͼ� ���̺� �ִ��� ������ Ȯ���ϰ�
//			
//			//������ �����ȣ
//			//							      ������o  ������x
//			String delNum = deleteTf.getText(); // "5"  ""
//			if(delNum==null || delNum.equals(" ")){
//				JOptionPane.showMessageDialog(this, "������ �л���ȣ�� �Է��ϼ���");
//			}else {
//				//db�۾� -> memberDAO
//				StudentDAO dao = new StudentDAO();
//				int result = dao.deleteRecord(Integer.parseInt(delNum)); //0�̸����x 0�̻��̸����o
//				if(result>0) { //�л�������
//					JOptionPane.showMessageDialog(this, delNum+"�л��� �����Ͽ����ϴ�");
//					deleteTf.setText(" "); //�Է�âŬ����
//					
//				}else {//�л���������
//					JOptionPane.showMessageDialog(this, delNum+"�л������� �����Ͽ����ϴ�");
//				}
//			}
//			
//		}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==1) {//���ʹ�ưŬ��
			updatemodel.setRowCount(0);
			int row = table.getSelectedRow(); //����Ŭ�����౸����

			Vector<Object> v = new Vector<Object>();
			v.add((Integer)table.getValueAt(row,0));
			v.add((Integer)table.getValueAt(row,1));
			v.add((String)table.getValueAt(row,2));
			v.add((String)table.getValueAt(row,3));
			v.add((String)table.getValueAt(row,4));
			v.add((String)table.getValueAt(row,5));
			v.add((String)table.getValueAt(row,6));
			v.add((String)table.getValueAt(row,7));
			v.add((String)table.getValueAt(row,8));
			v.add((String)table.getValueAt(row,9));
			v.add((String)table.getValueAt(row,10));
			updatemodel.addRow(v);	
			
		} 		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	

	
	public static void main(String[] args) {
		new StudentMain();

	}

	

}
