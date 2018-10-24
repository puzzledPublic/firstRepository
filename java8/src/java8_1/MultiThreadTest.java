package java8_1;

import java.util.Scanner;

public class MultiThreadTest {

	public static void main(String args[]){
		
		//Thread th = new Thread(()->{for(int i=0; i < 200;i++){System.out.print(".");}});
		//th.start();

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while(n != 'q') {
			solve(n);
			n = input.nextInt();
		}
		
	}
	
	static void solve(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append("┌");
		int width = n;//= n != 1 ? n * 2 : 1;
		String w = n != 1 ? "──" : "─";
		String s = n != 1 ? "  " : " ";
		for(int i = 0; i < width; i++) {
			sb.append(w);
		}
		sb.append("┐\n");
		int height = n;
		for(int i = 0; i < height; i++) {
			sb.append("│");
			for(int j = 0; j < width; j++) {
				sb.append(s);
			}
			sb.append("│\n");
		}
		sb.append("└");
		for(int i = 0; i < width; i++) {
			sb.append(w);
		}
		sb.append("┘");
		
		System.out.println(sb);
	}
}
