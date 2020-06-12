package com.company.project.hot100;

import java.util.List;
import java.util.ArrayList;

/*
 * 6. Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
 */
public class Question06 {

	/**
	 *  解法一：利用周期特性
	 * 根据z字排列的特性，发现字符串成周期排列，周期为2 * numRows -2，
	 * 发现第n行的元素，为每个周期的第i个或者第（周期-i）个
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
	 * 解法二：第一种解法的升级
	 * 去掉了跳过了许多没必要的检测，省去了大量的时间
	 * 
	 * 算法：
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
	 * 解法三：按行分组
	 * 我们可以遍历一遍字符串，可以使用当前行和当前方向两个变量来对合适的行进行跟踪。
	 * 只有当我们向上移动到最上面或者向下移动到最下面时，才会更改方向。
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert3(String s, int numRows) {
		if(numRows == 1) return s;
		
		List<StringBuilder> rows = new ArrayList<>();
		
		//创建结果行集合（每行元素按照StringBuilder存放）
		for(int i = 0; i<Math.min(numRows, s.length());i++) {
			rows.add(new StringBuilder());
		}
		
		//当前行序号
		int curRow = 0;
		
		//direction 为方向，false 为向上，true为向下。
		boolean direction = false;
		
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if(curRow == 0 || curRow == numRows -1 ) {
				direction = !direction;
			}
			//direction为true表示向下，false表示向上
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
