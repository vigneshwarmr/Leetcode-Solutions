class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[]dr = {-1,1,0,0};
        int []dc ={0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][][]vis = new boolean[n][m][k+1];

        q.offer(new int[]{0,0,0,k});
        vis[0][0][k]=true;

        while(!q.isEmpty()){
            int size =q.size();

            for(int i=0;i<size;i++){
                int []cell = q.poll();
                int x = cell[0];
                int y= cell[1];
                int steps = cell[2];
                int remainingK = cell[3];

                if(x==n-1 && y==m-1)return steps;

                for(int d=0;d<4;d++){
                    int nr = x+dr[d];
                    int nc = y+ dc[d];

                    if(nr<0 || nc<0 || nr>=n || nc>=m)continue;

                    if(grid[nr][nc]==0){
                        if(!vis[nr][nc][remainingK]){
                            vis[nr][nc][remainingK]=true;
                            q.offer(new int[]{nr,nc,steps+1,remainingK});
                        }
                    }else {
                        if(remainingK>0 && !vis[nr][nc][remainingK-1]){
                            vis[nr][nc][remainingK-1]=true;
                            q.offer(new int[]{nr,nc,steps+1,remainingK-1});
                        }
                    }
                    }
                }
            }
        
        return -1;

    }
}