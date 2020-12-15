package com.vidya.dailybyte;

import java.util.Stack;

/**
 * This question is asked by Google.
 * Given a string only containing the following characters (, ), {, }, [, and ] return whether or not the opening and closing characters are in a valid order.
 * <p>
 * Ex: Given the following strings...
 * <p>
 * "(){}[]", return true
 * "(({[]}))", return true
 * "{(})", return false
 */
public class ValidateParenthesis {

    public static void main(String[] args) {
        ValidateParenthesis validateParenthesis = new ValidateParenthesis();

        String str = "(){}[]";
        System.out.println(validateParenthesis.isValidParenthesis(str));

        str = "(({[]}))";
        System.out.println(validateParenthesis.isValidParenthesis(str));

        str = "{(})";
        System.out.println(validateParenthesis.isValidParenthesis(str));
    }

    boolean isValidParenthesis(String string) {

        if (string == null || string.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {

            char ch = string.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty() && ((ch == ')' && stack.peek() == '(') ||
                    (ch == ']' && stack.peek() == '[') ||
                    (ch == '}' && stack.peek() == '{'))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}
