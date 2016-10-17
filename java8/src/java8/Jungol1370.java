package java8;

import java.util.Arrays;
import java.util.Scanner;

//회의실 배정
//회의실이 하나만 있고 여러 회의들이 존재할때 최대한 많은 회의들을 하고 싶다. 최대 회의 개수와 회의 번호들을 출력하라
//입력 회의의 수 N (5<= N <=500), n번의 회의 번호와 시작시간, 종료시간이 주어진다.
//idea: 회의시간들을 끝나는 시간들로 오름차순 정렬하여 끝나는 시간이 가장 빠른 회의들을 선택하여 나가면 최대 회의 수를 구할 수 있다.
public class Jungol1370 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		int[] meetOrder = new int[n];
		MeetTime[] mt = new MeetTime[n];

		for (int i = 0; i < n; i++) {
			mt[i] = new MeetTime();
		}

		for (int i = 0; i < n; i++) {
			mt[i].num = scanner.nextInt();
			mt[i].beginTime = scanner.nextInt();
			mt[i].endTime = scanner.nextInt();
		}
		//람다 이용 정렬
		// Arrays.sort(mt,(a,b)->{ return Integer.compare(a.endTime,
		// b.endTime);});
		//comparable 구현한 객체를 정렬
		Arrays.sort(mt);
		int earliest = 0, selected = 0;
		//모든 회의들을 탐색
		for (int i = 0; i < mt.length; i++) {
			//각 회의의 시작, 끝시간
			int meetingBegin = mt[i].beginTime;
			int meetingEnd = mt[i].endTime;
			//만일 바로 전의 회의 끝 시간이 지금 회의시간 보다 작다면
			if (earliest <= meetingBegin) {
				//지금 회의 끝 시간을 비교할 변수에 넣어주고
				earliest = meetingEnd;
				//가능한 회의 배열에 추가
				meetOrder[selected++] = mt[i].num;
			}
		}
		System.out.println(selected);
		for (int i = 0; i < selected; i++) {
			System.out.print(meetOrder[i] + " ");
		}
	}
}

class MeetTime implements Comparable<MeetTime> {
	int num;
	int beginTime;
	int endTime;

	@Override
	public int compareTo(MeetTime o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.endTime, o.endTime);
	}
}
