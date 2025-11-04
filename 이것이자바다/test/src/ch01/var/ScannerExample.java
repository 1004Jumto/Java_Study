package ch01.var;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		
		Scanner inputNum =new Scanner(System.in);

		System.out.println("점수를 입력하세요");
		int score =inputNum.nextInt();

		System.out.println("이름을 입력하세요");
		String str =inputNum.nextLine();
//		String str =inputNum.next(); 

		System.out.println("당신의 점수:" + score);
		System.out.println("당신의 이름:" + str);

	}
}

