class Solution {
    int[]dp;
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        dp = new int[n];

        Arrays.fill(dp,-1);

        return solve(days,costs,0);
    }

    private int solve(int[]days,int[]costs,int i){
        int n = days.length;

        if(i>=n)return 0;

        if(dp[i]!=-1){
            return dp[i];
        }

        int j=i;
        while(j<n  && days[j]<days[i]+1){
            j++;
        }
        int one = costs[0]+solve(days,costs,j);

        j=i;
        while(j<n  && days[j]<days[i]+7){
            j++;
        }
        int two = costs[1]+solve(days,costs,j);
        
        j=i;
        while(j<n  && days[j]<days[i]+30){
            j++;
        }
        int three = costs[2]+solve(days,costs,j);
        
        return dp[i]=Math.min(one,Math.min(two,three));
    }
}