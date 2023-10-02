package com.newz.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.newz.model.News;
import com.newz.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView getAllNews() {
		ModelAndView mv = new ModelAndView("index");
		List<News> newsList = newsService.getAllNews();
		mv.addObject("newsList", newsList);
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String addNews(@RequestParam("newsId") int newsId, @RequestParam("newsTitle") String newsTitle,
			@RequestParam("author") String author, @RequestParam("description") String description,
			@RequestParam("newsContent") String newsContent) {
		News news = new News(newsId, newsTitle, author, description, newsContent, LocalDateTime.now());
		newsService.addNews(news);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	public String deleteNews(@RequestParam("newsId") int newsId) {
		newsService.deleteNews(newsId);
		return "redirect:/";
	}
}
