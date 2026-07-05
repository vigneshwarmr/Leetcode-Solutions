class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];

        Arrays.fill(dp,-1);

        return solve(nums,dp,n-1);

    }

    private int solve(int[]nums,int[]dp,int i){

        if(i<0)return 0;

        if(dp[i]!=-1)return dp[i];

        int pick = nums[i]+ solve(nums,dp,i-2);
        int notpick = solve(nums,dp,i-1);

        return dp[i]= Math.max(pick,notpick);
    }
}