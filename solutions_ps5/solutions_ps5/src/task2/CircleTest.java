package task2;
import java.awt.*;
import javax.swing.*;

public class CircleTest extends JFrame{

    public CircleTest(){
        NewCircle  circle = new NewCircle();
        add(circle);
    }

    public static void main(String [] args){
    	CircleTest frame = new CircleTest();
        frame.setTitle("Circle Test");
        frame.setSize(300, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


