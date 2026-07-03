class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[]vis= new boolean[n];
        dfs(source,adj,vis);
        return vis[destination];
    }

    private void dfs(int node,List<List<Integer>> adj,boolean[]vis){
        vis[node]=true;

        for(int x:adj.get(node)){
            if(!vis[x]){
                dfs(x,adj,vis);
            }
        }
    }
}