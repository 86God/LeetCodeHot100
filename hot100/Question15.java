package com.company.project.hot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. ����֮��
����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣

ע�⣺���в����԰����ظ�����Ԫ�顣

 

ʾ����

�������� nums = [-1, 0, 1, 2, -1, -4]��

����Ҫ�����Ԫ�鼯��Ϊ��
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * @author God_86
 *
 */

public class Question15 {
	
	/**
	 * �ⷨһ��˫ָ�뷨
	 * ����������Ҫ�ȶ���������������ǿ����ñ���i�������飬nums[i]���ǵ�һ��Ԫ�أ�
	 * ���ǿ���ʹ������ָ��l��r����ָ��i+1��len-1������len��nums����ĳ��ȡ�
	 * ��l<r����һ�ֽ�������ѭ����
	 * ����ͨ������t = nums[i] + nums[l]+nums[r],
	 * ��t=0�����Ǿ�ֱ�����Ǽ������ս������
	 * ��t>0��˵����nums[r]̫���ˣ�����Ӧ�ý�rָ�������ƶ���
	 * ��t<0��˵����nums[l]̫С�ˣ�����Ӧ�ý�lָ�������ƶ���
	 * 
	 * ����⻹��һ���ѵ㣬�������ȥ���ظ��Ľ����
	 * �����Ѿ��������������������������ظ��Ľ����
	 * ��ô�ظ�������±�i��l��rһ�������ڵģ�
	 * ��������ֻ��Ҫ���ҵ������ʱ���ж�nums[l+1]�Ƿ����nums[l]��num[r-1]�Ƿ����nums[r]
	 * �����ڣ�����ֱ���ƶ�ָ�룬ֱ������ȡ�
	 * ���о������ƶ�i��ʱ������Ҳ��Ҫ�жϣ�
	 * ���nums[i]��nums[i-1]��ȣ����ǾͿ���ֱ���������ѭ����������һ��ѭ����
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
