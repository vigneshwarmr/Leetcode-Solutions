class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        int n = nums.length;

        for(int x:nums){
            sum+=x;
        }

        if(Math.abs(target)>sum)return 0;

        if((sum+target)%2!=0)return 0;

        int sum1 = (sum+target)/2;

        return solve(nums,sum1);
    }
    private int solve(int nums[],int target){
        int n = nums.length;
        int[][]dp = new int[n+1][target+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    dp[i][j]=0;
                }else if(j==0){
                    dp[i][j]=1;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(nums[i-1]<=j){
                    dp[i][j]= dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    
}