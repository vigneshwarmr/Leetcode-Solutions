class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[]e :edges){
            int u = e[0];
            int v= e[1];
            boolean []vis = new boolean[n+1];

            if(dfs(u,v,adj,vis))return e;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }

    private boolean dfs(int src,int dest,List<List<Integer>>adj,boolean[]vis){
        if(src==dest)return true;

        vis[src]=true;

        for(Integer x:adj.get(src)){
            if(!vis[x]){
                if(dfs(x,dest,adj,vis))return true;
            }
        }
        return false;
    }
}