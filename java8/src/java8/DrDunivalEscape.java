package java8;

import java.util.Arrays;
import java.util.Vector;
//�δϹ� �ڻ��� Ż��
//������ 8.17 

public class DrDunivalEscape {
	//�������� ����� �ִ��� ���θ� ��Ÿ���� �迭 ( ������ �׷���)
	static int[][] connected = { { 0, 1, 1, 1, 0 }, { 1, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 } };
	//�� �������� ����� ������ ����( ����)
	static int[] deg = new int[5];
	//�޸������̼��� ���� ĳ��
	static double[][] cache = new double[10][10];
	// n = ���� ����, d = ������ ��¥, p = ������, q = ������
	static int n = 5, d = 2, p = 0, q = 0;

	public static void main(String[] args) {
		//������ �׷������� �� ������ ������ ���Ѵ�.
		for (int i = 0; i < connected.length; i++) {
			for (int j = 0; j < connected[0].length; j++) {
				if (connected[i][j] == 1) {
					deg[i]++;
				}
			}
		}
		//ĳ�� �ʱ�ȭ
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1.0);
		}
		// for(int i = 0; i < deg.length;i++){
		// System.out.print(deg[i] +" ");
		// }
		//Ž���ϴ� ��θ� ��Ÿ�� ����
		Vector<Integer> path = new Vector<Integer>();
		//����� ó���� ����
		path.add(p);
		System.out.println(search(path));
		System.out.println(search2(p, 0));

	}

	// ��ü ��θ� Ž���Ͽ� ��� ���
	static double search(Vector<Integer> path) {
		if (path.size() == d + 1) {
			if (path.lastElement() != q) {
				return 0.0;
			}
			double ret = 1.0;
			for (int i = 0; i + 1 < path.size(); i++) {
				ret /= deg[path.get(i)];
			}
			return ret;
		}
		double ret = 0;

		for (int there = 0; there < n; there++) {
			if (connected[path.lastElement()][there] == 1) {
				path.add(there);
				ret += search(path);
				path.remove(path.size() - 1);
			}
		}
		return ret;
	}

	// �޸������̼��� �̿��� ���
	static double search2(int here, int days) {
		if (days == d) {
			return (here == q ? 1.0 : 0.0);
		}
		if (cache[here][days] > -0.5) {
			return cache[here][days];
		}
		cache[here][days] = 0.0;
		for (int there = 0; there < n; there++) {
			if (connected[here][there] == 1) {
				cache[here][days] += search2(there, days + 1) / deg[here];
			}
		}
		return cache[here][days];
	}
	//������������ �Ųٷ� ���ϴ� ���
	static double search3(int here, int days){
		if(days == 0){
			return (here == p? 1.0:0.0);
		}
		if(cache[here][days] > -0.5){
			return cache[here][days];
		}
		cache[here][days]=0.0;
		for(int there = 0; there < n; there++){
			if(connected[here][there] == 1){
				cache[here][days] += search3(there, days - 1) / deg[here];
			}
		}
		return cache[here][days];
	}
}
