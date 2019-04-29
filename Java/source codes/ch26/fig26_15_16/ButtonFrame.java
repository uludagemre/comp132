// Fig. 26.15: ButtonFrame.java
// Command buttons and action events.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame 
{
   private final JLabel gameWelcome; // button with just text
//   private final JButton playGameButton; // button with icons
   private JLabel jLabelOne = new JLabel();
   private JLabel jLabelTwo = new JLabel();
   private JPanel panel = new JPanel();
   private BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

   // ButtonFrame adds JButtons to JFrame
   public ButtonFrame("Emre")
   {
      super("Testing Buttons");
      setLayout(boxLayout); 
      jLabelOne.setAlignmentX(CENTER_ALIGNMENT);
      jLabelTwo.setAlignmentX(CENTER_ALIGNMENT);

      jLabelOne.setText("This is text one");
      jLabelTwo.setText("This is text two");

      panel.add(jLabelOne);
      panel.add(jLabelTwo);

      panel.setAlignmentX(CENTER_ALIGNMENT);
      add(panel);
      setSize(300, 300);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }

   // inner class for button event handling
   private class ButtonHandler implements ActionListener 
   {
      // handle button event
      @Override
      public void actionPerformed(ActionEvent event)
      {
         JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
            "You pressed: %s", event.getActionCommand()));
      }
   } 
} // end class ButtonFrame

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
