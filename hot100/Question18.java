package com.company.project.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 18. ����֮��
����һ������ n ������������ nums ��һ��Ŀ��ֵ target���ж� nums ���Ƿ�����ĸ�Ԫ�� a��b��c �� d ��ʹ�� a + b + c + d ��ֵ�� target ��ȣ��ҳ��������������Ҳ��ظ�����Ԫ�顣

ע�⣺

���в����԰����ظ�����Ԫ�顣

ʾ����

�������� nums = [1, 0, -1, 0, -2, 2]���� target = 0��

����Ҫ�����Ԫ�鼯��Ϊ��
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
			//��nums[a] == nums[a-1] ֱ������
			if(a>0 && nums[a] == nums[a-1]) {
				continue;
			}
			
			//��ȡ��ǰ�����ֵ��������ֵ��Ŀ��ֵ��С��ֱ������
			max = nums[a]+nums[len-3]+nums[len-2]+nums[len-1];
			if(max<target) {
				continue;
			}
			
			//��ȡ��ǰ����Сֵ�������Сֵ��Ŀ��ֵ����ֱ������
			min = nums[a]+nums[a+1]+nums[a+2]+nums[a+3];
			if(min>target) {
				continue;
			}
			
			for(int b = a+1;b<len-2;b++) {
				//��nums[b] == nums[b-1]ֱ������
				if(b>a+1 && nums[b] == nums[b-1]) {
					continue;
				}
				l = b+1;
				r = len-1;
				
				//��ȡ��ǰ�����ֵ��������ֵ��Ŀ��ֵ��С��ֱ������
				max = nums[a]+nums[b]+nums[r-1]+nums[r];
				if(max<target) {
					continue;
				}
				
				//��ȡ��ǰ����Сֵ�������Сֵ��Ŀ��ֵ����ֱ������
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
						
						//��nums[r]==nums[r+1]ֱ������
						while(r<len-1 && r>l && nums[r]==nums[r+1]) {
							r--;
						}
						//��nums[l]==nums[l-1]ֱ������
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
