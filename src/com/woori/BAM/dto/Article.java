package com.woori.BAM.dto;

public class Article { //공개된 클래스의 세부 내용은 비공개로 처리한다
	private int id;
	private String title;
	private String body;
	private String regDate;
	private int viewCheck;

	public Article(int id, String regDate, String title, String body, int viewCheck) {
		this.setId(id);
		this.setTitle(title);
		this.setBody(body);
		this.setRegDate(regDate);
		this.setViewCheck(viewCheck);
		//비공개된 내용은 Setter, Getter로 바꾼다
	}
	// get은 값을 가져오는 행위
	// return 으로 값을 private 에 있는 값에 저장하게 해준다
	
	// set은 이미 들어있는 값을 수정하는 행위
	// App의 modify 수정하는 곳에서 사용되며 말 그대로 "설정"하는 기능
	public int getId() { 
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCheck() {
		return viewCheck;
	}

	public void setViewCheck(int viewCheck) {
		this.viewCheck = viewCheck;
	}
}