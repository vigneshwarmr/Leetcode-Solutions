class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[]dp = new int[n];

        Arrays.fill(dp,-1);

        return Math.min(solve(cost,dp,n-1),solve(cost,dp,n-2));
    }

    private int solve(int[]cost,int[]dp,int n){

        if(n==0)return cost[0];
        if(n==1)return cost[1];

        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n]= cost[n]+ Math.min(solve(cost,dp,n-1),solve(cost,dp,n-2));

        return dp[n];
    }
}