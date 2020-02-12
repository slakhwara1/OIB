package MAIN;

import util.ListNode;

public class REMOVE_DUPLICATES_FROM_SORTED_LIST_2 {

	public static ListNode deleteDuplicates(ListNode A) {
		int currentlySeen = A.val;
		ListNode temp = A;
		int count = 0;
		ListNode result = null, resultHead = result;

		while (temp != null) {
			while (temp != null && temp.val == currentlySeen) {
				count++;
				temp = temp.next;
			}
			if (count == 1) {
				if (result == null) {
					result = new ListNode(currentlySeen);
					resultHead = result;
				} else {
					result.next = new ListNode(currentlySeen);
					result = result.next;
				}
				if (temp != null)
					currentlySeen = temp.val;
				count = 0;
			} else {
				if (temp != null)
					currentlySeen = temp.val;
				count = 0;
			}
		}
		return resultHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next = new ListNode(3);

		ListNode.printList(deleteDuplicates(head));

	}

}
