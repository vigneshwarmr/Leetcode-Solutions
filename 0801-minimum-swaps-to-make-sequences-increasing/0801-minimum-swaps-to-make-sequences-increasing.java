class Solution {
    int[][]dp;
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        dp= new int[n][2];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= solve(nums1,nums2,1,0);
        int ans2= 1+solve(nums1,nums2,1,1);
        return Math.min(ans,ans2);
    }
    private int solve(int[]nums1,int[]nums2,int index,int swap){

        if(index==nums1.length)return 0;

        if(dp[index][swap]!=-1){
            return dp[index][swap];
        }

        int prev= nums1[index-1];
        int prev2= nums2[index-1];

        if(swap==1){
            int temp = prev;
            prev= prev2;
            prev2=temp;
        }

        int ans = Integer.MAX_VALUE;

        if(nums1[index]>prev && nums2[index]>prev2){
            ans= solve(nums1,nums2,index+1,0);
        }

        if(nums1[index]>prev2 && nums2[index]>prev){
            ans= Math.min(ans,1+solve(nums1,nums2,index+1,1));
        }

        return dp[index][swap]=ans;
    }
}