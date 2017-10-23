package java8;
//노드 간의 거리 (문제해결을 위한 창의적 알고리즘)
public class AfcDistanceOfNodes {
	public static void main(String[] args) {
		System.out.println(solve(200000,342));
	}
	
	static int solve(int a, int b){
		
		if(a == b){
			return 0;
		}
		int ret = 0;
		if(a > b){
			ret = solve(a / 2, b) + 1;
		}
		if(a < b){
			ret = solve(a, b / 2) + 1;
		}
		return ret;
	}
}
