package com.company.project.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
 * 31.实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

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
