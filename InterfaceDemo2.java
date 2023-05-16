import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.Color;

public class InterfaceDemo2 extends JPanel
{
	public InterfaceDemo2(){
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setVisible(true);
		frame.setSize(400, 400);
		setFocusable(true);
		addKeyListener(new KeyInterface());
		JLabel label = new JLabel("Demo for event", JLabel.CENTER);
		// label.setText(String text)
		frame.getContentPane().setBackground(Color.RED);
		// label.setForeground(Color.BLUE); // textcolor
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		InterfaceDemo2 demo = new InterfaceDemo2();
	}

	public class KeyInterface implements KeyListener{
		public void keyReleased(KeyEvent event){}
		public void keyPressed(KeyEvent event){
			if (event.getKeyChar() == 'a' || event.getKeyChar() == 'e' || event.getKeyChar() == 'i' || event.getKeyChar() == 'o' || event.getKeyChar() == 'u')
				System.out.println(event.getKeyChar() + " is a vowel");
			else
				System.out.println(event.getKeyChar() + " is a consonant");
		}
		public void keyTyped(KeyEvent event){}
	}
}