package com.company.project.hot100;

import java.util.ArrayList;
import java.util.List;

/*
 * 22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 */
public class Question22 {
	
	/**
	 * 方法一：暴力解法
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    
    /**
     * 解法二：回溯法
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n){
    	List<String> result = new ArrayList();
    	createStr(0,0,n,new StringBuilder(),result);
        return result;
    }
    
    public void createStr(int l,int r,int n, StringBuilder str,List<String> result) {
		if(str.length() == n*2) {
			result.add(str.toString());
			return;
		}
		if(l<n) {
			str.append("(");
			createStr(l+1, r, n, str, result);
			str.deleteCharAt(str.length()-1);
		}
		if(r<l) {
			str.append(")");
			createStr(l, r+1, n, str, result);
			str.deleteCharAt(str.length()-1);
		}
	}
    
    
    
	
	public static void main(String[] args) {
		int num = 3;
		Question22 question22 = new Question22();
		List<String> result = question22.generateParenthesis2(num);
		for (String string : result) {
			System.out.println(string);
		}
	}
}
