package six_kyu;

// https://www.codewars.com/kata/55c45be3b2079eccff00010f

public class Order {

    public static String order(String words) {
        if (words.isEmpty()) {
            return "";
        }
        String[] wordsArray = words.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= wordsArray.length; i++) {
            for (String s : wordsArray) {
                if (s.matches("[a-zA-Z]*" + i + "[a-zA-Z]*"))
                    stringBuilder.append(s + " ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
