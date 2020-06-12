package com.company.project.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * 16. ��ӽ�������֮�� ����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������ʹ�����ǵĺ���
 * target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 * 
 * ���磬�������� nums = [-1��2��1��-4], �� target = 1.
 * 
 * �� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).
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
