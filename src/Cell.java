import java.awt.Color;

import javax.swing.JButton;

public class Cell extends JButton { //wspolna dla obu gier
	private static final long serialVersionUID = -7309940893358748305L;
	private byte state;
	private byte nextState;
	private Color color;
	
	public Cell(byte state, byte nextState) {
		super();
		this.state = state;
		this.nextState = nextState;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	public byte getNextState() {
		return nextState;
	}
	public void setNextState(byte nextState) {
		this.nextState = nextState;
	}
	public void updateState() {
		this.state = this.nextState;
		this.nextState = C.OFF;
	}
	public void updateColorToMatchState() {
		if(state == C.OFF)
			color = Color.BLACK;
		else if(state == C.ON)
			color = Color.ORANGE;
		else if(state == C.HEAD)
			color = color.BLUE;
		else if(state == C.TAIL)
			color = color.RED;
		else if(state == C.PADD)
			color = color.GREEN;
	}
	
	
}