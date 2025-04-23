package com.woori.BAM;

import java.util.Scanner;

public class SwtichtestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("학생 이름 : ");
		int i = 5;
		String E = null;
//		String[] arr = new String[i]; 
		String[] name = new String[i];
//		String name = sc.nextLine();
		for (int a = 0; a < name.length; a++) {
			
			name[a] = sc.nextLine();
			E += name[a];
			
		}
		System.out.println(E);
//
//		System.out.println("점수 : ");
//		int score = sc.nextInt();
//
//		String grade;
//
//		switch (score / 10) {
//		case 10:
//		case 9:
//			grade = "A";
//			break;
//		case 8:
//			grade = "B";
//			break;
//		case 7:
//			grade = "C";
//			break;
//		case 6:
//			grade = "D";
//			break;
//		default:
//			grade = "f";
//			break;
//			
//		}
//System.out.println(grade);
	}
}
