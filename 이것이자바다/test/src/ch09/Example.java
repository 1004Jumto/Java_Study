package ch09;

public class Example {

	public static void main(String[] args) { 
		
		A a = new A();
		A.B b = a.new B();
		b.methodB();
		
		
		Car car = new Car();
		car.tire1.roll();
		car.run();
		// 3. 매개변수로 익명자식객체 사용
		car.run2(new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 자식 객체를 매개변수로 전달");
			}
		});
		
		
		Home h = new Home();
		h.rc.turnOn();
		h.use();
		h.use(new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("매개변수: 티비 켜기");
			}
			
			@Override
			public void turnOff() {}
		});
		
	}

}
