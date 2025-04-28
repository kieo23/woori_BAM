package com.woori.BAM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.time.LocalTime;
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
			
			int id = 0;
			Article foundArticle = null;
			
			
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
				int check = 0;

				
				Util.getDateStr();
//				LocalDateTime now = LocalDateTime.now(); //시간 설정
//				String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
//				String regDate = formatedNow;
				
				
//				Article article = new Article(lastArticleId, title, body,regDate);
				Article article = new Article(lastArticleId, check, title, body,Util.getDateStr());
				articles.add(article);
				

				System.out.println(lastArticleId + "번글이 생성되었습니다");
				lastArticleId++;

			} else if (cmd.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다");
					continue;

				}
				
				System.out.printf("번호    |     제목     |     내용     |     날짜          |      조회수\n");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
//					System.out.printf("%d       |     %s       |     %s     |     %s, %s\n", article.id, article.title,article.body,calendar.get(article.id-1),timeMake);
					System.out.printf("%d       |     %s       |     %s     |     %s     %d\n", article.id, article.title,article.body,article.regDate,article.check);
				}
			} else if (cmd.startsWith("article detail ")) { // article detail 로 시작하니?
				String[] cmdBits = cmd.split(" "); // 문자 쪼개기칸
													// (.)(,)(" ") 구분 칸을 적는다.
//				System.out.println(cmdBits[0]);
//				System.out.println(cmdBits[1]);
//				System.out.println(cmdBits[2]);

//				int checkIdNum = 0;

//				int id;
				try { // Exception ㅂ라생 할 예상 코드 블럭
					id = Integer.parseInt(cmdBits[2]);
//					checkIdNum = id;

				} catch (NumberFormatException e) {
					// Number로 생기는 오류를 처리
					System.out.println("조회하는 게시물의 숫자가 입력되지 않음.");
					continue;
				} catch (Exception e) { // 모든 예외처리 가능 혹시 몰라 써두기
					e.printStackTrace();
				}

//				boolean articleChk = false;
//				Article foundAticle = null;
				for (Article article : articles) {

					if (article.id == id) {
						foundArticle = article; // 부른 cmdbits가 맞다면 null값을 덮어씀
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번에 해당하는 게시물 없음");
					continue; // 매우매우 중요. 아래에서 NullPointException 발생 안되게 조치
				} // null값이 아니라면 아래 출력.
				
				foundArticle.check++;
				System.out.println("번호 : " + foundArticle.id);
				System.out.println("날짜 : " + foundArticle.regDate);
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.body);
				System.out.println("조회수 : " + foundArticle.check);
				
			} else if (cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");
//				int id = 0;
//				Article foundAticle = null;
				try { 
					id = Integer.parseInt(cmdBits[2]);

				} catch (NumberFormatException e) {
					System.out.println("삭제할 게시물의 숫자를 입력하세요.");
					continue;
				}catch (Exception e) { 
						e.printStackTrace();
					}
//				id = Integer.parseInt(cmdBits[2]);
				for (Article article : articles) {
					if (article.id == id) {
						articles.remove(id - 1);
						System.out.println(id + "번의 게시물이 삭제되었습니다");
//						System.out.println(articles.isEmpty());
						foundArticle = article;
						break;
					}
					}
					if (foundArticle == null) {
						System.out.println(id + "번 게시물이 존재하지 않습니다.");
						continue;
				
					} 

				
			} else if (cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");
//				int id = 0;
//				Article foundAticle = null;
				try { 
					id = Integer.parseInt(cmdBits[2]);

				} catch (NumberFormatException e) {
					System.out.println("수정 할 게시물의 숫자를 입력하세요.");
					continue;
				}catch (Exception e) { 
						e.printStackTrace();
					}
				
				for (Article article : articles) { //배열을 순서대로 돌림
					if (article.id == id) { //순서가 일치할때 해당 인덱스의 정보 수정
						foundArticle = article; //주소가 같기에 foundArticle, article 같은 주소가된다
						
//						System.out.printf("수정할 제목 : ");
//						String correctionTitle = sc.nextLine().trim();
//						foundArticle.title = correctionTitle; //두가지 모두 주소가 같기에 상관없다
//						System.out.print("수정할 내용 : ");
//						String correctionBody = sc.nextLine().trim();
//						article.body = correctionBody;
						
						System.out.printf("수정할 제목 : ");
						foundArticle.title = sc.nextLine().trim();  //foundArticle와 article는 주소가 같도록 선언함
						System.out.printf("수정할 내용 : ");
						article.body = sc.nextLine().trim();  // 따라서 불러오는 값은 같음
						
						
						
						System.out.println("수정완료");
						break;
						
					}
				}
				if (foundArticle == null) {
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
	String regDate;
	int check;

	public Article(int id, int check,String title, String body, String regDate) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.check = check;
	}
}
