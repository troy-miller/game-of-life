import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class CellPanel extends JPanel {
	//---------------------
	//Instance Variables
	//---------------------
	private iCell myCell;
	
	//---------------------
	//Constructors
	//---------------------
	public CellPanel() {
		myCell = new Cell();
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.addMouseListener(new ClickListener());
	}
	
	public CellPanel(iCell newCell) {
		myCell = newCell;
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.addMouseListener(new ClickListener());
	}
	
	//---------------------
	//Class Methods
	//---------------------
	public void killCell() {
		myCell.setNextState(0);
	}
	
	public void liveCell() {
		myCell.setNextState(1);
	}
	
	public void killCellNow() {
		myCell.setCurrentState(0);
		this.killCell();
		this.repaintCell();
	}
	
	public void liveCellNow() {
		myCell.setCurrentState(1);
		this.liveCell();
		this.repaintCell();
	}
	
	public iCell getCell() {
		return myCell;
	}
	
	public void repaintCell() {
		if (myCell.getCurrentState() == 0) {
			this.setBackground(Color.white);
		}
		else {
			this.setBackground(Color.black);
		}
	}
	
	//---------------------
	//Inner Classes
	//---------------------
	public class ClickListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (CellPanel.this.getCell().isAlive()) {
				CellPanel.this.killCellNow();
			}
			else {
				CellPanel.this.liveCellNow();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			//Do nothing
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//Do nothing
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			//Do nothing
		}

		@Override
		public void mouseExited(MouseEvent e) {
			//Do nothing
		}
	}
}
