package java8;

import java.util.Scanner;

//����
//5x5 ���� ���̺��� �־����� ȣ��Ǵ� ���ڿ��� ������ ���� ��ġ�� ������ȣ�� ����϶�
//����� 3���� �ҷ����ٸ� ���� ��ģ��.
public class Jungol1031 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int bingoTable[][] = new int[5][5];
		int numbers[] = new int[25];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingoTable[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < 25; i++) {
			numbers[i] = scanner.nextInt();
		}
		bingo(bingoTable, numbers);
	}
	//5x5�� �����ż� �ϳ��� �ҷ����� ���� ������ ��ü�� �˻��غ�
	static void bingo(int[][] bingoTable, int[] numbers) {
		//������ �������� Ȯ���� ����
		int count = 0;
		//3�� �̻� �������� Ȯ���� ����
		int bingoCount = 0;
		for (int k = 0; k < numbers.length; k++) {
			for (int i = 0; i < bingoTable.length; i++) {
				for (int j = 0; j < bingoTable[0].length; j++) {
					if(bingoTable[i][j] == numbers[k]){
						bingoTable[i][j] = 0;
						break;
					}
				}
			}
			for(int i = 0 ; i < bingoTable.length; i++){
				for(int j = 0 ; j < bingoTable[0].length;j++){
					if(bingoTable[j][i]==0){
						count++;
					}
				}
				if(count==5){
					bingoCount++;
				}
				count = 0;
				for(int j = 0 ; j < bingoTable[0].length;j++){
					if(bingoTable[i][j]==0){
						count++;
					}
				}
				if(count==5){
					bingoCount++;
				}
				count = 0;
			}
			for(int j = 0;j < bingoTable[0].length;j++){
				if(bingoTable[j][j] == 0){
					count++;
				}
			}
			if(count==5){
				bingoCount++;
			}
			count = 0;
			for(int j = 0;j < bingoTable[0].length;j++){
				if(bingoTable[j][bingoTable[0].length-1-j] == 0){
					count++;
				}
			}
			if(count==5){
				bingoCount++;
			}
			count = 0;
			if(bingoCount >2){
				System.out.println(k+1);
				break;
			}
			bingoCount =0;
		}
	}
}
