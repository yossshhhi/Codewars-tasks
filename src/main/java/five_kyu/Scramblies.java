package five_kyu;

import java.util.*;

// https://www.codewars.com/kata/55c04b4cc56a697bb0000048/java

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        List<String> arrayStr2 = new ArrayList<>(List.of(str2.split("")));
        List<String> arrayStr1 = new ArrayList<>(List.of(str1.split("")));
        Collections.sort(arrayStr2);
        Collections.sort(arrayStr1);
        String sortedStr1 = String.join("", arrayStr1);
        for (int i = 0; i < arrayStr2.size(); i++) {
            String letter = arrayStr2.get(i);
            long sameElement = arrayStr2.stream().filter(e -> e.equals(letter)).count();
            arrayStr2.subList(0, (int) sameElement).clear();
            if (sortedStr1.matches(".*" + letter.repeat((int) sameElement) + ".*")) {
                sortedStr1 = sortedStr1.replaceFirst(letter.repeat((int) sameElement), "");
                i = -1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
        String s2 = "zyxcba".repeat(9_000);
        System.out.println(scramble(s1, s2)); // true

        System.out.println(scramble("rkqodlw","world")); // true
        System.out.println(scramble("cedewaraaossoqqyt","codewars")); // true
        System.out.println(scramble("katas","steak")); // false
        System.out.println(scramble("scriptjavx","javascript"));// false
        System.out.println(scramble("scriptingjava","javascript")); // true
        System.out.println(scramble("scriptsjava","javascripts")); // true
        System.out.println(scramble("javscripts","javascript")); // false
        System.out.println(scramble("aabbcamaomsccdd","commas")); // true
        System.out.println(scramble("commas","commas")); // true
        System.out.println(scramble("sammoc","commas")); // true
    }
}
