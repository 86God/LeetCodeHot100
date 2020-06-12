package com.company.project.hot100;

/*
 * 19. ɾ������ĵ�����N���ڵ�
����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣

ʾ����

����һ������: 1->2->3->4->5, �� n = 2.

��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
˵����

������ n ��֤����Ч�ġ�

���ף�

���ܳ���ʹ��һ��ɨ��ʵ����
 */

public class Question19 {
	/**
	 * �����
	 * @author God_86
	 *
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        if(head == null) {
        	return null;
        }
        ListNode node = head;
		while(node.next!=null) {
        	len ++;
        	node = node.next;
        }
		node = head;
		int tag = len - n;
		if(tag == 0) {
			return head.next;
		}
		while(node.next!=null) {
			tag--;
			if(tag == 0) {
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
		return head;
    }
	
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
        ListNode R = dummy;
        ListNode L = dummy;
        for(int i = 0;i<n+1;i++) {
        	R = R.next;
        }

		while(R!=null) {
			R = R.next;
			L = L.next;
		}
		L.next = L.next.next;
		
		return dummy.next;
    }
	
	
	public static void main(String[] args) {
		Question19 question19 = new Question19();
		ListNode n0 = question19.new ListNode(1);
		ListNode n1 = question19.new ListNode(2);
		ListNode n2 = question19.new ListNode(3);
		ListNode n3 = question19.new ListNode(4);
		ListNode n4 = question19.new ListNode(5);
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		ListNode head = question19.removeNthFromEnd2(n0, 2);
		while(head.next!=null) {
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println(head.val);
	}
}
