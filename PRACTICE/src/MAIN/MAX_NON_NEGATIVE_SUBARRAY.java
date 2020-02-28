package MAIN;

import java.util.ArrayList;
import java.util.Arrays;

public class MAX_NON_NEGATIVE_SUBARRAY {

	static class Model {
		long val;
		int startIndex;
		int endIndex;

		public Model(int val, int startIndex, int endIndex) {
			this.val = val;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}
	}

	public static int[] maxset(int[] A) {
		Model maxSum = new Model(0, 0, 0);
		Model tempSum = new Model(-1, 0, 0);

		for (int i = 0; i < A.length; i++) {
			Model currSum = new Model(A[i], i, i);
			if (currSum.val >= 0) {
				if (tempSum.val == -1)
					tempSum = currSum;
				else {
					tempSum.val += currSum.val;
					tempSum.endIndex++;
				}
			} else if (currSum.val > -1) {
				tempSum.val += currSum.val;
				tempSum.endIndex++;
			} else
				tempSum = new Model(-1, 0, 0);
			if (tempSum.val > maxSum.val)
				maxSum = tempSum;
			else if (tempSum.val == maxSum.val) {
				int segmentLengthTemp = tempSum.endIndex - tempSum.startIndex;
				int segmentLengthMax = maxSum.endIndex - maxSum.startIndex;
				if (segmentLengthMax < segmentLengthTemp)
					maxSum = tempSum;
			}
		}

		if (A[maxSum.startIndex] < 0)
			return new int[] {};

		int size = (maxSum.endIndex - maxSum.startIndex) + 1;
		int[] result = new int[size];
		int start = maxSum.startIndex, end = maxSum.endIndex;
		for (int i = start, k = 0; i <= end; i++, k++) {
			result[k] = A[i];
		}
		return result;
		// keep increasing the sum as long as its increasing and keep adding
		// to endIndex.

		// maintain a tempSum variable which checks if the val at currentIndex is
		// greater than the tempSum seen so far it updates the tempSum
		// ,startIndex & endIndex to that index

		// when it begins to decrease do Nothing

		// if a number greater than the maxSum so far is seen update
		// the maxSum , startIndex & endIndex to that index

		// finally if tempSum turns out to be greater than the maxSum then
		// update the maxSum to tempSum and return the array corresponding to that
	}

	public static void main(String[] args) {
//		int[] A = new int[] { 1, 2, 5, -7, 2, 3 };
//		int[] A = new int[] { 10, -1, 2, 3, -4, 100 };
//		int[] A = new int[] { -1, -1, -1, -1, -1 };
//		int[] A = new int[] { 0, 0, -1, 0 };
		int[] A = new int[] { 1967513926, 1540383426, -1303455736, -521595368 };
		Arrays.stream(maxset(A)).forEach(x -> System.out.print(x + " "));
	}
}
