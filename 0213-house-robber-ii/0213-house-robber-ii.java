class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0)return 0;
        if(n==1)return nums[0];

        return Math.max(solve(0,n-2,nums),solve(1,n-1,nums));

    }
    private int solve(int start,int end,int[]nums){
        int prev=0;
        int prev2=0;

        for(int i=start;i<=end;i++){
            int pick= nums[i]+prev2;
            int notpick= prev;
            int curr= Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}