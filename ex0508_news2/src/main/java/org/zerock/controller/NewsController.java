package org.zerock.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/news/*")
public class NewsController {

	@GetMapping("/naver")
	public void naver(Model model) throws IOException{
		
	
		String url ="https://n.news.naver.com/mnews/article/277/0005415467";
		
		Document doc = Jsoup.connect(url).timeout(5000).get();
		log.info(doc);
		
		Elements elements =doc.select("#dic_area");
		log.info(elements);
		log.info(elements.text());
		
		/*
		 * Elements a =doc.select("#dic_area"); log.info(a);
		 * 
		 * 
		 * model.addAttribute("title", elements); model.addAttribute("content", a);
		 */

		
		
		
	}
}
