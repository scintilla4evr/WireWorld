import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {

	// obsluguje przyciski z menu w MainWindow - mowi co sie stanie po kliknieciu
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
	
		if(command.equals("goHomeBtn")) {
			;
		}
		else if(command.equals("pauseBtn")) {
			;
		}
		else if(command.equals("structBtn")) {
			;
		}
		
	}
}
