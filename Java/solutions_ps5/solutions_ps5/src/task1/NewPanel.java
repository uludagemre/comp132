package task1;

import java.awt.*;
import javax.swing.*;

class NewPanel extends JPanel {
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawLine(20, 0, 20, 60);
      g.drawString("This is the end of the line.", 20, 60);
   }
}