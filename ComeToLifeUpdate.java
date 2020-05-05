
public class ComeToLifeUpdate implements Update {
	@Override
	public void updateCell(iCell cell) {
		cell.setNextState(1);
	}
}
