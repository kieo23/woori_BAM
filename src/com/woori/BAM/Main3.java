package com.woori.BAM;
import java.util.Scanner;
public class Main3 {
	public static void main(String[] args) {
		//강사님이 해주신 파일
		//참고용으로 이해한 것 주석으로 처리
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);  //스캐너 선언
       
		int id = 1; //번글 변수 생성
		//이곳까지 1회실행후 while 반복문 시작
		
		
		while (true) { //무한 반복문 시작
			System.out.printf("명령어) "); 
			String cmd = sc.nextLine().trim(); 
			//trim == 문자열 사이 좌우 공백제거 
			//칸의 내용은 존재하지만 null 값은 아님
			
			if (cmd.equals("exit")) { //반복문 빠져나가는 방법
				break;
			} 
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요");
				continue; //아래 if문을 건너뛰고 다시 처음문단부터 실행
			}
			
			if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다");
				//게시글 확인 절차
			} else if(cmd.equals("article write")){
				
				
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim(); 
				//공백없이 제목 입력방법
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim(); 
				System.out.println(id +"번글이 생성되었습니다");
				id++;
				//while문 밖의 지역변수의 id값을 불러와 1씩 더해줌
			}else {
				System.out.println("존재하지 않는 명령어 입니다");
				//모든 if문이 false처리가 된다면 else 문장 실행
			}
		}
		
		sc.close();
		System.out.println("== 프로그램 종료 ==");
		//종료 메세지후 자바 출력 끝냄
	}

}