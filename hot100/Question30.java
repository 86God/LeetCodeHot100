package com.company.project.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.project.arithmetic.KMP;

public class Question30 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if(words.length == 0) {
			return result;
		}
		
		Map<String, Integer> wMap = new HashMap<String, Integer>();
		Map<String, Integer> sMap = new HashMap<String, Integer>();
		int num = words.length;
		int wordLen = words[0].length();
		int len = wordLen*num;
		
		for(int i = 0;i<num;i++) {
			if(wMap.containsKey(words[i])) {
				wMap.put(words[i], wMap.get(words[i])+1);
			}else {
				wMap.put(words[i], 1);
			}
		}
		
		for(int i = 0;i<s.length()-len+1;i++) {
			sMap = new HashMap<String, Integer>();
			for(int j = 0;j<num;j++) {
				String son = s.substring(i+j*wordLen,i+(j+1)*wordLen );
				if(!wMap.containsKey(son)) {
					break;
				}else {
					if(sMap.containsKey(son)) {
						sMap.put(son, sMap.get(son)+1);
					}else {
						sMap.put(son, 1);
					}
				}
			}
			
			//判断两个HashMap是否相等
			int k = 0;
			boolean flag = true;
			while(k<words.length ) {
				if(wMap.get(words[k]) != sMap.get(words[k])) {
					flag = false;
					break;
				}
				k++;
			}
			if(flag) {
				result.add(i);
			}
		}
		return result;
    }
	
	
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if(words.length == 0) {
			return result;
		}
		
		Map<String, Integer> wMap = new HashMap<String, Integer>();
		Map<String, Integer> sMap = new HashMap<String, Integer>();
		int num = words.length;
		int wordLen = words[0].length();
		int len = wordLen*num;
		
		for(String w : words) {
			int value = wMap.getOrDefault(w, 0);
			wMap.put(w, value+1);
		}
		
		
		for(int i = 0;i<s.length()-len+1;i++) {
			sMap = new HashMap<String, Integer>();
			int j = 0;
			while (j<num) {
				String son = s.substring(i+j*wordLen,i+(j+1)*wordLen );
				if(!wMap.containsKey(son)) {
					break;
				}else {
					int value = sMap.getOrDefault(son, 0);
					sMap.put(son, value+1);
					if(sMap.get(son)>wMap.get(son)) {
						break;
					}
				}
				j++;
			}	
					
			//如果是正常退出循环，说明符合条件
			if(j == num) {
				result.add(i);
			}
			
		}
		return result;
    }
	
	public static void main(String[] args) {
		Question30 question30 = new Question30();
		String s = "barfoothefoobarman";
		String[] words = {"bar","foo"};
		List<Integer> result = question30.findSubstring2(s, words);
		for (Integer integer : result) {
			System.out.println(integer);
		}
	}
	
}
