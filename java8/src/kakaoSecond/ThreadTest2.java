package kakaoSecond;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


public class ThreadTest2 {
	public static void main(String[] args) {
		
		System.out.println("start");
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			try{
				TimeUnit.SECONDS.sleep(2L);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello";
		}).thenAccept(System.out::println);
		
		System.out.println("end");
		cf.join();
	}
}
