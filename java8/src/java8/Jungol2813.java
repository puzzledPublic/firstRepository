package java8;

import java.util.Scanner;

//�Ҽ��� ����
//�ڿ��� M�� N�� �Է� �޾� M���� N������ �Ҽ��� ������ ���϶�
//1 <= M <= N <= 2,000,000;
public class Jungol2813 {
	static boolean eratostenes[] = new boolean[2000001];

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int m, n, count = 0;
		//�Է�
		m = scanner.nextInt();
		n = scanner.nextInt();
		//�����佺�׳׽� ü�� ���
		eratos(n);
		//�����佺�׳׽� ü���� m���� n������ �Ҽ��� ������ ���Ѵ� 
		for (int i = m; i <= n; i++) {
			if (eratostenes[i] == false) {
				count++;
			}
		}
		//���
		System.out.println(count);

	}
	//�����佺�׳׽��� ü
	static void eratos(int number) {
		//1�� �Ҽ��� �ƴϹǷ� true
		eratostenes[1] = true;
		//�Ҽ��� ã���鼭
		for (int i = 2; i * i <= number; i++) {
			//���� ���� �Ҽ����
			if (eratostenes[i] == false) {
				//���� ����� �Ҽ��� �ƴϹǷ� ��� true üũ( i*i ���� ���ڵ��� i ������ ������ ����� ���� ��������)
				for (int j = i * i; j <= number; j += i) {
					eratostenes[j] = true;
				}
			}
		}
	}

}
