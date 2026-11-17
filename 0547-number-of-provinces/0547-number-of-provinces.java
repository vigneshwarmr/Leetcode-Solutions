class DSU{
    int[]parent ;
    int[]rank;

    public DSU(int n){
        rank = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }

    public int find(int node){
        if(parent[node]!=node){
            parent[node]=find(parent[node]);
        }

        return parent[node];
    }

    public void union(int x,int y){
        int nx = find(x);
        int ny = find(y);

        if(nx==ny)return ;

        if(rank[nx]<rank[ny]){
            parent[nx]=ny;
        }else if(rank[ny]<rank[nx]){
            parent[ny]=nx;
        }else{
            parent[nx]=ny;
            rank[nx]++;
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        DSU dsu = new DSU(n);
        int count=n;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                if(isConnected[i][j]==1){
                    int ui = dsu.find(i);
                    int uj = dsu.find(j);

                    if(ui!=uj){
                        dsu.union(i,j);
                        count--;
                    }

                }
            }
        }
        return count;


    }
}