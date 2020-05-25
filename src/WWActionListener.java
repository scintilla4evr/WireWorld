import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WWActionListener implements ActionListener{
	private Board board;
	
	public WWActionListener(Board board) {
		super();
		this.board = board;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		board.calculateNextStateWW();
		board.updateBoard();
	}


}
