package kakaoSecond;

import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
	public static void main(String[] args) throws IOException {
		Logger log = Logger.getLogger("tester");
		Document doc = Jsoup.connect("http://nghttp2.org/httpbin/").get();
		log.info("get");
		Elements newHeadLines = doc.select("a[href]");
		for(Element e : newHeadLines) {
			log.info(e.attr("href"));
		}
	}
}
