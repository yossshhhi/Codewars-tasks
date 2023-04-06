package six_kyu;

// https://www.codewars.com/kata/5842df8ccbd22792a4000245

public class NumberInExpandedForm {

    public static String expandedForm(int num) {
        int rem = num % 10;
        String out = "";
        if (rem != 0) {
            out += rem;
        }
        int ten = 10;
        while (num > 0) {
            num /= 10;
            rem = num % 10;
            if (rem != 0) {
                out = rem*ten + " + " + out;
            }
            ten *= 10;
        }
        if (out.endsWith(" + ")) {
            out = out.substring(0, out.length()-3);
        }
        return out;
    }
}
