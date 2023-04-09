package six_kyu;

// https://www.codewars.com/kata/5208f99aee097e6552000148

public class BreakCamelCase {

    public static String camelCase(String input) {
        if (input.isEmpty()) {
            return "";
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 65 && input.charAt(i) <= 90) {
                String temp = input.substring(i, input.length());
                input = input.substring(0, i) + " " + temp;
                i++;
            }
        }
        return input;
    }
}
