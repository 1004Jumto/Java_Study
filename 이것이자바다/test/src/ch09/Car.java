package ch09;

public class Car {
	// 1. 필드에 익명자식객체 대입
	Tire tire1 = new Tire() {
		@Override
		public void roll() {
			System.out.println("tire1 굴러간다");
		};
	};
	
	// 2. 로컬변수(메소드 안 변수)에 익명자식객체 대입
	public void run() {
		Tire tire2 = new Tire() {
			@Override
			public void roll() {
				System.out.println("tire2 굴러간다");
			}
		};
		tire2.roll();
	}
	
	// 3. 매개변수 이용
	public void run2(Tire tire) {
		tire.roll();
	}
}
