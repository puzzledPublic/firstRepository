package java8;

import java.util.Arrays;

public class Quantization {
	final static int INF = 99999999;
	static int A[] = {1,744,755,4,897,902,890,6,777};
	static int pSum[] = new int[100];
	static int pSqSum[] = new int[100];
	static int cache[][] = new int[100][100];

	public static void main(String args[]) {
		//-1�� ĳ�� �ʱ�ȭ
		for(int i = 0; i < cache.length; i++){
			Arrays.fill(cache[i], -1);
		}
		//����ȭ �ϱ� ���� �غ�
		precalc();
		System.out.println(quantize(0, 3));
	}
	
	static void precalc() {
		// ����ȭ�� ���ڵ��� ����
		Arrays.sort(A);

		// �κ��յ��� ��� �� ���´�
		pSum[0] = A[0];
		pSqSum[0] = A[0] * A[0];
		for (int i = 1; i < A.length; i++) {
			pSum[i] = pSum[i - 1] + A[i];
			pSqSum[i] = pSqSum[i - 1] + (A[i] * A[i]);
		}
	}

	// �ش� �κ��� �ּ� ���� ���������� ���� ���Ѵ�
	static int minError(int lo, int hi) {
		// A[]���� �κ� ��
		int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo - 1]);
		// A[]^2���� �κ� ��
		int sqSum = pSqSum[hi] - (lo == 0 ? 0 : pSqSum[lo - 1]);
		// ��� ��
		int m = (int) (0.5 + (double) sum / (hi - lo + 1));
		// �κ� ���� ���������� �� = A[]^2 - 2 * A[] + (hi - lo + 1) * m * m(m:��հ�)
		int ret = sqSum - 2 * m * sum + (hi - lo + 1) * m * m;
		return ret;
	}

	static int quantize(int from, int parts) {
		if (from == A.length) {
			return 0;
		}
		if (parts == 0) {
			return INF;
		}
		if (cache[from][parts] != -1) {
			return cache[from][parts];
		}

		int ret = INF;
		for (int partSize = 1; from + partSize <= A.length; partSize++) {
			ret = Math.min(
					ret,
					minError(from, from + partSize - 1)
							+ quantize(from + partSize, parts - 1));
		}
		return ret;
	}
}
