package java8;

import java.util.Scanner;

//������
public class Jungol2074 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int n;
		// �Է�
		n = scanner.nextInt();
		// �Է� üũ
		if (n < 2 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		// ���
		magicSquare(n);
	}

	static void magicSquare(int n) {
		// �迭 ����
		int mSquare[][] = new int[n][n];
		// �迭 ��ġ�� ��Ÿ�� ��ǥ �� (���� ��ġ�� ù��, �߰���)
		int x = 0, y = n / 2;
		// �迭�� ���� ���� (1���� ����)
		int count = 1;
		//���ڰ� �迭�� �� ä�ﶧ����
		while (count <= n * n) {
			//���ڸ� �迭�� �ְ�
			mSquare[x][y] = count;
			//���� ���ڰ� n�� ����� �Ʒ���
			if (count % n == 0) {
				x++;
			}
			//�ƴ϶��
			else {
				//��������
				x--;
				y--;
				//���� �迭�� ������ �Ѿ�� ��ǥ ����
				if (x < 0) {
					x = n-1;
				}
				if (y < 0) {
					y = n-1;
				}
			}
			//���� ����
			count++;

		}
		
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < n; j++){
				System.out.print(mSquare[i][j]+" ");
			}
			System.out.println();
		}
	}
}
