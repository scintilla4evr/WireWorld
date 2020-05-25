import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ButtonClickListener implements ActionListener {

	// obsluguje przyciski z menu w MainWindow - mowi co sie stanie po kliknieciu
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
	
		if(command.equals("goHomeBtn")) {
			;
		}
		else if(command.equals("startBtn")) {
			if(MainWindow.chosenGame == C.GOL)
			{
				MainWindow.getGolAnimationTimer().start();
			}
			if(MainWindow.chosenGame == C.WW)
			{
				MainWindow.getWwAnimationTimer().start();
			}
		}
		else if(command.equals("pauseBtn")) {
			if(MainWindow.chosenGame == C.GOL)
			{
				MainWindow.getGolAnimationTimer().stop();
			}
			if(MainWindow.chosenGame == C.WW)
			{
				MainWindow.getWwAnimationTimer().stop();
			}
		}
		else if(command.equals("structBtn")) {
			;
			
		} 
		
	}
}
