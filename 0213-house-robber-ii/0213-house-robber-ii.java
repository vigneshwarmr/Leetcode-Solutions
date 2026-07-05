class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n+1];
        int[]dp2 = new int[n+1];

        if(n==1)return nums[0];

        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);

        return Math.max(solve(n-2,0,dp,nums),solve(n-1,1,dp2,nums));    
    }

    private int solve(int end,int start,int[]dp,int[]nums){

        if(end<start)return 0;
        if(end==start)return nums[start];

        if(dp[end]!=-1){
            return dp[end];
        }

        int pick = nums[end]+solve(end-2,start,dp,nums);
        int notpick =solve(end-1,start,dp,nums);
        return dp[end]= Math.max(pick,notpick);
}
}