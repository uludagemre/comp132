
public class App {

	public static void main(String[] args) {
	
		Vehicle v1 = new Vehicle();
		
		Car car1 = new Car();
		
		Vehicle v2 = v1; // fine. reference v2 points to v1 
		// two references for the same Vehicle object.
		v2.moving();
		
		// Polymorphism: Many forms
		// object of a subclass can be treated as an object of its superclass
		// (but reverse is not true)
		// Example below: Vehicle reference v3 points (refers) to a Car object car1
		// type of the reference matters. For reference v3:
		// Apparent type: Vehicle,     Actual type: Car
		// Apparent type: Declared type (fixed). Type checking is based on Apparent type.
		// Actual type: The type of the object we refer to. May change at runtime.
		
		Vehicle v3 = car1;      // upcasting (from subclass: Car to superclass: Vehicle)

		// see the effect before/after moving() method is overridden in subclass Car.
		v3.moving();
				
		car1.speedrange(); // this works.

		// Type checking is based on Apparent type
		// v3's Apparent type is Vehicle.
		// the following won't compile.
		// v3.speedrange(); // doesn't work! Class Vehicle has no speedrange() method.
		
		// downcasting (v3 to type Car) (from superclass: Vehicle to subclass: Car)
		System.out.println("\nWith downcasting:");
		((Car)v3).speedrange();  // now works! (with downcasting)

		System.out.println();
		
		// Polymorphism guarantees that:
		// where a superclass is expected, we can use a subclass of the superclass.
		// We can create an array of superclass variables (references) that can refer to 
		// objects of many different subclass types.
		
		Vehicle[] vehicles = new Vehicle[3];

		// superclass references at subclass objects
		vehicles[0] = new Car();
		vehicles[1] = new Bicycle();
		vehicles[2] = new Bus();

		for (int i = 0; i < vehicles.length; i++) {
			System.out.println("TestPoly method call-" + (i+1) + " ...................................");
			TestPoly(vehicles[i]);
		}
	}

	// a method to demonstrate polymorphic behavior 
	public static void TestPoly(Vehicle v) {
		
		// calling overridden method moving() with general reference v
		v.moving();

		// every object in Java knows its own type at execution time
		// getClass() method of Object returns info about the object's type
		System.out.println("getClass returns type at runtime: " + v.getClass() + "\n");
	}
	
}
