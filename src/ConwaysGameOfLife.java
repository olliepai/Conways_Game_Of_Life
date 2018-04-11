import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConwaysGameOfLife extends JPanel implements ActionListener{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int CELL_SIZE = 10;
	
	private JFrame window;
	private JButton startStopButton;
	private JTextField speedField;
	
	public static void main(String[] args) {
		
	}
	
	public void launchGame() {
		//build the window and start the simulation
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
