package com.company.project.hot100;

public class Question14 {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		StringBuilder result = new StringBuilder("");
		int i = 0;
		int minlen = Integer.MAX_VALUE;
		for (String string : strs) {
			if (string.length() < minlen) {
				minlen = string.length();
			}
		}
		while (i < minlen) {
			boolean flag = true;
			for (int j = 0; j < strs.length; j++) {
				flag &= (strs[0].charAt(i) == strs[j].charAt(i));
				if (!flag) {
					return result.toString();
				}
			}
			if (flag)
				result.append(strs[0].charAt(i));
			i++;
		}

		return result.toString();
	}

	public static String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	public static void main(String[] args) {
		String[] strings = {"flower","flow","flow"};
		System.out.println(longestCommonPrefix2(strings));
	}
}
