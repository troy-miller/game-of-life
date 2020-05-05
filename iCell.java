
public interface iCell {
	//Neighbor Methods
	public iCell getUp();
	public iCell getDown();
	public iCell getLeft();
	public iCell getRight();
	public iCell getUpLeft();
	public iCell getUpRight();
	public iCell getDownLeft();
	public iCell getDownRight();
	public void setUp(iCell myCell);
	public void setDown(iCell myCell);
	public void setLeft(iCell myCell);
	public void setRight(iCell myCell);
	public void setUpLeft(iCell myCell);
	public void setUpRight(iCell myCell);
	public void setDownLeft(iCell myCell);
	public void setDownRight(iCell myCell);
	public int countLivingNeighbors();
	public void recNeighbor(int currentIteration, int iterationCap, iCell prevCell);
	
	//State Methods
	public boolean isAlive();
	public void setNextState(int newState);
	public void updateCurrentState();
	public void setCurrentState(int newState);
	public int getCurrentState();
	public boolean isNull();
	
	//Update Methods
	public void changeUpdate(Update newUpdate);
	public void update();
	
}
