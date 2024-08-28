import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class Boxes extends JFrame implements ChangeListener
{
    private JSlider slider;
    private JPanel boxesPanel;  
    
    public Boxes()
    {
        setSize(300, 150);
        setTitle("Boxes and a Slider");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        boxesPanel= new BoxesPanel();//need to create class;
        add(boxesPanel, BorderLayout.NORTH);
        
        slider=new JSlider(0, 10, 0);
        slider.setMajorTickSpacing(2);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true); //show paint ticks
        
        slider.setPaintLabels(true); //tick values
        slider.addChangeListener(this);
        add(slider,BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent e)
    {
        repaint();

    }
    
    public static void main(String [] args)
    {
        Boxes b= new Boxes();
    }
    /**
     * 
     * 
     * @author al
     * Panel for drawing shapes
     * Panel will be redrawn by the gui when the window resizes or 
     */
    private class BoxesPanel extends JPanel
    {
        public BoxesPanel() {
            setPreferredSize(new Dimension (190, 150));
            setBackground(Color.white);
        }
        /**
         * 
         */
        public void paintComponent(Graphics g)
        {
            int x=5;
            int numBoxes=slider.getValue();
            g.setColor(Color.blue); //set pen color
            for(int i=0; i<numBoxes; i++)
            {
                g.drawRect(x, 10, 20, 20); //x y width height
                x+=28;
            }
            
        }
    }

}
