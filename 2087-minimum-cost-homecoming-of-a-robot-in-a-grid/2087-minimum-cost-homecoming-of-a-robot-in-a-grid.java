class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int x1=startPos[0],y1=startPos[1];
        int x2=homePos[0],y2=homePos[1];
        int cost=0;

        if(x2>x1){
            for(int j=x1+1;j<=x2;j++){
                cost+=rowCosts[j];
            }
        }else{
            for(int j=x1-1;j>=x2;j--){
                cost+=rowCosts[j];
            }
        }

        if(y2>y1){
            for(int j=y1+1;j<=y2;j++){
                cost+=colCosts[j];
            }
        }else{
            for(int j=y1-1;j>=y2;j--){
                cost+=colCosts[j];
            }
        }

        return cost;
    }
}