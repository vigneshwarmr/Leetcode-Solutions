class Solution {
    int[][]dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        dp = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for(int j=0;j<m;j++){
            ans=Math.min(ans,solve(matrix,0,j));
        }
    
        return ans;

    }
    private int solve(int[][]matrix,int row,int col){
        int n = matrix.length;
        int m = matrix[0].length;

        if(row<0 || col<0 || row>=n || col>=m )return Integer.MAX_VALUE;

        if(row==n-1)return matrix[row][col];

        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }

        int min= Integer.MAX_VALUE;

        min= Math.min(solve(matrix,row+1,col),Math.min(solve(matrix,row+1,col-1),solve(matrix,row+1,col+1)));

        if(min==Integer.MAX_VALUE){
            return dp[row][col]=Integer.MAX_VALUE;
        }
        
        return dp[row][col]=min+ matrix[row][col];
    }
}