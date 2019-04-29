import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;



public class CarTest extends JFrame{
	
	Timer timer = new Timer(100,new ActionListener(){ 
		public void actionPerformed(ActionEvent e) {
			car.move();
		}
		
	});

	
	Car car = new Car();

	public CarTest(){
		add(car);	
		timer.start();
	}

	

	

	public static void main(String [] args){
		CarTest frame = new CarTest();

		frame.setTitle("DisplayClock");
		frame.setSize(300, 350);

		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}



