import java.awt.Dimension;

public class Board {
	private int rows;
	private int cols;
	private Cell[][] board;
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		initializeBoard();
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public Cell getCell(int r, int c) { //uzycie np. board.getCell(1,1).getState() da stan tej komorki itp.
		return board[r][c];
	}
	
	public void initializeBoard() {
		BoardClickListener bcl = new BoardClickListener(rows, cols, this); //wspolny dla wszystkich z oszczednosci pamieci
		Dimension d = new Dimension(MainWindow.cellSideSize, MainWindow.cellSideSize);
		board = new Cell [rows][cols];
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
			{
				if(i==0 || j==0 || i==rows-1 || j==cols-1)
				{
					board[i][j] = new Cell(C.PADD, C.PADD);
					//board[i][j].setPreferredSize(d);
					continue;
				}
				board[i][j] = new Cell(C.OFF, C.OFF); //na start wy³¹czona komórka
				board[i][j].setActionCommand(i+" "+j);
				board[i][j].addActionListener(bcl); //kazdemu przyciskowi dodajemy ActionListener
				//board[i][j].setPreferredSize(d); //zwiazany z rozmiarem MainWindow				
			}
	}	
	public void changeCellsSize(Dimension d) {
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
				board[i][j].setPreferredSize(d);
	}
	
	public void updateBoard() {
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
				board[i][j].updateState();
	}
	
	public void calculateNextStateGOL() {
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
			{
				int friendsWithStateON = countFriendsWithState(i, j, C.ON);
				byte cellState = board[i][j].getState();
				
				if(cellState == C.OFF && friendsWithStateON == 3)
					board[i][j].setNextState(C.ON);
				else if(cellState == C.ON && (friendsWithStateON == 2 || friendsWithStateON == 3))
						board[i][j].setNextState(C.ON);
				else 
					board[i][j].setNextState(C.OFF);
			}
	}
	
	public void calculateNextStateWW() {
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
			{
				int friendsWithStateHEAD = countFriendsWithState(i, j, C.HEAD);
				byte cellState = board[i][j].getState();
				
				if(cellState == C.OFF)
					board[i][j].setNextState(C.OFF);
				else if(cellState == C.HEAD)
					board[i][j].setNextState(C.TAIL);
				else if(cellState == C.TAIL)
					board[i][j].setNextState(C.ON);
				else if(friendsWithStateHEAD == 1 || friendsWithStateHEAD == 2)
					board[i][j].setNextState(C.HEAD);
				else {
					board[i][j].setNextState(C.ON);
				}
			}
	}
	
	private int countFriendsWithState(int i, int j, byte friendState) {
		int count = 0;
		if(board[i][j-1].getState()==friendState)
			count++;
		else if(board[i][j+1].getState()==friendState)
			count++;
		else if(board[i-1][j].getState()==friendState)
			count++;
		else if(board[i+1][j].getState()==friendState)
			count++;
		else if(board[i-1][j-1].getState()==friendState)
			count++;
		else if(board[i-1][j+1].getState()==friendState)
			count++;
		else if(board[i+1][j-1].getState()==friendState)
			count++;
		else if(board[i+1][j+1].getState()==friendState)
			count++;
		return count;
	}
	
}
