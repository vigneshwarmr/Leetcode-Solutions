class DSU{
    int[]parent;
    int []size ;

    public DSU(int n){
        parent = new int[n];
        size= new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int find(int node){
        if(parent[node]!=node){
            parent[node]= find(parent[node]);
        }
        return parent[node];
    }

    public void union(int x,int y){
        int ux = find(x);
        int uy = find(y);

        if(ux==uy)return ;

        if(size[ux]<size[uy]){
            parent[ux]=uy;
            size[ux]+=size[uy];
        }else if(size[ux]>size[uy]){
            parent[uy]=ux;
            size[uy]+=size[ux];
        }else{
            parent[ux]=uy;
            size[ux]++;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DSU dsu = new DSU(n);
        int count =n;

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