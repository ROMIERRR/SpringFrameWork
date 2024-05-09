package org.zerock.crawling;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class CrawlingNaverNews {
	public List<String> crawlNaverNewsHeadLines(){
		List<String> headLines = new ArrayList<>();
		try {
			//가져올 url
			String url = "https://sports.news.naver.com/index";
			
			//html 가져오기
			Document doc = Jsoup.connect(url).get();
			
			//기사 제목 담고있는 요소 선택
			Elements newsHeadLines = doc.select(".today_item");
			
			for(Element headLine : newsHeadLines) {
				headLines.add(headLine.text());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return headLines;
	}
	
}
