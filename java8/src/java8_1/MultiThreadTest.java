package java8_1;

public class MultiThreadTest {

	public static void main(String args[]){
		
		Thread th = new Thread(()->{for(int i=0; i < 200;i++){System.out.print(".");}});
		th.start();

		
	}
}
