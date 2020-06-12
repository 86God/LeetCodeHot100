package com.company.project.hot100;

/*
 * 26. ɾ�����������е��ظ���
����һ���������飬����Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�

��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�

 

ʾ�� 1:

�������� nums = [1,1,2], 

����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2�� 

�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
ʾ�� 2:

���� nums = [0,0,1,1,1,2,2,3,3,4],

����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��

�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 

˵��:

Ϊʲô������ֵ��������������Ĵ���������?

��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�

����������ڲ���������:

// nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
int len = removeDuplicates(nums);

// �ں������޸�����������ڵ������ǿɼ��ġ�
// ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 */
public class Question26 {
	public int removeDuplicates(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		int result = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[result] != nums[i]) {
				result++;
				nums[result] = nums[i];
			}
		}
		return result+1;
    }
	
	public static void main(String[] args) {
		Question26 question26 = new Question26();
		int[] nums = {1,1,2,2,3,4,5};
//		System.out.println(question26.removeDuplicates(nums));
		int len = question26.removeDuplicates(nums);
		for (int i=0;i<len;i++) {
			System.out.println(nums[i]);
		}
	}
}
