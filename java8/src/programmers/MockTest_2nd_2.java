package programmers;

import java.util.Arrays;
//서울시에 일직선 모양의 새로운 도로가 생겼습니다. 새로운 도로의 전체 길이는 l이고 도로에는 총 n개의 가로등이 세워졌습니다. 이 도로의 모든 가로등에 전구를 사서 달려고 합니다. 전구를 선택하는 기준은 다음과 같습니다.
//
//전구는 길의 좌측, 우측 방향으로 각각 d 길이만큼 길을 밝힐 수 있고, d는 자연수입니다.
//모든 가로등에는 같은 종류(d 값이 같은)의 전구를 달아야 합니다.
//안전을 위하여 도로위에 어두운 부분이 있어서는 안 됩니다.
//이때, d 값이 충분히 크다면 전체 도로를 밝게 비출 수 있지만, d 값이 작아진다면 도로 위에 빛이 닿지 않는 부분이 생길 수도 있습니다. 따라서, 도로 위에 어두운 부분이 생기지 않도록 하는 d 값 중 최솟값을 구하려고 합니다. 전체 도로의 길이 l, 가로등이 세워져 있는 위치가 들어있는 배열 v가 매개변수로 주어질 때, 위의 모든 조건을 만족하는 d 의 최솟값을 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//l은 1 이상 1,000,000,000 이하의 자연수입니다.
//v에는 가로등의 위치정보가 들어있습니다.
//가로등의 위치는 0 이상 l 이하의 정수이며, 같은 위치에 2개 이상의 가로등이 있는 경우는 주어지지 않습니다.
//가로등의 개수는 1이상 1,000 이하의 자연수입니다.
public class MockTest_2nd_2 {
	public static void main(String[] args) {
		int[] l = {15, 5, 10};
		int[][] v = {
				{15, 5, 3, 7, 9, 14, 0},
				{2, 5},
				{1, 2}
		};
		
		for(int i = 0; i < l.length; i++) {
			System.out.println(solution(l[i], v[i]));
			System.out.println();
		}
	}
	static int solution(int l, int[] v) {
        int answer = 0;
        Arrays.sort(v);
        int start = 1, end = l;
        int mid = 0;
        while(start < end) {
        	mid = (start + end) / 2;
        	int p = 0;
        	boolean possible = true;
        	for(int i = 0; i < v.length; i++) {
        		if(p >= v[i] - mid) {
        			p = v[i] + mid;
        		}else {
        			possible = false;
        			break;
        		}
        	}
        	if(v[v.length - 1] + mid < l) {
        		possible = false;
        	}
        	if(possible) {
        		end = mid;
        	}else {
        		start = mid + 1;
        	}
        }
        return answer = end;
    }
}
