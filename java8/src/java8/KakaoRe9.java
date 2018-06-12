package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//파일명 정렬
//result
//["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
//["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]

public class KakaoRe9 {
	static String[][] inputs= {
		{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
		{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}
	};
	static List<FileName> files = new ArrayList<>();
	
	public static void main(String[] args) {
		
		for(int i = 0; i < inputs.length; i++) {
			solve(inputs[i]);
			files.clear();
		}
	}
	
	static void solve(String[] fileNames) {
		int n = 0, t = 0;
		for(int i = 0; i < fileNames.length; i++) {
			for(int j = 0; j < fileNames[i].length() - 1; j++) {
				char prev = fileNames[i].charAt(j);
				char next = fileNames[i].charAt(j + 1);
				
				if((prev < '0' || prev > '9') && (next > '0' && next < '9')) {
					n = j + 1;
				}
				else if((prev > '0' && prev < '9') && (next < '0' || next > '9')) {
					t = j + 1;
					break;
				}
			}
			files.add(new FileName(fileNames[i].substring(0, n), fileNames[i].substring(n, t), fileNames[i].substring(t, fileNames[i].length())));
		}
		
		Collections.sort(files, (a, b) -> {
			int result = a.head.compareToIgnoreCase(b.head);
			if(result == 0) {
				int an = Integer.parseInt(a.number);
				int bn = Integer.parseInt(b.number);
				return Integer.compare(an, bn);
			}
			return result;
		});
		
		files.stream().forEach((filename) -> { System.out.print(filename.toString() + " ");});
		System.out.println();
	}
}

class FileName{
	String head;
	String number;
	String tail;
	public FileName(String head, String number, String tail) {
		this.head = head;
		this.number = number;
		this.tail = tail;
	}
	@Override
	public String toString() {
		return this.head + this.number + this.tail;
	}
}
