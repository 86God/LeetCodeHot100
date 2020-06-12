package com.company.project.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.company.project.hot100.Question21.ListNode;

/*
 * 23. 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 */
public class Question23 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 解法一：暴力法
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode result = new ListNode(0);
		List<Integer> aList = new ArrayList<Integer>();
		ListNode temp = result;
		for (int i = 0; i < lists.length; i++) {
			while (lists[i] != null) {
				aList.add(lists[i].val);
				lists[i] = lists[i].next;
			}
		}
		Collections.sort(aList);

		for (Integer integer : aList) {
			ListNode node = new ListNode(integer);
			temp.next = node;
			temp = temp.next;
		}

		return result.next;
	}

	/**
	 * 解法二：优先队列
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		ListNode result = new ListNode(0);
		ListNode temp = result;
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}

		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			temp.next = node;
			temp = temp.next;
			if (node.next != null) {
				queue.add(node.next);
			}
		}

		return result.next;
	}

	/**
	 * 解法三：分治法
	 * 
	 * @param args
	 */
	public ListNode mergeKLists3(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		return divideRule(lists, 0, lists.length - 1);
	}

	public ListNode divideRule(ListNode[] lists, int l, int r) {
		if (l == r) {
			return lists[l];
		}
		int mid = l + (r - l) / 2;
		ListNode l1 = divideRule(lists, l, mid);
		ListNode r1 = divideRule(lists, mid + 1, r);
		return mergeTwoLists(l1, r1);
	}

	// 合并两个有序链表
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null || b == null) {
			return (a == null) ? b : a;
		}
		if (a.val <= b.val) {
			a.next = mergeTwoLists(a.next, b);
			return a;
		} else {
			b.next = mergeTwoLists(a, b.next);
			return b;
		}
	}

	public static void main(String[] args) {
		Question23 question23 = new Question23();
		ListNode a1 = question23.new ListNode(1);
		ListNode a2 = question23.new ListNode(4);
		ListNode a3 = question23.new ListNode(5);
		ListNode b1 = question23.new ListNode(1);
		ListNode b2 = question23.new ListNode(3);
		ListNode b3 = question23.new ListNode(4);
		ListNode c1 = question23.new ListNode(2);
		ListNode c2 = question23.new ListNode(6);
		a1.next = a2;
		a2.next = a3;
		a3.next = null;

		b1.next = b2;
		b2.next = b3;
		b3.next = null;

		c1.next = c2;
		c2.next = null;

		ListNode[] lists = new ListNode[3];
		lists[0] = a1;
		lists[1] = b1;
		lists[2] = c1;

		ListNode result = question23.mergeKLists3(lists);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}
