import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

// 컨테이너 Frame상속받아 구현하기
public class FrameTest extends Frame    {
	
	Point xy = new Point(500,300);
	Dimension wh = new Dimension(500,300);
	Rectangle rect = new Rectangle(100,100,400,400);

	public FrameTest() {
		
		//창의 제목 -> setTitle()
		//1.메소드 이용하여 제목설정하는방법
		//setTitle("프레임생성연습중")				
		//2.생성자이용해서 제목설정하는방법
		super("하위에서 제목설정"); //Frame("하위에서 제목설정")->제목설정해주는 상위클래스의 매개변수를가지는 생성메소드를 사용해서 ->super()
		
		//창의 크기(pixel) ->상속받은 Frame 의 상위클래스 Window클래스 기능사용 -> 1.setSize(), 2.setBounds()...
		//setSize(w,h);
		//setSize(500,500); //w,h	-> Dimension  폭과높이	//상위클래스의 메소드를 내거처럼 사용		
		//setLocation(300,300);// x,y -> point x좌표,y좌표	//x좌표는왼쪽에서 얼만큼띄울거냐 y는 위에서얼만큼 뛰울거냐	 
		//setLocation(xy);
		
		//		  x   y    w   h
		//setBounds(200,200,500,400); //-> Rectangle  x좌표,y좌표x,폭,높이 -> setSize와 setLocation을 한번에...
		setBounds(rect);
		
		//타이틀바에 이미지 아이콘 추가하기..
		//Frame클래스 ->class Image:추상클래스:추상메소드 :setIconImage()->상속받아야상속가능 new로객체형성 불가능- >Toolkit클래스 사용
		// createImage , getImage -> 이미지객체를 리턴해줌...추상이라서 객체못만든다 > 툴킷메소드를린턴해주는 getDefaultToolKit()사용
		//Toolkit tk = Toolkit.getDefaultToolkit();
		//Image icon = tk.getImage("img/haha.jpg"); //.파일형식		
		Image icon =Toolkit.getDefaultToolkit().getImage("img/haha.jpg");
		
		setIconImage(icon); //아이콘을셋팅해줌
		
		//창을띄우기전에 만들어야함
		//Button->두가지방법 ->매개변수의유/무
		Button btn = new Button("버튼"); //만든걸 컨테이너에 담아야함 add()
		add(btn); //컴포넌트 버튼을 클래스인컨테이너에 넣어줌--->가운데에 생기는이유 -> layout ->dafalt값이 가운데라서 설정전에는 가운데에셋팅됨

		Button btn1 = new Button("1111111");
		Button btn2 = new Button("2222222");
		Button btn3 = new Button("3333333");
		Button btn4 = new Button("4444444");			
		
		//add(String name ,Component comp);->name에서 위치설정 ,오른쪽엔 우리가만든 버튼 컴포넌트객체명
		//add(Component comp, int index); -> int에서 위치설정 
		//		"NORTH"
		add(BorderLayout.NORTH,btn1);
		add("South",btn2);
		add(BorderLayout.EAST,btn3);
		add(BorderLayout.WEST,btn4);
		//ㄴ> 창의크기를 조절해도 센터의 크기만 바뀐다//위아래의 폭은 바뀌지않는다		
		
		//창을 보여주기-숨기는기능도있음 ->크기설정한  창을 보여주는...-> setVisible()				
		setVisible(true); //true:보여줌 false:안보여줌(삭제x)  //여기까지 하고 컴파일하면 아무것도없는 창이뜬다-x눌러도 창 종료안됨
		

	}

	public static void main(String[] args) {
		new FrameTest();
		
	}

}
