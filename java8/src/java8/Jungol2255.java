package java8;

import java.util.Scanner;
//섞기 수열 ( 아직 노 해결)
public class Jungol2255 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n, count = 0, lcm;
		n = scanner.nextInt();
		if (n < 1 || n > 20000) {
			System.exit(0);
		}
		int[] item = new int[n];
		int[] temp = new int[n];
		int[] cycle = new int[n];
		int[] check = new int[n];
		for (int i = 0; i < n; i++) {
			item[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			temp[i] = item[item[i] - 1];
		}
		//count++;
		for (int i = 0; i < n; i++) { System.out.print(temp[i] + " "); }
		System.out.print(", ");
		 for (int i = 0; i < n; i++) { System.out.print(cycle[i] + " "); }
		 System.out.println();
		while (true) {

			for (int i = 0; i < n; i++) {
				temp[i] = item[temp[i] - 1];
				if (temp[i] != item[i]) {
					cycle[i]++;
				}
			}
			for (int i = 0; i < n; i++) { System.out.print(temp[i] + " "); }
			System.out.print(", ");
			 for (int i = 0; i < n; i++) { System.out.print(cycle[i] + " "); }
			 System.out.println();
			 
			if (!isSame(cycle, check, n)) {
				for (int i = 0; i < n; i++) {
					check[i] = cycle[i];
				}
			} else {
				break;
			}

			
			 //count++;
			
			 
			/*
			 * if (isSame(item, temp, n)) { break; }
			 */
		}
		lcm = cycle[0];
		for(int i = 1 ; i < n;i++){
			if(cycle[i]!=0){
				lcm = lcm * cycle[i] / get_gcd(lcm, cycle[i]);
			}
		}
		System.out.println(lcm);
	}

	static boolean isSame(int[] cycle, int[] check, int n) {
		for (int i = 0; i < n; i++) {
			if (cycle[i] != check[i]) {
				return false;
			}
		}
		return true;
	}

	static int get_gcd(int a, int b) {
		int r;
		while (true) {
			r = a % b;
			if (r == 0) {
				break;
			}
			a = b;
			b = r;
		}
		return b;
	}
	/*
	 * static boolean isSame(int[] item, int[] temp, int n) { for (int i = 0; i
	 * < n; i++) { if (item[i] != temp[i]) { return false; } } return true; }
	 */

}
