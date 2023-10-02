package com.newz.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.newz.model.News;

@Component
public class NewsRepository {

	private static List<News> newsList;

	public NewsRepository() {
		newsList = new ArrayList<News>();
		newsList.add(
				new News(1, "Breaking News 1", "Journalist 1", "politics", "this is sample news", LocalDateTime.now()));
		newsList.add(new News(2, "Breaking News 2", "Journalist 2", "sports",
				"India secures its second consecutive win against West Indies", LocalDateTime.now()));
	}

	public void addNews(News news) {
		newsList.add(news);
		sortNewsListByDateTimeDesc();
	}

	public List<News> getAllNews() {
		return newsList;
	}

	public Optional<News> getNewsById(int newsId) {
		return newsList.stream().filter(news -> news.getNewsId() == newsId).findFirst();
	}

	public void updateNews(News updatedNews) {
		getNewsById(updatedNews.getNewsId()).ifPresent(news -> {
			news.setNewsTitle(updatedNews.getNewsTitle());
			news.setAuthor(updatedNews.getAuthor());
			news.setDescription(updatedNews.getDescription());
			news.setContent(updatedNews.getContent());
			news.setDateTimeStamp(LocalDateTime.now());
			sortNewsListByDateTimeDesc();
		});
	}

	public void deleteNews(int newsId) {
		newsList.removeIf(news -> news.getNewsId() == newsId);
	}

	private void sortNewsListByDateTimeDesc() {
		newsList.sort(Comparator.comparing(News::getDateTimeStamp).reversed());
	}
}
