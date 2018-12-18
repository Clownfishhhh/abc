package spider;
/*
 * 抓取页面中影片信息爬虫（任务）
 * 
 */

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider implements Runnable{
	/*
	 * 页面路径
	 */
	String url="";
	/*
	 * 存储抓取的数据
	 */
	ArrayList<film> list;
	

	
	public Spider(String url, ArrayList<film> list) {
		super();
		this.url = url;
		this.list = list;
	}



	public void run() {
		//获得执行该任务的名称
		String name = Thread.currentThread().getName();
		System.out.println(name + "线程，处理：" + url);
		
		//JSOUP
		try {
		Document doc = Jsoup.connect(url).get();
		
		Elements es = doc.select(".grid_view .item");
	//创建一个电影的列表
		//ArrayList<film> list = new ArrayList<>();
		
		for (Element e :es) {
			film f = new film();
			//每一部电影
			f.id = Integer.parseInt(e.select(".pic em").first().text());
			f.poster = e.select("img").first().attr("src");
			//f.info = e.select(".bd p").first().text();
			f.title  = e.select(".title").first().text();
			f.rating = Double.parseDouble(e.select(".rating_num").first().text());
			String num = e.select(".star span").last().text();
			f.num = Integer.parseInt(num.substring(0, num.length()-3));
			f.quote = e.select(".inq").first().text();
			
//			System.out.println(name+":"+f);
			list.add(f);
			
			
			

			
		}
		
System.out.println(name + "线程，完成" + url);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	

}
