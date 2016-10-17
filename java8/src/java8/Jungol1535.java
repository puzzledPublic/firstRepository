package java8;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// �ܾ� ����
// ��Ʈ���� �Է� �� ��, ��Ʈ���� �����ϴ� �ܾ�� ��, ���� �ܾ��Ͽ� ������ �Ǿ����� ���� �ܾ �ܾ����� ���� �ڿ� �߰��϶�
// ��Ʈ���� ���� <= 50, �Է� ��Ʈ�� ���� <= 10
// ó������ �ܾ��� ����� �ϳ��� ����.
// �ܾ��� ������ �������� �Ѵ�.
// ��Ʈ���� ��� �Է¹�����, ���α׷��� ������� �ʴ� �̻� ������ �ܾ���� ����� ��� �����ȴ�. 
// ��Ͽ� �ܾ ���� ��� �ܾ ����� ���� �ڿ� �߰��ϰ�, ������� �߰����� �ʴ´�.
// �ܾ��Ͽ��� �ԷµǴ� ������� ����ȴ�.
// ���ĺ� ��.�ҹ��ڴ� ���еȴ�(�ٸ���).
public class Jungol1535 {
	
	static StringBuilder sb = new StringBuilder();
	static Set<String> independentWord = new TreeSet<String>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text;
		while(true){
			text = scanner.nextLine();
			if(text.equals("END")){
				break;
			}
			insertWord(text);
		}
	}
	static void insertWord(String text){
		String[] words = text.split(" ");
		
		for(int i = 0 ; i < words.length; i++){
			if(!independentWord.contains(words[i])){
				independentWord.add(words[i]);
				sb.append(words[i]);
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}
