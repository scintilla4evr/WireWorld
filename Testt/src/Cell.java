import javax.swing.*;

public class Cell extends JButton
{
    private byte state;
    private byte nextState;

    void setState(byte state)
    {
        this.state = state;
    }
    void setNextState(byte nextState)
    {
        this.nextState = nextState;
    }
    void updateState()
    {
        this.state = this.nextState;
    }
    byte getState()
    {
        return this.state;
    }

}
