class DSU{
    int[]parent;
    int[]size;

    public DSU (int n){
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int find(int n){
        if(parent[n]!=n){
            parent[n]= find(parent[n]);
        }

        return parent[n];
    }

    public void union(int x ,int y){
        int nx = find(x);
        int ny= find(y);

        if(nx==ny)return;

        if(size[nx]<size[ny]){
            parent[nx]=ny;
            size[nx]+=size[ny];
        }else if(size[nx]>size[ny]){
            parent[ny]=nx;
            size[ny]+=size[nx];
        }else{
            parent[nx]=ny;
            size[nx]++;
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
                    int nx = dsu.find(i);
                    int ny= dsu.find(j);

                    if(nx!=ny){
                        dsu.union(i,j);
                        count--;
                    }
                }
            }
        }
        return count;
    }
}