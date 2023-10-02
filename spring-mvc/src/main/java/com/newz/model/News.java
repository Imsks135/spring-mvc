package com.newz.model;

import java.time.LocalDateTime;

public class News {

	private int newsId;
	private String newsTitle;
	private String author;
	private String description;
	private String content;
	private LocalDateTime dateTimeStamp;

	public News() {
	}

	public News(int newsId, String newsTitle, String author, String description, String content,
			LocalDateTime dateTimeStamp) {
		super();
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.author = author;
		this.description = description;
		this.content = content;
		this.dateTimeStamp = dateTimeStamp;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDateTimeStamp() {
		return dateTimeStamp;
	}

	public void setDateTimeStamp(LocalDateTime dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", author=" + author + ", description="
				+ description + ", content=" + content + ", dateTimeStamp=" + dateTimeStamp + "]";
	}

}
