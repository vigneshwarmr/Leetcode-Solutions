class Solution {
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    int leftSize = 0, rightSize = 0;
    long sumLeft = 0, sumRight = 0;

    void addToMap(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    void removeFromMap(TreeMap<Integer, Integer> map, int num) {
        int count = map.get(num);

        if (count == 1) {
            map.remove(num);
        } else {
            map.put(num, count - 1);
        }
    }

    void add(int num) {
        if (left.isEmpty() || num <= left.lastKey()) {
            addToMap(left, num);
            leftSize++;
            sumLeft += num;
        } else {
            addToMap(right, num);
            rightSize++;
            sumRight += num;
        }

        balance();
    }

    void remove(int num) {
        if (left.containsKey(num)) {
            removeFromMap(left, num);
            leftSize--;
            sumLeft -= num;
        } else {
            removeFromMap(right, num);
            rightSize--;
            sumRight -= num;
        }

        balance();
    }

    void balance() {
        int target = (leftSize + rightSize + 1) / 2;

        while (leftSize > target) {
            int num = left.lastKey();

            removeFromMap(left, num);
            leftSize--;
            sumLeft -= num;

            addToMap(right, num);
            rightSize++;
            sumRight += num;
        }

        while (leftSize < target && !right.isEmpty()) {
            int num = right.firstKey();

            removeFromMap(right, num);
            rightSize--;
            sumRight -= num;

            addToMap(left, num);
            leftSize++;
            sumLeft += num;
        }
    }

    long getCost() {
        long median = left.lastKey();

        return median * leftSize - sumLeft
             + sumRight - median * rightSize;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {
            add(nums[i]);

            if (i >= x) {
                remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
            row[0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];

                if (i >= x) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}