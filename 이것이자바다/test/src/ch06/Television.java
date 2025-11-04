package ch06;

public class Television {
	
	// 상수 
	static final String CLASS_NAME = "Television";
	
	// 정적 필드
	static String company = "My Com";
	static String model = "LCD";
	static String info;
	static Double sale;
	
	static {
		info = company  + " : " + model; 
		
		Television t = new Television();
		sale = t.price * 0.8;
	}
	
	// 인스턴스 필드
	int price = 100;
	final int number;	
	
	
	// 접근제한자
	private int iSpeed;
	private boolean stop;
	
	public int getSpeed() {
		return iSpeed;
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setSpeed(int speed) {
		if(speed < 0) this.iSpeed = 0;
		else this.iSpeed = speed;
	}
	
	public Television() {
		this.number = 1;  
	}
}
