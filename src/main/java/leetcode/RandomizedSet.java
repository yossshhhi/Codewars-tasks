package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    private final List<Integer> randomizedSet;
    public RandomizedSet() {
        randomizedSet = new ArrayList<>();
    }

    public boolean insert(int val) {
        for (Integer integer : randomizedSet) {
            if (integer == val) {
                return false;
            }
        }
        randomizedSet.add(val);
        return true;
    }

    public boolean remove(int val) {
        for (Integer integer : randomizedSet) {
            if (integer == val) {
                randomizedSet.remove(integer);
                return true;
            }
        }
        return false;
    }

    public int getRandom() {
        Random rand = new Random();
        int random = rand.nextInt(randomizedSet.size()) + 1;
        return randomizedSet.get(random - 1);
    }
}
