package com.company.project.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * 16. 最接近的三数之和 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与
 * target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * @author God_86
 *
 */
public class Question16 {
//	public static void threeSumClosest(int[] nums, int target) {
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		for (int i : nums) {
//			map.put(Math.abs(i - target), i);
//		}
//
//		System.out.println(map.toString());
//		
//	}

	public static int threeSumClosest2(int[] nums, int target) {
		Arrays.sort(nums);
		int l, r, sum;
		int len = nums.length;
		int ans = nums[0] + nums[1] + nums[2];
		if (len <= 3) {
			return ans;
		}
		for (int i = 0; i < len - 2; i++) {
			l = i + 1;
			r = len - 1;
			while (l < r) {
				sum = nums[l] + nums[r] + nums[i];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					l++;
				} else {
					r--;
				}
				if (Math.abs(ans - target) > Math.abs(sum - target)) {
					ans = sum;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { -1,2,1,-4 };
		int target = 1;
		System.out.println(threeSumClosest2(nums, target));
	}
}
