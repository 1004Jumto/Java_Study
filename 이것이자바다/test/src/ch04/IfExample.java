package ch04;

import java.util.Scanner;

public class IfExample {

	public static void main(String[] args) {

		int score = 90;

		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}

		// 무작위 번호 생성
		double number = Math.random() * 6; // 0.0 ~ 6.0 사이 실수값
		System.out.println(number);

		int num = (int) (Math.random() * 6); // 0~6 사이 정수값
		System.out.println(num);

		switch (num) {
		case 1:
			System.out.println("1");
			break;

		case 2:
			System.out.println("2");
			break;

		case 3:
			System.out.println("3");
			break;

		case 4:
			System.out.println("4");
			break;

		case 5:
			System.out.println("5");
			break;

		case 6:
			System.out.println("6");
			break;

		default:
			System.out.println("??");

		}

		switch (num) {
		case 1, 2 -> {
			System.out.println("1 or 2");
		}
		default -> {
			System.out.println("0,3,4,5,6 중 하나임");
		}
		}

		// 반복문
		for (int i = 1; i < 10; i *= 2) {
			System.out.println(i);
		}

		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int speed = 0;

		while (run) {
			System.out.println("------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("------------------");
			System.out.println("선택: ");

			String snum = scanner.nextLine();

			if (snum.equals("1")) {
				speed++;
				System.out.println("speed = " + speed);
			} else if (snum.equals("2")) {
				speed--;
				System.out.println("speed = " + speed);
			} else if (snum.equals("3")) {
				run = false;
			}

		}
		
		System.out.println("종료");
		
		
		
		Master: for(char c = 'A'; c <= 'Z'; c++) {
			for(char cc = 'a'; cc <= 'z'; cc++) {
				System.out.println(c + '-' + cc);
				
				if(cc == 'e') break Master;
			}
			System.out.println("END");
		}
		
		
		// 3의 배수 총합
		
		int result = 0;
		for(int i = 1, j = 3; i*j <= 100; i++) {
			result += (j*i);
		}
		System.out.println(result);
		
		
		
		String name1 = "ann";
		String name2 = "ann";
		String name3 = new String("ann");
		System.out.println(name1 == name2);
		System.out.println(name1 == name3);
	}
}
