package util;

public class PRINT_ARRAYS {

	public static void printMatrix(int[][] matrix) {
		for (int[] arr : matrix) {
			for (int item : arr)
				System.out.print(item + " ");
			System.out.println();
		}
		System.out.println();
	}

}
