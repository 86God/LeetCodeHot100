package com.company.project.hot100;

/*
 * 7. 整数反转
	给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	
	示例 1:
	
	输入: 123
	输出: 321
	 示例 2:
	
	输入: -123
	输出: -321
	示例 3:
	
	输入: 120
	输出: 21
	注意:

	假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Question07 {

	/**
	 * 解法一：
	 * 
	 * 由于我们有范围限制，只能存储下32位的有符号整数 2^31-1=2147483647,-2^31=-2147483648， 我们反转整数，会用到n =
	 * n*10 + x%10;x = x/10; 但是n = n*10 + x%10;很有可能会溢出 我们来判断一下，导致溢出的条件： （1）如果
	 * n>INTMAX/10,那么n = n*10 + x%10会溢出 （2）如果 n=INTMAX/10,并且x%10>7,那么n = n*10 +
	 * x%10会溢出 （3）如果 n<INTMIN/10,那么n = n*10 + x%10会溢出 （4）如果
	 * n=INTMIN/10,并且x%10<-8,那么n = n*10 + x%10会溢出
	 * 
	 * @param x
	 * @return
	 */
	public static int reverse1(int x) {
		int result = 0;
		while (x != 0) {
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && x % 10 > 7)) {
				return 0;
			}
			if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && x % 10 < -8)) {
				return 0;
			}
			result = result * 10 + x % 10;
			x = x / 10;
		}
		return result;
	}

	/**
	 * 解法二：对解法一的优化 解法一是预先会不会溢出，然后才去计算新一轮的结果 如果我们调换一下顺序，先计算新一轮的结果，再除以10，
	 * 如果没有溢出，那么得到的值，还会是上一次计算的结果， 如果溢出，那么就会不相等
	 * 
	 * @param x
	 * @return
	 */
	public static int reverse2(int x) {
		/**
		 * ret 保存旧的翻转中间值, temp 保存新的翻转过程中间值 依次提取 x 的末位加入 temp, 如果发生溢出则通过temp/10
		 * 无法得到上一轮的翻转结果 ret
		 **/
		int ret = 0;
		while (x != 0) {
			int temp = ret * 10 + x % 10;
			if (temp / 10 != ret)
				return 0;
			ret = temp;
			x /= 10;
		}
		return ret;
	}

	/**
	 * 解法三：利用long和int类型的范围特点 （有点耍流氓，因为题目说过我们的环境只能存的下32 位的有符号整数）
	 * 
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		long n = 0;
		while (x != 0) {
			n = n * 10 + x % 10;
			x = x / 10;
		}
		return (int) n == n ? (int) n : 0;
	}

	public static void main(String[] args) {
		System.out.println(reverse1(-123));
	}
}
