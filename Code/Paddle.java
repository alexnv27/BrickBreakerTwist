import java.awt.Color;
/**
 * 
 * @author Alex Vasile Paddle class is a sub class of a wall that also has its own velocity 
 *
 **/
public class Paddle extends Wall
{

    private int yVel;
    /**
     * 
     * Constructor- first four parameters are for building the size of the paddle, c is for color, and yV is for its speed
     *
     **/
    public Paddle(int x, int y, int w, int h, Color c, int yV)
    {
        super(x, y, w, h, c, "V");
        yVel = yV;
        // TODO Auto-generated constructor stub.
    }
    /**
     * 
     *changes y velocity 
     *
     **/
    public void setVelocity(int v)
    {
        yVel=v;
    }
    /**
     * 
     * moves the paddle up
     *
     **/
    public void yMoveUp()
    {
        if (yVel > 0)
        {
            yVel *= -1;
        }
        y += yVel;
    }
    /**
     * 
     *moves paddle down
     *
     **/

    public void yMoveDown()
    {
        if (yVel < 0)
        {
            yVel *= -1;
        }

        y += yVel;
    }
    /**
     * 
     * returns velocity 
     *
     **/

    public int getYVelocity()
    {
        return yVel;
    }

}
