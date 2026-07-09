class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[]vis= new boolean[n];
        
        return dfs(arr,start,vis);

    }
    private boolean dfs(int[]arr,int node,boolean[]vis){
        int n = arr.length;
        if(node<0 || node>=n)return false;

        if(vis[node])return false;

        if(arr[node]==0)return true;
        
        vis[node]=true;
        return (dfs(arr,node+arr[node],vis)||dfs(arr,node-arr[node],vis));
  }
}