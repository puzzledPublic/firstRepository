package java8;

import java.util.Scanner;

//��������
//������ ����(10 <= ���� <=1000)�� ������, �Ķ���, ������� ��ġ�� ���� 2���� �־�����.(��ġ�� ���� ��ġ�� �ʴ´�.)
//�̶� �� - �� - ���� ������ ������ �´ݰ� ���ڸ� ���´ٸ� ������ ���̴� ������ ���϶�
public class Jungol1112 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double rulerLength;
		//���� ó�� ���� �Է�
		rulerLength = scanner.nextInt();
		//������ ��ġ �迭
		double[][] dots = new double[3][2];
		//������ ��ġ �Է� dots[0] = ��, dots[1] = ��, dots[2] = ��
		for (int i = 0; i < dots.length; i++) {
			dots[i][0] = scanner.nextDouble();
			dots[i][1] = scanner.nextDouble();
		}
		//��-��-�� ������ ����
		for (int i = 0; i < dots.length; i++) {
			//���� ��ġ�� ������ �´�� �ִ� ���̹Ƿ� ����
			if (dots[i][0] != dots[i][1]) {
				//���� ���� �ش�Ǵ� ������ �߾� ��ġ ���
				double middle = (dots[i][0] + dots[i][1]) / 2;
				//System.out.println(rulerLength + " " + middle + " "
				//		+ dots[i][0] + " " + dots[i][1]);
				//�߾� ��ġ�� �������� ������ �� ª����(��ġ�� ������ 0�� �ƴϹǷ� 0���� �����ֱ� ���� ������ �κ� ���� ���ʰ� ������ �Ѵ� ������ �ʿ���)
				if (middle < rulerLength - middle) {
					//���� ���� ���Ŀ� Ž���� ���� �� ��ġ�� �����Ѵ�.
					for (int j = i + 1; j < dots.length; j++) {
						for (int k = 0; k < dots[0].length; k++) {
							//�߾� ��ġ���� ū ��ġ���� 0�� �������� �����ش�
							if (dots[j][k] > middle) {
								dots[j][k] = dots[j][k] - middle;
							}
							//���� ��ġ�鵵 ��ġ ����
							else {
								dots[j][k] = middle - dots[j][k];
							}
						}
					}
					//���� ���̸� ���δ�
					rulerLength -= middle;
				}
				//�߾� ��ġ�� �������� �������� �� ª����(������ġ�� 0�̹Ƿ� ������ �κ� ���� �����ʸ� ���� ���ָ� ��)
				else {
					for (int j = i + 1; j < dots.length; j++) {
						for (int k = 0; k < dots[0].length; k++) {
							//�߾� ��ġ���� ū ��ġ���� �����Ѵ�
							if (dots[j][k] > middle) {
								dots[j][k] = middle - (dots[j][k]-middle);
							}
						}

					}
					//���� ���̸� ���δ�
					rulerLength = middle;
				}
			}
		}
		//���� ���� ���
		System.out.println(rulerLength);
	}
}
