package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		/*// 최적화 => 자원 1번 사용 개선
		// System = 클래스
		// in = 변수
		// System.in = static
		// Scanner(System.in); = 생성자
		*/
		int num1 = 0;			//게시글 번호 지정
		String 제목;			//상위 지역변수로 사용
		String 내용;			//상위 지역변수로 사용
		String abc = "초기화"; //스위치문에 명령어 저장
		                       //초기값으로 재정의
		
		//if문에서 continue를 쓰면 아래 if문을 무시하고 처음문단으로 올라감
		//trim(); 공백 제거
		//원래 while문으로 해결하는것 (switch문으로 하는거 아님!!
		//문제를 풀때 쉬운부분부터 풀고 어려운건 나중에
		//여러가지 시도를 해봐야 이게 왜 안되는지 가능성을 넓혀줌
		//본래 변수는 영어를 써야하는데 읽기 쉽도록 한글로 작성
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("== 프로그램 시작 ==");
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim(); //cmd 변수 ==> 재사용하기 위해
			//trim = 공백을 제거하는 역할
			
			System.out.println(cmd);
			if (cmd.equals("article list")) {
				abc = "게시글 확인"; //게시글 확인 코드 
			}
				if (cmd.equals("article write")) {
					abc = "제목내용쓰기"; //제목내용 쓰는 코드
				}
//				if (cmd.equals("")) {
//					abc = "없음"; //공백 엔터시 사용 코드 오류남
				if (cmd.length() == 0) {
					abc = "없음"; // 글자수로 제거하는법
				} 
			switch (abc) {
		case "게시글 확인": // 게시글 확인절차
			if (num1 == 0) {
			System.out.println("게시글이 없습니다.");
			abc = "초기화";
			}
			else { // 게시글이 1개이상 존재할시
				System.out.println(num1 + "개의 게시글이 존재합니다.");
				abc ="초기화";
			}
			break;
		case "제목내용쓰기": // 제목 내용 적기
			System.out.printf("제목 : ");
				String 제목초기 = sc.nextLine();
				제목 = 제목초기; //번호 내용을 볼려면 배열 arr[]를 써야함
				System.out.printf("내용 : ");
				String 내용초기 = sc.nextLine();
				내용 = 내용초기; //지역변수에 저장하는 과정
				num1++;
				System.out.println(num1 + "번글이 생성되었습니다.");
				abc = "초기화";
				break;
		case "없음": //아무것도 입력하지 않고 [엔터키]누를시
			System.out.println("명령어를 입력해주세요");
			abc = "초기화";
			break;
		case "초기화":
			if (cmd.equals("exit")) { //exit명령 수신시 switch문 빠져나오기
				break;
			}
			else { //목록에 없는 명령어 수신시
			System.out.println("존재하지 않는 명령어");
			abc = "초기화";
			break; //break문을 안쓰면 case문을 빠져나오지 못함
			}		
		default:
			break;
				
			} // 여기까지 스위치문
			if (cmd.equals("exit")) {
				break; //무한 반복문 while끝내기
			}
		}	
	

		System.out.println("== 프로그램 종료 =="); //프로그램 종료 닫는 말
		sc.close(); //스캐너 닫기
	}
}
