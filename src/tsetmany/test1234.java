package tsetmany;

import java.util.Scanner;

// 학생 점수에 따른 등급 출력에 따라 학생 서명/점수 입력창을 만들고, 임의로 점수를 기입하여 조건문을
//사용하여 등급을 출력하시오. (단, 등급 기준 90점 이상 A, 80점 이상 B, 이하 C)

//당신은 학생의 점수를 입력받고, 해당 점수에 따라 A,B,C 등급을 나누어 출력하는 프로그램을 작성하려고 합니다.
//총 몇 명의 학생인지 먼저 입력받은 후, 학생별로 이름과 점수를 입력받고, 아래 기준에 따라 등급을 판단하여 출력하세요.

//요구사항

// 사용자에게 입력받을 학생 수를 먼저 물어봅니다.
// 입력 받은 학생 수 만큼 반복하여 학생의 이름과 점수를 입력 받습니다
// 조건문 또는 switch 문을 사용하여 점수를 기준으로 등급을 판단합니다.
// 모든 학생의 이름, 점수, 등급을 한 번에 표 형태로 출력합니다.
public class test1234 {
	public static void main(String[] args) {
		int abc = 0; //학생수 결정
		int 점수 = 0;
		int 초기값 = 0;
	Scanner sc = new Scanner(System.in);	
	System.out.println("총 학생의 수를 입력하시오.");
	abc = sc.nextInt();
	int[] humanNum = new int[abc];
	String[] name = new String[abc];
	int[] lastNum = new int[abc];
	
	for (int score = 0; score < humanNum.length; score++) {
		System.out.printf((score+1) +"번째 학생의 이름를 입력하세요. :\n");
		name[score] = sc.next();
		
		System.out.printf((score+1) +"번째 학생의 점수를 입력하세요. :\n");
		초기값 = sc.nextInt();
		lastNum[score] = 초기값;
		humanNum[score] = 초기값 / 10;
	}
	System.out.println("===================================");
	System.out.println("                 점수                      등급");
	System.out.println("90점 이상 A, 80점 이상 ~ 89점 미만 B, 그외 C");
	int same = 0;
	int first = 0;
	if (first <= abc) {
//		lastNum = humanNum[score];
		for (int i = 0; same < lastNum.length;) {
		switch (humanNum[same]) {
		case 10:
		case 9:
			System.out.printf("이름 : " + name[same] + "      점수 : "+ lastNum[same]+ " 등급 : A\n");
			same++;
			if (same < humanNum.length) {
				break;
			}
		case 8:
			System.out.printf("이름 : " + name[same] + "      점수 : "+ lastNum[same]+ " 등급 : B\n");	
			same++;
			if (same < humanNum.length) {
				break;
			}
		case 7:
		case 6:
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.printf("이름 : " + name[same] + "      점수 : "+ lastNum[same]+ " 등급 : C\n");
			same++;
			if (same < humanNum.length) {
				break;
			}
		default:
			break;
				
			
		}
		}
	}
	}
}
	
	


