class Solution {
    int INF = (int)1e9;
    int[][]dp;
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;

        dp = new int[n][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(cost,time,0,n);
    }

    private int solve(int[]cost,int[]time,int i,int remain){

        if(remain<=0)return 0;

        if(i==cost.length)return INF;

        if(dp[i][remain]!=-1){
            return dp[i][remain];
        }

        int paidPaint = cost[i]+solve(cost,time,i+1,remain-(1+time[i]));
        int skip = solve(cost,time,i+1,remain); 

        return dp [i][remain]= Math.min(paidPaint,skip);

    }
}