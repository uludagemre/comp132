package task1;

import javax.swing.*;
import java.awt.*;

public class TestPaintComponent extends JFrame {
   public TestPaintComponent() {
      add(new NewPanel());
   }

   public static void main(String[] args) {
      TestPaintComponent frame = new TestPaintComponent();
      frame.setTitle("TestPaintComponent");
      frame.setSize(600, 400);
      frame.setLocationRelativeTo(null); // Center the frame
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}


