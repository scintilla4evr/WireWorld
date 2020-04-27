import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    Cell [][] space;
    Dimension d = getMaximumSize();
    int r;
    int c;
    int cellSize = 4;

    Window(int r, int c)
    {
        this.r = r+2;
        this.c = c+2;
        setSize(d.width, d.height);
        setLayout(null);
        space = new Cell[r][c];

        for(int i=0, h=0; i<r && h<d.height; i++, h+=cellSize)
            for(int j=0, w=0; j<c && w<d.width; j++, w+=cellSize)
            {
                space[i][j] = new Cell();
                space[i][j].setBounds(h,w,cellSize,cellSize);
                space[i][j].setBackground(new Color(0,0,0));
                //space[i][j].setBorder(BorderFactory.createEmptyBorder());
                add(space[i][j]);
            }
    }

    public static void main(String[] args)
    {
        Window window = new Window(100,100);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
