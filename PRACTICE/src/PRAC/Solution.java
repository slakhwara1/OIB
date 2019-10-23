package PRAC;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public int lengthOfLIS(int[] nums) {
		int memo[][] = new int[nums.length + 1][nums.length];
		for (int[] l : memo) {
			Arrays.fill(l, -1);
		}
		return lengthofLIS(nums, -1, 0, memo);
	}

	public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
		if (curpos == nums.length) {
			return 0;
		}
		if (memo[previndex + 1][curpos] >= 0) {
			System.out.println("POPPED : func( " + ((new ArrayList<Integer>()) Arrays.asList(nums)) + " , " + previndex + " , " + curpos + " , " + " memo )");
			return memo[previndex + 1][curpos];
		}
		int taken = 0;
		if (previndex < 0 || nums[curpos] > nums[previndex]) {
			System.out.println("BEFORE TAKEN : func( " + Arrays.asList(nums) + " , " + previndex + " , " + curpos + " , " + " memo )");
			taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
			System.out.println("AFTER TAKEN : func( " + Arrays.asList(nums) + " , " + previndex + " , " + curpos + " , " + " memo )");
		}

		System.out.println("BEFORE NOT TAKEN : func( " + Arrays.asList(nums) + " , " + previndex + " , " + curpos + " , " + " memo )");
		int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
		System.out.println("AFTER NOT TAKEN : func( " + Arrays.asList(nums) + " , " + previndex + " , " + curpos + " , " + " memo )");
		memo[previndex + 1][curpos] = Math.max(taken, nottaken);
		return memo[previndex + 1][curpos];
	}

	public static void main(String[] args) {
		new Solution().lengthOfLIS(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 });
	}
}