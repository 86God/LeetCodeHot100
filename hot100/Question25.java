package com.company.project.hot100;


/*
 * 25. K ��һ�鷭ת����
����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������

k ��һ��������������ֵС�ڻ��������ĳ��ȡ�

����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��

 

ʾ����

�����������1->2->3->4->5

�� k = 2 ʱ��Ӧ������: 2->1->4->3->5

�� k = 3 ʱ��Ӧ������: 3->2->1->4->5

 

˵����

����㷨ֻ��ʹ�ó����Ķ���ռ䡣
�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����
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
		
		

		//���Է�ת������
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
