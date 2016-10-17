package java8;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//�ܾ� ����
//���ڿ��� �Է� �޾� �������� ���еǴ� �ܾ���� ���� �ܾ���� ������ ����϶�
public class Jungol1516 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text;
		while(true){
			text = scanner.nextLine();
			if(text.equals("END")){
				break;
			}
			countWord(text);
		}
	}

	static void countWord(String text) {
		String[] words = text.split(" ");
		Map<String, Integer> wordMap = new TreeMap<String, Integer>();

		for (int i = 0; i < words.length; i++) {
			if (wordMap.containsKey(words[i])) {
				wordMap.put(words[i], wordMap.get(words[i]) + 1);
			} else {
				wordMap.put(words[i], 1);
			}
		}

		for (String str : wordMap.keySet()) {
			System.out.println(str + " : " + wordMap.get(str));
		}
	}
}
