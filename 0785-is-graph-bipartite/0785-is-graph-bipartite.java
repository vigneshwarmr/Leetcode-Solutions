class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[]color = new int[n];

        for(int i=0;i<n;i++){
            color[i]=-1;
        }

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(i,color,graph))return false;
            }
        }
       return true;
    }

    private boolean bfs(int start,int[]color,int[][]graph){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start,0});
        color[start]=0;

        while(!q.isEmpty()){
            int []cell = q.poll();
            int node = cell[0];
            int col = cell[1];

            for(int neighbor:graph[node]){
                if(color[neighbor]==-1){
                    color[neighbor]=1-col;
                    q.offer(new int[]{neighbor,1-col});
                }else if(color[neighbor]== col){
                    return false;
                }
            }
        }
        return true;
    }
}