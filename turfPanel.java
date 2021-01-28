
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.JLabel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;


public class turfPanel extends JPanel implements KeyListener

{
    
    int x = 110;
    int y = 215;
    
    
    JButton touchdown = new JButton("touchdown");
    JButton RunningBack = new JButton("RB");
    JButton firstLB = new JButton("1LB");
    JButton secondLB = new JButton("2LB");
    JButton thirdLB = new JButton("3LB");
    JButton fourthLB = new JButton("4LB");
    
    FirstPanel fp;
    int result; 

   public turfPanel()
   
   {
       
         setBackground(Color.getHSBColor(0.33f, 0.75f, 0.50f));
         setLayout(null);
        
        touchdown.setBounds(new Rectangle(820, 1, 115, 425));
        RunningBack.setBounds(new Rectangle(x, y, 80, 30));
        firstLB.setBounds(new Rectangle(410, 50, 85, 35));
        secondLB.setBounds(new Rectangle(410, 120, 95, 45));
        thirdLB.setBounds(new Rectangle(410, 200, 125, 125));
        fourthLB.setBounds(new Rectangle(410, 350, 60, 30));
        
        
        
        add(touchdown);
        add(RunningBack);
        add(firstLB);
        add(secondLB);
        add(thirdLB);
        add(fourthLB);
        
        
        setFocusable(true);
        addKeyListener(this);
        
        
        
       
    }
    
    
    public void createWindow(){
        JFrame frame = new JFrame("Touchdown!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(250, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void createUI(final JFrame frame){
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        
        JButton button = new JButton("Click Me!");
        JLabel label = new JLabel();
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                result = JOptionPane.showConfirmDialog(frame, "Go for another Touchdown?",
                    "Touchdown!",    
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                
                if(result == JOptionPane.YES_OPTION){
                    frame.dispose();
                    
                    RunningBack.setBounds(new Rectangle(110, 215, 80, 30));
                    firstLB.setBounds(new Rectangle(410, 50, 85, 35));
                    secondLB.setBounds(new Rectangle(410, 120, 95, 45));
                    thirdLB.setBounds(new Rectangle(410, 200, 125, 125));
                    fourthLB.setBounds(new Rectangle(410, 350, 60, 30));
                    
                    x = 110;
                    y = 215;
                   
                  

                          
                }
                else if(result == JOptionPane.NO_OPTION){
                    label.setText("You selected: No. Exit to end game.");
                }
            }
        });
        
        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
            
    
    
    @Override
    public void keyTyped(KeyEvent d) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent d) {
        int r = d.getKeyCode();
        
        if(r ==  d.VK_UP) {y = y - 5;}
        if(r ==  d.VK_DOWN) {y = y + 5;}
        if(r ==  d.VK_LEFT) {x = x - 5;}
        if(r ==  d.VK_RIGHT) {x = x + 5;}
        
         RunningBack.setBounds(new Rectangle(x, y, 80, 30));
         
    }
    
    

    @Override
    public void keyReleased(KeyEvent d) 
    {
       
    }
    
    
    @Override
    public void paintComponent(Graphics f)
    {
        setFocusable(true);
        requestFocusInWindow();
        super.paintComponent(f);
        
    }
    
    
 
}
    
    
    


