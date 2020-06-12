package com.company.project.hot100;

/*
 * 29. 两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

 

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2
 

提示：

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Question29 {
	
	public int divide(int dividend, int divisor) {
		if(dividend == 0 || divisor == 1) {
			return dividend;
		}
		if(divisor == -1) {
			if(dividend == Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			}else {
				return -dividend;
			}
		}
		
		int sign = (dividend^divisor)>=0?1:-1;
		int a = (dividend<0)?dividend:-dividend;
		int b = (divisor<0)?divisor:-divisor;
		int result = div(a, b);
		return sign>0?result:-result;
    }
	
	/**
	 * 递归计算a/b的值，a和b都是负整数
	 * @param a 被除数
	 * @param b 除数
	 * @return 商
	 */
	public int div(int a,int b) {
		if(a > b) return 0;
		int temp = b;
		int result = 1;
		while(a< temp + temp  && (temp + temp < 0)) {
			temp = temp + temp;
			result = result + result;
		}
		return result+div(a-temp, b);
	}
	
	public static void main(String[] args) {
		Question29 question29 = new Question29();
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(question29.divide(2147483647, 3));
	}
	
}
