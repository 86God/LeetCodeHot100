package com.company.project.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 20. ��Ч������
����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��

��Ч�ַ��������㣺

�����ű�������ͬ���͵������űպϡ�
�����ű�������ȷ��˳��պϡ�
ע����ַ����ɱ���Ϊ����Ч�ַ�����

ʾ�� 1:

����: "()"
���: true
ʾ�� 2:

����: "()[]{}"
���: true
ʾ�� 3:

����: "(]"
���: false
ʾ�� 4:

����: "([)]"
���: false
ʾ�� 5:

����: "{[]}"
���: true
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
