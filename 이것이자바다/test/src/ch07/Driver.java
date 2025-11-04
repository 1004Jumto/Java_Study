package ch07;

public class Driver {
	public Vehicle car;
	
	public void start() {
		car.run();
	}
	
	public void drive(Vehicle v) {
		v.run();
	}
}
