package com.company.project.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
 * 31.ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�

�����������һ����������У��������������г���С�����У����������У���

����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1

 */
public class Question31 {
	public void nextPermutation(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return;
		}

		int i = 0;
		for (i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				break;
			}
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j > i) {
				if (nums[i] < nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					break;
				}
				j--;
			}
		}

		for (int k = i + 1; k <= (nums.length + i) / 2; k++) {
			int temp = nums[k];
			nums[k] = nums[nums.length - (k - i)];
			nums[nums.length - (k - i)] = temp;
		}
	}

	public static void main(String[] args) {
		Question31 question31 = new Question31();
		int[] nums = { 1,2,3,8,5,7,6,4 };
		question31.nextPermutation(nums);
		for (int i : nums) {
			System.out.println(i);
		}

	}
}
