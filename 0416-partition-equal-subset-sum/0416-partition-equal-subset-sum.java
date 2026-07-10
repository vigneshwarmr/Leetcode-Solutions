class Solution {
    private boolean subset(int []nums,int sum){
        int n = nums.length;
        boolean[][]dp= new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i ==0 && j==0){
                    dp[i][j]=true;
                }else if(j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j]= dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum= 0;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }else return subset(nums,sum/2);
    }
}