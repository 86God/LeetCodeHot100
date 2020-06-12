package com.company.project.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class Question20 {
	public boolean isValid(String s) {
		boolean flag = true;
		Stack<Character> stack = new Stack<>();
		
		Map<Character, Character> map = new HashMap<Character, Character>(){
			{
				put('}', '{');
				put(')', '(');
				put(']', '[');
			}
		};
		if(s.length()==0) {
			return true;
		}
		
		for(int i = 0;i<s.length();i++) {
			
			if(!stack.isEmpty() && map.get(s.charAt(i))==stack.lastElement()) {
				stack.pop();
			}else {
				stack.push(s.charAt(i));
			}
		}
		flag = stack.isEmpty();
		
		return flag;
    }
	
	public static void main(String[] args) {
		Question20 question20 = new Question20();
		String s = "{[]}";
		System.out.println(question20.isValid(s));
	}
}
