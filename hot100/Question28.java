package com.company.project.hot100;

/*
 * 28. 实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Question28 {
	//解法一：暴力法
	public int strStr(String haystack, String needle) {
		int j = 0;
		if(needle.length()==0) {
			return  0;
		}
		for(int i = 0;i<haystack.length()-needle.length()+1;i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				for(j = 0;j<needle.length();j++) {
					if(haystack.charAt(i) != needle.charAt(j)) {
						break;
					}
					i++;
				}

				if(j == needle.length()) {
					return i-j;
				}else {
					i = i-j;
					j = 0;
				}
			}
		}
		return -1;
    }
	
	//解法二：KMP算法
	public int strStr2(String haystack, String needle) {
		int i = 0, j = 0;
		int [] next = Getnext(needle);
		while (i < haystack.length() && j < needle.length()) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else
				j = next[j]; // j回调
		}
		if (j >= needle.length())
			return (i - needle.length()); // 匹配成功，返回子串的位置
		else
			return (-1); // 没找到
	}
	
	int[] Getnext(String pat) {
		int[] next = new int[pat.length()];
		int j = 0, k = -1;
		next[0] = -1;
		while (j < pat.length() - 1) {
			if (k == -1 || pat.charAt(j) == pat.charAt(k)) {
				j++;
				k++;
				next[j] = k;
			} else
				k = next[k]; // k回调
		}
		return next;
	}
	
	
	public static void main(String[] args) {
		Question28 question28 = new Question28();
		String haystack= "aaqqqq";
		String needle = "aq";
		System.out.println(question28.strStr2(haystack, needle));
		System.out.println(haystack.indexOf(needle));
	}
}
