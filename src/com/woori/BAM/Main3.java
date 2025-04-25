package com.woori.BAM;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		// 강사님이 해주신 파일
		// 참고용으로 이해한 것 주석으로 처리
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in); // 스캐너 선언
		LocalDate now = LocalDate.now(); //날짜개념 부름
		LocalTime niw = LocalTime.now(); //시간개념 부름

		// 클래스 리모컨 = (생성자)new 객체;

		int id = 1; // 번글 변수 생성
		// 이곳까지 1회실행후 while 반복문 시작
		List<Article> articles = new ArrayList<>();// 뒷 <>는 생략가능
//		List<Article> articles = new ArrayList<Article>();
//		Number number = new Number();

		while (true) { // 무한 반복문 시작
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();
			// trim == 문자열 사이 좌우 공백제거
			// 칸의 내용은 존재하지만 null 값은 아님

			if (cmd.equals("exit")) { // 반복문 빠져나가는 방법
				break;
			}
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요");
				continue; // 아래 if문을 건너뛰고 다시 처음문단부터 실행
			}

			if (cmd.equals("article list")) {
//				if (id >= 2) {
				if (articles.size() >= 1) {
					// 번호 및 제목을 불러와야함
					// 그런데 제목은 article에 저장되어 있음

					// 인덱스의 제한이 필요함
//					System.out.println("번호     |     제목");
//					for (int num1 = 1; num1 <= articles.size(); num1++) {
//					System.out.print(articles.get(num1-1).id + "        |");
//					System.out.printf("     " + articles.get(num1-1).title + "\n");	
//					//size를 비교하는거라 1,2,3 이런식으로 되어있음
//					//[]인덱스는 0,1,2식으로 구성되기에 -1로 숫자를 맞춰줘야함
//					}
//					continue;
					// 첫 번째 방법이나 최적화가 안되어 있음

					// 배열 사용해서 get() 사용 ==> 객체를 리턴(불러오기) 받음
					System.out.printf("번호     |    제목\n");
					for (int i = articles.size() -1 ; i>= 0; i--) {
						//현재 역방향 출력으로 되어 있음
						//정방향 for (int i = 0; i < article.size(); i++)
						Article article = articles.get(i);
						
						// aritcle은 article.get() 을 통해 받은 객체를 재사용하기위해
						
						System.out.printf("%d        |    %s\n", article.id, article.title);
						//article = articles.get(i)로 인덱스 값에 따라 새로 선언된 리모컨
						//article.id등으로 클래스내의 변수를 가져온다
					}
					continue;
					
				}
				else if (articles.size() == 0) {
					// 게시글이 1개이상 존재하면 x 2 1
					System.out.println("존재하는 게시글이 없습니다");
					// 게시글 확인 절차
					continue;
				}
			}
			if (cmd.startsWith("article detail ")) { //article detail 로 시작하니
				if (articles.size() < 1 ) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n",id);
					String[] cmdBits = cmd.split(" "); //문자 쪼개기 / 쪼갤단위 집어넣기 (,) (" ") (":")
													   // Data 전
					System.out.println(cmdBits[0]);
					System.out.println(cmdBits[1]);
					System.out.println(cmdBits[2]);
					continue;
					
			} else if (articles.size() >= 1) {
				System.out.printf("번호 : %d\n",id);
				System.out.println("날짜 :" + now);
				System.out.println("제목 : " + articles.get(id).title);
				System.out.println("내용 : " + articles.get(id).body);
				
//				Article article = articles.get(여기에 입력한 번호);
//				System.out.printf("번호 : %d",Article.class);
			}	
			}
				//1번 인수를 간변적으로 하여서  숫자가 들어오면 반응하게 해야함.

				if (cmd.equals("article write")) {

					System.out.printf("제목 : ");
					String title = sc.nextLine().trim();
					// 공백없이 제목 입력방법
					System.out.printf("내용 : ");
					String body = sc.nextLine().trim();

					Article article = new Article(id, title, body); // 인자를 통해 생성자 호출
					// Article 타입으로 선언하여 article 리모컨이 들어간다
					// 객체로 값을 옮기는 과정
					// 객체 new Article(int, String, String)으로 선언되면
					// new 새로운 객체를 다시 선언할때 똑같은 행위가 있어야한다

					// 최적화 2
//				articles.add(new Article(id,title,body)); //두줄을 합쳐서 사용하는법
//				Article adc = new Article(); //선언 불가 객체타입이 틀리다.

					// 기존 방법
//				Article article = new Article(); // 최적화 사용 안함 일때
//				article.title = title;  
//				article.body = body;    
//				article.id = id;	
					
					articles.add(article); // List구조인 ArrayList 객체인 articles에 저장
					// 그당시 가지고 있던 값을 저장한다.

					System.out.println(id + "번글이 생성되었습니다");
					id++;
					// while문 밖의 지역변수의 id값을 불러와 1씩 더해줌
				}
//			} else if (cmd.equals("test")) {
//				for (int i = 0; i < articles.size(); i++) {
//					System.out.println(articles.get(i).id);
//					System.out.println(articles.get(i).title);
//					System.out.println(articles.get(i).body);
//					// get(i)로 ArrayList의 배열 번호속 정보를 끄집어낸다.
//					// get(1)일시 article 각가 3가지의 정보가 1이란 이름으로 등록된다.
//					// get(i)로 그 번호대의 article를 호출하여 .접근 메소드로 그 정보를
//					// 꺼내온다
//				}
//			}
				else {
					System.out.println("존재하지 않는 명령어 입니다");
					// 모든 if문이 false처리가 된다면 else 문장 실행
				}
		}
			sc.close();
			System.out.println("== 프로그램 종료 ==");
			// 종료 메세지후 자바 출력 끝냄

	}
}

class Article {
	int id; // 번호
	String title; // 제목
	String body; // 내용

	public Article(int id, String title, String body) {
		// 객체를 선언하면서 그곳에 있던 값을 받아옴
		// 객체 선언에 값을 입력하였기에 기존 Article();으로 선언이 안된다.
		this.id = id; // 객체에 가져온 값을 저장한다.
		this.title = title;
		this.body = body;
	}
}
class Number {
	int id;
	public Number(int i) {
		
	}
}