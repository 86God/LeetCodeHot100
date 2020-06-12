package com.company.project.hot100;

/*
 * 11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

 


图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

 

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
 */
public class Question11 {
	
	/**
	 * 刚开始看题，还有点没看明白，最后看懂了，题目其实很简单，
	 * 意思就是选取两个挡板，选中后忽略掉其他的挡板，
	 * 然后计算最大存水面积，即较小的挡板长度乘以两板之间的距离
	 * 解法一：双指针法
	 * 用两个变量分别表示最左边和最右边的数组下标，从最外层开始计算，
	 * 计算出面积后和当前的最大面积比较是否替换，然后再将较小的板的下标向中心移动，
	 * 依次循环，直到两个变量指向了同一块板，循环结束
	 * 输出最大面积
	 * 
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int l = 0;
		int r = height.length-1;
		int area = 0;
		int maxArea = 0;
		
		while (r>l) {
			area = Math.min(height[l], height[r])*(r-l);
			maxArea = area>maxArea?area:maxArea;
			if(height[l]>=height[r]) {
				r--;
			}else {
				l++;
			}	
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] a = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(a));
	}

}
