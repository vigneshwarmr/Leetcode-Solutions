class Solution {
    int[][]dp;
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(grid,n-1,m);

    }
    private int solve(int[][]grid,int curr,int last){
        int n = grid.length;
        int m = grid[0].length;

        if(curr==0){
            int min = Integer.MAX_VALUE;
            for(int currbest=0;currbest<m;currbest++){
                if(currbest!=last){
                    min= Math.min(min,grid[0][currbest]);
                }
            }
            return min;
        }

        if(dp[curr][last]!=-1){
            return dp[curr][last];
        }

        int min=Integer.MAX_VALUE;

        for(int currbest=0;currbest<m;currbest++){
            if(currbest!=last){
                int point = grid[curr][currbest]+ solve(grid,curr-1,currbest);
                min= Math.min(min,point);
            }
        }
        return dp[curr][last]=min;
    }
}