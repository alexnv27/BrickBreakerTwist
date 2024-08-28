import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/********************************************************
 * Alex Vasile Paddle Frame that makes a
 * brick panel and gets user input for customization
 **********************************************************/

public class PaddleFrame extends JFrame
{

    private BrickPanel panel;

    /**
     * 
     * constructor that makes frame with all ui specifications
     *
     **/
    public PaddleFrame(int sz, int players, int level, String name) throws IOException
    {

        setTitle("Classic Brick Breaker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(sz + 30, sz / 2 + 50); // frame size bigger than panel
        setResizable(false);

        panel = new BrickPanel(sz, players, level, name);

        add(panel);

        setVisible(true);

    }

    /**
     * 
     * main method that gets ui and creates instance of paddle frame so the program
     * can run
     *
     **/
    public static void main(String[] args) throws IOException
    {

        // int size = InputMethods.getIntBetweenJOP("Enter game size", 200, 1000);
        int players = InputMethods.getIntBetweenJOP("Enter number of players", 1, 2);
        int level = InputMethods.getIntBetweenJOP("Enter the level to start on", 1, 3);
        String name = JOptionPane.showInputDialog("Enter username");

        PaddleFrame bounce = new PaddleFrame(800, players, level, name);

    }

}