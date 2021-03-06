//Frame?? ?ݱⰡ ?ȉ??µ? JFrame?? ?ݱⰡ ?ȴ?

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
//								default : BorderLayout //?⺻????...
public class JFrameTest extends JFrame {
	
	ImageIcon icon1 = new ImageIcon("img/haha.jpg");
	ImageIcon icon2 = new ImageIcon("img/ha.jpg");
	ImageIcon icon3 = new ImageIcon("img/hahaha.jpg");
	
	public JFrameTest(){
		
		//BorderLayout?? GridLayout???κ????ϱ?
		//?????ϰ????? ???̾ƿ??? ??ü?θ?????-> JFrame ?? ???̾ƿ??????޼ҵ? ?????Ͽ? ????
		GridLayout layout = new GridLayout(3,2,10,10); //3??2?? ???Ʒ? ????10-?????ڸ??? ????Ȯ???ȵ?
		//setLayout()
		setLayout(layout); //???̾ƿ??????޼ҵ??ȿ? ??ü?θ??緹?̾ƿ??? ?־ ????
		
		//??ư?????? - JButton???? ??ü???????? ??ư?? ?????? frame?????̳ʿ? ?߰?
		JButton btn1 = new JButton("??ư1"); //(string)
		add(btn1);		
		
		JButton btn2 = new JButton(icon1);//(icon) //?Ű??????? ??????->imageiconŬ?????ΰ???....
		add(btn2);	
		//???콺?? ??ư?? ?????? icon ?ٲٱ? 
		//.setPressedIcon()
		btn2.setPressedIcon(icon2);
		//???콺 ?????? icon ?ٲٱ? 
		//.setRolloverIcon()
		btn2.setRolloverIcon(icon3);
		
		JButton btn3 = new JButton("??",icon1); // (String,icon)
		add(btn3);	
		// ??ư?? Ȱ??ȭ(true) ??Ȱ??ȭ(false) 
		//.setEnabled()
		btn3.setEnabled(false);
		
		JButton btn4 = new JButton("??ư4");
		add(btn4);
		
		//JRadioButton- ButtonGroup?? ???? //???????߿? ?Ѱ??? ?????ִ? ??ư ex) ????üũ
		//?????̳ʸ? ?Ἥ ???????? ????????ư?? ?? ?????? ?ִ´? ->> container -panel(?׵θ?x)(-?⺻???̾ƿ??? :flow) -> ?̰? ?׸??巹?̾ƿ????ִ´?
		//?????? ??ư
		JPanel pane = new JPanel(new GridLayout(3,1)); //?׵θ??? ???? ?????̳?..???̵???ư3???????Ŷ? 3??1????
		JRadioButton rBtn1 = new JRadioButton("ONE"); 
		JRadioButton rBtn2 = new JRadioButton("TWO");
		JRadioButton rBtn3 = new JRadioButton("THREE");  //JPanel ?ȿ? ????????ư 3?? ?????Ÿ???		
		//?????? ??ư ?׷? ?????? ->?????? ????????ư?? ?????شٰ?????
		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn1);  bg.add(rBtn2);  bg.add(rBtn3); //???????? ?Ѱ??? ????????ư?? üũ ????????			
		pane.add(rBtn1);
		pane.add(rBtn2);
		pane.add(rBtn3); //JPanel ?ȿ? ????????ư 3?? ????
		add(pane);//Frame?ȿ? ?г??߰?
		
		//JToggleButton
		//???۹?ư
		JToggleButton toggleBtn = new JToggleButton("????",icon3);
		//.setRolloverIcon() , .setRolloverIcon()
		toggleBtn.setRolloverIcon(icon1);
		toggleBtn.setSelectedIcon(icon2); //???õǸ? ?̹????ٲ?ä?? ???? ?ٽ? ?????ָ? ?????̹?????
		add(toggleBtn);
		
		//JLabel ?󺧸?????
		JLabel lb1 = new JLabel ("????ǥ??",JLabel.CENTER); //?⺻???? ?????????̹Ƿ? ??ġ?????? -> JLabel.CENTER , JLabel.RIGHT 		
		add(lb1); //frame?? ???? ?߰?
		
		//?????? ?÷??????ϱ? => .setBackground()
		//->JButton???? ?÷??????ϴ¸޼ҵ?ã?Ƽ? ->JComponent -setBackground(color fg)->color??ü ?????¹? ?˾ƾߵ?->awt?? colorŬ????->
		//?? ?????? static ?̱⶧???? -> Ŭ??????.?? -> Color.blue....?̷??????? ????-?÷??????? ?빮?ڼҹ??? ?Ѵٻ??밡????->????????rgb?ڵ??ε? ????
		btn1.setBackground(Color.orange);		
		//?÷???ü?? ????? ????
		//			R:0~255,G:0~255,B:0~255
		Color clr= new Color(100, 100, 200);
		toggleBtn.setBackground(clr); //???۹?ư ?????????? ????
		
		//???ڻ??÷??????ϱ? => .setForeground()
		btn1.setForeground(Color.WHITE);
		
		//?󺧿? ?????? ???ϱ?
		//????ó?? ?????޼ҵ? .setOpaque() ->?????? ?ؾ??? ???????? ???´?
		lb1.setOpaque(true); //true:????ó?????? , false :????ó??
		lb1.setBackground(new Color(200, 100,100)); //=>?????޼ҵ带 ???ٿ??? ?????ָ? ?????? ?ȳ??????? ?????? ????ó???Ǿ??ֱ⶧???? ???????? ?ȳ???...
		
		//FontŬ???? : ?۲?(????ü,????ü,Arial...), ????????(??????, ???ϰ?,????), ????ũ?⼳??(px)
		//?? Ŭ?????? ??ü?????Ҽ????? -> ?????޼ҵ尡 protected???̶??? -> ???? ???????????? ???ӹ޾Ƽ? ->protected???ƴѴٸ??????޼ҵ徵??
		//Font(String name , int style, int size) ?۲? ???????? ????ũ?? => static???? => Ŭ????.?????? ???밡??
		Font fnt = new Font("?ü?ü", Font.ITALIC+Font.BOLD, 40);
		lb1.setFont(fnt); //?????? ???ڿ? ??????Ŵ		
		
		
		//â ?? ????
		setSize(1000,500);
		setVisible(true);
		//???α׷??? ?????Ǹ? ?ڿ????? ?ϰų?, ???α׷??? ?????Ҽ? ?????? ????.....
		//JFrame?? ?۾??????ڿ??? ???? ???????????Ѵ?. ->?ڿ?????
		//DISPOSE_ON_CLOSE : ???α׷??????? ?ڿ??? ?????϶?.
		//DO_NOTHING_ON_CLOSE : ?ݱⰡ ???????? ?ʴ´?
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //frame?????? ?????? ?ִ°?.......
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//?и??? ??ŭ ?Ͻ????? //???? ?? -> ?ڵ带 ???? ????		
		try {
			Thread.sleep(5000); //5?? //?и???
		}catch(InterruptedException e) {}
		
		//??ư?? ????,Label?? ?????? ?????ϱ? 
		//.setText() ->abstractButton?? ?޼ҵ?
		btn1.setText("?????? ??ư????");
		lb1.setText("?????ȶ???");		
		
		
	}	

	public static void main(String[] args) {
		new JFrameTest();
	}
}
