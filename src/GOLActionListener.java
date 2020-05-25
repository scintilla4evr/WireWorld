import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GOLActionListener implements ActionListener{
	private Board board;
	
	public GOLActionListener(Board board) {
		super();
		this.board = board;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		board.calculateNextStateGOL();
		board.updateBoard();
	}

}
