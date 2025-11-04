package ch12.sec08.exam01;

import java.sql.Date;

public class EqualsExample {
	
	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		Member m3 = new Member("red");
		
		if(m1.equals(m2)) System.out.println("m1 m2 동등");
		else System.out.println("m1 m2 동등X");
		
		if(m1.equals(m3)) System.out.println("m1 m3 동등");
		else System.out.println("m1 m3 동등X");
		
		System.out.println(m2.hashCode());
		System.out.println(m2);
		System.out.println(m1.toString());
		 
	}
}
