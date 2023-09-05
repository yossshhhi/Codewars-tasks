package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy = 0;
        List<Integer> sells = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                buy = prices[0];
            }
            buy = Math.min(buy, prices[i]);
            sells.add(prices[i] - buy);
        }
        Collections.sort(sells);
        return sells.get(sells.size() - 1);
    }
}
