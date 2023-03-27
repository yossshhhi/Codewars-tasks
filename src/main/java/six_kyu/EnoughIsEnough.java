package six_kyu;

import java.util.*;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/554ca54ffa7d91b236000023

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> list = Arrays.stream(elements).boxed().collect(Collectors.toList());
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Collections.frequency(list, listIterator.previous()) > maxOccurrences)
                listIterator.remove();
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
