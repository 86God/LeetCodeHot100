package com.company.project.hot100;

/*
 * 33. ������ת��������
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��

����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��

����Լ��������в������ظ���Ԫ�ء�

����㷨ʱ�临�Ӷȱ����� O(log n) ����

ʾ�� 1:

����: nums = [4,5,6,7,0,1,2], target = 0
���: 4
ʾ�� 2:

����: nums = [4,5,6,7,0,1,2], target = 3
���: -1
 */
public class Question33 {
	public int search(int[] nums, int target) {
		int len = nums.length;
		if(len == 0) {
			return -1;
		}
		if(len == 1) {
			return target == nums[0]?0:-1;
		}
		
		int l=0,r=len-1;
		while(r>=l) {
			int mid = (l+r)/2;
			if(nums[mid] == target) return mid;
			if(nums[0]<=nums[mid]) {
				if(target>=nums[0]&&target<nums[mid]) {
					r= mid-1;
				}else {
					l=mid+1;
				}
			}else {
				if(target>nums[mid]&&target<=nums[len-1]) {
					l = mid+1;
				}else {
					r=mid-1;
				}
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		Question33 question33 = new Question33();
		int[] nums = {4,5,6,7,0,1,2};
		int target = 2;
		System.out.println(question33.search(nums,target));
	}
}