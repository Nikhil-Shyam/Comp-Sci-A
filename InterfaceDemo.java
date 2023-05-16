import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.Color;

public class InterfaceDemo extends JPanel
{
	static JFrame frame = new JFrame();
	static JLabel label = new JLabel("", JLabel.CENTER);

	public InterfaceDemo(){
		frame.add(this);
		frame.setVisible(true);
		frame.setSize(400, 400);
		setFocusable(true);
		frame.addMouseMotionListener(new MouseInterface());
		frame.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		InterfaceDemo demo = new InterfaceDemo();
	}

	public class MouseInterface implements MouseMotionListener{
		public void mouseEntered(MouseEvent event){
			frame.getContentPane().setBackground(Color.RED);
			label.setForeground(Color.BLACK);
			label.setText("It's-a Me, Mario!");
		}
		public void mouseExited(MouseEvent event){
			frame.getContentPane().setBackground(Color.BLACK);
			label.setForeground(Color.WHITE);
			label.setText("If you can dream it, you can do it.");
		}
		public void mouseMoved(MouseEvent event){
			System.out.println("Canvas: " + event.getX() + ", " + event.getY());
			System.out.println("Screen: " + event.getXOnScreen() + ", " + event.getYOnScreen());
			if (event.MOUSE_ENTERED <= 400 && event.MOUSE_ENTERED <= 400){
				frame.getContentPane().setBackground(Color.RED);
				label.setForeground(Color.BLACK);
				label.setText("It's-a Me, Mario!");
			}
		}
		public void mouseDragged(MouseEvent event){}
	}
}