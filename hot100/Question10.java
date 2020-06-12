package com.company.project.hot100;
/*
 * 10. ������ʽƥ��
����һ���ַ��� s ��һ���ַ����� p��������ʵ��һ��֧�� '.' �� '*' ��������ʽƥ�䡣

'.' ƥ�����ⵥ���ַ�
'*' ƥ���������ǰ�����һ��Ԫ��
��νƥ�䣬��Ҫ���� ���� �ַ��� s�ģ������ǲ����ַ�����

˵��:

s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
ʾ�� 1:

����:
s = "aa"
p = "a"
���: false
����: "a" �޷�ƥ�� "aa" �����ַ�����
ʾ�� 2:

����:
s = "aa"
p = "a*"
���: true
����: ��Ϊ '*' �������ƥ���������ǰ�����һ��Ԫ��, ������ǰ���Ԫ�ؾ��� 'a'����ˣ��ַ��� "aa" �ɱ���Ϊ 'a' �ظ���һ�Ρ�
ʾ�� 3:

����:
s = "ab"
p = ".*"
���: true
����: ".*" ��ʾ��ƥ�����������'*'�������ַ���'.'����
ʾ�� 4:

����:
s = "aab"
p = "c*a*b"
���: true
����: ��Ϊ '*' ��ʾ������������� 'c' Ϊ 0 ��, 'a' ���ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
ʾ�� 5:

����:
s = "mississippi"
p = "mis*is*p*."
���: false
 */
public class Question10 {
	
	
	
	/**
	 * �ⷨһ�����ݷ�
	 * ���û��'*'�Ļ�������ֻ��Ҫ�����ַ�����������ʽƥ�䣬
	 * 		����ַ�����������ʽ�Ķ�Ӧ�ַ���ȣ�����������ʽ��Ӧ�ַ�Ϊ'.'�����ǿ���ƥ��ġ�
	 * 		�����ƥ��ֱ�ӷ���false�����ǵ�ǰ�ַ�ƥ�䣬����ֻ��Ҫ���ַ�����������ʽ������ƶ�һλ�������ݹ���ø÷�����
	 * 		�������������������������������ʽΪ�գ�ֻ��Ҫ�����ַ����Ƿ�Ϊ�գ����ַ���ҲΪ�գ�˵������ƥ��ɹ���
	 * 
	 * ����'*'�Ļ������Ǿ���Ҫ�ֳ���������ж�һ�£��������ֻҪ����һ�־���ͨ���ġ�
	 * 		���pattern[1]=='*'��������'*',�������������������1��ǰ���ַ�����0�� ��2��ǰ���ַ�����1�λ���
	 * 			��һ�֣�����ǰ��'*'���������ǰ���һ���ַ�����0�Σ���ô����ֻ��Ҫ��������ʽ����ƶ�2λ��
	 * 			�ڶ��֣�����ǰ��'*'���������ǰ���һ���ַ�����1�λ��Σ���ô����ֻ��Ҫ���ַ��������1λ��
	 * 			�����У���'*'��ʾ����ǰ����ַ�����1�Σ���ô���ڶ��εݹ鵽��飬�ͻ���ϵ�һ�������
	 * 
	 * ���������Ľ�����������������ʽΪ�գ�ֻ��Ҫ�����ַ����Ƿ�Ϊ�գ����ַ���ҲΪ�գ�˵������ƥ��ɹ���
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static boolean isMatch(String text, String pattern)  {
		if(pattern.isEmpty()) return text.isEmpty();
		
		//�жϵ�ǰ�ַ��Ƿ����ƥ��
		boolean fMatch = (!text.isEmpty() 
				&& (pattern.charAt(0) == text.charAt(0) || (pattern.charAt(0)) == '.'));
		
		//������*���������������
		if(pattern.length() >=2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || 
					(fMatch && isMatch(text.substring(1), pattern)));
					
		}else {
			//û������*���������Ա�ƥ��
			return fMatch && isMatch(text.substring(1), pattern.substring(1));
		}
	}
	
	
	 public static boolean isMatch2(String text, String pattern) {
	        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
	        dp[text.length()][pattern.length()] = true;

	        for (int i = text.length(); i >= 0; i--){
	            for (int j = pattern.length() - 1; j >= 0; j--){
	                boolean first_match = (i < text.length() &&
	                                       (pattern.charAt(j) == text.charAt(i) ||
	                                        pattern.charAt(j) == '.'));
	                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
	                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
	                } else {
	                    dp[i][j] = first_match && dp[i+1][j+1];
	                }
	            }
	        }
	        return dp[0][0];
	    }


	
	
	public static void main(String[] args) {
		String s = "a";
		String p = "a*";
//		System.out.println(isMatch(s,p));
		System.out.println(isMatch2(s,p));
		
	}
	
	
}
