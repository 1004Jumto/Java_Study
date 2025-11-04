package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		String s = "가나다/라마바/사아자/차카아!타파하";
		StringTokenizer st = new StringTokenizer(s, "/|!");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
