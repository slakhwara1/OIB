package util;

public class PRINT_ARRAYS {

	public static void printMatrix(int[][] table) {
		for (int[] arr : table) {
			for (int item : arr)
				System.out.print(item + " ");
			System.out.println();
		}
		System.out.println();
	}
}
