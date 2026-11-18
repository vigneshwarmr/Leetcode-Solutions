class DSU{
    int []parent;
    int[]rank;
    int components;

    public DSU(int n){
        parent= new int[n];
        rank = new int[n];
        components= n;

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

        if(nx==ny)return;

        if(rank[nx]<rank[ny]){
            parent[nx]=ny;
        }else if(rank[ny]<rank[nx]){
            parent[ny]=nx;
        }else{
            parent[nx]=ny;
            rank[ny]++;
        }
        components--;
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        if(connections.length<n-1)return -1;

        for(int []edge:connections){
            int u = edge[0];
            int v= edge[1];
            dsu.union(u,v);
        }

        return dsu.components-1;
    }
}