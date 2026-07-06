class Solution {
    int[][]dp;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp= new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(grid,0,0);   
    }
    private int solve(int[][]grid,int i ,int j){

        int n = grid.length;
        int m = grid[0].length;

        if(n==0  && m==0)return 0;

        if(i==n-1 && j==m-1)return grid[i][j];

        if(i<0 || j< 0 || i>=n || j>=m )return Integer.MAX_VALUE;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        int sum= grid[i][j]+ Math.min(solve(grid,i+1,j),solve(grid,i,j+1));

        return dp[i][j]=sum;
    }
}