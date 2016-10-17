package java8;

import java.util.Scanner;

//���� �������� �ִ� �����, �ּ� �����
public class Jungol1002 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n, gcm, lcm;
		n = scanner.nextInt();

		if (n < 2 || n > 100) {
			System.exit(0);
		}

		int[] item = new int[n];

		for (int i = 0; i < n; i++) {
			item[i] = scanner.nextInt();
		}
		//ó�� ������ gcm, lcm ���� ����
		gcm = lcm = item[0];
		//���� ������ gcm, lcm ���ϴ� ���� �ݺ�
		for (int i = 1; i < n; i++) {
			gcm = get_gcd(gcm, item[i]);
			lcm = lcm * item[i] / get_gcd(lcm, item[i]);

		}
		System.out.println(gcm +" "+ lcm);

	}
	//��Ŭ���� ȣ�������� gcm ���ϴ� �Լ�
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
}
