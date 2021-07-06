import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JComboBoxTest extends JFrame implements ItemListener{

	JPanel pane = new JPanel();
	JComboBox<String> cb1 = new JComboBox<String>();
	JComboBox<String> cb2,cb3,cb4;
	
	JLabel lb1 =new JLabel("���ð� ǥ�õǴ� ��",JLabel.CENTER);
	Color clr[] = {Color.red,Color.blue,Color.green, Color.white,Color.black};
	
	public JComboBoxTest() {
		
		add(BorderLayout.NORTH,pane); //�����г������̳���ġ����
		pane.add(cb1);	//// ������������̳ʿ� ����
		
		lb1.setOpaque(true);//����ó������
		add(lb1); //�󺧼��Ϳ�ǥ��
		
		//����߰�
		cb1.addItem("�ڹ�");
		cb1.addItem("������");
		cb1.addItem("jsp");
		
		//�迭�� �����͸� ��ϸ����
		String comboList[] = {"RED", "BLUE", "GREEN", "WHITE","BLACK"};
		cb2=new JComboBox(comboList); //����迭�� �־���
		pane.add(cb2); // ������������̳ʿ� ����
		
		//�÷���(vector)�� �̿��� ��ϸ����
		Vector<String> v = new Vector<String>();
		v.add("AAAAA");
		v.add("BBBBB");
		v.add("CCCCC");		
		cb3 = new JComboBox(v); //���� ����v�� cb3�� ����
		pane.add(cb3);
		
		//���� �̿��� ��ϸ����
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("���");
		model.addElement("��ȭ");
		model.addElement("ƫ��");		
		cb4 = new JComboBox<String>(model);
		pane.add(cb4); 			
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
				
		//�̺�Ʈ���
		//ComboBox ���� ��̺�Ʈ���߻��ϴ��� �޼ҵ� --->>ItemListener��� ---> add~~~Listerner
		cb2.addItemListener(this); //���⿡�ִ¸޼ҵ徵���� ��ӹ޾����ϰ� this����Ͽ� ��Ŭ���� �����ְ�
		cb4.addItemListener(this); 
		
	}
	
	//�������̵� : ��ӹ��� ����Ŭ������ �޼ҵ� �������̵�
	public void itemStateChanged(ItemEvent ie) { //�������̵�
		
		JComboBox event =(JComboBox)ie.getSource();
		
		//�����ϸ� �̺�Ʈ�� �߻��Ͽ� ��׶��� ������ -> �÷������Ҷ��� �÷���ü�ʿ� ->�迭�� �÷���ü�־
		//�����ϸ� �̺�Ʈ���߻��Ͽ� �����ѱ��ڰ� ������->���̶��̿��ؼ� ����������� �켱�����ѵ� �ٲ��
		if(event.equals(cb2)) {
			//�����޺��ڽ� �޼ҵ� ->getSelectedIcon,getSelectedIndex 
			//���ø���� index��������
			int idx =cb2.getSelectedIndex(); 
			lb1.setBackground(clr [idx]); //�迭�� �÷���ü�־
			//����ó������
			
		}else if(event.equals(cb4)) {
			lb1.setText((String)cb4.getSelectedItem());
		}
		
		
		
		
	}

	public static void main(String[] args) {
		new JComboBoxTest();
	}

}
