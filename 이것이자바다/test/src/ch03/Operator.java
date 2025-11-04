package ch03;

public class Operator {

	public static void main(String[] args) {
		int x = 1;
		System.out.println(x);
		
		int y = ++x;	// 전위 연산
		System.out.println(y);		// 2 출력
		
		int z = y++;	// 후위 연산
		System.out.println(z);		// 2 출력
		System.out.println(y);		// 3 출력
		
		int kor = 90;
		int eng = 80;
		int math = 80;
		
		int total = kor + eng + math;
		
//		double avg = total / 3;		// (주의점!) 만일 실제 평균이 83.3333이라 해도, avg는 83.0 이 됨
//		System.out.println(avg);
		// 즉 적어도 연산중 하나는 실수이어야함
		double avg = (double)total / 3;
		System.out.println(avg);
		
		
		int apple = 1;
		double unit = 0.1;
		int num = 7;
		
		double res = apple - num * unit;
		System.out.println(res);
		
		
		// 대입연산
		int c = 10;
		System.out.println(c+=5);
		
		//삼항 연산
		int score = 90;
		String result = score >= 60 ? "합격" : "불합";
		System.out.println(result);
		
		char grade = score >= 90 ? 'A' : score >= 80 ? 'B' : 'C';
		System.out.println(grade);
		
		
		int pen = 534;
		int student = 30;
		int penPerStudent = pen / student;
		System.out.println(penPerStudent);
		int left = pen % student;
		System.out.println(left);
		
	}

}
