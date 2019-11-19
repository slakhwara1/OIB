package PRAC;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NEW_SOLUTION {

	// USING PRIORITY_QUEUE
	public int findMaxMedian(int[] A, int B) {

		Comparator<Integer> min_priority = new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		};

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(min_priority);
		for (int i = A.length / 2; i < A.length; i++)
			pq.add(A[i]);

		for (int i = 0; i < B; i++) {
			int temp_min = pq.poll();
			temp_min++;
			pq.add(temp_min);
		}
		return pq.poll();
	}

	public static void main(String[] args) {
		System.out.println(new NEW_SOLUTION().findMaxMedian(new int[] { 1, 2, 4, 6, 8 }, 5));
		System.out.println(new NEW_SOLUTION().findMaxMedian(new int[] { 1, 1, 1, 1, 2 }, 5));
	}
}
