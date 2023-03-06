package five_kyu;

import java.util.Arrays;

public class SimplePigLatin {

    // Move the first letter of each word to the end of it,
    // then add "ay" to the end of the word. Leave punctuation marks untouched.

    public static String pigIt(String str) {
        String[] array = str.split("\\s+");
        for (int i = 0; i < array.length; i++) {
            if (array[i].matches("[A-Za-z]+"))
                array[i] = array[i].substring(1) + array[i].charAt(0) + "ay";
        }
        return Arrays.stream(array).reduce("", (str1, str2) -> str1 + " " + str2).substring(1);
    }

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool")); // igPay atinlay siay oolcay
        System.out.println(pigIt("This is my string")); // hisTay siay ymay tringsay
    }
}
