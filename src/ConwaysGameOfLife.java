import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *  1. Check out the Wikipedia page on Conway's Game of Life to familiarize yourself
 *     with the concept.
 *     
 *	https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */

/*
 *  2. Run the ConwaysGOL.jar to see a demo of the final product.
 */

/* 
 *  3. Create the program on your own or fill in the code under the comments to complete the project.
 *
 */

public class ConwaysGameOfLife extends JPanel implements ActionListener{
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	public static final int CELLS_PER_ROW = 350;
	
	private boolean isRunning = false;
	
	private JFrame window;
	private JPanel inputPanel;
	private JButton startStopButton;
	private JButton randomizeButton;
	private JButton clearButton;
	private JLabel speedLabel;
	private JTextField speedField;
	
	private WorldPanel gamePanel;
	
	public static void main(String[] args) {
		new ConwaysGameOfLife().launchGame();
	}
	
	public void launchGame() {
		//build the window and start the simulation
		window = new JFrame();
		inputPanel = new JPanel();
		gamePanel = new WorldPanel(WIDTH, HEIGHT, CELLS_PER_ROW);
		startStopButton = new JButton();
		randomizeButton = new JButton();
		clearButton = new JButton();
		speedLabel = new JLabel();
		speedField = new JTextField(4);
		setLayout(new BorderLayout());
		
		startStopButton.setText("START");
		startStopButton.addActionListener(this);
		randomizeButton.setText("RANDOMIZE");
		randomizeButton.addActionListener(this);
		clearButton.setText("CLEAR");
		clearButton.addActionListener(this);	
		speedLabel.setText("DELAY: ");		
		
		inputPanel.add(startStopButton);
		inputPanel.add(speedLabel);
		inputPanel.add(speedField);
		inputPanel.add(randomizeButton);
		inputPanel.add(clearButton);
		
		window.add(this);	
		add(inputPanel, BorderLayout.NORTH);
		add(gamePanel);	
		
		window.setVisible(true);	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if startStopButton is pressed, 
		if (e.getSource() == startStopButton) {
			// toggle isRunning to the opposite of its current state
			isRunning = !isRunning;
			
			// start or stop the animation based on the state of isRunning
			if (isRunning) {
				gamePanel.startAnimation();
			} else {
				gamePanel.stopAnimation();
			}
		}
		
		// if ranomizeButton is pressed
		if (e.getSource() == randomizeButton) {
			// call randomizeCells
			gamePanel.randomizeCells();
		}
		
		// if clearButton is pressed
		if (e.getSource() == clearButton) {
			//call clearCells
			gamePanel.clearCells();
		}
	}
}

