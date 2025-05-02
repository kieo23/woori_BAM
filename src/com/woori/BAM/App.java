package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.woori.BAM.dto.Article;
import com.woori.BAM.util.Util;

public class App {

	// static 제거 하는 이유?
	
	private List<Article> articles; // List 타입의 articles
	private int lastArticleId; 
	// 게시글 번호, 마지막 게시글 번호 수정
	// 시작하자마자 선언 및 초기화

	// 기본 생성자, 초기화, 관례 and 가독성 증가
	App() { 
		articles = new ArrayList<>(); // 데이터의 구조 ArrayList 형태 객체가 생성
		lastArticleId = 1;
	}

	void run () {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

		
		makeTestData(); // 중요 --> static 메소드일수밖에 없는 이유
		

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}

//			int id = 0;
//			Article foundArticle = null;

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요");
				continue;
			}
			// List 메서드중 size() 이용 (Data 유무를 객체의 객수(크기)로 변환)
			if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();
				int viewCheck = 0; // 새로 생성시 0으로 시작하도록 함

				Util.getDateStr();

				Article article = new Article(lastArticleId, Util.getDateStr(), title, body, viewCheck);
				articles.add(article);

				System.out.println(lastArticleId + "번글이 생성되었습니다");
				lastArticleId++;

			} else if (cmd.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다");
					continue;

				}

				System.out.printf("번호    |     제목        |     내용      |                  날짜              |   조회수\n");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
//					System.out.printf("%d       |     %s       |     %s     |     %s, %s\n", article.id, article.title,article.body,calendar.get(article.id-1),timeMake);
					System.out.printf("%d       |     %s       |     %s     |     %s|     %d\n", article.getId(),
							article.getTitle(), article.getBody(), article.getRegDate(), article.getViewCheck());
				}
			} else if (cmd.startsWith("article detail ")) { // article detail 로 시작하니?
				
				int id = getCmdId(cmd); 
				
				// cmdId가 0으로 리턴시 처리 로직 보강
				if (id == 0) {
					continue;
				}
				
				Article foundArticle = getArticleById(id);
				

				if (foundArticle == null) {
					System.out.println(id + "번에 해당하는 게시물 없음");
					continue; // 매우매우 중요. 아래에서 NullPointException 발생 안되게 조치
				} // null값이 아니라면 아래 출력.

				foundArticle.setViewCheck(foundArticle.getViewCheck() + 1); // 조회수 1씩 증가
				System.out.println("번호 : " + foundArticle.getId());
				System.out.println("날짜 : " + foundArticle.getRegDate());
				System.out.println("제목 : " + foundArticle.getTitle());
				System.out.println("내용 : " + foundArticle.getBody());
				System.out.println("조회수 : " + foundArticle.getViewCheck());

			} else if (cmd.startsWith("article delete ")) {
				int id = getCmdId(cmd); 
				
				if (id == 0) {
					continue;
				}
				Article foundArticle = getArticleById(id);
				
				
				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
				//객체로 삭제는 되는데 인덱스로는 오류남
				articles.remove(foundArticle);
				System.out.println(foundArticle.getId()+"번 게시글을 삭제했습니다.");

				

			} else if (cmd.startsWith("article modify ")) {
				int id = getCmdId(cmd); 
				
				if (id == 0) {
					continue;
				}
				Article foundArticle = getArticleById(id);
				
				


				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
				System.out.printf("수정할 제목 : ");
				foundArticle.setTitle(sc.nextLine().trim()); // foundArticle와 article는 주소가 같도록 선언함
				System.out.printf("수정할 내용 : ");
				foundArticle.setBody(sc.nextLine().trim()); // 따라서 불러오는 값은 같음
				
				System.out.println("수정완료");
				continue;
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}

		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}

	private Article getArticleById(int id) {
		for (Article article : articles) {

			if (article.getId() == id) {
				return article; // 부른 cmdbits가 맞다면 null값을 덮어씀
			}
		}
		return null;
	}

	private int getCmdId(String cmd) {
		
		String[] cmdBits = cmd.split(" "); // 문자 쪼개기칸
		try { // Exception ㅂ라생 할 예상 코드 블럭
			int id = Integer.parseInt(cmdBits[2]);
			return id;
		} catch (NumberFormatException e) {
			// Number로 생기는 오류를 처리
			System.out.println("명령어가 올바르지 않습니다.");
			return 0;
			
	}
		
	}

	private void makeTestData() {
//	Article ar = new Article(lastArticleId++, Util.getDateStr(), "제목1", "내용2", 10);
		System.out.println("5개의 test data가 생성되었습니다.");
		
		// 10번 반복
		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleId++, Util.getDateStr(), "제목" + i, "내용" + i, i * 10));

		}

	}
}
