package java8;

import java.util.Scanner;

//���ڿ� ��ȯ
//�Է�- ù�ٿ��� �����ؾ��ϴ� ������ ���� n(n<=50), 
//     ���� n���� �ٿ��� ���� 2������ ����(ù��° ���ڸ� �ι�° ���ڷ� �ٲ�), 
//     ���� ��Ÿ�� ���Ե� ������ ���� ���� m( 1<=m<=100000), 
//     ���� m ���� ����
public class Jungol2518 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, m;
		n = scanner.nextInt();
		String[][] str = new String[n][2];
		for (int i = 0; i < n; i++) {
			str[i][0] = scanner.next();
			str[i][1] = scanner.next();
		}
		
		m = scanner.nextInt();
		String[] text = new String[m];
		for (int i = 0; i < m; i++) {
			text[i] = scanner.next();
		}
		
		changeText(str, text);
	}
	//�Է��� ���� ���� �ð��� �ް��� ���� O(n^2)
	static void changeText(String[][] str, String[] text) {

		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < str.length; j++) {
				if(text[i].equals(str[j][0])){
					text[i]=str[j][1];
					break;
				}
			}
		}
		for(int i = 0 ; i < text.length;i++){
			System.out.print(text[i]);
		}
	}
}
