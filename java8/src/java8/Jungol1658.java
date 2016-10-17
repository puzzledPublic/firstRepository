package java8;

import java.util.Scanner;

//�ִ� ������� �ּ� �����
public class Jungol1658 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		int lcm;
		a = scanner.nextInt();
		b = scanner.nextInt();
		// �� ���� ���� �� ���� �ִ� ������� �ּ� ������� ���̴�
		lcm = a * b / get_GCD(a, b);
		System.out.println(lcm);
		scanner.close();
	}

	// ��Ŭ���� ȣ�������� �ִ������� ���Ѵ�
	// GCD(a , b) == GCD(b , a % b)�� ����
	static int get_GCD(int a, int b) {
		int r;

		while (true) {
			r = a % b;
			if (r == 0) {
				break;
			}
			a = b;
			b = r;

		}
		System.out.println(b);
		return b;
	}
}
