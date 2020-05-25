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
				GOLActionListener golActionListener = new GOLActionListener(MainWindow.getBoard());
		        new Timer(MainWindow.getCurrentSpeedLabel()*100 , golActionListener).start();
			}
			if(MainWindow.chosenGame == C.WW)
			{
				WWActionListener wwActionListener = new WWActionListener(MainWindow.getBoard());
		        new Timer(MainWindow.getCurrentSpeedLabel()*100 , wwActionListener).start();
			}
		}
		else if(command.equals("pauseBtn")) {
			;
		}
		else if(command.equals("structBtn")) {
			;
			
		} 
		
	}
}
