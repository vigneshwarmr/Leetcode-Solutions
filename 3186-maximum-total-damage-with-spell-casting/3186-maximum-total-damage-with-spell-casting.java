class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer,Long> map = new HashMap<>();

        for(int x:power){
            map.put(x,map.getOrDefault(x,0L)+x);
        }

        List<Integer> values = new ArrayList<>(map.keySet());
        Collections.sort(values);

        int n = values.size();

        long[]dp = new long[n];

        for(int i=0;i<n;i++){
            long pick = map.get(values.get(i));

            int j=i-1;
            
            while(j>=0 && values.get(i)-values.get(j)<=2) {
                j--;
            }     

            if(j>=0){
                pick+=dp[j];
            }  

            long notpick =(i==0)?0:dp[i-1];
            dp[i]= Math.max(pick,notpick);
            
        }
        return dp[n-1];
    }
}