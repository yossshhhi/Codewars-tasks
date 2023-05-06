package five_kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class JosephusSurvivor {
    public static int josephusSurvivor(final int n, final int k) {
        int count = 0;
        List<Integer> list = IntStream.rangeClosed(1, n).boxed().toList();
        List<Integer> people = new ArrayList<>(list);
        while (people.size() > 1) {
            for (int i = 0; i < people.size(); i++) {
                count++;
                if (count == k && people.size() > 1) {
                    count = 0;
                    people.remove(i);
                    i--;
                }
            }
        }
        return people.get(0);
    }
}
