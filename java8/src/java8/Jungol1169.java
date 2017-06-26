package java8;

import java.util.Scanner;

//�ֻ��� ������ 1
//�ֻ����� ���� Ƚ�� N�� ������� M�� �Է� �޾Ƽ� M�� ���� ���� ���� �Ʒ��� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//M = 1 : �ֻ����� N�� ������ ���� �� �ִ� ��� ���
//M = 2 : �ֻ����� N�� ������ �ߺ��� �Ǵ� ��츦 �����ϰ� ���� �� �ִ� ��� ���
//M = 3 : �ֻ����� N�� ������ ��� �ٸ� ���� ���� �� �ִ� ��� ���
//* �ߺ��� ��
//1 1 2 �� �ߺ� : 1 2 1, 2 1 1
//1 2 3 �� �ߺ� : 1 3 2, 2 1 3, 2 3 1, 3 1 2
//ù �ٿ� �ֻ����� ���� Ƚ�� N(2��N��5)�� ��¸�� M(1��M��3)�� ���´�
//���� ���ں��� ���
public class Jungol1169 {

	static int[] print = { 1, 0, 0, 0, 0, 0 };
	static boolean[] mask = new boolean[7];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, m;
		n = scanner.nextInt();
		m = scanner.nextInt();

		switch (m) {
		case 1:
			throwCoin(1, n);
			break;
		case 2:
			throwCoin2(1, n);
			break;
		case 3:
			throwCoin3(1, n);
			break;
		}
	}

	// M==1
	static void throwCoin(int k, int n) {
		if (n == 0) {
			for (int i = 1; i < print.length; i++) {
				if (print[i] > 0) {
					System.out.print(print[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= 6; i++) {
			print[k] = i;
			throwCoin(k + 1, n - 1);
		}
	}

	// M==2
	static void throwCoin2(int k, int n) {
		if (n == 0) {
			for (int i = 1; i < print.length; i++) {
				if (print[i] > 0) {
					System.out.print(print[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = print[k - 1]; i <= 6; i++) {
			print[k] = i;
			throwCoin2(k + 1, n - 1);
		}
	}

	// M==3
	static void throwCoin3(int k, int n) {
		if (n == 0) {
			for (int i = 1; i < print.length; i++) {
				if (print[i] > 0) {
					System.out.print(print[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if (mask[i] == true) {
				continue;
			}
			print[k] = i;
			mask[i] = true;
			throwCoin3(k + 1, n - 1);
			mask[i] = false;
		}
		/*
		 * for (int i = 1; i <= 6; i++) { for(int j = 1 ; j < print.length;
		 * j++){ if(print[j] == i){ i++; } } print[k] = i; throwCoin3(k + 1, n -
		 * 1); }
		 */
	}

}
