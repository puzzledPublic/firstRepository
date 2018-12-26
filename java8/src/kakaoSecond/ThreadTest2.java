package kakaoSecond;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


public class ThreadTest2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		T t = new T();
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < 10000; i++) {
				t.increase();
			}
		});
		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 10000; i++) {
				t.decrease();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(t.getData());
		
//		System.out.println("start");
//		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
//			try{
//				TimeUnit.SECONDS.sleep(2L);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//			return "Hello";
//		}).thenAccept(System.out::println);
//		
//		System.out.println("end");
//		cf.join();
	}
}
class T {
	private int data;
	
	synchronized void increase() {
		data++;
	}
	synchronized void decrease() {
		data--;
	}
	int getData() {
		return data;
	}
}