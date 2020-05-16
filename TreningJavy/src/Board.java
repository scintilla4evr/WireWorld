
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
		board = new Cell [rows][cols];
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
			{
				board[i][j] = new Cell(C.OFF, C.OFF);
				board[i][j].setActionCommand(i+" "+j);
				board[i][j].addActionListener(bcl); //kazdemu przyciskowi dodajemy ActionListener
			}
	}
	
}
