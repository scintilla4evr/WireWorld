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
		Dimension d = calculateCellSize();
		board = new Cell [rows][cols];
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
			{
				board[i][j] = new Cell(C.OFF, C.OFF);
				board[i][j].setActionCommand(i+" "+j);
				board[i][j].addActionListener(bcl); //kazdemu przyciskowi dodajemy ActionListener
				board[i][j].setSize(d); //nie dzila nie wiem czemu
				
			}
	}
	
	private Dimension calculateCellSize() {
		int height = (int)MainWindow.windowHeight/rows;
		int width = (int)MainWindow.windowWidth/cols;
		int smallerSize = Integer.min(height, width);
		return new Dimension(smallerSize,smallerSize);
	}
	
	public void updateBoard() {
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
			{
				board[i][j].updateState();
				board[i][j].updateColorToMatchState();
			}
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
