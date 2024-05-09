package org.zerock.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.crawling.CrawlingNaverNews;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/crawl/*")
@Log4j
public class CrawController {
	@Autowired
	private CrawlingNaverNews crawlingNaverNews;
	
	
	@GetMapping("/newsCrawl")
	public String newsCrawl(Model model) {
		List<String> headLines = crawlingNaverNews.crawlNaverNewsHeadLines();
		log.info(headLines);
		model.addAttribute("headLines",headLines);
	
		return "crawl/newsCrawl";
	}
}
