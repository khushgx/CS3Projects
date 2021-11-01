package ConwaysGameOfLifeClasses;

import java.awt.*;
import javax.swing.*;
import java.util.Random;


/** The view (graphical) component */
public class LifeView extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static int SIZE = 60;
	private boolean buttonPressed;
	

	/** store a reference to the current state of the grid */
    private LifeCell[][] grid;

    public LifeView()
    {
        grid = new LifeCell[SIZE][SIZE];
    }

    /** entry point from the model, requests grid be redisplayed */
    public void updateView( LifeCell[][] mg )
    {
        grid = mg;
        repaint();
    }
    
    public void setButtonPressed(boolean x) {
    	buttonPressed = x;
    }

    public void paintComponent(Graphics g)
    {
    	Random rand = new Random();
       
        float re = rand.nextFloat();
        float gr = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(re, gr, b); 
        super.paintComponent(g);
        int testWidth = getWidth() / (SIZE+1);
        int testHeight = getHeight() / (SIZE+1);
        // keep each life cell square
        int boxSize = Math.min(testHeight, testWidth);

        for ( int r = 0; r < SIZE; r++ )
        {
            for (int c = 0; c < SIZE; c++ )
            {
                if (grid[r][c] != null)
                {
                	if(grid[r][c].isAliveNow() && buttonPressed) {
                		g.setColor(getColor());
                	}
                	else if ( grid[r][c].isAliveNow() )
                        g.setColor( Color.BLUE );
                    else
                        g.setColor( new Color(235,235,255) );

                    g.fillRect( (c+1)*boxSize, (r+1)* boxSize, boxSize-2, boxSize-2);
                }
            }
        }
    }
    
    private Color getColor() {
    	
    	return new Color((int) (Math.random() * 0x1000000));
    }
}
