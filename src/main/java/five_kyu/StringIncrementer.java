package five_kyu;


public class StringIncrementer {
    public static String incrementString(String str) {
        if (str.isEmpty() || str.isBlank())
            return "1";

        int lastChar = str.length() - 1;
            char c = str.charAt(lastChar);

            if (Character.isDigit(c)) {
                int number = Character.digit(c, 10);
                if (number != 9) {
                    return str.substring(0, str.length() - 1) + ++number;
                } else {
                    int nines = howMuchNine(str, lastChar);
                    if (nines == str.length()) {
                        return String.valueOf(Integer.parseInt(str) + 1);
                    }
                    char nextChar = str.charAt(lastChar - nines);
                    if (Character.isDigit(nextChar) && Character.digit(nextChar, 10) == 0) {
                        String substring = str.substring(0, lastChar - nines);
                        return substring + (int) (Math.pow(10, nines));
                    } else if (Character.isDigit(nextChar) && Character.digit(nextChar, 10) != 0) {
                        String substring = str.substring(0, lastChar - nines);
                        int notZero = Character.digit(nextChar, 10);
                        String zeros = String.valueOf((int) (Math.pow(10, nines))).substring(1);
                        return substring + (notZero + 1) + zeros;
                    } else {
                        String substring = str.substring(0, lastChar - nines + 1);
                        return substring + (int) (Math.pow(10, nines));
                    }
                }
            } else {
                return str + 1;
            }
    }

    public static int howMuchNine(String str, int n) {
        int nines = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int number = Character.digit(c, 10);
                if (number == 9) {
                    nines++;
                } else {
                    return nines;
                }
            } else {
                return nines;
            }
        }
        return nines;
    }

    public static void main(String[] args) {
        System.out.println(incrementString("fo99obar099")); //fo99obar100
        System.out.println(incrementString("foo")); ///foo1
        System.out.println(incrementString("foobar001")); //foobar002
        System.out.println(incrementString("foobar99")); //foobar100
        System.out.println(incrementString("foobar099")); //foobar100
        System.out.println(incrementString("")); //1
        System.out.println(incrementString("+*%.716=%V2?0&@LvZ#EgO<g[PeUOtILaX`@XKN2965210926961997382590061"));
//        +*%.716=%V2?0&@LvZ#EgO<g[PeUOtILaX`@XKN2965210926961997382590062
    }
}
