
/********************************************************   
  * Your Name:
  * Period:1
  * Date: 
  * Program Purpose: Balls bounce in a rectangular area and 
  *                  detect horizontal and Vertical walls
 **********************************************************/

import java.awt.*;

import javax.swing.*;

public class GameFrame extends JFrame
{

    

    BallPanel panel;

    public GameFrame(int sz)
    {

        setTitle("Ball Bouncing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(sz + 30, sz / 2 + 50); // frame size bigger than panel
        setResizable(false);

        panel = new BallPanel(sz);

        add(panel);

        setVisible(true);

    }

    public static void main(String[] args)
    {

        //int size = InputMethods.getIntBetweenJOP("Enter game size", 200, 1000);

        GameFrame bounce = new GameFrame(1000);

    }
}