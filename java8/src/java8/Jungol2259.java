package java8;

import java.util.Scanner;

//���ܹ�
// ���ڷ� ���� ���ܹ��� �ִ�. �� ���� 90, 180 270���� ȸ���� ������ ���� �ִ�.
// ���ܹ��� ������ �𼭸����� ����Ͽ� �ݽð� �������� ���� ������� �ٽ� ���ƿ����� ���ܹ翡 ���� �� �ִ� �� ������ ���� ���϶�.
// �Է�: ù���� �ٿ� 1m^2�� �ڶ�� ���� ���� K (1 <= K <=20),
//      ���ܹ� ������ �𼭸����� ����Ͽ� �ٽ� ����������� ���ƿ��� ����(��:1, ��:2, ��:3, ��:4)��, ���� ����(1 <= <=500)���� �־�����.
public class Jungol2259 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//1m^2�� ���� ����
		int orientalMelonPerSpace;
		orientalMelonPerSpace = scanner.nextInt();
		//������ ���� �迭
		int[] direction = new int[6];
		//�� ���� ���̸� ���� �迭
		int[] lengths = new int[6];
		//������� ������ ���� �迭
		int[] dirNumbers = new int[5];
		//����� ���� ���� �Է�
		for(int i = 0 ; i < 6; i++){
			direction[i] = scanner.nextInt();
			lengths[i] = scanner.nextInt();
		}
		//������� ������ ���
		for(int i = 0 ; i < direction.length;i++){
			dirNumbers[direction[i]]++;
		}
		//�ܰ� �簢��
		int outerRect = 1;
		//���� �簢��
		int innerRect = 1;
		//������� �������� ����
		for(int i = 1 ; i < dirNumbers.length; i++){
			//������ ������ 1�̸� �ܰ� �簢���� ����,�ʺ� ����Ѵ� (idea:�� ���ܹ��� �������� �߿� 1������ 2�� ����, 2������ 2�� ����(�� 6���� ��)�� ���´�)
			if(dirNumbers[i] == 1){
				//���⿡ ���� ���� ���̸� ã�� outerRect�� ���Ѵ�.
				for(int j = 0 ; j < direction.length; j++){
					if(direction[j] == i){
						outerRect *= lengths[j];
					}
				}
				//���� �簢���� ���ϱ� ���� direction �迭�� Ž��
				for(int j = 0; j < direction.length; j++){
					//���� ����� ���� ������ ������ ������ 1�̶�� ���� ���⿡�� 3�� ���Ŀ� 4�� ������ ���� ���� �簢���� ����, �ʺ� ������ �Ѵ�.
					if(direction[j] == i && dirNumbers[direction[(j+1)%6]] == 1){
						innerRect = lengths[(j+3)%6] * lengths[(j+4)%6];
						break;
					}
					//���� ������ ������ ������ 1�� �ƴ϶��(2���) ���� ���⿡�� 2�� ���Ŀ� 3�� ������ ���� ���� �簢���� ����, �ʺ� ������ �Ѵ�.
					else if(direction[j] == i && dirNumbers[direction[(j+1)%6]] != 1){
						innerRect = lengths[(j+2)%6] * lengths[(j+3)%6];
						break;
					}
					//System.out.println(outerRect +" "+ innerRect);
				}
			}
		}//System.out.println(outerRect +" "+ innerRect);
		//�ܰ� �簢�� ���̿��� ���� �簢�� ���̸� ���� ���ܹ� ���̰� ������ ���⿡ 1m^2�� ���� ������ ���ϸ� ���� ���
		System.out.println((outerRect - innerRect)*orientalMelonPerSpace);
	}
}
