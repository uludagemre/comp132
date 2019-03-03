// Polymorphism concepts example 

public class Car extends Vehicle {

	
	public Car() {
		System.out.println("Car constructor \n");
	}

	@Override
	public void moving() {
		System.out.println("Car moves: 90km/h");
	}

	public void speedrange() {
		System.out.println("Car's speed range: 60 to 120km/h");
	}

}
