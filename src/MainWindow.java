import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class MainWindow {
	public static Dimension screenSize;
	public static byte chosenGame = C.GOL;
	public static int cellSideSize;
	private int rows;
	private int cols;
	
	private JFrame mainWindow;
	private JPanel controlPanel;
	private JPanel displayPanel; 
	private JPanel leftMargin;
	private JPanel rightMargin;
	private Board board;
	
	private JButton goHomeBtn;
	private JButton pauseBtn;
	private JButton structBtn;
	private JButton startBtn;
	private TextArea rowsTA;
	private TextArea columnsTA;
	private TextArea numOfGensTA;
	private JLabel rowsLabel;
	private JLabel columnsLabel;
	private JLabel numOfGensLabel;
	private JLabel speedLabel;
	private JLabel currentSpeedLabel;
	private JSlider speedSlider;
	
	public MainWindow() {
		buildMainWindow();
		buildControlPanel();
		buildDisplayPanel();
	}
	
	private void buildMainWindow() {
		mainWindow = new JFrame("Uniwersalny automat komórkowy"); 
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainWindow.setSize(screenSize);
//		mainWindow.setMinimumSize(screenSize);  //nie wiem czy to potrzebne
		mainWindow.setMaximumSize(screenSize);
		mainWindow.setLayout(new BorderLayout()); 
		
		controlPanel = new JPanel(new GridBagLayout()); 
		displayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0)); 
		leftMargin = new JPanel();
		rightMargin = new JPanel();
		
		//leftMargin.setPreferredSize(new Dimension( (screenSize.width - (cols * cellSideSize))/2 ,screenSize.height)); // tu bedzie zabawa aby odpowiednio dobrac te wartosci!
		//rightMargin.setPreferredSize(new Dimension( (screenSize.width - (cols * cellSideSize))/2 ,screenSize.height));
	
		mainWindow.add(controlPanel,BorderLayout.NORTH); //kazdy element należy dodać do okna, a niektóre tylko do odpowiadającej struktury która już jest dodana do okna
		mainWindow.add(displayPanel,BorderLayout.CENTER);
		mainWindow.add(leftMargin,BorderLayout.WEST);
		mainWindow.add(rightMargin,BorderLayout.EAST);
		
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //kliknięcie zamnknięcia wyłącza okno
		mainWindow.setVisible(true); //aby okno było widoczne, dla false jest niewidzialne
		
	}
	
	private void buildControlPanel() {
		goHomeBtn = new JButton("go home");
		pauseBtn = new JButton("pause");
		structBtn = new JButton("structs");
		startBtn = new JButton("start");
		rowsTA = new TextArea("10", 1, 8, TextArea.SCROLLBARS_NONE); //tekst zachęty, ilość rzędów i kolumn, można usunąć scrollbary
		columnsTA = new TextArea("10", 1, 8, TextArea.SCROLLBARS_NONE);
		numOfGensTA = new TextArea("default value", 1, 8, TextArea.SCROLLBARS_NONE);
		rowsLabel = new JLabel("rows:");
		columnsLabel = new JLabel("columns:");
		numOfGensLabel = new JLabel("number of generations:");
		speedLabel = new JLabel("animation speed:");
		speedSlider = new JSlider(1,10,5);
		currentSpeedLabel = new JLabel("5");
		
		
		//to jest tylko po to aby ButtonClickListener mogl obslugiwac te przyciski bez dostepu do nich bezposrednio
		goHomeBtn.setActionCommand("goHomeBtn");
		pauseBtn.setActionCommand("pauseBtn");
		structBtn.setActionCommand("structBtn");
		startBtn.setActionCommand("startBtn");
		
		//wszystkie actions listenery:
		goHomeBtn.addActionListener(new ButtonClickListener());
		pauseBtn.addActionListener(new ButtonClickListener());
		structBtn.addActionListener(new ButtonClickListener());
		startBtn.addActionListener(new ButtonClickListener());
		speedSlider.addChangeListener(new SliderChangeListener(this));
		
		GridBagConstraints gbc = new GridBagConstraints();
	//trzeba je dodać do controlPanel ale nie trzeba już bezpośrednio do mainWindow bo controlPanel 
		//jest do niego dodany, więc i przyciski pośrednio są dodane
	//mamy wyobrazoną siatkę a x, y to pozycje na niej a nie odległości, tutaj wszystko jest względne
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,15,0,15);
		gbc.gridx = 0;
		gbc.gridy = 1;
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
		gbc.gridx = 8;
		gbc.gridy = 1;
		controlPanel.add(startBtn,gbc);
		
	}
	
	private void buildDisplayPanel() { 
//		board = LoadBoardFromFile.loadBoardFromFile("example.life"); //wczytanie pliku
		if(board == null)
			board = new Board(Integer.parseInt(rowsTA.getText())+2, Integer.parseInt(columnsTA.getText())+2); // +2 dla paddingu
		rows = board.getRows(); 
		cols = board.getCols();
		
		cellSideSize = (displayPanel.getSize().height)/rows*9/10;	//tak chyba wygodniej, tez zmniejszylem do 90%
		board.changeCellsSize(new Dimension(cellSideSize,cellSideSize));
		
		for(int i=0; i<rows; i++) //dodanie kazdego przycisku do JPanel'u 
			for(int j=0; j<cols; j++) {
				displayPanel.add(board.getCell(i, j));
			}

	}
	
	public int getCurrentSpeedLabel() {
		return Integer.parseInt(currentSpeedLabel.getText());
	}
	public void setCurrentSpeedLabel(int currentSpeed) {
		currentSpeedLabel.setText(String.valueOf(currentSpeed));
	}
	
}
