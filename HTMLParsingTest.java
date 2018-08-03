
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.io.IOException;

public class HTMLParsingTest{
  public static void main(String[] args) throws IOException{
    String engine = "http://www.bing.com/search?q=";
    String search = "lol slang";
    String en_flag = "&ensearch=1";
    String charset = "UTF-8";
    String userAgent = "Mozilla/5.0 (Windows NT 6.1) " +
      "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 " +
      "Safari/537.36 SE 2.X MetaSr 1.0";

    Elements links = Jsoup.connect(engine +
      URLEncoder.encode(search, charset) + en_flag)
      .userAgent(userAgent)
      .get().select(".b_algo");

    for(Element link : links){
      String title = link.select("a").text();
      String content = link.select(".b_caption p").text();
      String url = link.select("a").attr("href");

      System.out.println("Title: " + title);
      System.out.println("URL: " + url);
      System.out.println("Content: " + content);
    }
  }

}
