package com.company.project.hot100;

import java.util.Arrays;

/**
 * 4. 寻找两个有序数组的中位数 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1: nums1 = [1, 3] nums2 = [2] 则中位数是 2.0
 * 
 * 示例 2: nums1 = [1, 2] nums2 = [3, 4] 则中位数是 (2 + 3)/2 = 2.5
 * 
 * @author God_86
 *
 */
public class Question04 {
	/**
	 * 第一种解法：合并数组排序，找到中位数
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);

		/**
		 * 将一个数组片段复制到另一个数组的指定位置 System.arraycopy(src, srcPos, dest, destPos, length)
		 * src: 源数组 srcPos: 从源数组复制数据的起始位置 dest: 目标数组 destPos: 复制到目标数组的起始位置 length: 复制的长度
		 */
		System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
		Arrays.sort(result);
		double d = (double) (result[(nums1.length + nums2.length - 1) / 2] + result[(nums1.length + nums2.length) / 2])
				/ 2;

		return d;
	}

	/**
	 * 第二种解法：和第一种一样，不过利用位运算，可以优化计算
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		if (nums1.length < 2 && nums2.length < 2) {
			if (nums1.length == 0) {
				return (double) nums2[0];
			} else if (nums2.length == 0) {
				return (double) nums1[0];
			}
			return (double) (nums1[0] + nums2[0]) / 2;
		}
		int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);
		/**
		 * 将一个数组片段复制到另一个数组的指定位置 System.arraycopy(src, srcPos, dest, destPos, length)
		 * src: 源数组 srcPos: 从源数组复制数据的起始位置 dest: 目标数组 destPos: 复制到目标数组的起始位置 length: 复制的长度
		 */
		System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
		Arrays.sort(result);
		int mid = result.length >> 1;
		if ((result.length & 1) == 1) {
			return (double) result[(result.length - 1) >> 1];
		} else {
			return (double) (result[mid - 1] + result[mid]) / 2;
		}
	}

	/**
	 * 第三种解法：二分查找法
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int left = (m + n + 1) / 2;
		int right = (m + n + 2) / 2;
		return (find(nums1, 0, nums2, 0, left) + find(nums1, 0, nums2, 0, right)) / 2.0;
	}

	/**
	 * 在nums1和nums2中找出第k小的元素
	 * 
	 * @param nums1 nums1数组
	 * @param i     nums1数组的起始位置
	 * @param nums2 nums2数组
	 * @param j     nums2数组的起始位置
	 * @param k     需要找到的元素的序号
	 * @return 第k小的元素值
	 */
	public static int find(int[] nums1, int i, int[] nums2, int j, int k) {
		if (i >= nums1.length)
			return nums2[j + k - 1]; // nums1数组全部被舍弃
		if (j >= nums2.length)
			return nums1[i + k - 1]; // nums2数组全部被舍弃
		// 当k = 1 的时候，两个数组的布局基本相同，最后只需要找到
		if (k == 1) {
			return Math.min(nums1[i], nums2[j]);
		}

		/*
		 * 分别找到两个数组中的第k/2位置的元素，如果不存在就给他赋最大值， 比较两个值，值小的数组则淘汰其前k/2个元素 最后把k也减去k/2，继续递归
		 */
		int mid1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
		int mid2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
		if (mid1 < mid2) {
			return find(nums1, i + k / 2, nums2, j, k - k / 2);
		} else {
			return find(nums1, i, nums2, j + k / 2, k - k / 2);
		}

	}

	public static void main(String[] args) {
		int[] nums1 = { 9, 10, 11, 12, 13, 14 };
		int[] nums2 = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
//		int[] nums1 = { 1 };
//		int[] nums2 = { 2 };

		System.out.println(findMedianSortedArrays3(nums1, nums2));

	}
}
