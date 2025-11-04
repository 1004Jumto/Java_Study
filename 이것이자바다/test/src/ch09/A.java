package ch09;

public class A {

	// 인스턴스 멤버 클래스 - A가 생성되어야 B도 만들 수 있음
	// public: 다른 패키지 사용 가능, private: A안에서만 사용 가능
	class B {
		int b = 10;

		void methodB() {
			System.out.println("class B method");
		};
	}

	// 정적 멤버 클래스 - A 없이도 B 만들 수 있음
	static class C {
		int c = 20;

		void methodC() {
			System.out.println("class C method");
		};
	}

	// 로컬 클래스 - 생성자 또는 메소드 내부에서 선언된 클래스
	// 로컬 클래스는 메소드나 생성자가 실행될 동안에만 객체 생성 가능
	public A() {
		class C {
			C() {
				System.out.println("class C in Constructor");
			}
		}

		C c = new C();
	}

	void methodA() {
		class C {
			C() {
				System.out.println("class C in methodA");
			}
		}
		C c = new C();
	}
	// 로컬 변수를 로컬 클래스 내에서 수정할 수는 없음

	class D {
		void methodD() {
			A.this.methodA(); // 바깥 클래스 객체 접근
		}

	}

}
