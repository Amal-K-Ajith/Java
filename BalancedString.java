/**
 * A balanced String is string having an opening and closing bracket
 * eg:  
 *     ([]{}()) ---- is a balanced string where when there is an opening then there should be a closing for that
 *     (){{})   ---- is not a balanced string as there are closing brackets for which there are no openings 
 */

import java.util.Scanner;

public class BalancedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		if (balanced(s))
			System.out.println("Balanced");
		else
			System.out.println("Not Balanced");
	}

	public static boolean balanced(String s) {
		char[] c = s.toCharArray();
		char[] c1 = new char[s.length() - 1];
		int top = -1;
		for (char ch : c) {
			if (ch == '(' || ch == '{' || ch == '[') {
				top++;
				c1[top] = ch;
//					System.out.println(ch+" inserted");
				continue;
			}
			char check;
			if (top < 0)
				return false;
			switch (ch) {
			case ')':
//				System.out.println("check 1");
				check = c1[top];
				top--;
				if (check == '{' || check == '[') {
//                	System.out.println("c1 true");
					return false;
				}
				break;

			case '}':
//            	System.out.println("check 2");
				check = c1[top];
				top--;
				if (check == '(' || check == '[') {
//                	System.out.println("c2 true");
					return false;
				}
				break;

			case ']':
//            	System.out.println("check 3");
				check = c1[top];
				top--;
				if (check == '(' || check == '{') {
//                	System.out.println("c3 true");
					return false;
				}
				break;
			}
		}
		return true;
	}
}
