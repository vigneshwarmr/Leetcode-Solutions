class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int []vis = new int[numCourses];

        for(int[]edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        Stack<Integer> q = new Stack<>();

        for(int i=0;i<numCourses;i++){
            if(dfs(i,adj,vis))return false;
        }

        return true;
    }
    private boolean dfs(int node,List<List<Integer>> adj,int[]vis){
        vis[node]=1;

        for(Integer x:adj.get(node)){
            if(vis[x]==0){
                if(dfs(x,adj,vis))return true;
            }else if(vis[x]==1)return true;
        }

        vis[node]=2;
        return false;
    }
}