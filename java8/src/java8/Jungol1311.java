package java8;

import java.util.Arrays;
import java.util.Scanner;

//카드게임(not yet)
public class Jungol1311 {
	enum color {
		R(1), B(2), Y(3), G(4);
		private int value;

		private color(int value) {
			this.value = value;
		}
	};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		int highestNumber, lowestNumber;
		int sameColorCount, sameNumberCount = 0;
		int numbers[] = new int[10];
		int colors[] = new int[5];
		Arrays.fill(numbers, 0);
		Arrays.fill(colors, 0);
		for (int i = 0; i < 5; i++) {
			colors[color.valueOf(scanner.next()).value]++;
			numbers[scanner.nextInt()]++;
		}
		for(int i = 1; i<colors.length; i++)
		{
			if(colors[i]==5){
				sameColorCount = colors[i];
				break;
			}
		}
		for(int i = 1; i<numbers.length; i++)
		{
			if(numbers[i]!=0){
				sameNumberCount += numbers[i];
			}
		}
		
		
	}
}
