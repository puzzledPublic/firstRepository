package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//물통
public class BJ2251 {
	static class BowlState {
		int A, B, C;
		BowlState(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		boolean[][] isVisitedAtState = new boolean[A + 1][B + 1];
		List<Integer> list = new ArrayList<>();
		Queue<BowlState> queue = new LinkedList<>();
		
		queue.add(new BowlState(0, 0, C));
		while(!queue.isEmpty()) {
			BowlState bs = queue.poll();
			if(isVisitedAtState[bs.A][bs.B]) {
				continue;
			}
			isVisitedAtState[bs.A][bs.B] = true;
			if(bs.A == 0) {
				list.add(C - bs.B);
			}
			if(bs.A > 0) {
				if(B < bs.A + bs.B) {	//A -> B
					queue.add(new BowlState(bs.A - (B - bs.B), B, bs.C));
				}else {
					queue.add(new BowlState(0, bs.A + bs.B, bs.C));
				}
				if(C < bs.A + bs.C) {	//A -> C
					queue.add(new BowlState(bs.A - (C - bs.C), bs.B, C));
				}else {
					queue.add(new BowlState(0, bs.B, bs.A + bs.C));
				}
			}
			if(bs.B > 0) {
				if(A < bs.B + bs.A) {	//B -> A
					queue.add(new BowlState(A, bs.B - (A - bs.A), bs.C));
				}else {
					queue.add(new BowlState(bs.B + bs.A, 0, bs.C));
				}
				if(C < bs.B + bs.C) {	//B -> C
					queue.add(new BowlState(bs.A, bs.B - (C - bs.C), C));
				}else {
					queue.add(new BowlState(bs.A, 0, bs.B + bs.C));
				}
			}
			if(bs.C > 0) {	//C -> A
				if(A < bs.C + bs.A) {
					queue.add(new BowlState(A, bs.B, bs.C - (A - bs.A)));
				}else {
					queue.add(new BowlState(bs.A + bs.C, bs.B, 0));
				}
				if(B < bs.C + bs.B) {	//C -> B
					queue.add(new BowlState(bs.A, B, bs.C - (B - bs.B)));
				}else {
					queue.add(new BowlState(bs.A, bs.C + bs.B, 0));
				}
			}
		}
		Collections.sort(list);
		for(int i : list) {
			bw.write(i + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
