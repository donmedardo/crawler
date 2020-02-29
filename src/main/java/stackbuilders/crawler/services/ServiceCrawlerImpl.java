package stackbuilders.crawler.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import stackbuilders.crawler.entities.News;

public class ServiceCrawlerImpl {
	
	public static int getStatusConnectionCode(String url) {
		
	    Response response = null;
		
	    try {
		response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
	    } catch (IOException ex) {
		System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
	    }
	    return response.statusCode();
	}
	
	public Document getHtmlDocument(String url) {

	    Document doc = null;
		try {
		    doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
		    } catch (IOException ex) {
			System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
		    }
	    return doc;
	} 

	public List<News> loadNews(String url){
		Document document = getHtmlDocument(url);
		Elements entradas = document.select(".itemlist");
		System.out.println("Número de entradas en la página inicial de Jarroba: " + entradas.size() + "\n");
		List<News> enties = new ArrayList<>();
		boolean agregar;
		News newTemp = new News();
		for (Element table : entradas) {

			for (Element row : table.select("tr")) {
				Elements tds = row.select("td");

				agregar = false;
				for (Element td : tds) {
					if (td.getElementsByClass("rank").size() > 0) {
						newTemp = new News();
						String numberOrder = td.getElementsByClass("rank").text();
						newTemp.setNumberOrder(Integer.parseInt(numberOrder.replace(".", "").trim()));

					}
					if (td.getElementsByClass("storylink").size() > 0) {

						String titulo = td.getElementsByClass("storylink").text();
						newTemp.setTitle(titulo);
					}
					if (td.getElementsByClass("score").size() > 0) {

						String score = td.getElementsByClass("score").text();
						newTemp.setPoints(Integer.parseInt(score.replace("points", "").trim()));

						if (td.select("a[href]").size() > 0) {
							Element refs = td.select("a[href]").get(3);
//							System.out.println(refs.text());
							String coment= refs.text().replace("comments", "").replace("comment", "").trim();
							try {
							    newTemp.setAmountComments(Integer.parseInt(coment));
							} catch (NumberFormatException e) {
								newTemp.setAmountComments(new Integer(0));
							}
						}
						agregar = true;
					}

				}
				if (agregar) {
					enties.add(newTemp);
				}

			}
			
		}
		return enties;

	}
}
