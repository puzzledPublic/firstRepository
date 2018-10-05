package kakaoSecond;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KakaoTest4 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
		KakaoApiHelper kah = new KakaoApiHelper();
		executor.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getId() + " " + kah.getIP());
			}
		});
		executor.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getId() + " " + kah.getIP());
			}
		});
		executor.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getId() + " " + kah.getIP());
			}
		});
		
		executor.shutdown();
	}
	
}
