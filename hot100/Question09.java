package com.company.project.hot100;

/*
 * # 9. 回文数

难度：简单

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

**示例 1:**

输入: 121
输出: true


**示例 2:**

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。


**示例 3:**

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。


 */
public class Question09 {
	
	/**
	 * 解法一：倒置字符串
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome1(int x) {
		String revstr = new StringBuilder(x + "").reverse().toString();
		String str = x + "";
        return str.equals(revstr);
    }
	
	/**
	 * 解法二：数学算法
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome2(int x) {
		if(x<0) {
			return false;
		}
		int digit = 1;
		while(x / digit >= 10) {
			digit *= 10;
		}
		while(x > 0) {
			int l = x / digit;
			int r = x % 10;
			if(l != r) {
				return false;
			}
			x = (x % digit) /10;
			digit /= 100;
		}
		return true;
    }
	
	/**
	 * 解法三：利用数字对折
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome3(int x) {
		if(x < 0) {
			return false;
		}
		int b = 0;
		while(x > b) {
			b = b * 10 + x % 10;
			x /= 10;
		}
		return x == b || x == b / 10;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome2(120021));
	}


}
