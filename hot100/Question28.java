package com.company.project.hot100;

/*
 * 28. ʵ�� strStr()
ʵ�� strStr() ������

����һ�� haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�  -1��

ʾ�� 1:

����: haystack = "hello", needle = "ll"
���: 2
ʾ�� 2:

����: haystack = "aaaaa", needle = "bba"
���: -1
˵��:

�� needle �ǿ��ַ���ʱ������Ӧ������ʲôֵ�أ�����һ���������кܺõ����⡣

���ڱ�����ԣ��� needle �ǿ��ַ���ʱ����Ӧ������ 0 ������C���Ե� strstr() �Լ� Java�� indexOf() ���������
 */
public class Question28 {
	//�ⷨһ��������
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
	
	//�ⷨ����KMP�㷨
	public int strStr2(String haystack, String needle) {
		int i = 0, j = 0;
		int [] next = Getnext(needle);
		while (i < haystack.length() && j < needle.length()) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else
				j = next[j]; // j�ص�
		}
		if (j >= needle.length())
			return (i - needle.length()); // ƥ��ɹ��������Ӵ���λ��
		else
			return (-1); // û�ҵ�
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
				k = next[k]; // k�ص�
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
