package com.company.project.hot100;

/*
 * 24. �������������еĽڵ�
����һ���������������������ڵĽڵ㣬�����ؽ����������

�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����

 

ʾ��:

���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
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
