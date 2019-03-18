package task2;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class NewCircle extends JPanel {
    
	private int hour;
    private int minute;
    private int second;

    public NewCircle() {
        System.out.println("Creating Circle");
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int circleRadius = (int) (Math.min(getWidth(), getHeight()) * 0.3 );
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        
        // Draw circle
        g.setColor(Color.BLACK);
        int x = xCenter - circleRadius;
        int y = yCenter - circleRadius;
        int width = 2 * circleRadius;
        int height = 2 * circleRadius;
        g.drawOval(x,y,width,height);
        
        
    }
    
//    public Dimension getPreferredSize() {
//    	return new Dimension(200,200);   
//    }

}