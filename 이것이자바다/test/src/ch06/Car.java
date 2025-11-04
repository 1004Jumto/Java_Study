package ch06;

public class Car {
	
	String company = "Renault";
	String model;
	String color;
	int maxSpeed;

	int speed;
	int rpm;
	boolean start;

	Car() {
	}

	Car(String model) {
		this(model, "은색", 250);
	}

	Car(String model, String color) {
		this(model, color, 250);
	}

	// 공통 초기화 코드
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	int sum(int... values) {
		int sum = 0;

		for (int i : values) {
			sum += i;
		}
		 
		return sum;
	} 
}
