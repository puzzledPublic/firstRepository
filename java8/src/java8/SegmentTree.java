package java8;

//세그먼트 트리
public class SegmentTree {
	int[] segmentArr;	//세그먼트 트리
	int length;	//데이터 배열의 길이
	public SegmentTree(int[] arr, int n) {
		segmentArr = new int[n * 4];
		this.length = n;
		init(arr, 0, n - 1, 1);
	}
	//초기화
	int init(int[] arr, int left, int right, int node) {
		if(left == right) {
			return segmentArr[node] = arr[left];
		}
		int mid = (left + right) / 2;
		return segmentArr[node] = Math.min(init(arr, left, mid, node * 2), init(arr, mid + 1, right, node * 2 + 1));
	}
	//쿼리
	private int query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(left > nodeRight || right < nodeLeft) {
			return 987654321;
		}
		if(left <= nodeLeft && right >= nodeRight) {
			return this.segmentArr[node];
		}
		int mid = (nodeLeft + nodeRight) / 2;
		return Math.min(query(left, right, node * 2, nodeLeft, mid), query(left, right, node * 2 + 1, mid + 1, nodeRight));
	}
	int query(int left, int right) {
		return this.query(left, right, 1, 0, this.length - 1);
	}
	//갱신
	private int update(int index, int value, int node, int nodeLeft, int nodeRight) {
		if(index < nodeLeft || index > nodeRight) {
			return this.segmentArr[node];
		}
		if(nodeLeft == nodeRight) {
			return this.segmentArr[node] = value;
		}
		int mid = (nodeLeft + nodeRight) / 2;
		return this.segmentArr[node] = Math.min(update(index, value, node * 2, nodeLeft, mid), update(index, value, node * 2 + 1, mid + 1, nodeRight));
		
	}
	int update(int index, int value) {
		return update(index, value, 1, 0, this.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 3, 7, 9, 6, 4, 1, 2, 1};
		SegmentTree st = new SegmentTree(arr, arr.length);
	}
}
