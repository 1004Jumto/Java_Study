package ch01.var;

public class Variable {

	public static void main(String[] args) {
		int age;		// 정수형 변수 선언(초기화x)
//		System.out.println(age);	// (에러 발생!) 변수 초기화 없이 사용 불가
		
		// 변수에 값 대입
		age = 10;
//		age = 3.41;		// (에러 발생!) 다른 타입 대입 불가
		
		// 선언과 대입 동시에 진행(초기화)
		int height = 170;
		 
		// 변수명은 변수가 갖는 값을 알 수 있는 네이밍
		int a = 30; // 나이를 a로 하는 건 부적절
		
		// 여러 의미를 갖는 경우
		int studentage = 10;
		int studentAge = 10;	// camel 표기법
		int student_age = 10; 	// snake 표기법
		int iStudentAge = 10; 	// 변수명 앞에 변수 타입 추론가능한 문자 더해서 네이밍
		
		String companyEmployeeName = "홍길동"; 	// 변수명이 길더라도 이렇게 하는게 나음
	
		byte x = 1;
		byte y = 2;
//		byte z = x + y;	// (에러 발생!) type mismatch: cannot convert from int to byte
						// 연산이 일어나는 순간 int로 변경됨
		
		// 문자형
		char c = 'A';	// 홑따옴표로 하나의 문자만.
		char g = 'A' + 1;
		int f = c + 1;
		System.out.println(f);
		System.out.println(g);
		
//		float h = 3.14; 	// (에러 발생!) double로 인식됨
		double d = 3.14;
		float k = 3.14f;	// 값 뒤에 f로 명시
		float k2= 3.14F;
		System.out.println(k);
		System.out.println(k2);
		
		// int 의 범위  약 21억
		int i2 = 210000000;
//		int i2 = 2100000000; 	// (에러 발생!) 210억은 범위를 넘음
		long ll = 2100000000L;
		
		int i = 1;
		long l = i;	// int는 long으로 변환시킬 수 있음
					// 외에도 short -> long, short -> int는 가능함
					// 즉 작은 크기의 형에서 큰 타입으로 변환 가능
		
		/* 크기 비교: int < long < double */
		
		// 문자열
		String n = "A";
		String n2 = "";		// 빈 문자열
		String n3 = " ";	// 공백 문자열
		String n4 = null;	// 값이 존재하지 않음
		
		
		String n10 = "ice";
		String n11 = "ice";
		System.out.println(n10 == n11); 	// true 출력
		
		String n20 = new String("ice");
		String n21 = new String("ice");
		System.out.println(n10 == n11); 	// false 출력
		// 참조 자료형은 주소로 비교하기 때문
		System.out.println(n20.equals(n21));
		
		
		// 강제 타입 변환
		int value = 10;
		byte b = (byte) value;
		System.out.println(b);
		
		value = 10002345;
		b = (byte) value;
		System.out.println(b);
		
		// 문자열 연산
		String s1 = "안녕 ";
		String s2 = "잘 지내";
		String s3 = s1 + s2;
		System.out.println(s3);
 
		s3 = "3" + 1;
		System.out.println(s3);
		
		s3 = "3" + String.valueOf(1);
		System.out.println(s3);
		
		// 문자 + 숫자 연산 시 숫자가 문자로 형 변환이 일어남
		
		String s4 = "10";
		String s5 = "안녕";
		String s6 = s4 + s5;
		System.out.println(s6);
		
		int n7 = Integer.parseInt(s4);
		int n8 = 5 + n7;
		System.out.println(n8);
		
	}

}
