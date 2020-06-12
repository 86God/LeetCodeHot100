package com.company.project.hot100;


public class Question02 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode t = new ListNode(0);
		ListNode s = t;
		int c = 0;
		while (l1 != null || l2 != null) {
			int x = l1 == null ? 0 : l1.val;
			int y = l2 == null ? 0 : l2.val;

			int sum = x + y + c;
			c = sum /10;
			sum = sum %10;
			s.next = new ListNode(sum);
			s = s.next;
			if(l1 != null) {
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
		}
		if(c != 0) {
			s.next = new ListNode(c);
		}

		return t.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode s = addTwoNumbers(l1, l2);

		while (s != null) {
			System.out.println(s.val);
			s = s.next;
		}
	}

}
