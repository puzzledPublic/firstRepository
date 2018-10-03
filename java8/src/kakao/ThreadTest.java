package kakao;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
	public static void main(String[] args) throws ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ExecutorCompletionService<String> ecs = new ExecutorCompletionService<String>(executor);
		
		String[] str = {"1", "2", "3", "4", "5"};
		
		for(String s : str) {
			ecs.submit(() -> {
				Thread.sleep(1000);
				return s;
			});
		}
		
		System.out.println("main thread ing");
		
		try{
			for(int i = 0; i < str.length; i++) {
				Future<String> f = ecs.take();
				System.out.println(f.get());
			}
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}catch(ExecutionException e) {
			throw e;
		}
		executor.shutdown();
	}
}
