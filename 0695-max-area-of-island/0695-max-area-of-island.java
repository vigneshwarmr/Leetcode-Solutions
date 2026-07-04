class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count=0;
        int maxArea = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int area =dfs(grid,i,j);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][]grid,int i ,int j){
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0) return 0;

        grid[i][j]=0;

        return 1+dfs(grid,i-1,j)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);       
    }
}