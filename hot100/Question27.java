package com.company.project.hot100;
/*
 * 27. �Ƴ�Ԫ��
����һ������ nums ��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ���� val ��Ԫ�أ��������Ƴ���������³��ȡ�

��Ҫʹ�ö��������ռ䣬������ʹ�� O(1) ����ռ䲢 ԭ�� �޸��������顣

Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�

 

ʾ�� 1:

���� nums = [3,2,2,3], val = 3,

����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��

�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
ʾ�� 2:

���� nums = [0,1,2,2,3,0,4,2], val = 2,

����Ӧ�÷����µĳ��� 5, ���� nums �е�ǰ���Ԫ��Ϊ 0, 1, 3, 0, 4��

ע�������Ԫ�ؿ�Ϊ����˳��

�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 

˵��:

Ϊʲô������ֵ��������������Ĵ���������?

��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�

����������ڲ���������:

// nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
int len = removeElement(nums, val);

// �ں������޸�����������ڵ������ǿɼ��ġ�
// ������ĺ������صĳ���, �����ӡ�������� �ó��ȷ�Χ�� ������Ԫ�ء�
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 */
public class Question27 {
	public int removeElement(int[] nums, int val) {
		if(nums.length==0) {
			return 0;
		}
		int result = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] != val) {		
				nums[result] = nums[i];
				result++;
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		Question27 question27 = new Question27();
		int[] nums = {1,1,2,2,3,4,5};
//		System.out.println(question26.removeDuplicates(nums));
		int len = question27.removeElement(nums,2);
		for (int i=0;i<len;i++) {
			System.out.println(nums[i]);
		}
	}
}
