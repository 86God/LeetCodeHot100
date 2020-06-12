package com.company.project.hot100;

/*
 * 24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Question24 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode result = new ListNode(0);
		ListNode re = result;
		
		while(head!=null && head.next!= null) {
			ListNode t = head.next.next;
			re.next = head.next;
			re = re.next;
			re.next = head;
			re = re.next;
			re.next = t;
			head = t;
		}
		
		return result.next;	
	}
	
	public static void main(String[] args) {
		Question24 question24 = new Question24();
		ListNode a = question24.new ListNode(1);
		ListNode b = question24.new ListNode(2);
		ListNode c = question24.new ListNode(3);
		ListNode d = question24.new ListNode(4);
		ListNode e = question24.new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = null;
		
		ListNode result = question24.swapPairs(a);
		
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
