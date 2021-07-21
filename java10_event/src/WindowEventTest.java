import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowEventTest extends JFrame implements WindowListener{

	public WindowEventTest() {
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //DO_NOTHING_ON_CLOSE : x´­·¯µµ¾È´ÝÈû
		
		this.addWindowListener(this);
	}

	
	
	
	public static void main(String[] args) {
		new WindowEventTest();
	}




	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Opened");
		
	}




	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Closing");

	}




	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed");
		
	}




	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconfied");
		
	}




	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconfied");
		
	}




	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated");
		
	}




	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated");
		
	}

}
