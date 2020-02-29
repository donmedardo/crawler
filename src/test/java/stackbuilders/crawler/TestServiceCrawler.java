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
		System.out.println(" \n Number of Entries: " + news.size() + "\n");
		for (News a : news) {
			System.out.println("No."+a.getNumberOrder() + " Title:" + a.getTitle() + " Points: " + a.getPoints()+ " Amount: " + a.getAmountComments());
		}
	}
	
	@Test
	public void getEntriesMoreFiveWordsInTitle(){
		String url = "https://news.ycombinator.com/";
		ServiceCrawlerImpl crawler = new ServiceCrawlerImpl();
		List<News> news= crawler.getEntriesMoreFiveWordsInTitle(url);
		System.out.println("\n 1. Filter all previous entries with more than five words in the title ordered by the amount of comments first."+ "\n");
		for (News a : news) {
			System.out.println("No."+a.getNumberOrder() + " Title:" + a.getTitle() + " Points: " + a.getPoints()+ " Amount: " + a.getAmountComments());
		}
	}
	@Test
	public void getEntriesLessFiveWordsInTitle(){
		String url = "https://news.ycombinator.com/";
		ServiceCrawlerImpl crawler = new ServiceCrawlerImpl();
		List<News> news= crawler.getEntriesLessFiveWordsInTitle(url);
		System.out.println("\n 2. Filter all previous entries with less than or equal to five words in the title ordered by points."+ "\n");
		for (News a : news) {
			System.out.println("No."+a.getNumberOrder() + " Title:" + a.getTitle() + " Points: " + a.getPoints()+ " Amount: " + a.getAmountComments());
		}
	}
	
	
}
