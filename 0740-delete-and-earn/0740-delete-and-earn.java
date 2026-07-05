class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;

        for(int x:nums){
            max=Math.max(max,x);
        }

        int[]points = new int[max+1];

        for(int x:nums){
            points[x]+=x;
        }
        int prev2=0;
        int prev=0;
        for(int i=0;i<=max;i++){
            int pick = points[i]+prev2;
            int notpick = prev;
            int curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}