import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeListener implements ChangeListener { // nie roznicuje sliderow wiec dziala dla 1, mozna zmienic
	private MainWindow mainWindow;
	
	public SliderChangeListener(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		int currentSpeed = ((JSlider)e.getSource()).getValue();
		mainWindow.setCurrentSpeedLabel(currentSpeed);
	}
	
}	
