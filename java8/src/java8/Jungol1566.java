package java8;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//�Ҽ����ڿ�
//���ڿ��� �Է� �ް�, �� ���ڿ� �� � �� ���ڶ� �߻��󵵰� �Ҽ��� �����ϸ� �̴� �Ҽ����ڿ��̶�� �Ѵ�
//10,000 ������ ���ڿ��� �Էµȴ�. ���ڿ��� ���ĺ� �빮�ڸ� �����ȴ�.
//�Է¿� ���ؼ� �ش� ���ڿ��� �Ҽ����ڿ��� �ƴ� ��� "NONE"�� ����ϸ� �Ҽ����ڿ��� ��� �Ҽ����ڿ��� �̷�� ������ִ� ���ڸ� ���������� �� �ٿ� ������� ����Ѵ�.
public class Jungol1566 {
	static boolean eratostenes[] = new boolean[10005];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text;
		text = scanner.next();
		//�����佺�׳׽� ü
		eratos(10000);
		primeText(text);
	}

	static void primeText(String text) {
		//Ʈ�� �� ����
		Map<Character, Integer> wordCounter = new TreeMap<Character, Integer>();
		for (int i = 0; i < text.length(); i++) {
			char word = text.charAt(i);
			//���ڰ� Ʈ���� �̹� �ִٸ�
			if (wordCounter.containsKey(word)) {
				//���� ����
				wordCounter.put(word, wordCounter.get(word) + 1);
			} else {
				//�ƴ϶�� 1�� �־��ش�
				wordCounter.put(word, 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		//���ڵ��� �������� ����
		for (char word : wordCounter.keySet()) {
			int c = wordCounter.get(word);
			//������ �Ҽ����
			if(eratostenes[c] == false){//if (c != 1 && isPrime(c)) {
				//�ش� ���ڵ� ����
				sb.append(word);
			}
		}
		//����Ȱ� ������ NONE
		if(sb.length()==0){
			System.out.println("NONE");
		}else{
			//�ִٸ� �Ҽ����ڿ� ���
			System.out.println(sb);
		}
	}
	/*
	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}*/
	static void eratos(int number){
		eratostenes[1] = true;
		for(int i = 2; i*i<=number;i++){
			if(eratostenes[i] == false){
				for(int j = i*i; j<=number;j+=i){
					eratostenes[j] = true;
				}
			}
		}
	}
}
