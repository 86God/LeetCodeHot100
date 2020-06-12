package com.company.project.hot100;

/*
 * 21. 合并两个有序链表
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */

public class Question21 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode result = head;
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			}else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		
		if(l1!=null) {
			head.next = l1;
		}
		if(l2!=null) {
			head.next = l2;
		}
	
		return result.next;
    }
	
	public static void main(String[] args) {
		Question21 question21 = new Question21();
		ListNode l1 = question21.new ListNode(1);
		ListNode l2 = question21.new ListNode(2);
		ListNode l3 = question21.new ListNode(4);
		ListNode r1 = question21.new ListNode(1);
		ListNode r2 = question21.new ListNode(3);
		ListNode r3 = question21.new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		
		r1.next = r2;
		r2.next = r3;
		r3.next = null;
		
		ListNode result = question21.mergeTwoLists(l1, r1);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
}
