package five_kyu;

import java.util.*;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/55c6126177c9441a570000cc/java

public class WeightForWeight {
    public static String orderWeight(String strng) {
        String[] array = strng.split("\\s+");
        Map<Long, Long> weightForWeight = new HashMap<>();
        List<Long> duplicate = new ArrayList<>();
        for (String s : array) {
            if (s.isEmpty()) {
                continue;
            }
            long key = Long.parseLong(s);
            long value = Arrays.stream(s.split("")).map(Long::parseLong).reduce(0L, Long::sum);

            if (weightForWeight.containsKey(key)) {
                duplicate.add(key);
            }
            weightForWeight.put(key, value);
        }

        Map<Long,Long> sorted = weightForWeight.entrySet().stream()
                .sorted((i, j) -> compareSame(i.getKey(), j.getKey()))
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder result = new StringBuilder();
        sorted.forEach((key, value) -> {
            result.append(key).append(" ");
            if (duplicate.contains(key))
                result.append(key).append(" ");
        });
        return strng.isEmpty() ? "" : result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(orderWeight(" 103 123 4444 99 20008755768465")); // 2000 103 123 4444 99
        System.out.println(orderWeight("1 162518 1000 100"));
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123")); // 11 11 2000 10003 22 123 1234000 44444444 9999
        System.out.println(orderWeight("111 1111"));
    }

    public static int compareSame(long first, long second) {
        String firstString = String.valueOf(first);
        String secondString = String.valueOf(second);
        int minLength = Math.min(firstString.length(), secondString.length());
        for (int i = 0; i < minLength; i++) {
            char firstChar = firstString.charAt(i);
            char secondChar = secondString.charAt(i);
            if (firstChar == secondChar) {
                continue;
            } else {
                return Integer.compare(firstChar, secondChar);
            }
        }

        return Integer.compare(firstString.length(), secondString.length());
    }


}
