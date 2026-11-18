class DSU{
    int []parent;
    int[]size;

    public DSU(int n){
         parent = new int[n];
         size= new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int find(int n ){
        if(parent[n]!=n){
            parent[n]=find(parent[n]);
        }
        return parent[n];
    }

    public void union(int x,int y){
        int nx = find(x);
        int ny = find(y);

        if(nx ==ny)return;

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
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       
       DSU dsu = new DSU(n);

       for(int []edge:edges){
            int u = edge[0];
            int v = edge[1];

            dsu.union(u,v);
       }
       return dsu.find(source)==dsu.find(destination);
    }
}