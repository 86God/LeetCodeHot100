package com.company.project.hot100;

import java.util.Stack;

/*
 * 32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */
public class Question32 {
	
	/**
	 * 解法一：暴力法
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		int result = 0;
		if(s.length()==0 && s.length()==1) {
			return 0;
		}
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i) == ')') {
				continue;
			}
			int maxLen = maxValid(s.substring(i));
			if(result < maxLen) {
				result = maxLen;
			}
		}	
		return result;
    }
	
	//计算从字符串串首开始计算最长有效的子串长度
	public int maxValid(String s) {
		int temp = 0;
		int maxLen = 0;
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i) == '(') {
				temp ++;
				
			}else {
				temp --;
				if(temp<0) {
					return maxLen;
				}
				if(temp == 0) {
					maxLen = i+1;
				}
			}
		}
		return maxLen;
	}
	
	/**
	 * 解法二：动态规划
	 * @param s
	 * @return
	 */
	public int longestValidParentheses2(String s) {
		if(s.length()==0 || s.length()==1) {
			return 0;
		}
		int[] dt = new int[s.length()];
		int result = 0;
		for(int i = 1;i<s.length();i++) {
			if(s.charAt(i)==')') {
				if(s.charAt(i-1)=='(') {
					dt[i] = (i>=2?dt[i-2]:0) + 2;
				}else if(i>dt[i-1] && s.charAt(i-dt[i-1]-1)=='(' ){
					dt[i] = dt[i-1] + 2 + ((i-dt[i-1]-2)>=0?dt[i-dt[i-1]-2]:0);
				}
			}
			result = Math.max(result, dt[i]);
		}
		return result;
    }
	
	/**
	 * 解法三：利用栈
	 * @param s
	 * @return
	 */
	public int longestValidParentheses3(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		int len = 0;
		stack.add(-1);
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				stack.add(i);
			}else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				}else {
					result = Math.max(result, i-stack.peek());
				}
			}
		}
		return result;
    }
	
	
	public static void main(String[] args) {
		Question32 question32 = new Question32();
		String s = "(())()";
		System.out.println(question32.longestValidParentheses3(s));
	}
}
