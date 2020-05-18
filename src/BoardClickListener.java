import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardClickListener implements ActionListener {

	private int rows;
	private int cols;
	private Board board;
	
	public BoardClickListener(int rows, int cols, Board board) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.board = board;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
				if(command.equals(i+" "+j))
				{
					board.getCell(i,j).setState(C.ON); //tutaj zmienimy na zalezne od ilosci klikniec
				}
	}

}
