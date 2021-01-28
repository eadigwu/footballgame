
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;





public class FirstPanel extends JPanel implements ActionListener, ChangeListener
{

    int speed = 0;
    int i = 0;
    int l6x = 410;
    int l6y = 50;
    int l7x = 410;
    int l7y = 120;
    int l8x = 410;
    int l8y = 200;
    int l9x = 410;
    int l9y = 350;
    
   
    
    JSlider time;
    turfPanel tp;
    pointsPanel pp;
    
    JTextArea message = new JTextArea("Game Clock");
    
    JButton start = new JButton("START");
   
    
    Timer tm;
    
    

    public FirstPanel(turfPanel tp, pointsPanel pp) 
    {
        this.tp = tp;
        this.pp = pp;
        setBackground(Color.darkGray);
        speed = 250;

        tm = new Timer(speed, this);
        start.addActionListener(this);
        add(start);
        add(message);
        
        time = new JSlider(JSlider.HORIZONTAL, 50, 500, 250);
        time.setBorder(BorderFactory.createTitledBorder("Game Speed"));
        time.setMajorTickSpacing(1);
        time.setPaintTicks(true);
        
        
        
        
        add(time);
        time.addChangeListener(this);

    }

    public void movementLB() {

        if (tp.x < l6x) {
            l6x = l6x - 4;
        }
        if (tp.y < l6y) {
            l6y = l6y - 4;
        }
        if (tp.x > l6x) {
            l6x = l6x + 4;
        }
        if (tp.y > l6y) {
            l6y = l6y + 4;
        }

        if (tp.x < l7x) {
            l7x = l7x - 5;
        }
        if (tp.y < l7y) {
            l7y = l7y - 5;
        }
        if (tp.x > l7x) {
            l7x = l7x + 5;
        }
        if (tp.y > l7y) {
            l7y = l7y + 5;
        }
        
        if (tp.x < l8x) {
            l8x = l8x - 2;
        }
        if (tp.y < l8y) {
            l8y = l8y - 2;
        }
        if (tp.x > l8x) {
            l8x = l8x + 2;
        }
        if (tp.y > l8y) {
            l8y = l8y + 2;
        }
        
        if (tp.x < l9x) {
            l9x = l9x - 7;
        }
        if (tp.y < l9y) {
            l9y = l9y - 7;
        }
        if (tp.x > l9x) {
            l9x = l9x + 7;
        }
        if (tp.y > l9y) {
            l9y = l9y + 7;
        }
            
            
        tp.firstLB.setBounds(new Rectangle(l6x, l6y, 85, 35));
        tp.secondLB.setBounds(new Rectangle(l7x, l7y, 95, 45));
        tp.thirdLB.setBounds(new Rectangle(l8x, l8y, 125, 125));
        tp.fourthLB.setBounds(new Rectangle(l9x, l9y, 60, 30));
        
    }

    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        
        
        if (ob == tm){
            i = i + 1;
            movementLB();
            message.setText(i + " seconds have past");
            

            if (tp.RunningBack.getBounds().intersects(tp.firstLB.getBounds()) == true){
                pp.tack = pp.tack + 1;
                pp.takedown.setText("tackles: " + pp.tack);

            }
            
            if (tp.RunningBack.getBounds().intersects(tp.secondLB.getBounds()) == true){
                pp.tack = pp.tack + 1;
                pp.takedown.setText("tackles: " + pp.tack);

            }

            if (tp.RunningBack.getBounds().intersects(tp.touchdown.getBounds()) == true){
                pp.point = pp.point + 1;
                tm.stop();
                pp.touchdownscore.setText("touchdownscore: " + pp.point);
                tp.createWindow();
                
            }        
        }
        
        
         
            if (i == 120){
                tm.stop();
                message.setText("GAME OVER");
            }

            if (ob == start){
                tm.start();
                tp.requestFocusInWindow();
                
                l6x = 410;
                l6y = 50;
                   
                l7x = 410;
                l7y = 120;

                l8x = 410;
                l8y = 200;

                l9x = 410;
                l9y = 350;
            }
    }

    
                   
    
    @Override
    public void stateChanged(ChangeEvent f) {
        Object ob = f.getSource();
        if (ob == time) {

            tm.setDelay(time.getValue());
        }

    }

}
