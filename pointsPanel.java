
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;



public class pointsPanel extends JPanel {

    int point;
    int tack;
    
    JButton touchdownscore;
    JButton takedown;

   
    pointsPanel() 
    {
        touchdownscore = new JButton("touchdowns");
        takedown = new JButton("tackles");
        setBackground(Color.darkGray);
        add(touchdownscore);
        add(takedown);
        tack = 0;
    }

}
