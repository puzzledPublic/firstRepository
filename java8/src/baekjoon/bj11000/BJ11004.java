package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//K번째 수 //quick select(quick정렬 기반)으로 푸는 문제
public class BJ11004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(arr, 0, n - 1);
		bw.write(arr[k - 1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//quick select
	static void solve2() {
		
	}
	
	//병합정렬. (가까스로 성공)
	static void solve(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			solve(arr, start, mid);
			solve(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	
	static void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int a = start;
		int b = mid + 1;
		int i = 0;
		while(a <= mid && b <= end) {
			if(arr[a] < arr[b]) {
				temp[i++] = arr[a++];
			}else {
				temp[i++] = arr[b++];
			}
		}
		if(a > mid) {
			while(b <= end) {
				temp[i++] = arr[b++];
			}
		}else {
			while(a <= mid) {
				temp[i++] = arr[a++];
			}
		}
		for(int k = 0; k < temp.length; k++) {
			arr[start++] = temp[k];
		}
	}
}
