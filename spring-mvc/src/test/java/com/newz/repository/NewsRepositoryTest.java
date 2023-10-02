package com.newz.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.newz.model.News;

public class NewsRepositoryTest {

	private NewsRepository newsRepository;

	@Before
	public void setUp() {
		newsRepository = new NewsRepository();
	}

	@Test
	public void testAddNews() {
		int initialSize = newsRepository.getAllNews().size();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		News news = new News(3, "Sample News", "Author 3", "Description 3", "Content 3", LocalDateTime.now());
		newsRepository.addNews(news);
		List<News> newsList = newsRepository.getAllNews();
		assertEquals(initialSize + 1, newsList.size());

		News addedNews = newsList.get(0);
		assertEquals(news, addedNews);
	}

	@Test
	public void testGetAllNews() {
		List<News> newsList = newsRepository.getAllNews();
		assertFalse(newsList.isEmpty());
	}

	@Test
	public void testGetNewsById() {
		Optional<News> news = newsRepository.getNewsById(1);
		assertTrue(news.isPresent());
		assertEquals(1, news.get().getNewsId());
	}

	@Test
	public void testUpdateNews() {
		News newsToUpdate = newsRepository.getAllNews().get(0);
		newsToUpdate.setNewsTitle("Updated Title");
		newsToUpdate.setAuthor("Updated Author");
		newsToUpdate.setDescription("Updated Description");
		newsToUpdate.setContent("Updated Content");

		newsRepository.updateNews(newsToUpdate);

		Optional<News> updatedNews = newsRepository.getNewsById(newsToUpdate.getNewsId());
		assertTrue(updatedNews.isPresent());
		assertEquals("Updated Title", updatedNews.get().getNewsTitle());
		assertEquals("Updated Author", updatedNews.get().getAuthor());
		assertEquals("Updated Description", updatedNews.get().getDescription());
		assertEquals("Updated Content", updatedNews.get().getContent());
	}

	@Test
	public void testDeleteNews() {
		int initialSize = newsRepository.getAllNews().size();
		int newsIdToDelete = newsRepository.getAllNews().get(0).getNewsId();

		newsRepository.deleteNews(newsIdToDelete);

		List<News> newsList = newsRepository.getAllNews();
		assertEquals(initialSize - 1, newsList.size());
		assertFalse(newsList.stream().anyMatch(news -> news.getNewsId() == newsIdToDelete));
	}
}
