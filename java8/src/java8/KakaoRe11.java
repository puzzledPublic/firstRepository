package java8;

//자동완성
public class KakaoRe11 {
	static String[][] words= {
		{"go", "gone", "guild"},
		{"abc", "def", "ghi", "jklm"},
		{"word", "war", "warrior", "world"},
		{"zzz", "zzzz"}
	};
	//트라이
	static class Trie {
		Trie[] tries = new Trie[26];
		boolean terminal;
		int stack = 0;	//접두어 구분하기 위한 변수 (이것이 1이라면 이후에 검색할 필요가 없음)
		//삽입 함수
		public void insert(String key) {
			if(key.isEmpty()) {
				terminal = true;
				return;
			}
			int number = toNumber(key.charAt(0));
			if(tries[number] == null) {
				tries[number] = new Trie();
			}
			tries[number].stack++;
			tries[number].insert(key.substring(1));
			
		}
		//해당 검색시 사용하는 단어 횟수 구하는 함수
		public int calcSearchTime(String key) {
			if(key.isEmpty() || this.stack == 1) {
				return 1;
			}
			int next = toNumber(key.charAt(0));
//			if(tries[next] == null) {
//				return 0;
//			}
			return tries[next].calcSearchTime(key.substring(1)) + 1;
		}
		public int toNumber(char c) {
			return c - 'a';
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < words.length; i++) {
			solve(words[i]);
		}
	}
	
	static void solve(String[] word) {
		Trie trie = new Trie();
		for(int i = 0; i < word.length; i++) {
			trie.insert(word[i]);
		}
		int result = 0;
		for(int i = 0; i < word.length; i++) {
			int temp = trie.calcSearchTime(word[i]) - 1;
			result += temp;
		}
		System.out.println(result);
	}
}
