import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 
 * @author Alex Vasile Ball class creates ball for brick pannel with all
 *         attributes
 *
 **/
public class Ball extends Ellipse2D.Double
{

    private int xVel;
    private int yVel;
    private Color clr;

    /**
     * 
     * Constructor- basic ball
     *
     **/
    public Ball()
    {
        x = 10;
        y = 10;
        width = 20;
        height = 20;

        clr = Color.black;
        xVel = 15;
        yVel = 15;
    }

    /**
     * 
     * Constructor-overrides makes ball using eclipse super class parameters but
     * adds color, x velocity, and y velocity
     *
     **/
    public Ball(double x, double y, double w, double h, Color c, int xV, int yV)
    {
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        clr = c;
        xVel = xV;
        yVel = xV;
    }

    /**
     * 
     * sets the speed for the ball
     *
     **/
    public void setVelocity(int v, int vs)
    {
        xVel = v;
        yVel = vs;
    }

    /**
     * 
     * returns color
     *
     **/

    public Color getColor()
    {
        return clr;
    }

    /**
     * 
     * moves ball
     *
     **/
    public void move()
    {
        x += xVel;
        y += yVel;
    }

    /**
     * 
     * does opposite x velocity
     *
     **/
    public void changeXVelocity()
    {

        xVel = -xVel;
    }

    /**
     * 
     * does opposite y velocity
     *
     **/

    public void changeYVelocity()
    {
        yVel = -yVel;
    }

    /**
     * 
     * return x vel
     *
     **/
    public int getXVelocity()
    {
        return xVel;
    }

    /**
     * 
     * returns y velocity
     *
     **/
    public int getYVelocity()
    {
        return yVel;
    }

    /**
     * 
     * changes ball size by increment
     *
     **/
    public void changeSize(int s)
    {
        width += s;
        height += s;
    }

    /**
     * 
     * changes color
     *
     **/

    public void setColor(Color c)
    {
        clr = c;
    }

    /**
     * 
     * sets ball to fixed size
     *
     **/
    public void setSize(int s)
    {
        width = s;
        height = s;
    }

}
