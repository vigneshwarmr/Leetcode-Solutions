class Solution {
    int MOD = 1_000_000_007;
    Integer[][]dp;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        dp = new Integer[locations.length][fuel+1];
        return solve(locations, start, finish, fuel);
    }

    public int solve(int[] locations, int city, int finish, int fuel) {

        if(fuel<0)return 0;

        if(dp[city][fuel]!=null){
            return dp[city][fuel];
        }

        long ans=(city==finish)?1:0;

        for(int next=0;next<locations.length;next++){

            if(next==city)continue;
            int cost = Math.abs(locations[city]-locations[next]);

            if(fuel>=cost){
                ans +=solve(locations,next,finish,fuel-cost);
                ans%=MOD;
            }
       }
        return dp[city][fuel]=(int)ans;

    }
}