package stackbuilders.crawler;

import java.util.List;

import org.junit.Test;

import stackbuilders.crawler.entities.News;
import stackbuilders.crawler.services.ServiceCrawlerImpl;

public class TestServiceCrawler {

	@Test
	public void getHtmlDocumentTest() {
		String url = "https://news.ycombinator.com/";
		ServiceCrawlerImpl crawler = new ServiceCrawlerImpl();
		List<News> news= crawler.loadNews(url);
		
		for (News a : news) {
			System.out.println(a.getNumberOrder() + " " + a.getTitle() + " " + a.getPoints()+ " " + a.getAmountComments());
		}
		
		
	}

}
