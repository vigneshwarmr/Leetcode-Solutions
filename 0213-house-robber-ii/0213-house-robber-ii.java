class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];

        return Math.max(solve(0,n-2,nums),solve(1,n-1,nums));
    }

    private int solve(int start,int end,int[]nums){
        int prev2=0;
        int prev1=0;

        for( int i=start;i<=end;i++){
            int pick= nums[i]+prev2;
            int nopick = prev1;
            int curr = Math.max(pick,nopick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}