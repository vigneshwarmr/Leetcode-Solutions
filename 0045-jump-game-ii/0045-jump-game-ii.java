class Solution {
    public int jump(int[] nums) {
        int near=0,far=0,jumps=0;
        
        while(far<nums.length-1){
            int farthest =0;

            for(int i=near;i<=far;i++){
                farthest= Math.max(nums[i]+i,farthest);
            }
            near=far+1;
            far=farthest;
            jumps++;
        }
        return jumps;
    }
}