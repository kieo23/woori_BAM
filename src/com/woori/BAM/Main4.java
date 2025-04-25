package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

		int lastArticleId = 1; // 게시글 번호, 마지막 게시글 번호 수정
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}
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

				Article article = new Article(lastArticleId, title, body);
				articles.add(article);

				System.out.println(lastArticleId + "번글이 생성되었습니다");
				lastArticleId++;

			} else if (cmd.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다");
					continue;

				}

				System.out.printf("번호    |     제목\n");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d      |     %s\n", article.id, article.title);
				}
			} else if (cmd.startsWith("article detail ")) { // article detail 로 시작하니?
				String[] cmdBits = cmd.split(" "); // 문자 쪼개기칸
													// (.)(,)(" ") 구분 칸을 적는다.
//				System.out.println(cmdBits[0]);
//				System.out.println(cmdBits[1]);
//				System.out.println(cmdBits[2]);

//				int checkIdNum = 0;

				int id;
				try { // Exception ㅂ라생 할 예상 코드 블럭
					id = Integer.parseInt(cmdBits[2]);
//					checkIdNum = id;

				} catch (NumberFormatException e) {
					// 그밖에 모든 Exscpion 처리한다.
					System.out.println("조회하는 게시물의 숫자가 입력되지 않음.");
					continue;
//				} finally { //밥 먹고와서 변수없이 실행하는법 찾아보기

//					System.out.println("조회 하려는 게시물의 번호를 제대로 써주세요");
				}
//				boolean articleChk = false;
				Article foundAticle = null;
				for (Article article : articles) {

					if (article.id == id) {
						foundAticle = article; // 부른 cmdbits가 맞다면 null값을 덮어씀
						break;
					}
				}

				if (foundAticle == null) {
					System.out.println(id + "번에 해당하는 게시물 없음");
					continue; // 매우매우 중요. 아래에서 NullPointException 발생 안되게 조치
				} // null값이 아니라면 아래 출력.
				System.out.println("번호 : " + foundAticle.id);
				System.out.println("날짜 : " + "랄라이");
				System.out.println("제목 : " + foundAticle.title);
				System.out.println("내용 : " + foundAticle.body);
			} else if (cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");
				int id = 0;
				Article foundAticle = null;

				id = Integer.parseInt(cmdBits[2]);
				for (Article article : articles) {
					if (article.id == id) {
						foundAticle = article;
						articles.remove(id - 1);
						System.out.println(id + "번의 게시물이 삭제되었습니다");
						System.out.println(articles.isEmpty());
						break;
					}
					if (foundAticle == null) {
						System.out.println(id + "번 게시물이 존재하지 않습니다.");
						continue;
				
					} 

				}
			} else if (cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");
				int id = 0;
				Article foundAticle = null;
				
				id = Integer.parseInt(cmdBits[2]);
				for (Article article : articles) {
					if (article.id == id) {
						foundAticle = article;
						System.out.printf("수정할 제목 : ");
						String correctionTitle = sc.nextLine();
						article.title = correctionTitle;
						System.out.print("수정할 내용 : ");
						String correctionBody = sc.nextLine();
						article.body = correctionBody;
						System.out.println("수정완료");
						break;
						
					}
				}
				if (foundAticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
			}
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}
}


class Article {
	int id;
	String title;
	String body;

	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}