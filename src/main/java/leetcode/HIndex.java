package leetcode;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            int papersWithAtLeastCitations = n - i;
            if (citations[i] >= papersWithAtLeastCitations) {
                hIndex = papersWithAtLeastCitations;
            } else {
                break;
            }
        }
        return hIndex;
    }
}
