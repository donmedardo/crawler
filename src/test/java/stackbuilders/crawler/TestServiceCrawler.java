package stackbuilders.crawler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


public class TestServiceCrawler {

	@Test public void getHtmlDocumentTest() {
		String url = "https://news.ycombinator.com/";
		ServiceCrawlerImpl crawler = new ServiceCrawlerImpl();
		Document document = crawler.getHtmlDocument(url);
		 Elements entradas = document.select(".itemlist");
         System.out.println("Número de entradas en la página inicial de Jarroba: "+entradas.size()+"\n");
			
         // Paseo cada una de las entradas
         for (Element table : entradas) {
        	 
        	 for (Element row : table.select("tr")) {
        		 //String titulo = table.getElementsByClass("storylink").text();
                 Elements tds = row.select("td");
                 
                 for(Element td:tds){
                	 if (tds.size() > 0) {
                    	 String titulo = td.getElementsByClass("storylink").text();
                         System.out.println(titulo);
                     }
                 }
                 
             }
//             String titulo = table.getElementsByClass("storylink").text();
//             String autor = table.getElementsByClass("autor").toString();
//             String fecha = table.getElementsByClass("fecha").text();
				
//             System.out.println(titulo+"\n"+autor+"\n"+fecha+"\n\n");
				
             // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
             // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
         }
		
        //assertTrue("someLibraryMethod should return 'true'", );
    }
	
}
