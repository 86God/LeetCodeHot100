/*3. ���ظ��ַ�����Ӵ�
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
*/
package com.company.project.hot100;

import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question03 {
	/*
	 * ����һ�������� ˼·���𲽼�����е����ַ������ҵ�����ظ����ַ���
	 * 
	 * ʱ�临�Ӷȣ�O(n^3) �ռ临�Ӷȣ�O(min(m,n)), ��ҪO(K)�Ŀռ䣬����K��ʾset�Ĵ�С��
	 * ȡ�����ַ���n�Ĵ�С�Լ��ַ���/��ĸm�Ĵ�С��
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
	 * ���������������� �㷨�� ��������Ѿ�ȷ��������i��j-1֮����Ӵ�s(i,j-1)û���ظ����ַ���,
	 * ������ֻ��Ҫ�ж��ַ�s[j]�Ƿ��Ѿ������Ӵ�s(i,j-1)�С�
	 * 
	 * Ҫ���һ���ַ��Ƿ��Ѿ����������ַ����У�����ͨ��ʹ��HashSet��Ϊ�������ڣ� ����ʹ��O(1)��ʱ�������
	 * 
	 * �������ڣ� ����/�ַ��������г��õĳ����� ����ָ��������/�ַ������ɿ�ʼ����������������һϵ��Ԫ�صļ��ϣ���[i,j) ����ҿ���
	 * ���������ǿ��Խ������߽���ĳ�����򻬶��Ĵ��ڡ� ���磺���ǽ�[i,j)���һ���һ��Ԫ�أ���Ϊ[i+1,j+1)��
	 * 
	 * �ص����ǵ����⣬����ʹ��HashSet���ַ��洢�ڵ�ǰ����[i,j) ����ʼi=j��,Ȼ���������һ�������j��
	 * ���s[j]û��HashSet�У����Ǽ������һ���j�� ֱ��s[j]�Ѿ�����HashSet�У����ǵ�ǰ�ҵ�������ַ�������i��ʼ��j-1��һ���ַ�����
	 * ��������е�i�������������Ϳ����ҵ��𰸡�
	 * 
	 * ʱ�临�Ӷȣ� O(2n) = O(n),�������������i��j��������n�� �ռ临�Ӷȣ�O(min(m,n)),
	 * ����������ҪO(K)�Ŀռ䣬����K��ʾset�Ĵ�С�� ȡ�����ַ���n�Ĵ�С�Լ��ַ���/��ĸm�Ĵ�С��
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
	 * ���������Ż��Ļ������� �����ķ��������Ҫ2n�����裬��ʵ�����Ż���n������ ���ǿ��Զ����ַ���������ӳ�䣬������ʹ�ü����ж�һ���ַ��Ƿ���ڡ�
	 * �������ҵ��ظ��ַ�ʱ�����ǿ���ֱ�������ô��ڡ� Ҳ����˵�����s[j]�����ַ���[i,j-1)��Χ����s[J]�ظ������ǲ���Ҫ������i��
	 * ���ǿ���ֱ������s[i,J]��Χ�ڵ�����Ԫ�أ�����i���J+1��
	 * 
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(min(m,n)),m���ַ����Ĵ�С,set�Ĵ�Сȡ�����ַ���n�Ĵ�С�Լ��ַ���/��ĸm�Ĵ�С��
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
	 * �����ģ���������������Ϊֱ�ӷ��ʱ����滻Map
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(m),m���ַ����Ĵ�С
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
