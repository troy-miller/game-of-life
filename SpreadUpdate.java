
public class SpreadUpdate implements Update {
	@Override
	public void updateCell(iCell cell) {
		//Spread to neighbors
		cell.getLeft().setNextState(1);
		cell.getRight().setNextState(1);
		cell.getUp().setNextState(1);
		cell.getDown().setNextState(1);
		cell.getUpLeft().setNextState(1);
		cell.getUpRight().setNextState(1);
		cell.getDownLeft().setNextState(1);
		cell.getDownRight().setNextState(1);
	}
}
