package java8;

import java.util.Scanner;

//gcd(x,y)�� lcm(x,y)�� �־��� �� x, y ���� ���ϴ� ���� 
//x, y ���� �������� ��� x+y�� �ּ� ���� �Ǵ� �� ��� 
public class Jungol2498 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int gcd, lcm;

		gcd = scanner.nextInt();
		lcm = scanner.nextInt();
		if (lcm % gcd != 0) {
			System.out.println("�ش� x, y�� ����");
			System.exit(0);
		}
		commonNumbers(gcd, lcm);
	}

	static void commonNumbers(int gcd, int lcm) {
		// x*y = gcd(x,y)*lcm(x,y)�� ������ ���� ��Ÿ�� �� �ִ�.
		//gcd * a * gcd * b = gcd * lcm => a * b = lcm / gcd 
		//�̶� a�� b�� �Ҽ��̰� ���μҴ�. 
		//�� a * b �� lcm/gcd �̸鼭 a�� b�� �Ҽ��� ���� ���ϰ� a+b�� �ּ��϶� a, b�� ���� gcd�� �����ָ� �ǰڴ�
		//�̸� �̿��Ͽ� mult = a * b;
		int mult = lcm / gcd;
		//a�� ������ mult�� �ΰ�
		int a = mult;
		//b�� ������ 1���� �����Ѵ�.
		int b = 1;
		//���� �ּҸ� ���ϱ� ���� ������ ���� a + b�� �д�
		int sum = a + b;
		//���� �ּҰ� �ǵ��� �ϴ� a, b�� ������ ����
		int lastA = a, lastB = b;
		//a�� b���� ū ����
		while (a > b) {
			//b�� 1 ����
			b++;
			//b �� a * b�� ������ 
			if (mult % b == 0) {
				// mult / b �� ������ b�� ���Ͽ� mult���� �Ǵ� a�� ���� �� �ִ�.
				a = mult / b;
				//�̶� a�� b�� ���μ��̰�
				if (get_gcd(a, b) == 1) {
					//���� sum ���� a+b�� �۴ٸ�
					if (sum > a + b) {
						//�� ���� �ּ� ���� sum���� �Ѵ�
						sum = a + b;
						//�̶��� a, b�� ���� �ּҰ� �ǵ��� �ϴ� ���̴�.
						lastA = a;
						lastB = b;
					}
				}
			}
		}
		//���� �ּҷ� �ϴ� ���� gcd�� ���� �����ش�.
		System.out.println(lastB * gcd + " " + lastA * gcd);
	}

	static int get_gcd(int x, int y) {
		int r;
		while (true) {
			r = x % y;
			if (r == 0) {
				break;
			}
			x = y;
			y = r;
		}
		return y;
	}
}
