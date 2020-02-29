package stackbuilders.crawler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import stackbuilders.crawler.entities.News;
import stackbuilders.crawler.services.ServiceCrawlerImpl;

public class TestServiceCrawler {

	

	@Test
	public void getHtmlDocumentTest() {
		String url = "https://news.ycombinator.com/";
		ServiceCrawlerImpl crawler = new ServiceCrawlerImpl();
		Document document = crawler.getHtmlDocument(url);
		Elements entradas = document.select(".itemlist");
		System.out.println("Número de entradas en la página inicial de Jarroba: " + entradas.size() + "\n");
		List<News> enties = new ArrayList<>();
		boolean agregar;
		News newTemp = new News();
		for (Element table : entradas) {

			for (Element row : table.select("tr")) {
				// String titulo = table.getElementsByClass("storylink").text();
				Elements tds = row.select("td");
				
				agregar= false;
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
						 agregar = true;
					}
//					if (td.getElementsByClass("storylink").size() > 0) {
//
//						String titulo = td.getElementsByClass("storylink").text();
//						newTemp.setTitle(titulo);
//					}
				}
				if(agregar){
					enties.add(newTemp);
				}
				
			}

			for (News a : enties) {
				System.out.println(a.getNumberOrder() + " " + a.getTitle()+ " " + a.getPoints());
			}
			// String titulo = table.getElementsByClass("storylink").text();
			// String autor = table.getElementsByClass("autor").toString();
			// String fecha = table.getElementsByClass("fecha").text();

			// System.out.println(titulo+"\n"+autor+"\n"+fecha+"\n\n");

			// Con el método "text()" obtengo el contenido que hay dentro de las
			// etiquetas HTML
			// Con el método "toString()" obtengo todo el HTML con etiquetas
			// incluidas
		}

		// assertTrue("someLibraryMethod should return 'true'", );
	}

}
