
public class DieUpdate implements Update {
	@Override
	public void updateCell(iCell cell) {
		cell.setNextState(0);
	}
}
