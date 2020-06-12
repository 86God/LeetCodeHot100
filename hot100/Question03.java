/*3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
*/
package com.company.project.hot100;

import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question03 {
	/*
	 * 方法一：暴力法 思路：逐步检查所有的子字符串，找到最大不重复子字符串
	 * 
	 * 时间复杂度：O(n^3) 空间复杂度：O(min(m,n)), 需要O(K)的空间，其中K表示set的大小，
	 * 取决于字符串n的大小以及字符集/字母m的大小。
	 */
	public static int lengthOfLongestSubstring1(String s) {
		int n = s.length();
		int ans = 0;
		String maxson = null;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (allUnique(s, i, j)) {
//					ans = Math.max(ans, j - i);
					if (j - i > ans) {
						ans = j - i;
						maxson = s.substring(i, j);
					}
				}
			}
		}
		System.out.println(maxson);
		return ans;
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character c = s.charAt(i);
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}

	/*
	 * 方法二：滑动窗口 算法： 如果我们已经确定了索引i到j-1之间的子串s(i,j-1)没有重复子字符串,
	 * 那我们只需要判断字符s[j]是否已经存在子串s(i,j-1)中。
	 * 
	 * 要检查一个字符是否已经存在在子字符串中，可以通过使用HashSet作为滑动窗口， 可以使用O(1)的时间来完成
	 * 
	 * 滑动窗口： 数组/字符串问题中常用的抽象概念。 窗口指的是数组/字符串中由开始索引到结束索引的一系列元素的集合，即[i,j) 左闭右开。
	 * 滑动窗口是可以将两个边界沿某个方向滑动的窗口。 例如：我们将[i,j)向右滑动一个元素，变为[i+1,j+1)。
	 * 
	 * 回到我们的问题，我们使用HashSet将字符存储在当前窗口[i,j) （开始i=j）,然后我们向右滑动索引j，
	 * 如果s[j]没在HashSet中，我们继续向右滑动j。 直到s[j]已经存在HashSet中，我们当前找到的最长子字符串就是i开始到j-1的一段字符串。
	 * 如果对所有的i都这样操作，就可以找到答案。
	 * 
	 * 时间复杂度： O(2n) = O(n),在最糟糕的情况下i和j都访问了n次 空间复杂度：O(min(m,n)),
	 * 滑动窗口需要O(K)的空间，其中K表示set的大小， 取决于字符串n的大小以及字符集/字母m的大小。
	 */
	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		String maxson = null;
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
//				ans = Math.max(ans, j - i);
				if (j - i > ans) {
					ans = j - i;
					maxson = s.substring(i, j);
				}
			} else {

				set.remove(s.charAt(i++));
			}
		}
		System.out.println(maxson);
		return ans;
	}

	/*
	 * 方法三：优化的滑动窗口 上述的方法最多需要2n个步骤，其实可以优化到n个步骤 我们可以定义字符到索引的映射，而不是使用集合判断一个字符是否存在。
	 * 当我们找到重复字符时，我们可以直接跳过该窗口。 也就是说，如果s[j]在子字符串[i,j-1)范围内与s[J]重复，我们不需要逐渐增加i，
	 * 我们可以直接跳过s[i,J]范围内的所有元素，即将i变成J+1。
	 * 
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(min(m,n)),m是字符集的大小,set的大小取决于字符串n的大小以及字符集/字母m的大小。
	 **/
	public static int lengthOfLongestSubstring3(String s) {
		int n = s.length();
		int ans = 0, i = 0, j = 0;
		String maxson = null;
		Map<Character, Integer> map = new HashMap<>();
		for (i = 0, j = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {

				i = Math.max(map.get(s.charAt(j)) + 1, i);
			}
//			ans = Math.max(ans, j - i);
			if (j - i + 1 > ans) {
				ans = j - i +1 ;
				maxson = s.substring(i, j+1);
			}
			map.put(s.charAt(j), j);
		}
		System.out.println(maxson);
		return ans;

	}

	/*
	 * 方法四：利用整数数组作为直接访问表来替换Map
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(m),m是字符集的大小
	 */
	public static int lengthOfLongestSubstring4(String s) {
		int n = s.length();
		int[] index = new int[128];
		int ans = 0;
		String maxson = null;
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
//			ans = Math.max(ans, j-i+1);
			if (j - i + 1 > ans) {
				ans = j - i + 1;
				maxson = s.substring(i, j + 1);
			}

			index[s.charAt(j)] = j + 1;
		}
		System.out.println(maxson);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "abcabcdnn";
		System.out.println(lengthOfLongestSubstring1(string));
	}

}
