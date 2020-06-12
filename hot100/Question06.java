package com.company.project.hot100;

import java.util.List;
import java.util.ArrayList;

/*
 * 6. Z ���α任
��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�

���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�

L   C   I   R
E T O E S I I G
E   D   H   N
֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��

����ʵ��������ַ�������ָ�������任�ĺ�����

string convert(string s, int numRows);
ʾ�� 1:

����: s = "LEETCODEISHIRING", numRows = 3
���: "LCIRETOESIIGEDHN"
ʾ�� 2:

����: s = "LEETCODEISHIRING", numRows = 4
���: "LDREOEIIECIHNTSG"
����:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
 */
public class Question06 {

	/**
	 *  �ⷨһ��������������
	 * ����z�����е����ԣ������ַ������������У�����Ϊ2 * numRows -2��
	 * ���ֵ�n�е�Ԫ�أ�Ϊÿ�����ڵĵ�i�����ߵڣ�����-i����
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert1(String s, int numRows) {
		if(numRows == 1) return s;
		int len = s.length();
		int cycle = 2 * numRows -2;
		StringBuilder sBuilder = new StringBuilder(len);
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < len; j++) {
				if (j % cycle == i || j % cycle == (cycle - i)) {
					sBuilder.append(s.charAt(j));
				}
			}
		}		
		return sBuilder.toString();
	}

	
	/**
	 * �ⷨ������һ�ֽⷨ������
	 * ȥ�������������û��Ҫ�ļ�⣬ʡȥ�˴�����ʱ��
	 * 
	 * �㷨��
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert2(String s, int numRows) {
		if(numRows == 1) return s;
		int len = s.length();
		int cycle = 2 * numRows -2;
		StringBuilder sBuilder = new StringBuilder(len);
		for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < len; j += cycle) {
            	sBuilder.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycle - i < len)
                	sBuilder.append(s.charAt(j + cycle - i));
            }
        }
		return sBuilder.toString();
	}
	
	/**
	 * �ⷨ�������з���
	 * ���ǿ��Ա���һ���ַ���������ʹ�õ�ǰ�к͵�ǰ���������������Ժ��ʵ��н��и��١�
	 * ֻ�е����������ƶ�����������������ƶ���������ʱ���Ż���ķ���
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert3(String s, int numRows) {
		if(numRows == 1) return s;
		
		List<StringBuilder> rows = new ArrayList<>();
		
		//��������м��ϣ�ÿ��Ԫ�ذ���StringBuilder��ţ�
		for(int i = 0; i<Math.min(numRows, s.length());i++) {
			rows.add(new StringBuilder());
		}
		
		//��ǰ�����
		int curRow = 0;
		
		//direction Ϊ����false Ϊ���ϣ�trueΪ���¡�
		boolean direction = false;
		
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if(curRow == 0 || curRow == numRows -1 ) {
				direction = !direction;
			}
			//directionΪtrue��ʾ���£�false��ʾ����
			curRow += direction ? 1 : -1;
		}
				
		StringBuffer result = new StringBuffer();
		for (StringBuilder row : rows) {
			result.append(row);
		}
		return result.toString();		
	}
	
	
	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		int numRows = 4;
		System.out.println(convert3(s, numRows));
	}
}
