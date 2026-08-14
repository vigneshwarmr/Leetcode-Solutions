class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

        int[]vis = new int[graph.length];

        List<Integer> res = new ArrayList<>(); 

        for(int i=0;i<graph.length;i++){
            if(dfs(i,graph,vis)){
                res.add(i);
            }
        }
        return res;
    }

     private boolean dfs(int node,int[][]graph ,int[]vis){
        if(vis[node]==2)return true;
        if(vis[node]==1)return false;
        vis[node]=1;

        for(int x:graph[node]){
            if(!dfs(x,graph,vis))return false;
        }
        vis[node]=2;
        return true;
    }
}
