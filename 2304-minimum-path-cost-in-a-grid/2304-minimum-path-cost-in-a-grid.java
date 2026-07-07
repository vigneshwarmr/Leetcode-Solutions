class Solution {
    int[][]dp;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans =Integer.MAX_VALUE;

        for(int j=0;j<m;j++){
            ans = Math.min(ans,solve(grid,moveCost,0,j));
        }
        return ans;
    }
    private int solve(int[][]grid,int[][]moveCost,int row,int col){
        int n = grid.length;
        int m = grid[0].length;

        if(row<0 || col<0 || row>=n || col>=m)return Integer.MAX_VALUE;

        if(row==n-1)return grid[row][col];

        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int ans = Integer.MAX_VALUE;

        for(int nextCol=0;nextCol<m;nextCol++){
            int path = grid[row][col]+ solve(grid,moveCost,row+1,nextCol)+moveCost[grid[row][col]][nextCol];
            ans = Math.min(ans,path);
        }

        return dp[row][col]=ans;

    }
}