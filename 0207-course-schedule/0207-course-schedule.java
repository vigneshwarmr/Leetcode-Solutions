class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[]vis = new boolean[n];
        boolean[]pathVis = new boolean[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());         
        }

        for(int []e : prerequisites){
            int u = e[0];
            int v= e[1];
            adj.get(u).add(v);
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(i,prerequisites,adj,vis,pathVis))return false;
            }
        }
        return true;
    }
    private boolean dfs(int node,int[][]prerequisites,List<List<Integer>> adj,boolean[]vis,boolean[]pathVis){
        vis[node]=true;
        pathVis[node]=true;

        for(Integer x:adj.get(node)){
            if(!vis[x]){
                if(dfs(x,prerequisites,adj,vis,pathVis))return true;
            }else if (pathVis[x])return true;
        }
        pathVis[node]=false;
        return false;
    }
}