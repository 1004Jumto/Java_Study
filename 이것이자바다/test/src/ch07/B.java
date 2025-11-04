package ch07;

public class B extends A {
	public int a = 100;

	@Override
	public int methodA(int x) {
		return a * x;
	}
}
