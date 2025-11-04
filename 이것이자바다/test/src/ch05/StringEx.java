package ch05;

import java.util.Arrays;

public class StringEx {

	public static void main(String[] args) {
		String name1 = "ann";
		String name2 = "ann";
		String name3 = new String("ann");
		System.out.println(name1 == name2);
		System.out.println(name1 == name3);
		
		String msg = "안녕하세요, ann입니다";
		
		// 문자열 추출
		System.out.println(msg.charAt(0));
		
		// 문자열 길이
		System.out.println(msg.length());
		
		// 문자열 대체
		System.out.println(msg.replace('안', '강'));
		System.out.println(msg.replace("하세요", "!"));
		
		// 문자열 잘라내기
		System.out.println(msg.substring(0,5));
		
		// 특정 문자열 위치 찾기
		System.out.println(msg.indexOf("ann")); 
		System.out.println(msg.indexOf("ANN"));
		
		// 특정 단어로 시작하는지 여부
		System.out.println(msg.startsWith("안녕"));
		
		// 특전 문자로 쪼개기
		String[] m = msg.split(",");
		System.out.println(m);		// 해시 코드로 저장된 메모리 주소 값
		System.out.println(m[1]);
		System.out.println(Arrays.toString(m));
		
		// 공백 제거하기
		String address = "	서울시      마포구   막삼동 1231";
		System.out.println(address);
		System.out.println(address.strip()); 	// 양쪽 공백 제거
		System.out.println(address.replace(" ", "")); 	// 모든 공백 제거 - 탭은 제거 X
		System.out.println(address.replace(" ", "").replace("\t", "")); 	// 모든 공백 제거 - 탭은 제거 X
		
		
		
		
		// 퀴즈
		// 파일 업로드 시
		// 1. 파일명 중복
		// 2. 한글 파일명
		// -> 파일 명을 임의의 값으로 변경 후 저장
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		String filename = "1012.내사진.jpg"; 
//		String filename2 = filename.replace("내사진", String.valueOf(System.currentTimeMillis()));
		String filename2 = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
		System.out.println(filename2);
		
		
		
	}

}
