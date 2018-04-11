import java.awt.Graphics;
import java.util.ArrayList;

public class Cell implements Drawable{
	private int x;
	private int y;
	private boolean isAlive;
	
	public void liveOrDie(ArrayList<Cell> neighbors) {
		//sets isAlive to true or false based on the neighbors and 
		//the rules of the game
		/*
		 * 1. Any live cell with fewer than two live nieghbours dies, as if caused by underpopulation.
		 * 2. Any live cell with two or three live neighbours lives on to the next generation.
		 * 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
		 * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
		 * (source: Wikipedia)
		 * */
		
	}
	
	@Override
	public void draw(Graphics g) {
		//draws colored square if cell is alive
		//draws empty square if cell is dead
		
	}

}
