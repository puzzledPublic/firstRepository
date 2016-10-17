package java8;

import java.util.Scanner;

//�Ҽ�
//�ڿ��� M�� N�� �־��� �� M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ��� �̵� �Ҽ��� �հ� �ּҰ��� ã�ƶ�
//�Ҽ��� ���� ��쿡�� -1�� ����Ѵ�.
//M <= N <= 10000
public class Jungol1740 {
	static boolean eratostenes[] = new boolean[10005];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int m, n, sum = 0, min = 99999;
		// �Է�
		m = scanner.nextInt();
		n = scanner.nextInt();
		// �����佺�׳׽� ü ����
		eratos(n);
		// �����佺�׳׽� ü ���
		for (int i = m; i <= n; i++) {
			// �Ҽ����̸�
			if (eratostenes[i] == false) {
				// �Ҽ����� ��� ���Ѵ�
				sum += i;
				// ���� ���� �Ҽ��� ���Ѵ�
				min = Math.min(min, i);
			}
		}
		// sum == 0 �� ���(�Ҽ��� ���� ���)
		if (sum == 0) {
			System.out.println("-1");
		}
		// �Ҽ����� �հ� �ּ� �Ҽ��� ���
		else {
			System.out.println(sum + "\n" + min);
		}
	}

	// �����佺�׳׽�ü
	static void eratos(int number) {

		eratostenes[1] = true;
		for (int i = 2; i * i <= number; i++) {
			if (eratostenes[i] == false) {
				for (int j = i * i; j <= number; j += i) {
					eratostenes[j] = true;
				}
			}
		}
	}
}
