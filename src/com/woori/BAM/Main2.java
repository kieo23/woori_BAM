package com.woori.BAM;

public class Main2 {
	public static void main(String[] args) {
// 메인 메서드 안에 존재하는 것이기 때문에 둘의 주소는 같다.
		String a = "asd";
		String b = "asd";

		System.out.println(a == b); // 주소가 같은가?
		System.out.println(a.equals(b)); // a.b 가진 값이 같은가?
//		System.out.println(a == "asd");
		
		
		System.out.println("---------------------");
		a.equals("asd");
		boolean e;
		String c = new String("asd"); //생성자가 다르기 때문에
		String d = new String("asd");
		System.out.println(c == d); // 주소가 같은가?
		System.out.println(e = c.equals(d)); // a.b 가진 값이 같은가?
		if (e == true) {
		System.out.println("맞다");	
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
