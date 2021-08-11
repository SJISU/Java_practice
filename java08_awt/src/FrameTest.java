import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

// �����̳� Frame��ӹ޾� �����ϱ�
public class FrameTest extends Frame    {
	
	Point xy = new Point(500,300);
	Dimension wh = new Dimension(500,300);
	Rectangle rect = new Rectangle(100,100,400,400);

	public FrameTest() {
		
		//â�� ���� -> setTitle()
		//1.�޼ҵ� �̿��Ͽ� �������ϴ¹��
		//setTitle("�����ӻ���������")				
		//2.�������̿��ؼ� �������ϴ¹��
		super("�������� ������"); //Frame("�������� ������")->���������ִ� ����Ŭ������ �Ű������������� �����޼ҵ带 ����ؼ� ->super()
		
		//â�� ũ��(pixel) ->��ӹ��� Frame �� ����Ŭ���� WindowŬ���� ��ɻ�� -> 1.setSize(), 2.setBounds()...
		//setSize(w,h);
		//setSize(500,500); //w,h	-> Dimension  ��������	//����Ŭ������ �޼ҵ带 ����ó�� ���		
		//setLocation(300,300);// x,y -> point x��ǥ,y��ǥ	//x��ǥ�¿��ʿ��� ��ŭ���ų� y�� ��������ŭ �ٿ�ų�	 
		//setLocation(xy);
		
		//		  x   y    w   h
		//setBounds(200,200,500,400); //-> Rectangle  x��ǥ,y��ǥx,��,���� -> setSize�� setLocation�� �ѹ���...
		setBounds(rect);
		
		//Ÿ��Ʋ�ٿ� �̹��� ������ �߰��ϱ�..
		//FrameŬ���� ->class Image:�߻�Ŭ����:�߻�޼ҵ� :setIconImage()->��ӹ޾ƾ߻�Ӱ��� new�ΰ�ü���� �Ұ���- >ToolkitŬ���� ���
		// createImage , getImage -> �̹�����ü�� ��������...�߻��̶� ��ü������� > ��Ŷ�޼ҵ带�������ִ� getDefaultToolKit()���
		//Toolkit tk = Toolkit.getDefaultToolkit();
		//Image icon = tk.getImage("img/haha.jpg"); //.��������		
		Image icon =Toolkit.getDefaultToolkit().getImage("img/haha.jpg");
		
		setIconImage(icon); //����������������
		
		//â���������� ��������
		//Button->�ΰ������ ->�Ű���������/��
		Button btn = new Button("��ư"); //����� �����̳ʿ� ��ƾ��� add()
		add(btn); //������Ʈ ��ư�� Ŭ�����������̳ʿ� �־���--->����� ��������� -> layout ->dafalt���� ����� ���������� ��������õ�

		Button btn1 = new Button("1111111");
		Button btn2 = new Button("2222222");
		Button btn3 = new Button("3333333");
		Button btn4 = new Button("4444444");			
		
		//add(String name ,Component comp);->name���� ��ġ���� ,�����ʿ� �츮������ ��ư ������Ʈ��ü��
		//add(Component comp, int index); -> int���� ��ġ���� 
		//		"NORTH"
		add(BorderLayout.NORTH,btn1);
		add("South",btn2);
		add(BorderLayout.EAST,btn3);
		add(BorderLayout.WEST,btn4);
		//��> â��ũ�⸦ �����ص� ������ ũ�⸸ �ٲ��//���Ʒ��� ���� �ٲ����ʴ´�		
		
		//â�� �����ֱ�-����±�ɵ����� ->ũ�⼳����  â�� �����ִ�...-> setVisible()				
		setVisible(true); //true:������ false:�Ⱥ�����(����x)  //������� �ϰ� �������ϸ� �ƹ��͵����� â�̶��-x������ â ����ȵ�
		

	}

	public static void main(String[] args) {
		new FrameTest();
		
	}

}