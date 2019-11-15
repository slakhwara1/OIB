package PRAC;

import java.util.Arrays;

public class Solution {
	public int jump(int[] A) {
		int[] memo = new int[A.length];
		Arrays.fill(memo, -1);
		int ans = jumpHelper(memo, A, 0);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

	public int jumpHelper(int[] memo, int[] A, int index) {

		if (index >= A.length - 1)
			return 0;

		if (memo[index] != -1)
			return memo[index];

		int minimumJumps = Integer.MAX_VALUE;

		for (int i = 1; i <= A[index]; i++) {
			minimumJumps = Integer.min(minimumJumps, 1 + jumpHelper(memo, A, index + i));
		}
		memo[index] = minimumJumps;
		return minimumJumps;
	}

	public static void main(String[] args) {
//		int[] A = new int[] { 2, 3, 1, 1, 4 };
		int[] A = new int[] { 33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35,
				37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1,
				21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24,
				16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28 };

		System.out.println(new Solution().jump(A));
	}

}
