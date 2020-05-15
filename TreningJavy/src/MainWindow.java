import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class MainWindow {
	
	private JFrame mainWindow;
	private JPanel controlPanel;
	public static JLabel currentSpeedLabel; // to jest tu tylko dlatego ¿e potzrebowa³em mieæ do tego dostêp z innej klasy, to wyj¹tek, nie regu³a

	public MainWindow() {
		buildMainWindow();
		buildControlPanel();
	}
	
	private void buildMainWindow() {
		mainWindow = new JFrame("Uniwersalny automat komórkowy"); 
		mainWindow.setMinimumSize(new Dimension(1500,1000));
		mainWindow.setMaximumSize(new Dimension(1500,1000));
		mainWindow.setLayout(new GridLayout(3,8)); //dzieli okno na 3 rzêdy i 8 kolumn
		
		controlPanel = new JPanel(); //to bêdzie nasze menu
		controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		mainWindow.add(controlPanel); //kazdy element nale¿y dodaæ do okna, a niektóre tylko do odpowiadaj¹cej struktury która ju¿ jest dodana do okna
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //klikniêcie zamnkniêcia wy³¹cza okno
		mainWindow.setVisible(true); //aby okno by³o widoczne, dla false jest niewidzialne
		
	}
	
	private void buildControlPanel() {
		JButton goHomeBtn = new JButton("go home");
		JButton pauseBtn = new JButton("pause");
		JButton structBtn = new JButton("structs");
		
		TextArea rowsTA = new TextArea("default value", 1, 8); //tekst zachêty, iloœæ rzêdów i kolumn, mo¿na usun¹æ scrollbary
		TextArea columnsTA = new TextArea("default value", 1, 8);
		TextArea numOfGensTA = new TextArea("default value", 1, 8);
		JLabel rowsLabel = new JLabel("rows:");
		JLabel columnsLabel = new JLabel("columns:");
		JLabel numOfGensLabel = new JLabel("number of generations:");
		
		JLabel speedLabel = new JLabel("animation speed:");
		JSlider speedSlider = new JSlider(1,10,5);
		currentSpeedLabel = new JLabel("5");
		
		//to jest tylko po to aby ButtonClickListener mogl obslugiwac te przyciski bez dostepu do nich bezposrednio
		goHomeBtn.setActionCommand("goHomeBtn");
		pauseBtn.setActionCommand("pauseBtn");
		structBtn.setActionCommand("structBtn");
		
		//wszystkie actions listenery:
		goHomeBtn.addActionListener(new ButtonClickListener());
		pauseBtn.addActionListener(new ButtonClickListener());
		structBtn.addActionListener(new ButtonClickListener());
		speedSlider.addChangeListener(new SliderChangeListener());

		controlPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
	//trzeba je dodac do controlPanel ale nie trzeba ju¿ bezpoœrednio do mainWindow bo controlPanel jest do niego dodany, wiêc i przyciski poœrednio s¹ dodane
	//mamy wyobrazon¹ siatkê a x, y to pozycje na niej a nie odleg³oœci, tutaj wszystko jest wzglêdne
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		controlPanel.add(goHomeBtn,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		controlPanel.add(numOfGensLabel,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		controlPanel.add(numOfGensTA,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		controlPanel.add(rowsLabel,gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		controlPanel.add(rowsTA,gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		controlPanel.add(columnsLabel,gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		controlPanel.add(columnsTA,gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		controlPanel.add(speedLabel,gbc);
		gbc.gridx = 4;
		gbc.gridy = 1;
		controlPanel.add(speedSlider,gbc);
		gbc.gridx = 4;
		gbc.gridy = 2;
		controlPanel.add(currentSpeedLabel);
		
		gbc.gridx = 6;
		gbc.gridy = 1;
		controlPanel.add(pauseBtn,gbc);
		gbc.gridx = 7;
		gbc.gridy = 1;
		controlPanel.add(structBtn,gbc);
		
	}
	
	
	public static void main(String[] args) {
		MainWindow window = new MainWindow(); //stworzenie obiektu ktory jest oknem, mozna stworzyc 2 niezalezne identyczne okna
		
	}
	
}
