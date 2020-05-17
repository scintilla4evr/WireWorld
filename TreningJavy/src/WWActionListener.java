import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WWActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow.board.calculateNextStateWW();
		MainWindow.board.updateBoard();
	}

}
