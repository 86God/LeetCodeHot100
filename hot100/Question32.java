package com.company.project.hot100;

import java.util.Stack;

/*
 * 32. ���Ч����
����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�

ʾ�� 1:

����: "(()"
���: 2
����: ���Ч�����Ӵ�Ϊ "()"
ʾ�� 2:

����: ")()())"
���: 4
����: ���Ч�����Ӵ�Ϊ "()()"
 */
public class Question32 {
	
	/**
	 * �ⷨһ��������
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
	
	//������ַ������׿�ʼ�������Ч���Ӵ�����
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
	 * �ⷨ������̬�滮
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
	 * �ⷨ��������ջ
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
