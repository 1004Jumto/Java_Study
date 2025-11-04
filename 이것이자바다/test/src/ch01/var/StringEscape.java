package ch01.var;

public class StringEscape {

	public static void main(String[] args) {
		String str = "나는 \"자바\"를 배웁니다";
		System.out.println(str);
		
		str = "번호 \t 이름 \t 직업";
		System.out.println(str);
		
		System.out.println("나는 \n");
		System.out.print("자바를 \n");
		System.out.println("배웁니다. \n");
		
		str = """
			  \t\"스트링 블록 입니다.\"\n
			  여기엔 길게 글을 쓸 수 있나봅니다.
			  """;
		System.out.println(str);
	} 
}
