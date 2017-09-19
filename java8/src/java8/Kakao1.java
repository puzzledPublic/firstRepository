package java8;

import java.util.Scanner;

public class Kakao1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		solution(6, arr1, arr2);
	}
	public static String[] solution(int n, int[] arr1, int[] arr2){
		String[] answer = new String[arr1.length];
		int[] temp = new int[arr1.length];
		String[] str = new String[arr1.length];
		for(int i = 0 ; i < arr1.length; i++){
			temp[i] = arr1[i] | arr2[i];
			str[i] = Integer.toBinaryString(temp[i]);
		}
		
		for(int i = 0; i < str.length; i++){
			if(str[i].length() != n){
				for(int j = str[i].length(); j < n; j++){
					str[i] = "0" + str[i];
				}
			}
			answer[i] = str[i].replaceAll("1", "#").replaceAll("0", " ");
		}
		for(int i = 0 ; i < arr1.length; i++){
			System.out.println(answer[i]);
		}
		
		return answer;
	}
}
