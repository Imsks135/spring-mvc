package com.newz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newz.model.News;
import com.newz.repository.NewsRepository;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public void addNews(News news) {
        if (!isDuplicateNews(news)) {
            newsRepository.addNews(news);
        } else {
            throw new IllegalArgumentException("News with the same ID already exists.");
        }
    }

    public List<News> getAllNews() {
        return newsRepository.getAllNews();
    }

    public Optional<News> getNewsById(int newsId) {
        Optional<News> news = newsRepository.getNewsById(newsId);
        if (news.isPresent()) {
            return news;
        }
        return Optional.empty(); 
    }

    public void updateNews(News updatedNews) {
        if (getNewsById(updatedNews.getNewsId()).isPresent()) {
            newsRepository.updateNews(updatedNews);
        } else {

            throw new IllegalArgumentException("News with the given ID does not exist.");
        }
    }

    public void deleteNews(int newsId) {
        if (getNewsById(newsId).isPresent()) {
            newsRepository.deleteNews(newsId);
        } else {
            throw new IllegalArgumentException("News with the given ID does not exist.");
        }
    }

    private boolean isDuplicateNews(News news) {
        return newsRepository.getAllNews().stream().anyMatch(existingNews -> existingNews.getNewsId() == news.getNewsId());
    }
}
