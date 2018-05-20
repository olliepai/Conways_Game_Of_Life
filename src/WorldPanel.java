import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private int cellsPerRow;
	private int cellSize;
	private Cell[][] cells;
	private Timer timer;
	
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
	
		//calculate the cellSize
		cellSize = w / cpr;
		
		//initialize the cells array
		cells = new Cell[cpr][cpr];
		
		//initialize each cell in the array
		for (int r = 0; r < cells.length; r++) {
			for (int c = 0; c < cells[r].length; c++) {
				cells[r][c] = new Cell(r * cellSize, c * cellSize, cellSize);
			}
		}
	}
	
	public void randomizeCells() {
		// make each cell alive or dead randomly
		for (Cell[] r : cells) {
			for (Cell c : r) {
				if (new Random().nextBoolean()) {
					c.isAlive = true;
				} else {
					c.isAlive = false;
				}
			}
		}

		repaint();
	}
	
	public void clearCells() {
		// set isAlive to false for all cells
		for (Cell[] r : cells) {
			for (Cell c : r) {
				c.isAlive = false;
			}
		}
		
		repaint();
	}
	
	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//iterate through the cells and draw them
		for (Cell[] r : cells) {
			for (Cell c : r) {
				c.draw(g);
			}
		}
	}
	
	//advances world one step
	public void step() {
		//initialize the numLivingNbors variable to be the same size as the cells
		int[][] numLivingNbors = new int[cells.length][cells[0].length];
		
		//iterate through the cells and populate the numLivingNbors array with their neighbors
		for (int r = 0; r < numLivingNbors.length; r++) {
			for (int c = 0; c < numLivingNbors[r].length; c++) {
				numLivingNbors[r][c] = getLivingNeighbors(c, r);
			}
		}
		
		repaint();
	}
	
	//returns an array list of the  8 or less neighbors of the 
	//cell identified by x and y
	public int getLivingNeighbors(int x, int y){
		int livingNeighbors = 0;
		
		//add 1 to livingNeighbors for each
		//neighboring cell that is alive
		for (int r = y - 1; r < y + 2; r++) {
			for (int c = x - 1; c < x + 2; c++) {
				if (r >= 0 && r < cells.length && c >= 0 && c < cells[0].length && r != y && c != x && cells[r][c].isAlive == true) {
					livingNeighbors++;
				}
			}
		}
		
		return livingNeighbors;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// IGNORE
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//get the location of the mouse
		int xPos = e.getX() / cellSize;
		int yPos = e.getY() / cellSize;
		
		//toggle the cell at that location to either alive or dead
		//based on its current state
		if (cells[yPos][xPos].isAlive) {
			cells[yPos][xPos].isAlive = false;
		} else {
			cells[yPos][xPos].isAlive = true;
		}
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
