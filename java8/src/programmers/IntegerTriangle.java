package programmers;
//정수 삼각형
public class IntegerTriangle {
	public static void main(String[] args) {
		int[][] triangle = {
				{7},
				{3,8},
				{8,1,0},
				{2,7,4,4},
				{4,5,2,6,5}
		};
		System.out.println(solution(triangle));
	}
	
	static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++) {
        	dp[i][0] = dp[i - 1][0] + triangle[i][0];
        }
        for(int i = 1; i < triangle.length; i++) {
        	for(int j = 1; j <= i; j++) {
        		dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
        	}
        }
        for(int i = 0; i < triangle.length; i++) {
        	answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }
}
