
public class Cell implements iCell {
	//---------------------
	//Instance Variables
	//---------------------
	private iCell up;
	private iCell down;
	private iCell left;
	private iCell right;
	private iCell upLeft;
	private iCell upRight;
	private iCell downLeft;
	private iCell downRight;
	private int currentState;
	private int nextGenState;
	private Update update;
	
	//---------------------
	//Constructors
	//---------------------
	public Cell() {
		up = new NullCell();
		down = new NullCell();
		left = new NullCell();
		right = new NullCell();
		upLeft = new NullCell();
		upRight = new NullCell();
		downLeft = new NullCell();
		downRight = new NullCell();
		currentState = 0;
		nextGenState = 0;
		update = new DefaultUpdate();
	}
	
	//---------------------
	//Class Methods
	//---------------------
	public boolean isNull() {
		return false;
	}
	
	//Get neighbors
	@Override
	public iCell getUp() {
		return up;
	}
	
	@Override
	public iCell getDown() {
		return down;
	}
	
	@Override
	public iCell getLeft() {
		return left;
	}
	
	@Override
	public iCell getRight() {
		return right;
	}
	
	@Override
	public iCell getUpLeft() {
		return upLeft;
	}
	
	@Override
	public iCell getUpRight() {
		return upRight;
	}
	
	@Override
	public iCell getDownLeft() {
		return downLeft;
	}
	
	@Override
	public iCell getDownRight() {
		return downRight;
	}
	
	//Set neighbors
	@Override
	public void setUp(iCell myCell) {
		up = myCell;
	}
	
	@Override
	public void setDown(iCell myCell) {
		down = myCell;
	}
	
	@Override
	public void setLeft(iCell myCell) {
		left = myCell;
	}
	
	@Override
	public void setRight(iCell myCell) {
		right = myCell;
	}
	
	@Override
	public void setUpLeft(iCell myCell) {
		upLeft = myCell;
	}
	
	@Override
	public void setUpRight(iCell myCell) {
		upRight = myCell;
	}
	
	@Override
	public void setDownLeft(iCell myCell) {
		downLeft = myCell;
	}
	
	@Override
	public void setDownRight(iCell myCell) {
		downRight = myCell;
	}
	
	//Get and set states
	@Override
	public boolean isAlive() {
		return currentState == 1;
	}
	
	@Override
	public void setCurrentState(int newState) {
		currentState = newState;
	}
	
	@Override
	public void setNextState(int newState) {
		nextGenState = newState;
	}
	
	@Override
	public void updateCurrentState() {
		currentState = nextGenState;
	}
	
	@Override
	public int getCurrentState() {
		return currentState;
	}
	
	//Updates
	@Override
	public void changeUpdate(Update newUpdate) {
		update = newUpdate;
	}
	
	@Override
	public void update() {
		update.updateCell(this);
	}
	
	@Override
	public int countLivingNeighbors() {
		int count = 0;
		if (this.getUp().isAlive()) {
			count += 1;
		}
		if (this.getDown().isAlive()) {
			count += 1;
		}
		if (this.getRight().isAlive()) {
			count += 1;
		}
		if (this.getLeft().isAlive()) {
			count += 1;
		}
		if (this.getUpRight().isAlive()) {
			count += 1;
		}
		if (this.getUpLeft().isAlive()) {
			count += 1;
		}
		if (this.getDownRight().isAlive()) {
			count += 1;
		}
		if (this.getDownLeft().isAlive()) {
			count += 1;
		}
		return count;
	}
	
	//-----------------------------
	//Recursive Neighboring Helper
	//-----------------------------
	@Override
	public void recNeighbor(int currentIteration, int iterationCap, iCell prevCell) {
		if (currentIteration < iterationCap) {
			this.setLeft(prevCell);
			currentIteration += 1;
			Cell newCell = new Cell();
			newCell.recNeighbor(currentIteration,  iterationCap, this);
			this.setRight(newCell);
		}
		else {
			this.setLeft(prevCell);
		}
	}
}
