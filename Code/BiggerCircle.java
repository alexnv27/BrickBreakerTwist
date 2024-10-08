import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BiggerCircle extends JFrame implements ChangeListener, ActionListener
{

    private JPanel answerPanel;
    private JSlider redSlider, blueSlider;
    private CirclePanel drawPanel;
    private JLabel lblAnswer;
    private JButton btnReset;
    private static final int W = 650;
    private static final int H = (int) (14 / 25. * W);
    
    
    public BiggerCircle()
    {
        setSize(W,H);
        setLayout(new BorderLayout());
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Which circle is bigger?");
        
        createGUI();
        
        add(redSlider, BorderLayout.WEST);
        add(drawPanel, BorderLayout.CENTER);
        add(blueSlider, BorderLayout.EAST);
        
        
        add(answerPanel, BorderLayout.SOUTH);
        
        setResizable(false); //can't resize frame
        setLocationRelativeTo(null); //places frame in center of screen
        setVisible(true);
        
    }
    private void createGUI()
    {
        redSlider=new JSlider(JSlider.VERTICAL, 0, 100, 50);
        redSlider.addChangeListener(this);
        redSlider.setMajorTickSpacing(25);
        redSlider.setMinorTickSpacing(10);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true); //show values
        redSlider.setInverted(true);//inverted so 0 is at top
        redSlider.setForeground(Color.red);
        
        
        blueSlider=new JSlider(JSlider.VERTICAL, 0, 100, 50);
        blueSlider.addChangeListener(this);
        blueSlider.setMajorTickSpacing(25);
        blueSlider.setMinorTickSpacing(10);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true); //show values
        blueSlider.setInverted(true);//inverted so 0 is at top
        blueSlider.setForeground(Color.blue);
        
        drawPanel=new CirclePanel(getWidth(), getHeight()); //inner class
        
        answerPanel= new JPanel(); //flowlayout
        lblAnswer= new JLabel();
        answerPanel.add(lblAnswer);
        
        btnReset= new JButton("Reset");
        
        answerPanel.add(btnReset);
        btnReset.addActionListener(this);
        
        
    
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        redSlider.setValue(50);
        blueSlider.setValue(50);

    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        repaint(); //repaints frame-calls paint Component

    }

    public static void main(String[]args)
    {
        BiggerCircle b=new BiggerCircle();
    }
    private class CirclePanel extends JPanel
    {
        public CirclePanel(int w, int h)
        {
            setPreferredSize(new Dimension(w, h));
            setBackground(Color.white);

        }

        public void paintComponent(Graphics g)
        {
            int redValue, blueValue;
            redValue = redSlider.getValue();
            blueValue = blueSlider.getValue();

            g.setColor(Color.red);
            int redDiameter = (int) (redValue / 100. * getWidth() / 2);
            int blueDiameter = (int) (blueValue / 100. * getWidth() / 2);

            g.fillOval(0, 0, redDiameter, redDiameter);

            g.setColor(Color.blue);
            g.fillOval(getWidth() / 2, 0, blueDiameter, blueDiameter);

            if (redValue > blueValue)
            {
                lblAnswer.setText("Red is bigger");
            } else if (blueValue > redValue)

                lblAnswer.setText("Blue is bigger");
            else
                lblAnswer.setText("Circles are the same size");
        }
    }

}
