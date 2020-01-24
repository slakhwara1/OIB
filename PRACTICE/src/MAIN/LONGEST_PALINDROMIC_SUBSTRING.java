package MAIN;

public class LONGEST_PALINDROMIC_SUBSTRING {

	public String longestPalindrome(String A) {
		if (A.length() == 0)
			return "";
		int N = A.length();
		int maxLength = 1;
		int[][] table = new int[N][N];
		int start = 0;

		for (int i = 0; i < A.length(); i++)
			table[i][i] = 1;

		for (int i = 0; i < A.length() - 1; i++)
			if (A.charAt(i) == A.charAt(i + 1)) {
				start = i;
				maxLength = 2;
				table[i][i + 1] = 1;
			}

		for (int length = 3; length <= N; length++) {
			for (int i = 0; i < N - length + 1; i++) {
				int j = i + length - 1;
				if ((A.charAt(i) == A.charAt(j)) && table[i + 1][j - 1] == 1) {
					table[i][j] = 1;
					if (length > maxLength) {
						maxLength = length;
						start = i;
					}
				}
			}
		}
		System.out.println(start + " " + maxLength);
		return A.substring(start, start + maxLength);
	}

	public static void main(String[] args) {
		System.out.println(new LONGEST_PALINDROMIC_SUBSTRING().longestPalindrome("bananas"));
		System.out.println(new LONGEST_PALINDROMIC_SUBSTRING().longestPalindrome("abacdf"));
		System.out.println(new LONGEST_PALINDROMIC_SUBSTRING().longestPalindrome("forgeeksskeegfor"));
	}

}
