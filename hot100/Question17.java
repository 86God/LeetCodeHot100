package com.company.project.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question17 {

	/*
	 * �ⷨһ����ͨ��ѭ��(�����ڽ�����BFS��������������������)
	 * ���Ƚ����ֻ��������ַ��Ķ�Ӧ��ϵ������Map�洢��
	 * ���ǿ������ñ���digits��ÿһ���ַ������ΰѵ�ǰ���ֶ�Ӧ���ַ�����ӵ����յ�list���ϡ�
	 * ÿһ�õ�һ�����ְ������õ�������Ӧ���ַ���s��
	 * ����ǰ��list���Ϻ��ַ������յѿ���������ʽƴ�ӣ�����γ��µ�list��
	 * Ȼ��list���أ�������һ��������ƴ�ӡ�
	 * ѭ�����������ؽ���ַ������ϡ�
	 * 
	 * ȱ�㣺ʱ�临�Ӷ�ΪO(n^3)  
	 * ʱ�临�ӶȽϸߣ����leetcode����Ĳ�����Ҫ7ms��
	 */
	
	public List<String> addLetter(List<String> list, String s) {
		List<String> newList = new ArrayList<String>();
		for (int j = 0; j < list.size(); j++) {
			for (int i = 0; i < s.length(); i++) {
				newList.add(list.get(j) + s.charAt(i));
			}
		}
		return newList;
	}

	public List<String> letterCombinations(String digits) {
		HashMap<String, String> map = new HashMap<>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		List<String> result = new ArrayList<>();

		if (digits.length() == 0) {
			return result;
		}
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			result = addLetter(result, map.get(String.valueOf(digits.charAt(i))));
		}

		return result;
	}

	
	/*
	 * �ⷨ�������ݷ�(�����ڽ�����DFS��������������������)
	 * ���Ƚ����ֻ��������ַ��Ķ�Ӧ��ϵ������Map�洢��
	 * �����Ƚ���һ�����ַ���letter,����ʱ�洢��ϵĽ���ַ���
	 * �������õݹ飬�ó�digits�еĵ�һ��������Ӧ���ַ�����
	 * Ȼ������ַ����е�ÿһ���ַ����뵱ǰ���ַ���letter���ӣ�
	 * ���Ӻ�����ֱ�ӵݹ�ȥ����һ������������ƴ��
	 * ���գ���û���µİ������룬��ô��ǰ���ַ���letter���������ַ���������Ҳ�ǵݹ�������������ݹ�ĳ��ڣ�
	 * ���䱣�浽���յļ���result�У������εݹ�
	 * �˳��ݹ�󣬵õ��ļ���result�������ս����
	 */
	Map<String, String> phoneMap = new HashMap<String, String>() {
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	List<String> result = new ArrayList<>();

	public void addLetter2(String letter, String nextLetter) {
		if (nextLetter.length() == 0) {
			result.add(letter);
		} else {
			String digit = String.valueOf(nextLetter.charAt(0));
			String letters = phoneMap.get(digit);

			for (int i = 0; i < letters.length(); i++) {
				String c = String.valueOf(letters.charAt(i));
				addLetter2(letter + c, nextLetter.substring(1));
			}
		}
	}

	public List<String> letterCombinations2(String digits) {
		if (digits.length() != 0)
			addLetter2("", digits);
		return result;
	}

	public static void main(String[] args) {
		Question17 q = new Question17();
		String digits = "525";
		System.out.println(String.valueOf(q.letterCombinations2(digits)));
	}

}
