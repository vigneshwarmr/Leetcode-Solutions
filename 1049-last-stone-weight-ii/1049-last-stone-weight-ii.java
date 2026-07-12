class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int weight =0;
        int n = stones.length;

        for(int num:stones){
            weight+=num;
        }

        Boolean [][]dp = new Boolean[n+1][weight+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=weight;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;;
                }else if(j==0){
                    dp[i][j]=true;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=weight;j++){
                if(stones[i-1]<=j){
                    dp[i][j]= dp[i-1][j-stones[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        int min= Integer.MAX_VALUE;

        for(int s1=0 ;s1<=weight/2;s1++){
            if(dp[n][s1]){
                min = Math.min(min,weight-2*s1);
            }
        }

        return min;
}
}