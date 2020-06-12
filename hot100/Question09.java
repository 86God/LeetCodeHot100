package com.company.project.hot100;

/*
 * # 9. ������

�Ѷȣ���

�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������

**ʾ�� 1:**

����: 121
���: true


**ʾ�� 2:**

����: -121
���: false
����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������


**ʾ�� 3:**

����: 10
���: false
����: ���������, Ϊ 01 �����������һ����������


 */
public class Question09 {
	
	/**
	 * �ⷨһ�������ַ���
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome1(int x) {
		String revstr = new StringBuilder(x + "").reverse().toString();
		String str = x + "";
        return str.equals(revstr);
    }
	
	/**
	 * �ⷨ������ѧ�㷨
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome2(int x) {
		if(x<0) {
			return false;
		}
		int digit = 1;
		while(x / digit >= 10) {
			digit *= 10;
		}
		while(x > 0) {
			int l = x / digit;
			int r = x % 10;
			if(l != r) {
				return false;
			}
			x = (x % digit) /10;
			digit /= 100;
		}
		return true;
    }
	
	/**
	 * �ⷨ�����������ֶ���
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome3(int x) {
		if(x < 0) {
			return false;
		}
		int b = 0;
		while(x > b) {
			b = b * 10 + x % 10;
			x /= 10;
		}
		return x == b || x == b / 10;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome2(120021));
	}


}
