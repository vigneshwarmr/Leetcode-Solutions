class Solution {
    Integer[]dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target+1];
        return solve(target,nums);
    }
    private int solve(int target,int[]nums){
        if(target==0)return 1;
        if(target<0)return 0;

        if(dp[target]!=null)return dp[target];
        int ways=0;

        for(int num:nums){
            ways+=solve(target-num,nums);
        }
        return dp[target]=ways;
    }
}