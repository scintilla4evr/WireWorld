import java.awt.Color;

import javax.swing.JButton;

public class Cell extends JButton { //wspolna dla obu gier
	private byte state;
	private byte nextState;
	private Color color;
	
	public Cell(byte state, byte nextState) {
		super("b");
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
	
}
