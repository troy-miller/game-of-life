import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameFrame extends JFrame {
	//---------------------
	//Instance Variables
	//---------------------
	private ArrayList<ArrayList<CellPanel>> cellRows;
	private JPanel cells;
	private JMenuBar menuBar;
	private JMenu updateMenu;
	private JMenu boardMenu;
	private JMenuItem nextGen;
	private JMenuItem randomize;
	private JMenuItem reset;
	private JMenuItem start;
	private JMenuItem stop;
	private Timer time;
	
	
	//---------------------
	//Constructors
	//---------------------
	public GameFrame(int numCells) {
		/////////
		//Timer//
		/////////
		time = new Timer(1000, new UpdateListener());
		
		/////////////////
		//Menu Elements//
		/////////////////
		
		//Menu Bar
		menuBar = new JMenuBar();
		
		//Menus
		updateMenu = new JMenu("Update");
		boardMenu = new JMenu("Board");
		
		//Menu Items
		nextGen = new JMenuItem("Next Generation");
		randomize = new JMenuItem("Randomize");
		reset = new JMenuItem("Reset");
		start = new JMenuItem("Start");
		stop = new JMenuItem("Stop");
		
		//Add Elements to Bar
		menuBar.add(updateMenu);
		menuBar.add(boardMenu);
		
		//Add Elements to Menus
		updateMenu.add(nextGen);
		updateMenu.add(start);
		updateMenu.add(stop);
		boardMenu.add(randomize);
		boardMenu.add(reset);
		
		//Add Action Listeners
		nextGen.addActionListener(new UpdateListener());
		randomize.addActionListener(new RandomizeListener());
		reset.addActionListener(new ResetListener());
		start.addActionListener(new StartListener());
		stop.addActionListener(new StopListener());
		
		////////////////
		//Set Up Frame//
		////////////////
		this.setLayout(new FlowLayout());
		this.setSize(700, 700);
		this.setTitle("Game of Life");
		
		/////////
		//Cells//
		/////////
		
		//Initialize Cells
		cellRows = new ArrayList<ArrayList<CellPanel>>();
		cells = new JPanel();
		cells.setPreferredSize(new Dimension(630, 630));
		cells.setLayout(new GridLayout(numCells, numCells));
		
		for (int i = 0; i < numCells; i++) {
			cellRows.add(new ArrayList<CellPanel>());
		}
		
		//Neighbor Cells
		for (ArrayList<CellPanel> cellRow : cellRows) {
			iCell newCell = new Cell();
			newCell.recNeighbor(0, numCells - 1, new NullCell());
			while (!newCell.isNull()) {
				cellRow.add(new CellPanel(newCell));
				newCell = newCell.getRight();
			}
		}
		
		for (int i = 0; i < numCells; i++) {
			if (!(i == 0)) {
				for (int j = 0; j < numCells; j++) {
					cellRows.get(i).get(j).getCell().setUp(cellRows.get(i - 1).get(j).getCell());
					if (!(j == 0)) {
						cellRows.get(i).get(j).getCell().setUpLeft(cellRows.get(i - 1).get(j - 1).getCell());
					}
					if (!(j == numCells - 1)) {
						cellRows.get(i).get(j).getCell().setUpRight(cellRows.get(i - 1).get(j + 1).getCell());
					}
				}
			}
			if (!(i == numCells - 1)) {
				for (int j = 0; j < numCells; j++) {
					cellRows.get(i).get(j).getCell().setDown(cellRows.get(i + 1).get(j).getCell());
					if (!(j == 0)) {
						cellRows.get(i).get(j).getCell().setDownLeft(cellRows.get(i + 1).get(j - 1).getCell());
					}
					if (!(j == numCells - 1)) {
						cellRows.get(i).get(j).getCell().setDownRight(cellRows.get(i + 1).get(j + 1).getCell());
					}
				}
			}
		}
		
		//Add cells to panel
		for (ArrayList<CellPanel> cellRow : cellRows) {
			for (CellPanel cell : cellRow) {
				cells.add(cell);
			}
		}
		
		this.setJMenuBar(menuBar);
		this.add(cells);
		
		this.setVisible(true);
	}
	
	//---------------------
	//Helper Methods
	//---------------------
	private void updateBoard() {
		for (ArrayList<CellPanel> cellRow : cellRows) {
			for (CellPanel cell : cellRow) {
				int neighborCount = cell.getCell().countLivingNeighbors();
				if (cell.getCell().getCurrentState() == 1) {
					if (neighborCount == 2 || neighborCount == 3) {
						cell.getCell().changeUpdate(new DefaultUpdate());
					}
					else {
						cell.getCell().changeUpdate(new DieUpdate());
					}
				}
				else {
					if (neighborCount == 3) {
						cell.getCell().changeUpdate(new ComeToLifeUpdate());
					}
					else {
						cell.getCell().changeUpdate(new DefaultUpdate());
					}
				}
				cell.getCell().update();
			}
		}
		for (ArrayList<CellPanel> cellRow : cellRows) {
			for (CellPanel cell : cellRow) {
				cell.getCell().updateCurrentState();
				cell.repaintCell();
			}
		}
	}
	
	//---------------------
	//Inner Classes
	//---------------------
	
	public class UpdateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			GameFrame.this.updateBoard();
		}
	}
	
	public class RandomizeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			for (ArrayList<CellPanel> cellRow : cellRows) {
				for (CellPanel cell : cellRow) {
					int randState = rand.nextInt(2);
					cell.getCell().setCurrentState(randState);
					cell.getCell().setNextState(randState);
					cell.repaintCell();
				}
			}
		}
	}
	
	public class ResetListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (ArrayList<CellPanel> cellRow : cellRows) {
				for (CellPanel cell : cellRow) {
					cell.getCell().setCurrentState(0);
					cell.getCell().setNextState(0);
					cell.repaintCell();
				}
			}
		}
	}
	
	public class StartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			time.start();
		}
	}
	
	public class StopListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			time.stop();
		}
	}
}
