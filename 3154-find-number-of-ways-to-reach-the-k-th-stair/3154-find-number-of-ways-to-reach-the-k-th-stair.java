class Solution {
    
    Map<String, Integer> dp;
    public int waysToReachStair(int k) {
        dp = new HashMap<>();
        
        return helper(1, k, 0, true);
    }
 
    private int helper(int currentStair, int targetK, int jump, boolean canGoDown) {
        
        String hash = currentStair + ";" + jump + ";" + canGoDown;
        
        if(dp.containsKey(hash))
            return dp.get(hash);
        
        int answer = 0;
    
        if(currentStair > targetK + 1) {
            return 0;
        }
        
   
        if(currentStair == targetK) {
            answer++;
        }
        
      
        if(canGoDown && currentStair != 0) {
            answer += helper(currentStair - 1, targetK, jump, false);
        }
        
     
        int jumpPower = (int) Math.pow(2, jump);
        answer += helper(currentStair + jumpPower, targetK, jump + 1, true);
        
        dp.put(hash, answer);
        return answer;
    }
}