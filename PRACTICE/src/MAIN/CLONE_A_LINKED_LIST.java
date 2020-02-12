package MAIN;

public class CLONE_A_LINKED_LIST {

	static class ListNode {
		int val;
		ListNode next, random;

		ListNode(int x) {
			val = x;
			next = random = null;
		}
	}

	public ListNode cloneList(ListNode A) {
		ListNode result = new ListNode(A.val);
		result.next = A.next;
		result.random = A.random;
		return result;
	}

	public static void main(String[] args) {

	}

}
