
import java.awt.BorderLayout;
import javax.swing.JFrame;


public class FirstFrame extends JFrame 
{
   
    FirstFrame()
    {
        
        super("Football Game");
       
        turfPanel tp = new turfPanel();
        add(tp); 
        
        pointsPanel pp = new pointsPanel();
        add(pp, BorderLayout.SOUTH);
        
        FirstPanel yp = new FirstPanel(tp, pp);
        add(yp, BorderLayout.NORTH);
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (950, 550);
	setVisible(true);
     
    }
    
}
