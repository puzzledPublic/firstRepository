package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BingoPloblem1031 {

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		int table[][] = new int[5][5];
		int call[] = new int[25];
		for(int i = 0 ; i < 5 ; i++)
		{
			for(int j = 0 ; j < 5 ; j++)
			{
				table[i][j] = input.nextInt();
			}
		}
		for(int i = 0 ; i < 25 ; i++)
		{
			call[i] = input.nextInt();
		}
		int bingo = 0;
		while(bingo!=3)
		{
			
		}
		
		
	}
}
