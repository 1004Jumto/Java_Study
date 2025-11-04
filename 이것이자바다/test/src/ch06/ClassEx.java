package ch06;

public class ClassEx {

	// 필드 선언
	int fieldName;

	// 메소드 선언
	int test() {
		return 0;
	}

	// 생성자
	public ClassEx() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		ClassEx ex = new ClassEx(); // 생성자 호출
		Car car = new Car();
		
		System.out.println(car.start);
		System.out.println(car.speed);
		System.out.println(car.model);
		
		Car car2 = new Car("그랑콜레오스", "르노");
		System.out.println(car2.company);
		System.out.println(car2.model);
		
		int count = car2.sum(1,2,3,4,5);
		System.out.println(count);
		
		count = car2.sum(new int[] {1,2,3});
		System.out.println(count);
	}

}
