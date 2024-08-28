import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * 
 * @author Alex Vasile wall class that creates h or v walls in game
 *
 **/
public class Wall extends Rectangle2D.Double
{
    private String type;
    private Color clr;

    /**
     * 
     * constructor- creates wall size, color, and type
     *
     **/
    public Wall(double x, double y, double w, double h, Color c, String t)
    {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.clr = c;
        this.type = t;

    }

    /**
     * 
     * gets the type of wall
     *
     **/

    public String getType()
    {
        return type;
    }

    /**
     * 
     * sets the type of wall
     *
     **/
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * 
     * gets color
     *
     **/
    public Color getClr()
    {
        return clr;
    }

    /**
     * 
     * changes color
     *
     **/
    public void setClr(Color clr)
    {
        this.clr = clr;
    }

}
