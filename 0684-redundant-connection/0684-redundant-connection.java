class DSU{
    int[]parent;
    int[]size;

    public DSU (int n){
        parent= new int[n+1];
        size = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
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
        int ny= find(y);

        if(nx==ny)return;

        if(size[nx]<size[ny]){
            parent[nx]=ny;
            size[ny]+=size[nx];
        }else if(size[ny]<size[nx]){
            parent[ny]=nx;
            size[nx]+=size[ny];
        }else{
            parent[nx]=ny;
            size[nx]++;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for(int []edge:edges){
            int root1=dsu.find(edge[0]);
            int root2 = dsu.find(edge[1]);

            if(root1==root2)return edge;

            dsu.union(edge[0],edge[1]);
        }
        return new int[0];
    }
}