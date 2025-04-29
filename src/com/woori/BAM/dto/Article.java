package com.woori.BAM.dto;

public class Article {
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
	}

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