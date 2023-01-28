import javax.swing.*;
import java.awt.*;

import java.awt.Graphics2D;

public class BrickGenerator extends JPanel{

    boolean brickmap[][];
    int brickWidth;
    int brickHeight;

    public BrickGenerator(int rows, int cols)
    {
        brickmap = new boolean[rows][cols];

        for(int i=0 ; i<rows ; i++)
        {
            for(int j=0; j<cols;j++)
                brickmap[i][j] = true;
        }
        brickWidth = 600/rows;
        brickHeight =200/cols;
    }

    public void draw(Graphics2D g) {
        
        for(int i=0;i<brickmap.length;i++)
        {
            for(int j=0 ; j<brickmap[i].length;j++)
            {
                if(brickmap[i][j])
                {
                    g.setColor(Color.white);
                    g.fillRect(i*brickWidth + 100, j*brickHeight + 125, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(i*brickWidth + 100, j*brickHeight + 125, brickWidth, brickHeight);
                }
            }
        }
    }

    public void disableBrick(int row,int col)
    {
        brickmap[row][col] = false;
    }

}
