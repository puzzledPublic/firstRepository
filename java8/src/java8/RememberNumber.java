package java8;

import java.util.Arrays;

//������ �ܿ�� (������)
public class RememberNumber {
	static int cache[] = new int[1000];
	static String N = "43211234453463454353234";
	final static int INF = 999999999;
	public static void main(String args[]) {
		
		Arrays.fill(cache, -1);
		System.out.println("���̵�: "+ memorize(0));
	}

	static int memorize(int begin) {
		if (begin == N.length()) {
			return 0;
		}
		if (cache[begin] != -1) {
			return cache[begin];
		}

		int ret = INF;
		
		for (int i = 3; i <= 5; i++) {
			if (begin + i <= N.length()) {
				ret = Math.min(ret, memorize(begin + i) + classify(begin, begin + i));
			}
		}
		return ret;

	}

	static int classify(int a, int b) {
		String m = N.substring(a,b);//(a, b - a + 1);
		// ��� ���Ұ� ������ ���̵� 1
		if (isAllSame(m)) {
			return 1;
		}

		// ���ڰ� �����ϰų� ���� �� ��
		boolean progressive = true;
		for (int i = 0; i < m.length() - 1; i++) {
			if (m.charAt(i + 1) - m.charAt(i) != m.charAt(1) - m.charAt(0)) {
				progressive = false;
			}
		}
		// ���ڰ� 1�� �����ϰų� ���� �� �� ���̵� 2
		if (progressive && Math.abs(m.charAt(1) - m.charAt(0)) == 1) {
			return 2;
		}
		// �� ���� ������ ��Ÿ�� �� ���̵� 4
		boolean alternating = true;
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) != m.charAt(i % 2)) {
				alternating = false;
			}
		}
		if (alternating) {
			return 4;
		}
		// ������ 1�� �ƴ� ���� ������ �� ���̵� 5
		if (progressive) {
			return 5;
		}
		// �ƹ��͵� �ƴ϶�� ���̵� 10
		return 10;

	}

	static boolean isAllSame(String m) {
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(0) != m.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
