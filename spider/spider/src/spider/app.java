package spider;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class app {
	public static void main(String[] args) {

		/*
		 * �̷߳������̳߳�
		 */
		
		/*
		 * �̶���С���̳߳�
		 */
		ExecutorService pool = Executors.newFixedThreadPool(4);
		/*
		 * ���޻���
		 */
	pool = Executors.newCachedThreadPool();
		/*
		 * һ���߳�
		 */
//		pool = Executors.newSingleThreadExecutor();
		ArrayList<film> list = new ArrayList<>();
		String url = "https://movie.douban.com/top250?start=";
		for(int i =0 ; i < 10; i++) {
			String path = String.format("%s%d",url, i*25);
			pool.submit(new Spider(path, list));
		}
		pool.shutdown();
		System.out.println(pool.isTerminated());
		
		while(!pool.isTerminated()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(list.size());
		
		for(film film:list) {
			System.out.print(film.toCSV());
		}
		
		//д���ļ�
		String file="d:/film.csv"; //����·��
		file="film.csv";
		//io
		
		//����
		Collections.sort(list);
		
		try(FileWriter out=new FileWriter(file)) {
			//д����
			for (film film :list) {
				out.write(film.toCSV());
			
			}
			System.out.println("ok");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
