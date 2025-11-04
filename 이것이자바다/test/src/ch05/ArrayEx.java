package ch05;

import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
		String[] a2;
		ArrayEx[] a3;

		int[] arr2 = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(arr2));

		int[] arr3 = { 1, 2, 3, 4, 5 };
		int[] arr4 = { 1, 2, 3, 4, 5 };
		System.out.println(arr3 == arr4); // 배열 변수를 비교할 때는 주소값을 비교하므로 false 출력

		int[] arr5 = arr3;
		System.out.println(arr3 == arr5); // true 출력

		arr3[0] = 10;
		System.out.println(Arrays.toString(arr5)); // [10, 2, 3, 4, 5] 출력됨
		System.out.println(Arrays.toString(arr4)); // [1, 2, 3, 4, 5] 출력됨

		// 참조자료형과 기본자료형의 차이
		int x = 10;
		int y = x;
		y = 20;
		System.out.println(x); // 10 출력
		System.out.println(y); // 20 출력

		// out of Bound 에러
		String[] arr = { "하나", "둘", "셋" };
		System.out.println(arr.length);
		System.out.println(arr[0]);
//		System.out.println(arr[3]);

		// 배열 순회
		int[] scores = { 85, 90, 85 };
		int total = 0, total2 = 0;
		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		System.out.println(total);

		for (int score : scores) {
			total2 += score;
		}
		System.out.println(total2);

		System.out.println(Arrays.toString(scores));
		scores = new int[] { 80, 90, 87 }; // 새로운 배열 생성-> 새로운 주소를 가진 배열
		System.out.println(Arrays.toString(scores));

		// 값을 미리 지정하지 않는 경우
		int[] scores2 = new int[10]; // int 배열은 0으로 초기화됨
		// 기본자료형은 0, 참조자료형은 null로 초기화됨
		int a;
		System.out.println(a = 1);

	
		
		// 2차원 배열
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(Arrays.toString(matrix));
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(matrix[0][0]);
		System.out.println(matrix.length);

		int[] vector = matrix[0];
		System.out.println(Arrays.toString(vector));

		vector[0] = 10;
		System.out.println(Arrays.toString(matrix[0]));

		
		// 배열 복사
		int[] newScores = new int[3];
		System.arraycopy(scores, 0, newScores, 1, 2);
		System.out.println(Arrays.toString(newScores));
		
		
		int in1 = Integer.parseInt(args[0]);
		int in2 = Integer.parseInt(args[1]);
		System.out.println(in1 + in2);
		
		
		
		
		
		
	}

}
