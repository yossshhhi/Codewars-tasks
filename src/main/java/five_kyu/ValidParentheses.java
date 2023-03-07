package five_kyu;

import java.util.Stack;

public class ValidParentheses {

    // Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
    // The function should return true if the string is valid, and false if it's invalid.
    // Examples
    // "()"              =>  true
    // ")(()))"          =>  false
    // "("               =>  false
    // "(())((()())())"  =>  true
    // Constraints
    // 0 <= input.length <= 100
    // Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters.
    // Furthermore, the input string may be empty and/or not contain any parentheses at all.
    // Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).

    public static boolean validParentheses(String parens) {
        Stack<String> parentheses = new Stack<>();
        String[] array = parens.split("");
        for (int i = 0; i < parens.length(); i++) {
            if (array[i].matches("\\(")) {
                parentheses.push(array[i]);
            } else if (array[i].matches("\\)")) {
                if (!parentheses.isEmpty() && parentheses.lastElement().matches("\\("))
                    parentheses.pop();
                else
                    parentheses.push(array[i]);
            }
        }
        return parentheses.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParentheses("()"));
        System.out.println(validParentheses("())"));
        System.out.println(validParentheses("32423(sgsdg)"));
        System.out.println(validParentheses("(dsgdsg))2432"));
        System.out.println(validParentheses("adasdasfa"));
    }
}
