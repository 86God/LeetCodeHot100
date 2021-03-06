package com.company.project.hot100;
/*
 * 10. 正则表达式匹配
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 */
public class Question10 {
	
	
	
	/**
	 * 解法一：回溯法
	 * 如果没有'*'的话，我们只需要挨个字符串和正则表达式匹配，
	 * 		如果字符串和正则表达式的对应字符相等，或者正则表达式对应字符为'.'，都是可以匹配的。
	 * 		如果不匹配直接返回false，若是当前字符匹配，我们只需要将字符串和正则表达式都向后移动一位，继续递归调用该方法。
	 * 		特殊情况处理（结束条件）：若正则表达式为空，只需要返回字符串是否为空，若字符串也为空，说明正好匹配成功。
	 * 
	 * 加入'*'的话，我们就需要分成两种情况判断一下，两种情况只要符合一种就是通过的。
	 * 		如果pattern[1]=='*'，即遇到'*',分如下两种情况处理：（1）前面字符出现0次 （2）前面字符出现1次或多次
	 * 			第一种：若当前的'*'，代表的是前面的一个字符出现0次，那么我们只需要把正则表达式向后移动2位；
	 * 			第二种：若当前的'*'，代表的是前面的一个字符出现1次或多次，那么我们只需要把字符串向后移1位；
	 * 			（其中，若'*'表示的是前面的字符出现1次，那么它第二次递归到这块，就会符合第一种情况）
	 * 
	 * 若满足最后的结束条件，若正则表达式为空，只需要返回字符串是否为空，若字符串也为空，说明正好匹配成功。
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static boolean isMatch(String text, String pattern)  {
		if(pattern.isEmpty()) return text.isEmpty();
		
		//判断当前字符是否可以匹配
		boolean fMatch = (!text.isEmpty() 
				&& (pattern.charAt(0) == text.charAt(0) || (pattern.charAt(0)) == '.'));
		
		//若遇到*，分两种情况处理
		if(pattern.length() >=2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || 
					(fMatch && isMatch(text.substring(1), pattern)));
					
		}else {
			//没有遇到*，就正常对比匹配
			return fMatch && isMatch(text.substring(1), pattern.substring(1));
		}
	}
	
	
	 public static boolean isMatch2(String text, String pattern) {
	        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
	        dp[text.length()][pattern.length()] = true;

	        for (int i = text.length(); i >= 0; i--){
	            for (int j = pattern.length() - 1; j >= 0; j--){
	                boolean first_match = (i < text.length() &&
	                                       (pattern.charAt(j) == text.charAt(i) ||
	                                        pattern.charAt(j) == '.'));
	                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
	                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
	                } else {
	                    dp[i][j] = first_match && dp[i+1][j+1];
	                }
	            }
	        }
	        return dp[0][0];
	    }


	
	
	public static void main(String[] args) {
		String s = "a";
		String p = "a*";
//		System.out.println(isMatch(s,p));
		System.out.println(isMatch2(s,p));
		
	}
	
	
}
