package task3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClockTest extends JFrame{
	
	
	
	StillClock clock = new StillClock();
	
	public ClockTest(){
		 
	add(clock);	
	
		Timer timer = new Timer(1000,new ActionListener(){ 
				public void actionPerformed(ActionEvent e) {
					clock.setCurrentTime();	
				}
		    
		    });
		
		timer.start();
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


