class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[]edge :edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        List<List<Integer>> ancestors = new ArrayList<>();

        for(int i =0;i<n;i++){
            ancestors.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            boolean []vis = new boolean[n];
            dfs(i,i,adj,vis,ancestors);
            
        }
        return ancestors;
    }

    private void dfs(int src,int node,List<List<Integer>> adj,boolean[]vis,List<List<Integer>> ancestors){
        vis[node]=true;

        for(int nbr:adj.get(node)){
            if(!vis[nbr]){
                ancestors.get(nbr).add(src);
                dfs(src,nbr,adj,vis,ancestors);
            }
        }
    }
}