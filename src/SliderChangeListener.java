import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeListener implements ChangeListener { //tylko dla 1 slidera zadzia³a bo inaczej nie bêdziemy wiedzieæ z którego bierze wartoœæ
	@Override
	public void stateChanged(ChangeEvent e) {
		int currentSpeed = ((JSlider)e.getSource()).getValue();
		MainWindow.currentSpeedLabel.setText(String.valueOf(currentSpeed));
		
	}
	
}	
