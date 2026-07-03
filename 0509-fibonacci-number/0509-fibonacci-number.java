class Solution {
    int dp[];
    public int fib(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return recur(n);
    }

    private int recur(int n){
        if(n==0)return 0;
        if(n==1)return 1;

        if(dp[n]!=-1){
            return dp[n];
        }


        return dp[n]= recur(n-1)+recur(n-2);
        
    }
}