import java.util.*;
class Solution {
    int[]dr ={-1,1,0,0};
    int[]dc= {0,0,-1,1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<int[]> q= new LinkedList<>();

        int remainHealth = health- grid.get(0).get(0);
        if(remainHealth<=0)return false;
        q.offer(new int[]{0,0,remainHealth});

        int[][]best= new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(best[i],-1);
        }
        best[0][0]=remainHealth;

        while(!q.isEmpty()){
            int[]cell = q.poll();
            int r = cell[0];
            int c= cell[1];
            remainHealth = cell[2];

            if(r==n-1 && c==m-1)return true;

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c+ dc[i];

                if(nr<0 || nc<0 || nr>=n || nc>=m)continue;

                int newHealth = remainHealth-grid.get(nr).get(nc);

                if(newHealth<=0)continue;

                if(newHealth>best[nr][nc]){
                    best[nr][nc]=newHealth;
                    q.offer(new int[]{nr,nc,newHealth});
                }
            }
        }
        return false;

    }
}