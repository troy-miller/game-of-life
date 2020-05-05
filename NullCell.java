
public class NullCell implements iCell {	
	//---------------------
	//Constructors
	//---------------------
	public NullCell() {
		//Do nothing
	}
	
	//---------------------
	//Class Methods
	//---------------------
	@Override
	public boolean isNull() {
		return true;
	}
	
	//Get neighbors
	@Override
	public iCell getUp() {
		return this;
	}
	
	@Override
	public iCell getDown() {
		return this;
	}
	
	@Override
	public iCell getLeft() {
		return this;
	}
	
	@Override
	public iCell getRight() {
		return this;
	}
	
	@Override
	public iCell getUpLeft() {
		return this;
	}
	
	@Override
	public iCell getUpRight() {
		return this;
	}
	
	@Override
	public iCell getDownLeft() {
		return this;
	}
	
	@Override
	public iCell getDownRight() {
		return this;
	}
	
	//Set neighbors
	@Override
	public void setUp(iCell myCell) {
		//Do nothing
	}
	
	@Override
	public void setDown(iCell myCell) {
		//Do nothing
	}
	
	@Override
	public void setLeft(iCell myCell) {
		//Do nothing
	}
	
	@Override
	public void setRight(iCell myCell) {
		//Do nothing
	}
	
	@Override
	public void setUpLeft(iCell myCell) {
		//Do nothing
	}
	
	@Override
	public void setUpRight(iCell myCell) {
		//Do nothing
	}
	
	@Override
	public void setDownLeft(iCell myCell) {
		//Do nothing
	}
	
	@Override
	public void setDownRight(iCell myCell) {
		//Do nothing
	}
	
	//Get and set states
	@Override
	public boolean isAlive() {
		return false;
	}
	
	@Override
	public void setNextState(int newState) {
		//Do nothing
	}
	
	@Override
	public void updateCurrentState() {
		//Do nothing
	}
	
	@Override
	public void setCurrentState(int newState) {
		//Do nothing
	}
	
	@Override
	public int getCurrentState() {
		return -1;
	}
	
	@Override
	public void recNeighbor(int currentIteration, int iterationCap, iCell prevCell) {
		//Do nothing
	}
	
	@Override
	public void changeUpdate(Update newUpdate) {
		//Do nothing
	}
	
	@Override
	public void update() {
		//Do nothing
	}
	
	@Override
	public int countLivingNeighbors() {
		return 0;
	}
}
