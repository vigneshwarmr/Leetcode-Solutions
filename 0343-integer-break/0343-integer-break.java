class Solution {
    public int integerBreak(int n) {
        int[]dp = new int[n+1];
        dp[1]=1;

        for(int j=2;j<=n;j++){
            for(int i=1;i<j;i++){
                dp[j]=Math.max(dp[j],Math.max(i*(j-i),i*dp[j-i]));
            }
        }
        return dp[n];
    }
}