class Solution {
    int[][]dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        dp = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,0,obstacleGrid);
    }

    private int solve(int i,int j,int[][] obstacleGrid){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;


        if(i<0 || j<0 || i>=n || j>=m || obstacleGrid[i][j]==1)return 0;
        if(obstacleGrid[n-1][m-1]==1)return 0;
    

        if(i==n-1 && j== m-1 )return 1;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ways= solve(i+1,j,obstacleGrid)+ solve(i,j+1,obstacleGrid);

        return dp[i][j]=ways;

    }
}