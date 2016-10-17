package java8;

import java.util.Scanner;

//����(�⵵ ������ ������ ������ ���϶�)
//startYear = ���۳⵵, endYear = �������⵵
//startYear + 1 ~ endYear������ ������ ������?
//������ 4�� �������� 100���� �������� �ʰų� 400���� �������� �⵵�� ���Ѵ�.
public class Jungol2085 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int startYear, endYear;
		endYear = scanner.nextInt();
		startYear = scanner.nextInt();

		leapYear(startYear, endYear);
	}

	static void leapYear(int startYear, int endYear) {
		int count = 0;
		int fixedYear = 0;
		//������ Ȧ���� ���� �⺻������ 4�� ����̹Ƿ� startYear�� 4�� ����� �ٲ��ش� => fixedYear
		fixedYear = startYear+(4-startYear%4);
		//startYear + 1���� fixedYear������ ������ ���Ѵ�
		for (int i = startYear+1; i < fixedYear; i++) {
			if ( i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
				count++;
			}
		}
		//fixedYear���� endYear���� 4�ǹ���� �⵵���� ���� ������ ���Ѵ�
		for (int i = fixedYear; i <= endYear; i+=4) {
			if ( i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
				count++;
			}
		}
		//���� ���� ���
		System.out.println(count);
	}
}
