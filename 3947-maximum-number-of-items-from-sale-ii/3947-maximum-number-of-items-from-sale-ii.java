import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

       
        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

    
        long[] strictMultiples = new long[maxFactor + 1];
        for (int d = 1; d <= maxFactor; d++) {
            long sum = 0;
            for (int m = 2 * d; m <= maxFactor; m += d) {
                sum += freq[m];
            }
            strictMultiples[d] = sum;
        }


        TreeMap<Long, Long> boostedByPrice = new TreeMap<>();
        long threshold = 2L * minPrice;

        for (int[] item : items) {
            int factor = item[0];
            long price = item[1];

            long gain = strictMultiples[factor] + (freq[factor] - 1);

            if (gain > 0 && price < threshold) {
                boostedByPrice.put(price, boostedByPrice.getOrDefault(price, 0L) + gain);
            }
        }

        long remBudget = budget;
        long totalItems = 0;

        for (Map.Entry<Long, Long> entry : boostedByPrice.entrySet()) {
            long price = entry.getKey();
            long avail = entry.getValue();
            if (remBudget < price) break;

            long buy = Math.min(avail, remBudget / price);
            totalItems += 2L * buy;
            remBudget -= buy * price;
        }


        totalItems += remBudget / minPrice;

        return (int) totalItems;
    }
}