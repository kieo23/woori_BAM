package com.woori.BAM;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main3 {
	public static void main(String[] args) {
		//강사님이 해주신 파일
		//참고용으로 이해한 것 주석으로 처리
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);  //스캐너 선언
       
		//클래스 리모컨 = (생성자)new 객체;
		
		int id = 1; //번글 변수 생성
		//이곳까지 1회실행후 while 반복문 시작
		List<Article> articles = new ArrayList<>();//뒷 <>는 생략가능
//		List<Article> articles = new ArrayList<Article>();
		
		
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
				
//				Article article = new Article(); // 최적화 사용 안함 일때
				Article article = new Article(id,title,body); //인자를 통해 생성자 호출 
//				article.title = title;  
//				article.body = body;    
//				article.id = id;		
				
				articles.add(article); //List구조인 ArrayList 객체인 articles에 저장
				//Article 타입으로 선언하여 article 리모컨이 들어간다
				
				// 최적화 2
//				articles.add(new Article(id,title,body)); //두줄을 합쳐서 사용하는법
				
				System.out.println(id +"번글이 생성되었습니다");
				id++;
				//while문 밖의 지역변수의 id값을 불러와 1씩 더해줌
				
			} else if (cmd.equals("test")) {
				for(int i = 0; i < articles.size(); i++) {
					System.out.println(articles.get(i).id);
					System.out.println(articles.get(i).title);
					System.out.println(articles.get(i).body);
					//get(i)로 ArrayList의 배열 번호속 정보를 끄집어낸다.
					//get(1)일시 article 각가 3가지의 정보가 1이란 이름으로 등록된다.
				}
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
class Article {
	int id; //번호
	String title; //제목
	String body;  //내용
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}