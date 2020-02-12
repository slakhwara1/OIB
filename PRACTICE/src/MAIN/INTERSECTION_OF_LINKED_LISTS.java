package MAIN;

import util.ListNode;

public class INTERSECTION_OF_LINKED_LISTS {

	public static ListNode getIntersectionNode(ListNode a, ListNode b) {
		ListNode ptr1 = a, ptr2 = b;
		int length_1 = 1;
		int length_2 = 1;
		while (ptr1 != null) {
			length_1++;
			ptr1 = ptr1.next;
		}
		while (ptr2 != null) {
			length_2++;
			ptr2 = ptr2.next;
		}

		int diff = Math.abs(length_2 - length_1);

		if (length_1 >= length_2) {
			ptr1 = a;
			ptr2 = b;
		} else {
			ptr2 = a;
			ptr1 = b;
		}
		while (diff > 0 && ptr1 != null) {
			ptr1 = ptr1.next;
			diff--;
		}
		if (ptr1 == null || ptr2 == null)
			return null;
		if (ptr1 == ptr2)
			return ptr2;
		while ((ptr1 != null && ptr2 != null) && ptr1.next != ptr2.next) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr1.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode head_1 = new ListNode(4);
		head_1.next = new ListNode(7);
		head_1.next.next = new ListNode(9);
		head_1.next.next.next = new ListNode(11);
		head_1.next.next.next.next = head.next.next.next.next.next.next.next;
//		head_1.next.next.next.next.next = new ListNode(6);
//		head_1.next.next.next.next.next.next = new ListNode(7);
//		head_1.next.next.next.next.next.next.next = new ListNode(8);

		ListNode.printList(head);
		ListNode.printList(head_1);

		System.out.println(getIntersectionNode(head, head_1));

	}
}
