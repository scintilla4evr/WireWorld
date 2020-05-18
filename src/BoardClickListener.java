import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardClickListener implements ActionListener {
	private int rows;
	private int cols;
	private Board board;
	private byte stateChangeClock = 0;
	private String lastCommand;
	
	public BoardClickListener(int rows, int cols, Board board) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.board = board;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		lastCommand = command;
		
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
				if(command.equals(i+" "+j))
				{
					if(lastCommand != command)
						stateChangeClock = board.getCell(i, j).getState();
					stateChangeClock++;
					
					board.getCell(i,j).setState((byte)(stateChangeClock%4)); //5-1=4 to ilosc stanow do wyboru po odjeciu 4. czyli PADDING
				}
	}

}
