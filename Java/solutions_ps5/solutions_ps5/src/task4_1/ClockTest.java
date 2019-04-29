package task4_1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.*;

public class ClockTest extends JFrame{
	private JButton button = new JButton("Update Time");
	AnimatedClock  clock = new AnimatedClock();
    public ClockTest(){
    	// panel to group buttons
    	JPanel panel = new JPanel();
    	panel.add(button);
    	
    	// adding panels to the         
        this.add(clock,BorderLayout.CENTER);
        this.add(panel,BorderLayout.SOUTH);
        
        // registering listeners
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
          	   clock.setCurrentTime();
            }
        });
        
        
        // to animate clock
//        Timer timer = new Timer(1000,new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//           	   clock.setCurrentTime();
//             }
//         } );
//        
//        timer.start();
        
    }

    public static void main(String [] args){
        ClockTest frame = new ClockTest();

        frame.setTitle("DisplayClock");
        frame.setSize(300, 350);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}


