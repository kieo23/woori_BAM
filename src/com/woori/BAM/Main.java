package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 최적화 => 자원 1번 사용 개선
		Scanner sc = new Scanner(System.in);
		System.out.println("== 프로그램 시작 ==");
		while (true) {

			// System = 클래스
			// in = 변수
			// System.in = static
			// Scanner(System.in); = 생성자
			System.out.printf("cmd) ");
			String cmd = sc.nextLine(); //cmd 변수 ==> 재사용하기 위해
//			System.out.println(cmd);
			if (cmd.equals("exit")) {
				break;
			}
		}

		System.out.println("== 프로그램 종료 ==");
		sc.close();
	}
}
