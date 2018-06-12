package java8;

//블록 제거
//result =  14, 15, 75, 24
public class KakaoRe6 {
	static int[] m = {4, 6, 5, 5};	//높이
	static int[] n = {5, 6, 15, 6};	//폭
	static String[][] board = {
		{"CCBDE", "AAADE", "AAABF", "CCBBF"},	
		{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"},
		{"AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA"},
		{"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"}
	};
	static int[][] checkMat = {{0,1}, {1,0}, {1,1}};
	
	public static void main(String[] args) {
		System.out.println(solve(m[1],n[1],board[1]));
	}
	
	static int solve(int m, int n, String[] board) {
		char[][] gameBoard = new char[m][];
		int[][] copyBoard = new int[m][n];
		
		for(int i = 0; i < board.length; i++) {
			gameBoard[i] = board[i].toCharArray();
		}
		
		int count = 0, result = 0;
		
		while(true) {
			//gameboard에서 2x2사각형이 지워지는 경우 copyboard에 체크
			for(int i = 0; i < m - 1; i++) {
				for(int j = 0;  j < n - 1; j++) {
					char currentCharacter = gameBoard[i][j];
					if(currentCharacter == ' ') {
						continue;
					}
					for(int k = 0; k < checkMat.length; k++) {
						if(currentCharacter != gameBoard[i + checkMat[k][0]][j + checkMat[k][1]]) {
							break;
						}
						count++;
					}
					if(count == 3) {
						copyBoard[i][j] = 1;
						for(int k = 0; k < checkMat.length; k++) {
							copyBoard[i + checkMat[k][0]][j + checkMat[k][1]] = 1;
						}
					}
					count = 0;
				}
			}
			//체크 결과 출력 (디버깅용)
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(gameBoard[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < n; j++) {
					System.out.print(copyBoard[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			//체크 결과에 따라 블록 제거
			for(int i = m - 1; i >= 0; i--) {
				for(int j = 0; j < n; j++) {
					if(copyBoard[i][j] == 1) {
						if(i != m - 1 && copyBoard[i+1][j] == 1) {
							continue;
						}
						int alpha = 1;
						gameBoard[i][j] = ' ';
						while(i - alpha >= 0 && copyBoard[i - alpha][j] == 1) {
							gameBoard[i - alpha][j] = ' ';
							alpha++;
						}
						for(int k = i - alpha; k >= 0; k--) {
							gameBoard[k + alpha][j] = gameBoard[k][j];
							gameBoard[k][j] = ' ';		
						}
					}
				}
			}
			//copyboard에서 사라진 블록 수 계산
			int compareResult = result;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(copyBoard[i][j] == 1) {
						result++;
						copyBoard[i][j] = 0;
					}
				}
			}
			//사라진 블록이 없으면 종료
			if(compareResult == result) {
				break;
			}
		}
		
		return result;
	}
}
