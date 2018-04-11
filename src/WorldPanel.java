import java.awt.Graphics;
import java.util.ArrayList;

public class WorldPanel implements Drawable {
	private Cell[][] cells;
	
	@Override
	public void draw(Graphics g) {
		//iterate through cells and draw them
		
	}
	
	public void step() {
		//advances world one step
		//iterate through cells and get their neighbors
		//check if each cell should live or die
	}
	
	public ArrayList<Cell> getNeighbors(int x, int y){
		//returns an array list of the  8 or less neighbors of the 
		//cell identified by x and y
		return null;
	}

}
