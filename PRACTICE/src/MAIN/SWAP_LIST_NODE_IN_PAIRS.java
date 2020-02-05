package MAIN;

import util.ListNode;

public class SWAP_LIST_NODE_IN_PAIRS {

	public static ListNode swapPairs(ListNode head) {
		ListNode curr = head, Next = curr.next, temp = new ListNode(0);

		while (curr != null && curr.next != null) {
			temp.val = curr.val;
			curr.val = Next.val;
			Next.val = temp.val;
			curr = Next.next;
			if (curr != null && curr.next != null)
				Next = curr.next;
		}
		return head;
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

		ListNode.printList(swapPairs(head));

	}
}
