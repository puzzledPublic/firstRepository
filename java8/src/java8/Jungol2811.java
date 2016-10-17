package java8;

import java.util.Scanner;

/*�Ҽ��� �ռ���
 �Ҽ�: 1���� ū �ڿ��� �� 1�� �ڱ� �ڽ�, �� ������ ����� ���� ��
 �ռ���: 1���� ū �ڿ��� �� �Ҽ��� �ƴ� ��, 3�� �̻��� ����� ���� ��
 1�� �Ҽ��� �ռ����� �ƴϴ�.
 10�� ������ 5���� ���� �Է� �޾� �Ҽ�, �ռ���, 1 ���� �Ǻ��϶�
 */
public class Jungol2811 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		//�Է� ���� ���� �迭
		int[] number = new int[5];

		//�Է�
		for (int i = 0; i < 5; i++) {
			number[i] = scanner.nextInt();
		}
		//���ڵ��� ����
		for (int i = 0; i < 5; i++) {
			//���ڰ� 1 �̸� �״�� ��� �� ���� ���ڷ�
			if (number[i] == 1) {
				System.out.println("number one");
				continue;
			}
			//�Ҽ���� ���
			else if (isPrimeNumber(number[i])) {
				System.out.println("prime number");
			}
			//�ƹ��͵� �ƴ϶�� �ռ��� ���
			else {
				System.out.println("composite number");
			}
		}
	}
	//�Ҽ����� �ƴ��� �Ǻ��ϴ� �Լ�
	static boolean isPrimeNumber(int n) {
		
		for(int i = 2; i*i<=n;i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}
}
