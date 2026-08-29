class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> res = new ArrayList<>();
        int[]vis = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!dfs(i,graph,vis)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int node,int[][]graph,int[]vis){

        vis[node]=1;

        for(Integer x:graph[node]){
            if(vis[x]==0){
                if(dfs(x,graph,vis))return true;
            }else if(vis[x]==1) return true;
        }

        vis[node]=2;
        return false;
    }
}