package com.company.project.hot100;


/*
 * 25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

 

说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Question25 {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode result = new ListNode(0);
		ListNode re = result;
		ListNode tail = head;
		int i = 0;
		while( tail!= null) {		
			i++;
			if( i%k == 0) {
				ListNode tailNext = tail.next;
				ListNode[] temp = reversalList(head, tail);
				re.next = temp[1];
				re = temp[0];
				re.next = tailNext;
				head = tailNext;
				tail = re;
			}
			tail = tail.next;
		}
		return result.next;
    }
	
	public ListNode[] reversalList(ListNode head,ListNode tail) {
		ListNode[] result =  {head,tail};
		if(head == null || head == tail) {
			
			return result;
		}
		ListNode temp = head;
		while(temp!=tail) {
			ListNode t = tail.next;
			tail.next = temp;
			ListNode n = temp.next;
			temp.next = t;
			temp = n;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Question25 question25 = new Question25();
		ListNode a = question25.new ListNode(1);
		ListNode b = question25.new ListNode(2);
		ListNode c = question25.new ListNode(3);
		ListNode d = question25.new ListNode(4);
		ListNode e = question25.new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = null;
		
		

		//测试翻转链表方法
//		ListNode[] result = question25.reversalList(a, e);
//		ListNode head = result[0];
//		ListNode tail = result[1];
//		ListNode r = question25.new ListNode(0);
//		r.next = tail;
//		do {
//			System.out.println(r.next.val);
//			r = r.next;
//		} while (r != head);
		
		ListNode result = question25.reverseKGroup(a, 3);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}	
		
	}
	
	
}
