package MAIN;

import java.util.Arrays;

public class LONGEST_ARITHMETIC_PROGRESSION {

	public int solve(final int[] A) {
	    if(A.length < 3)
	    	return A.length;
	    
		Arrays.sort(A);
		for (int item : A)
			System.out.print(item + " ");
		System.out.println();
		int N = A.length;
		int[][] dp = new int[N][N];
		int i, j, k, longestAp = 2;

		for (int a = 0; a < A.length; a++)
			dp[a][N - 1] = 2;

		for (j = N - 2; j > 0; j--) {
			i = j - 1;
			k = j + 1;
			while (i >= 0 && k < N) {
				int middle = 2 * A[j];
				int sides = A[i] + A[k];
				if (middle > sides)
					k++;
				else if (middle < sides) {
					dp[i][j] = 2;
					i--;
				}
				else {
					dp[i][j] = 1 + dp[j][k];
					longestAp = Math.max(longestAp, dp[i][j]);
					i--;
					k++;
				}
			}

			while (i >= 0) {
				dp[i][j] = 2;
				i--;
			}

			print2dArray(dp);
		}
		return longestAp;
	}

	public static void main(String[] args) {
//		System.out.println(new LONGEST_ARITHMETIC_PROGRESSION().solve(new int[] { 1, 7, 10, 15, 27, 29 }));
//		System.out.println(new LONGEST_ARITHMETIC_PROGRESSION().solve(new int[] { 5, 10, 15, 20, 25, 30 }));
//		System.out.println(new LONGEST_ARITHMETIC_PROGRESSION().solve(new int[] { 100, 10, 8, 300, 6, 1, 4, 2 }));
		System.out.println(new LONGEST_ARITHMETIC_PROGRESSION().solve(new int[] { 1, 2, 4, 6, 8, 10, 100, 300 }));
	}

//	
	{

//	static int lenghtOfLongestAP(int set[], int n) {
//		if (n <= 2)
//			return n;
//
//		// Create a table and initialize all
//		// values as 2. The value ofL[i][j] stores
//		// LLAP with set[i] and set[j] as first two
//		// elements of AP. Only valid entries are
//		// the entries where j>i
//		int L[][] = new int[n][n];
//
//		// Initialize the result
//		int llap = 2;
//
//		// Fill entries in last column as 2.
//		// There will always be two elements in
//		// AP with last number of set as second
//		// element in AP
//		for (int i = 0; i < n; i++)
//			L[i][n - 1] = 2;
//
//		// Consider every element as second element of AP
//		for (int j = n - 2; j >= 1; j--) {
//			// Search for i and k for j
//			int i = j - 1, k = j + 1;
//			while (i >= 0 && k <= n - 1) {
//				if (set[i] + set[k] < 2 * set[j])
//					k++;
//
//				// Before changing i, set L[i][j] as 2
//				else if (set[i] + set[k] > 2 * set[j]) {
//					L[i][j] = 2;
//					i--;
//
//				}
//
//				else {
//					// Found i and k for j, LLAP with i and j as first two
//					// elements is equal to LLAP with j and k as first two
//					// elements plus 1. L[j][k] must have been filled
//					// before as we run the loop from right side
//					L[i][j] = L[j][k] + 1;
//
//					// Update overall LLAP, if needed
//					llap = Math.max(llap, L[i][j]);
//
//					// Change i and k to fill
//					// more L[i][j] values for current j
//					i--;
//					k++;
//				}
//				print2dArray(L);
//			}
//
//			// If the loop was stopped due
//			// to k becoming more than
//			// n-1, set the remaining
//			// entties in column j as 2
//			while (i >= 0) {
//				L[i][j] = 2;
//				i--;
//			}
//		}
//		return llap;
	}

	public static void print2dArray(int[][] A) {
		System.out.println();
		for (int[] arr : A) {
			for (int item : arr)
				System.out.print(item + " ");
			System.out.println();
		}
		System.out.println();
	}

}