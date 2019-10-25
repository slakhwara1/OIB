package PRAC;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public int lengthOfLIS(int[] nums) {
		int memo[][] = new int[nums.length + 1][nums.length];
		for (int[] l : memo) {
			Arrays.fill(l, -1);
		}
		System.out.println("FIRST CALL : func( " + printArray(nums) + " , " + "-1" + " , " + 0 + " , " + " memo )");
		return lengthofLIS(nums, -1, 0, memo);
	}

	public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
		print2dArray(memo);
		if (curpos == nums.length) {
			
			System.out.println("------------------------------------------------------------------");
			System.out.println("POPPED : func( " + printArray(nums) + " , " + previndex + " , " + curpos + " , " + " memo )" + "returned = "+0);
			System.out.println("------------------------------------------------------------------");
			
			return 0;
		}
		if (memo[previndex + 1][curpos] >= 0) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("POPPED : func( " + printArray(nums) + " , " + previndex + " , " + curpos + " , " + " memo )"+ "returned = "+memo[previndex + 1][curpos]);
			System.out.println("------------------------------------------------------------------");
			return memo[previndex + 1][curpos];
		}
		int taken = 0;
		if (previndex < 0 || nums[curpos] > nums[previndex]) {
			System.out.println("BEFORE TAKEN : func( " + printArray(nums) + " , " + previndex + " , " + curpos + " , " + " memo )");
			taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
			System.out.println("AFTER TAKEN : func( " + printArray(nums) + " , " + previndex + " , " + curpos + " , " + " memo )");
		}

		System.out.println("BEFORE NOT TAKEN : func( " + printArray(nums) + " , " + previndex + " , " + curpos + " , " + " memo )");
		int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
		System.out.println("AFTER NOT TAKEN : func( " + printArray(nums) + " , " + previndex + " , " + curpos + " , " + " memo )");

		System.out.println("TAKEN = "+taken+" NOT_TAKEN = "+nottaken);
		memo[previndex + 1][curpos] = Math.max(taken, nottaken);
		

		System.out.println("------------------------------------------------------------------");
		System.out.println("-->POPPED : func( " + printArray(nums) + " , " + previndex + " , " + curpos + " , " + " memo )"+ "returned = "+memo[previndex + 1][curpos]);
		System.out.println("------------------------------------------------------------------");
		
		return memo[previndex + 1][curpos];
	}
	
	public String printArray(int[] A) {
		String s = "[ ";
		for(int item : A)
			s+=""+item+" ";
		return s+" ]";
	}
	
	public void print2dArray(int [][] A) {
		for(int[] array : A) {
			for(int item : array) {
				if (item < 0 || item > 9)
					System.out.print(item+" ");
				else
					System.out.print(item + "  ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLIS(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }));
	}
}