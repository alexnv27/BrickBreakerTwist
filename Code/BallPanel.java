import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import javax.swing.Timer;

public class BallPanel extends JPanel implements ActionListener
{
    private ArrayList<Ball> balls;
    private ArrayList<Wall> walls;
    private Random r;
    private Timer timer;

    public BallPanel(int size)
    {
        int w = (size + 12);
        int h = (size / 2 + 5);
        setSize(w, h);
        setBackground(Color.WHITE);
        r = new Random();
        walls = new ArrayList<Wall>();
        balls = new ArrayList<Ball>();

        walls.add(new Wall(0, 0, 4, h, Color.RED, "V"));
        walls.add(new Wall(w - 4, 0, 4, h, Color.RED, "V"));

        walls.add(new Wall(0, 0, w, 4, Color.RED, "H"));
        walls.add(new Wall(0, h, w, 4, Color.RED, "H"));

        //addRandomWall();

        balls.add(new Ball());
        balls.add(new Ball());
        balls.add(new Ball(w-50, h-200, 30, 30, Color.pink, 20, 20));
        balls.add(new Ball(w-100, h-150, 50, 50, Color.CYAN, 4, 4));
        balls.add(new Ball(w-300, h-100, 5, 5, Color.MAGENTA, 1, 1));

        timer = new Timer(20, this);       
       
        timer.start();
        
    }

    

    public void addRandomWall()
    {
        for (int i = 0; i < 10; i++)
        {
            int type = (int) (r.nextInt(2));
            String t = "";
            if (type == 1)
            {
                t = "V";
            } else
                t = "H";
            Color myColor = new Color(((int) (r.nextInt(256))), ((int) (r.nextInt(256))), ((int) (r.nextInt(256))));

            Wall h;
            int x = r.nextInt(this.getWidth());
            int y = r.nextInt(this.getHeight());

            if (t.equals("V"))
            {
                h = (new Wall(x, y, 4, 50, myColor, "V"));
            } else
            {
                h = (new Wall(x, y, 100, 4, myColor, "H"));
            }

            for (Wall w : walls)
            {
                while (h.intersects(w))
                {
                    x = r.nextInt(this.getWidth());
                    y = r.nextInt(this.getHeight());
                    if (t.equals("V"))
                    {
                        h = (new Wall(x, y, 4, 50, myColor, "V"));
                    } else
                    {
                        h = (new Wall(x, y, 100, 4, myColor, "H"));
                    }
                }
            }
            walls.add(h);

        }

    }

    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);

        Graphics2D paper = (Graphics2D) g;

        for (int i = 0; i < 4; i++)
        {
            g.setColor(walls.get(i).getClr());
            paper.draw(walls.get(i));
            paper.fill(walls.get(i));

        }

        for (int i = 4; i < walls.size(); i++)
        {

            g.setColor(walls.get(i).getClr());
            paper.draw(walls.get(i));
            paper.fill(walls.get(i));

        }

        for (int i = 0; i < balls.size(); i++)
        {

            g.setColor(balls.get(i).getColor());
            paper.draw(balls.get(i));
            paper.fill(balls.get(i));

        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        for (int i = 0; i < balls.size(); i++)
        {
            balls.get(i).move();
            
            for (int k = 0; k < walls.size(); k++)
            {
                
                
                if (balls.get(i).intersects(walls.get(k)))
                {
                    
                    if (walls.get(k).getType().equals("V"))
                    {
                        if(balls.get(i).getXVelocity()<0) //negative which is right side of wall
                        {
                            balls.get(i).x=walls.get(k).getMaxX()+1;
                            balls.get(i).changeXVelocity();
                            
                        }
                        else
                        {
                            balls.get(i).x=walls.get(k).x-balls.get(i).getWidth()-1;
                            balls.get(i).changeXVelocity();
                        }
                                
                        
                    } else
                    {
                        if(balls.get(i).getYVelocity()<0)
                        {
                            balls.get(i).y=walls.get(k).getMaxY()+1;
                            balls.get(i).changeYVelocity();
                        }
                        else
                        {
                            balls.get(i).y=walls.get(k).y-balls.get(i).getHeight()-1;
                            balls.get(i).changeYVelocity();
                        }
                        
                    }
                }

            }

        }

        repaint();
    }

}
