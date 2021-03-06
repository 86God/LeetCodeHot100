package com.company.project.hot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * @author God_86
 *
 */

public class Question15 {
	
	/**
	 * 解法一：双指针法
	 * 首先我们需要先对数组进行排序，我们可以用变量i遍历数组，nums[i]就是第一个元素，
	 * 我们可以使用两个指针l和r依次指向i+1和len-1，其中len是nums数组的长度。
	 * 当l<r，就一种进行下面循环：
	 * 我们通过计算t = nums[i] + nums[l]+nums[r],
	 * 若t=0，我们就直接他们加入最终结果集；
	 * 若t>0，说明是nums[r]太大了，我们应该将r指针向右移动；
	 * 若t<0，说明是nums[l]太小了，我们应该将l指针向左移动。
	 * 
	 * 这道题还有一个难点，就是如何去除重复的结果？
	 * 我们已经对数组进行了排序，所以如果有重复的结果，
	 * 那么重复结果的下标i或l或r一定是相邻的，
	 * 所以我们只需要在找到结果的时候，判断nums[l+1]是否等于nums[l]，num[r-1]是否等于nums[r]
	 * 若等于，我们直接移动指针，直到不相等。
	 * 还有就是在移动i的时候，我们也需要判断，
	 * 如果nums[i]和nums[i-1]相等，我们就可以直接跳过这次循环，进行下一次循环。
	 * 
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int len = nums.length;		
		for(int i =0;i<len;i++) {
			if(nums[i]>0) {
				return result;
			}
			
			if(i>0 && nums[i] == nums[i-1]) {
				continue;
			}
			int l = i+1;
			int r = len -1;		
			while (l<r) {
				int t = nums[i] + nums[l]+nums[r];
				if(t == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[l]);
					list.add(nums[r]);
					result.add(list);	
					
					while(l < r && nums[l+1] == nums[l]) {
						l++;
					}
					while(l<r && nums[r-1] == nums[r]) {
						r--;
					}
					++l;
					--r;
					
				}else if(t > 0) {
					r--;
				}else {
					l++;
				}				
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		int [] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums).toString());
	}
}
