package five_kyu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecureTester {
    public static boolean alphanumeric(String input){
        String regex = "[a-zA-Z0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(alphanumeric("with space"));
        System.out.println(alphanumeric("with_underscore"));
        System.out.println(alphanumeric("punctuation."));
        System.out.println(alphanumeric("naïve"));
        System.out.println(alphanumeric("１strangedigit"));
        System.out.println(alphanumeric("emoji😊"));
        System.out.println(alphanumeric("alphanumeric123"));
    }
}
