package com.company.project.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class Question18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		int l,r;
		int sum;
		int max,min;
		Arrays.sort(nums);
		int len = nums.length;
		
		for(int a = 0;a<len-3;a++) {
			//当nums[a] == nums[a-1] 直接跳过
			if(a>0 && nums[a] == nums[a-1]) {
				continue;
			}
			
			//获取当前的最大值，如果最大值比目标值还小，直接跳过
			max = nums[a]+nums[len-3]+nums[len-2]+nums[len-1];
			if(max<target) {
				continue;
			}
			
			//获取当前的最小值，如果最小值比目标值还大，直接跳过
			min = nums[a]+nums[a+1]+nums[a+2]+nums[a+3];
			if(min>target) {
				continue;
			}
			
			for(int b = a+1;b<len-2;b++) {
				//当nums[b] == nums[b-1]直接跳过
				if(b>a+1 && nums[b] == nums[b-1]) {
					continue;
				}
				l = b+1;
				r = len-1;
				
				//获取当前的最大值，如果最大值比目标值还小，直接跳过
				max = nums[a]+nums[b]+nums[r-1]+nums[r];
				if(max<target) {
					continue;
				}
				
				//获取当前的最小值，如果最小值比目标值还大，直接跳过
				min = nums[a]+nums[b]+nums[l]+nums[l+1];
				if(min>target) {
					continue;
				}
				
				while(l<r) {
					sum = nums[a]+nums[b]+nums[l]+nums[r];
					if(sum == target) {
						results.add(Arrays.asList(nums[a],nums[b],nums[l],nums[r]));
						l++;
						r--;
						
						//当nums[r]==nums[r+1]直接跳过
						while(r<len-1 && r>l && nums[r]==nums[r+1]) {
							r--;
						}
						//当nums[l]==nums[l-1]直接跳过
						while(l>b+1 && r>l && nums[l]==nums[l-1]) {
							l++;
						}
					}else if(sum > target) {
						r--;
					}else {
						l++;
					}
				}
			}
		}
		return results;
    }
	
	
	public static void main(String[] args) {
		Question18 question18 = new Question18();
		int [] nums = {0,0,0,0};
		int target = 0;
		System.out.println(question18.fourSum(nums, target));
	}
}
