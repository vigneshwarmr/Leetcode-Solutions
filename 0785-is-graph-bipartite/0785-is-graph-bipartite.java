class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int[]color = new int[n];

        for(int i=0;i<n;i++){
            color[i]=-1;
        }

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(i,0,color,graph))return false;
            }
        }
        return true;


    }
    private boolean dfs(int node,int col,int []color,int[][]graph){
        color[node]=col;

        for(int x:graph[node]){
            if(color[x]==-1){
                if(!dfs(x,1-col,color,graph))return false;
            }else if(color[x]==col)return false;
        }
        return true;
    }
}